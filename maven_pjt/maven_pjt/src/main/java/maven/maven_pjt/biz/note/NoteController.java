package maven.maven_pjt.biz.note;

import lombok.Data;
import maven.maven_pjt.biz.note.dto.NoteRequestDto;
import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import maven.maven_pjt.biz.note.entity.Note;
import maven.maven_pjt.biz.user.UserMapper;
import maven.maven_pjt.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private NoteService noteService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity getAllNotes(@RequestHeader(value="X-AUTH-TOKEN") String accessToken) {
        // 1. 인증 후
        if(jwtTokenProvider.validateToken(accessToken)) {
            String userId = jwtTokenProvider.parseClaims(accessToken).getSubject();
            List<Note> result = noteService.getAllNotes();
            HttpStatus status = HttpStatus.OK;

        // 2. 모든 게시글 가져오기
            return new ResponseEntity<>(result, status);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{note_id}")
    public ResponseEntity getNoteDetail(@RequestHeader(value="X-AUTH-TOKEN") String accessToken, @PathVariable("note_id") Integer noteId) {

        if(jwtTokenProvider.validateToken(accessToken)) {
            // 1. 인증 후
            String userId = jwtTokenProvider.parseClaims(accessToken).getSubject();
            NoteDetailDto result = noteService.getNoteById(noteId);

            // 2. 게시글 누르면 글의 id 값을 가지고 해당 글 정보만 조회
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping
    public ResponseEntity createNote(@RequestHeader(value="X-AUTH-TOKEN") String accessToken, @RequestBody NoteRequestDto noteRequestDto) {
        if(jwtTokenProvider.validateToken(accessToken)) {
            // 1. 인증 후
            String userId = jwtTokenProvider.parseClaims(accessToken).getSubject();
            int id = userMapper.getUserByUserId(userId).get().getId();
            noteRequestDto.setUserId(id);
            Integer result = noteService.createNote(noteRequestDto);

            // 2. 새 노트 생성하고 새로 생성한 글의 id값 반환
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{note_id}")
    public ResponseEntity updateNote(@RequestHeader(value="X-AUTH-TOKEN") String accessToken, @RequestBody NoteRequestDto noteRequestDto, @PathVariable("note_id") Integer noteId) {

        // 4. 수정
        // 1. 인증 후
        if(jwtTokenProvider.validateToken(accessToken)) {
            // 2. 현재 사용자와 글 작성자가 같은지 확인
            String userId = jwtTokenProvider.parseClaims(accessToken).getSubject();
            Integer requestUserId = userMapper.getUserByUserId(userId).get().getId();
            NoteDetailDto targetNote = noteService.getNoteById(noteId);
            Integer noteUserId = targetNote.getUserId();

            if(!requestUserId.equals(noteUserId)) {
                String message = "작성자와 사용자 정보가 일치하지 않습니다.";
                return new ResponseEntity(message, HttpStatus.FORBIDDEN);
            }

            // 3. 수정된 내용 입력 후(id, 시간 등은 수정 불가)
            noteRequestDto.setId(targetNote.getId());
            noteService.updateNote(noteRequestDto);

            return new ResponseEntity(HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping
    public void deleteNote() {
        // 1. 인증 후

        // 2. 현재 사용자와 삭제할 글의 작성자가 같은지 확인
    }



}

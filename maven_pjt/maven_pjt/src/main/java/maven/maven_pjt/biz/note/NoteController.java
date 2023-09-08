package maven.maven_pjt.biz.note;

import jakarta.websocket.server.PathParam;
import lombok.Data;
import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import maven.maven_pjt.biz.note.entity.Note;
import maven.maven_pjt.biz.user.entity.User;
import maven.maven_pjt.jwt.JwtTokenProvider;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public void createNote() {
        // 1. 인증 후

        // 2. 새 노트 생성
    }

    @PutMapping
    public void updateNote() {
        // 1. 인증 후

        // 2. 현재 사용자와 글 작성자가 같은지 확인

        // 3. 수정된 내용 입력 후(id, 시간 등은 수정 불가)

        // 4. 수정

    }

    @DeleteMapping
    public void deleteNote() {
        // 1. 인증 후

        // 2. 현재 사용자와 삭제할 글의 작성자가 같은지 확인
    }



}

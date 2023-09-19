package maven.maven_pjt.biz.note;

import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import maven.maven_pjt.biz.note.dto.NoteRequestDto;
import maven.maven_pjt.biz.note.entity.Note;
import maven.maven_pjt.biz.user.UserMapper;
import maven.maven_pjt.biz.user.entity.User;
import maven.maven_pjt.biz.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    public NoteDetailDto getNoteById(Integer noteId) {
        return noteMapper.getNoteById(noteId);
    }

    public List<Note> getAllNotes() {
        return noteMapper.getAllNotes();
    }

    public Integer createNote(NoteRequestDto noteRequestDto) {
        noteMapper.createNote(noteRequestDto);
        return noteRequestDto.getId();
    }

    public Integer updateNote(NoteRequestDto noteRequestDto) {
        noteMapper.updateNote(noteRequestDto);
        return noteRequestDto.getId();
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public void setNullBeforeDeleteNotes(Integer userId) {
        noteMapper.setNullBeforeDeleteNotes(userId);
    };
}

package maven.maven_pjt.biz.note;

import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import maven.maven_pjt.biz.note.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    public NoteDetailDto getNoteById(Integer noteId) {
        return noteMapper.getNoteById(noteId);
    }

    public List<Note> getAllNotes() { return noteMapper.getAllNotes(); }

}

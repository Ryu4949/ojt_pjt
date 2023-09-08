package maven.maven_pjt.biz.note;

import lombok.Data;
import maven.maven_pjt.biz.note.entity.Note;
import maven.maven_pjt.biz.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/notes")
public class NoteController {

    @GetMapping
    public void getAllNotes() {}

    @GetMapping
    public void getNoteDetail() {}

    @PostMapping
    public void createNote() {}

    @PutMapping
    public void updateNote() {}

    @DeleteMapping
    public void deleteNote() {}



}

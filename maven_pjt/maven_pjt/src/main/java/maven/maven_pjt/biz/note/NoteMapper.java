package maven.maven_pjt.biz.note;

import maven.maven_pjt.biz.note.dto.NoteCreateDto;
import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import maven.maven_pjt.biz.note.dto.NoteRequestDto;
import maven.maven_pjt.biz.note.entity.Note;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    NoteDetailDto getNoteById(Integer noteId);

    List<Note> getAllNotes();

    Integer createNote(NoteRequestDto noteRequestDto);

    Integer updateNote(NoteRequestDto noteRequestDto);

    void deleteNote(Integer noteId);

    void setNullBeforeDeleteNotes(Integer userId);

}

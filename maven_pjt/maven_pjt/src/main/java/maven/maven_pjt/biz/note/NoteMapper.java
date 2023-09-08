package maven.maven_pjt.biz.note;

import maven.maven_pjt.biz.note.dto.NoteDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteMapper {
    NoteDetailDto getNoteById(Integer noteId);
}

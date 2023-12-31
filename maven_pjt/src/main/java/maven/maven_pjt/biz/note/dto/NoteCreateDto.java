package maven.maven_pjt.biz.note.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NoteCreateDto {
    private String title;
    private String content;
    private int userId;
    private LocalDate createDate;
    private LocalDate updateDate;
}

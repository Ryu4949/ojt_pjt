package maven.maven_pjt.biz.note.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class NoteDetailDto {
    private int id;
    private String title;
    private String content;
    private int userId;
    private String userName;
    private LocalDate createDate;
    private LocalDate updateDate;
}

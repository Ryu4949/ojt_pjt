package maven.maven_pjt.biz.note.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequestDto {
    @Id
    private int id;
    private String title;
    private String content;
    private int userId;
}
package maven.maven_pjt.biz.note.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
public class Note {
    @Id @GeneratedValue
    private int id;
    private String title;
    private String content;
    private int userId;
    private LocalDate createDate;
    private LocalDate updateDate;
}

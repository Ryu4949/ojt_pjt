package maven.maven_pjt.biz.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsersInfoDto {

    private String name;
    private String email;
    private String department;
    private String rankName;
    private LocalDate startDate;

}

package maven.maven_pjt.biz.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserInfoDto {

    private Integer id;
    private String name;
    private String userId;
    private String password;
    private String email;
    private String department;
    private String rankName;
    private LocalDate startDate;
    private LocalDate lastChangeDate;

}

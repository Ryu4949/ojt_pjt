package maven.maven_pjt.biz.users.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserSignUpDto {

    private Integer id;
    private String name;
    private String email;
    private String userId;
    private String password;
    private String department;
    private String rankName;

}

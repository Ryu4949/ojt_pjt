package maven.maven_pjt.biz.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UpdateUserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String department;
    private String rankName;
    private LocalDate lastChangeDate;

}

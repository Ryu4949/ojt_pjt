package maven.maven_pjt.biz.users.entity;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Users {

    @Id
    private Integer id;
    private String name;
    private String email;
    private String userId;
    private String password;
    private String department;
    private String rankName;
    private LocalDate startDate;
    private LocalDate lastChangeDate;
    private boolean useAccount;
    private String authority;
}

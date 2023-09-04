package maven.maven_pjt.biz.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

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
    private String authorities;
}

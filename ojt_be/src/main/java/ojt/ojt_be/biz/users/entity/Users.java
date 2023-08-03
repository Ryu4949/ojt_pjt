package ojt.ojt_be.biz.users.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="users")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

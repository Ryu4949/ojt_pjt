package ojt.ojt_be.biz.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

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
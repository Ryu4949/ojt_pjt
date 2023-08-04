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

    public Users(String name, String email, String userId, String password, String department, String rankName, LocalDate startDate, LocalDate lastChangeDate, boolean useAccount) {
        this.name = name;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.department = department;
        this.rankName = rankName;
        this.startDate = startDate;
        this.lastChangeDate = lastChangeDate;
        this.useAccount = useAccount;
    }
}
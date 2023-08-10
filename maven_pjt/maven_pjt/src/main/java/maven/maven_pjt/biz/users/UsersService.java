package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    public List<UsersInfoDto> findAllUsersInfo() {
        return usersMapper.findAllUsers();
    }
}

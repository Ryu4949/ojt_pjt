package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UpdateUserDto;
import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import maven.maven_pjt.biz.users.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    public Users getUserById(Integer userId) { return usersMapper.getUserById(userId);}
    public List<UsersInfoDto> findAllUsersInfo() {
        return usersMapper.findAllUsers();
    }

    public UsersInfoDto getUserDetail(Integer userId) { return usersMapper.getUserDetail(userId);}

    public UsersInfoDto updateUser(UpdateUserDto updateUserDto) {
        return usersMapper.updateUser(updateUserDto);
    }
}

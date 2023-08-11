package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UpdateUserDto;
import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import maven.maven_pjt.biz.users.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    Users getUserById(Integer userId);

    List<UsersInfoDto> findAllUsers();

    UsersInfoDto getUserDetail(Integer userId);

    UsersInfoDto updateUser(UpdateUserDto updateUserDto);

    Integer deleteUser(Integer userId);
}

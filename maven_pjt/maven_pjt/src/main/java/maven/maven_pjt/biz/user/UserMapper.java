package maven.maven_pjt.biz.user;

import maven.maven_pjt.biz.user.dto.UpdateUserDto;
import maven.maven_pjt.biz.user.dto.UserSignInDto;
import maven.maven_pjt.biz.user.dto.UserSignUpDto;
import maven.maven_pjt.biz.user.dto.UserInfoDto;
import maven.maven_pjt.biz.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(Integer userId);

    List<UserInfoDto> findAllUsers();

    UserInfoDto getUserDetail(Integer userId);

    UserInfoDto updateUser(UpdateUserDto updateUserDto);

    Integer deleteUser(Integer userId);

    void signUpUser(UserSignUpDto userSignUpDto);

    Integer getLastUserId();

    User getUserByUserId(String userId);

    UserInfoDto findUserByUserId(UserSignInDto userSignInDto);

}

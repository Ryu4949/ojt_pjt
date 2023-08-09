package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    List<UsersInfoDto> findAllUsers();
}

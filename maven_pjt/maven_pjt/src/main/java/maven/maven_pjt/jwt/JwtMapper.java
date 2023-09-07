package maven.maven_pjt.jwt;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Ref;
import java.util.Optional;

@Mapper
public interface JwtMapper {

    Optional<RefreshToken> findTokenByUserId(String key);

    void saveRefreshToken(RefreshToken newRefreshToken);
}

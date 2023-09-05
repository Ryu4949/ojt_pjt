package maven.maven_pjt.jwt;

import java.sql.Ref;
import java.util.Optional;

public interface JwtMapper {

    Optional<RefreshToken> findTokenByUserId(String key);
}

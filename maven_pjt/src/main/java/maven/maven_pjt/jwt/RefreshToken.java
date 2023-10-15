package maven.maven_pjt.jwt;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefreshToken {

    @Id
    private String tokenKey;

    private String tokenValue;

    @Builder
    public RefreshToken(String key, String value) {
        this.tokenKey = key;
        this.tokenValue = value;
    }

    public RefreshToken updateValue(String token) {
        this.tokenValue = token;
        return this;
    }
}
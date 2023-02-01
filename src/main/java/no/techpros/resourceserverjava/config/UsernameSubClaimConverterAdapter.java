package no.techpros.resourceserverjava.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * Extract token to spring boot claims
 * <p>
 * Cognito
 * https://www.harshajayamanna.com/2020/07/use-spring-resource-server-with-aws-cognito.html?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed:+HarshaJayamanna+(Harsha+Jayamanna)&m=1
 */
@Component
public class UsernameSubClaimConverterAdapter implements Converter<Map<String, Object>, Map<String, Object>> {
    private final MappedJwtClaimSetConverter delegate = MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());

    private static final String COGNITO_GROUPS = "cognito:groups";
    private static final String SPRING_AUTHORITIES = "authorities";
    private static final String COGNITO_USERNAME = "username";
    private static final String SPRING_USER_NAME = "user_name";

    @Override
    public Map<String, Object> convert(Map<String, Object> claims) {
        Map<String, Object> convertedClaims = this.delegate.convert(claims);

        if (claims.containsKey("cognito:groups")) {
            convertedClaims.put("authorities", claims.get(COGNITO_GROUPS));
        }

        if (claims.containsKey("username")) {
            convertedClaims.put("user_name", claims.get(COGNITO_USERNAME));
        }
        JwtAuthenticationConverter s = new JwtAuthenticationConverter();
        return convertedClaims;
    }
}

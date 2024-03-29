# Documentation

## Diff @PreAuthorize hasRole and hasAuthority

See @PreAuthorize("hasRole('ROLE_ADMIN')")
See @PreAuthorize("hasAuthority('NICE')")

https://www.baeldung.com/spring-security-granted-authority-vs-role

## Dff SecurityFilterChain && WebSecurityCustomizer

https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
(NB! ikke helt spring 3.0)

Use of SecurityFilterChain:
suppose we want to secure the endpoints depending on the roles, and leave an anonymous entry pointonly for login. We'll also restrict any delete request to an admin role
```


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
..
}

```

Configure Web Security

use WebSecurityCustomizer for securing the web
```
@Bean
public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.debug(securityDebug)
      .ignoring()
      .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
}
```

## Spring boot 3 og spring-addons-webmvc-jwt-resource-server

thin wrappers around spring-boot-starter-oauth2-resource-server
https://github.com/ch4mpy/spring-addons

https://github.com/ch4mpy/spring-addons/tree/master/samples/tutorials

```
<dependency>
    <groupId>com.c4-soft.springaddons</groupId>
    <artifactId>spring-addons-webmvc-jwt-resource-server</artifactId>
    <version>6.0.9</version>
</dependency>
```

### OAuth2/OpenID for Spring Boot 3 API
Gir mer informasjon også om når du ikke brukere dette
https://dzone.com/articles/spring-oauth2-resource-servers


(springdoc-openapi-starter-webmvc-ui)


OAuth2/OpenID for Spring Boot 3 API
Med og uten spring-addons-webmvc-jwt-resource-server
https://dzone.com/articles/spring-oauth2-resource-servers

https://github.com/ch4mpy/spring-addons

#### Spesielt til cognito
https://stackoverflow.com/questions/74695989/im-using-cognito-spring-security-there-are-any-way-to-use-authorization

https://stackoverflow.com/questions/74901986/how-to-permitall-anonymous-access-in-spring-boot-3-or-above
 
## Spring boot 3  eller
## Complete (short) tutorials there (with spring libs only or "my" wrappers): 

https://devforum.okta.com/t/okta-and-springboot-3-0-0/22815
()

Spring Security: Upgrading the Deprecated WebSecurityConfigurerAdapter

https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter



## Secure Resource Reserver rest API spring boot

https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/

https://springdoc.org/v2/


## Congnito

### AWS: Integrate Spring Boot Resource Server with Cognito Identity Provider
https://medium.com/cloud-base/resource-server-with-cognito-b7fbfbee0155

AWS: Integrate Spring Boot Resource Server with Cognito Identity Provider


I'm using Cognito + Spring security. There are any way to use authorization?
spring-addons-webmvc-jwt-resource-server

https://stackoverflow.com/questions/74695989/im-using-cognito-spring-security-there-are-any-way-to-use-authorization


https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_mt1mX8KOM/.well-known/jwks.json

## Start calling
```
curl -X GET "http://localhost:9000/status" -H "accept: application/json" -H "Authorization: Bearer <access_token>"
```

## cognito jwt
```
https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_mt1mX8KOM/.well-known/jwks.json
```

logout
```
Read:
https://docs.aws.amazon.com/cognito/latest/developerguide/logout-endpoint.html

Add to the url

SenseOn APP  CLIENT ID
xxxxxxxx


aws cognito-idp initiate-auth --region eu-west-1 --auth-flow USER_PASSWORD_AUTH --client-id xxxxxxxx --auth-parameters USERNAME=userpoolname,PASSWORD=usernamepassword
```
NB!
Gå til App client -> Info 
Merk "USER_PASSWORD_AUTH"

Da skulle du få noe som dette:

hent ut Beared token å sendt til jwt og post man
```
eyJraWQiOiIzNjE3ck9VVzk0eWdWakVnS0RyZjVFc2FqRjc4OTRFTU5DUXpmcnZINnJjPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI4OTQ5YTNmZC1jMjdkLTRjYmEtYWM1MC04ODlkNDFiNWRiZWMiLCJjb2duaXRvOmdyb3VwcyI6WyJST0xFX0FETUlOIl0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5ldS13ZXN0LTEuYW1hem9uYXdzLmNvbVwvZXUtd2VzdC0xX210MW1YOEtPTSIsImNsaWVudF9pZCI6InFuZnFwaGtlcTk2cHBpanJjbmRtMmtqbm0iLCJvcmlnaW5fanRpIjoiNjdiNjI2ZDctYTZkZC00MjVlLTgyZTEtNDVlMzQ0NzhjYjU1IiwiZXZlbnRfaWQiOiIzYzYzOGQ3ZS05YTliLTRlMzktYTk3NS05MTljYjhiOTc2ODYiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjc1MjY3MjU5LCJleHAiOjE2NzUyNjc1NTksImlhdCI6MTY3NTI2NzI1OSwianRpIjoiNTc4MzQ1NjAtNzY1Zi00NWEzLWJkZTMtMmYwYWZlNjY1YTFmIiwidXNlcm5hbWUiOiJ0b3JlZ2FyZDEifQ.qR5ETOaI20P_PAGOt32V04WRqGcttENiyw7vVbApOUMRQwx3vVRpqZuBm9NgIM2qM5euRTQmUkDjRAiRG_DwQkFSA7Eaed8LZrrBFznFlJYUKibSzXgyQ6X2D5u58guQpfPHc41TKqoBp36k_Wro3uSQJ5SqNLZBA5dZPMcp5Zqb3fadZHVDeyKdi2GAKj-cyC3ggJ7blG1S_V9Ut8lGjLWdoFXZ5lutqnGVK75cuCoBF3ZkN_b9o6zuOwcRCTYTuTbyE5yKZnQAnF9_bM7jqX3rSZkxg_H7N_AjalBiLi1zA_aspIr6G12hMN9ah20z3Z5cp1K5paFXmTAO3umrXA

```
På web kopier in dette i jwt.io

Header:
```
{
  "kid": "3617rOUW94ygVjEgKDrf5EsajF7894EMNCQzfrvH6rc=",
  "alg": "RS256"
}
```

Payload:
```json
{
  "sub": "8949a3fd-c27d-4cba-ac50-889d41b5dbec",
  "cognito:groups": [
    "ROLE_ADMIN"
  ],
  "iss": "https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_mt1mX8KOM",
  "client_id": "qnfqphkeq96ppijrcndm2kjnm",
  "origin_jti": "67b626d7-a6dd-425e-82e1-45e34478cb55",
  "event_id": "3c638d7e-9a9b-4e39-a975-919cb8b97686",
  "token_use": "access",
  "scope": "aws.cognito.signin.user.admin",
  "auth_time": 1675267259,
  "exp": 1675267559,
  "iat": 1675267259,
  "jti": "57834560-765f-45a3-bde3-2f0afe665a1f",
  "username": "toregard1"
}
```

VERIFY SIGNATURE:
```json

RSASHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  
{
  "e": "AQAB",
  "kty": "RSA",
  "n": "rjyLqgyu2SOEGKqifOXsYD4VaKelf2MtjQe04EzGTvFMeo_QyCXxfhYDuajPczT4dkmicFNQQpWP6NQgIGRDleoJ7BFptEddAPdFVtXWjZQpO0y6jezSrbkRk9w8lNvZFkFb13kmjwrcJMKdwQcx_T15f6XickWO0tB3Tmmr68rPZP9L9TeW8k_8tMhhS0pukWOhkpz-BDpk1V-9qSk0Lhb0J-j4Ip01c-g_Vni_AX2g0OcNIyNwRuUVE-tAhijt8QR1erKiftlGLikTRpq6ECjiTsQ8dRJ0GgV101F9By74px6HfP_dZBUj30fbn5CxGyhunhXnu4n5cr-zQjJ5Dw"
}
,
  
Private Key in PKCS #8, PKCS #1, or JWK string format. The key never leaves your browser.

)
  
Public Key in SPKI, PKCS #1, X.509 Certificate, or JWK string format.
,
  
Private Key in PKCS #8, PKCS #1, or JWK string format. The key never leaves your browser.

)
```

# Some code for example 

```
package no.techpros.resourceserverjava.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * OAuth2 login should be handled by clients, not resource-server:
 * clients acquire access token and send it as Authorization header to resource-server.
 * <p>
 * This configuration class extends ResourceServerConfigurerAdapter and enables
 * a resource server using the @EnableResourceServer annotation.
 * It also uses the @Autowired annotation to inject instances of
 * CognitoJwtDecoder, RoleHierarchy, RoleHierarchyAuthoritiesMapper, and AuthenticationManager.
 * <p>
 * It uses http.authorizeRequests() to configure the authorization rules.
 * For example, it requires authentication for all requests to the /api endpoint
 * and requires the ADMIN role for all requests to the /admin endpoint.
 * <p>
 * It also sets up the JWT decoder and converter to use the CognitoJwtDecoder
 * and CognitoJwtGrantedAuthoritiesConverter classes, respectively, and sets the authenticationManager and jwtAuthenticationConverter beans.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;
     @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String jwkSetUri;

    /**
     * SpringFramework 6.xx
     * <p>
     * Only rest endpoint /status/** is public
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(
                        csrf -> csrf.disable()
                )
                .anonymous().and()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/resources/**","/home/**","/actuator/*").permitAll()
                        .requestMatchers("/status/**").permitAll()
                         .requestMatchers("/test/**").authenticated()
                        //.requestMatchers(HttpMethod.GET, "/","/actuator/**", "/status/**", "/home","/health","/info").permitAll()
                        // .requestMatchers("/db/**").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') and hasRole('DBA')"))
                        // .requestMatchers("/db/**").access(AuthorizationManagers.allOf(AuthorityAuthorizationManager.hasRole("ADMIN"), AuthorityAuthorizationManager.hasRole("DBA")))
                        //.anyRequest().denyAll()
                )

                //arg could be OAuth2ResourceServerConfigurer
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                // This is rest, do not need session. Must not
                // enable when csrf is of! Can get a csrf attack!
                .sessionManagement(session-> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //No dialog
                //.httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
                //.oauth2ResourceServer().jwt();


        /*.jwkSetUri(

                        jwkSetUri
                );
         */
         /*
                .oauth2ResourceServer(ouath2 ->
                        ouath2
                                .jwt(jwt ->
                                        jwt
                                                .decoder(jwtDecoder())
                                )
                );
        */
        return http.build();


    }


    /**
     * Decode token
     *
     * @return Added Cognito CognitoAccessTokenConverter()
     * @See https://www.harshajayamanna.com/2020/07/use-spring-resource-server-with-aws-cognito.html?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed:+HarshaJayamanna+(Harsha+Jayamanna)&m=1
     * <p>
     * https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html
     * section JWT
     *
     * Enable Cognito groups in Spring, so you can add restrictions based on the user role/group.
     * To do this, we need to add a JwtDecoder and a Converter.
     */
   /* @Bean
    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuerUri);

        OAuth2TokenValidator<Jwt> withClockSkew = new DelegatingOAuth2TokenValidator<>(
                new JwtTimestampValidator(Duration.ofSeconds(60)), new JwtIssuerValidator(issuerUri));

        jwtDecoder.setJwtValidator(withClockSkew);
        jwtDecoder.setClaimSetConverter(new CognitoAccessTokenConverter());

        return JwtDecoders.fromIssuerLocation(issuerUri);
    }*/


    /**
     * https://www.baeldung.com/spring-security-map-authorities-jwt
     *
     * @return
     */
  /*  public Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        *//*if (StringUtils.hasText(mappingProps.getAuthoritiesPrefix())) {
            converter.setAuthorityPrefix(mappingProps.getAuthoritiesPrefix().trim());
        }*//*
        return converter;
    }

    @Bean
    public JwtAuthenticationConverter customJwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter());
        return converter;
    }*/

    /**
     * Annen måte enn CognitoAccessTokenConverter
     * @return
     */
    /*private JwtAuthenticationConverter grantedAuthoritiesExtractor() {
    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
                String[] scopes;
                if (jwt.getClaims().containsKey("cognito:groups")) {
                    scopes = ((JSONArray) jwt.getClaims().get("cognito:groups")).toArray(new String[0]);
                } else {
                    scopes = ((String) jwt.getClaims().getOrDefault("scope", "")).split(" ");
                }
                return Arrays.stream(scopes)
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase(Locale.ROOT)))
                        .collect(Collectors.toSet());
            }

    );

    return jwtAuthenticationConverter;
} */


}


```



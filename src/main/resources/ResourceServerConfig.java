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

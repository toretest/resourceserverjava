package no.techpros.resourceserverjava.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    /**
     * Must be open
     * @return
     */
    @GetMapping("/login")
    public String loginEndpoint() {
        return "Login!";
    }

    /**
     * Just ADMIN role
     * @return
     */
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAuthority('NICE')")
    @PreAuthorize("hasAnyRole('ADMIN','VIEW_CUSTOMER')")
    @GetMapping("/admin")
    public String adminEndpoint(Principal principal)
    {
        return "adminEndpoint with role"+((JwtAuthenticationToken) principal).getAuthorities();
    }

    /**
     * Normal Customer
     * @return
     */
    @GetMapping("/user")
    public String userEndpoint() {
        return "User!";
    }

    /**
     * As Login, open
     * @return
     */
    @GetMapping("/all")
    public String allRolesEndpoint() {
        return "All Roles!";
    }

    /**
     * Admin Role
     * @param s
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteEndpoint(@RequestBody String s) {
        return "I am deleting " + s;
    }
}

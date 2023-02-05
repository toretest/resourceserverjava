package no.techpros.resourceserverjava.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusEndpoint {


    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/toregard")
    @PreAuthorize("hasRole('VIEW_CUSTOMER')")
    public String getStatus() {
        return "Ok status";
    }
}

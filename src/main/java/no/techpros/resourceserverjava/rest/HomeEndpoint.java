package no.techpros.resourceserverjava.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeEndpoint {

    @GetMapping("home")
    public String home(){
        return "Hello JWT!";
    }
}

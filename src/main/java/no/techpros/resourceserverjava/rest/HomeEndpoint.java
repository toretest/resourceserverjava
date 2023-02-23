package no.techpros.resourceserverjava.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HomeEndpoint {

    @GetMapping("home")
    public String home() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();

    	System.out.println("My hostname is : " + inetAddress.getHostName());
        System.out.println("My IP address is  : " + inetAddress);
        return "Hello JWT! "+inetAddress;
    }
}

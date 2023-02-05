package no.techpros.resourceserverjava.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/toregard")
    public Map<String, String> get() {

        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost()
                    .getHostAddress();
        } catch (UnknownHostException e) {
            hostname = "unknown";
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Response from API");
        map.put("host", hostname);
        map.put("status", "up");
        return map;
    }
}


package restendpoints;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StatusEndpoint {

    @GetMapping("status")
    public String getStatus() {
        return "Ok";
    }

    @PreAuthorize("hasRole('ROLE_ROLE_ADMIN')")
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = { "application/json",
            "application/xml" })
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
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

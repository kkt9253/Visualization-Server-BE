package IOT_Platform.Lantern_Of_Dusk_BE.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    // test API
    @GetMapping("/device/position/test")
    public Map<String, Object> getTestPosition() {
        Random random = new Random();
        Map<String, Object> response = new HashMap<>();
        response.put("x", -100 + (200 * random.nextDouble()));
        response.put("y", -100 + (200 * random.nextDouble()));
        response.put("z", -100 + (200 * random.nextDouble()));
        response.put("timestamp", LocalDateTime.now());
        return response;
    }
}

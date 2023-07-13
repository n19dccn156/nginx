package app;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/get")
    public String get() {
        return "GET";
    }

    @PostMapping("/post")
    public String post() {
        return "POST";
    }

    @PutMapping("/put")
    public String put() {
        return "PUT";
    }

    @DeleteMapping("/del")
    public String delete() {
        return "DELETE";
    }
}
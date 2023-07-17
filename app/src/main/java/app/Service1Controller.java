package app;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s1")
public class Service1Controller {

    @GetMapping("/get")
    public String get() {
        return "GET Service 1";
    }

    @PostMapping("/post")
    public String post() {
        return "POST Service 1";
    }

    @PutMapping("/put")
    public String put() {
        return "PUT Service 1";
    }

    @DeleteMapping("/del")
    public String delete() {
        return "DELETE Service 1";
    }
}
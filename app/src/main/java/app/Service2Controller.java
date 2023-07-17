package app;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s2")
public class Service2Controller {

    @GetMapping("/get")
    public String get() {
        return "GET Service 2";
    }

    @PostMapping("/post")
    public String post() {
        return "POST Service 2";
    }

    @PutMapping("/put")
    public String put() {
        return "PUT Service 2";
    }

    @DeleteMapping("/del")
    public String delete() {
        return "DELETE Service 2";
    }
}
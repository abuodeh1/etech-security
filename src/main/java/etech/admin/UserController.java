package etech.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class UserController {

    @GetMapping("/say")
    public String sayHello(){

        return "Hello Mohammad";
    }
}

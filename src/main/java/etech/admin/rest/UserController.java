package etech.admin.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController {

    @GetMapping
    public String sayHello(){

        return "Hello World..............................";
    }

}

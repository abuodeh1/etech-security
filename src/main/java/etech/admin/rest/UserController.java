package etech.admin.rest;

import etech.admin.domain.User;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping(value = "/{userID}")
    public User getUser(@PathVariable String userID) {
        return userService.get(userID);
    }

    @DeleteMapping(value = "/{userID}")
    public void deleteUser(@PathVariable String userID) {
         userService.delete(userID);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        List userList = new ArrayList();
        userList= userService.getAllUsers();
        return userList;
    }
    @GetMapping(value = "/search")
    public List<User> findUser(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<User> querySpecification = new QuerySpecification(criteriaList);
        List<User> users = userService.findAll(querySpecification);
        return users;
    }

}

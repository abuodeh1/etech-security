package etech.admin.rest;

import etech.admin.domain.User;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value ="/{userName}" )
    public List<User> SearchUserName(@PathVariable String userName) {
        List userList = new ArrayList();
        userList= userService.searchUserName(userName);
        return userList;
    }





}

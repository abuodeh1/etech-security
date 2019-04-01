package etech.admin.rest;

import etech.admin.domain.User;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public User add(@RequestBody User user) {
        try {
            return userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity get(@PathVariable String userId) {
        User user = userService.get(userId);
        return (user == null? new ResponseEntity(HttpStatus.NO_CONTENT): ResponseEntity.accepted().body(user) );
    }

    @DeleteMapping(value = "/{userId}")
    public void delete(@PathVariable String userId) {
         userService.delete(userId);
    }

    @PutMapping
    public User update(@RequestBody User user) {

        try {
            return userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping()
    public List<User> getAll() {
        List userList = new ArrayList();
        userList= userService.getAllUsers();
        return userList;
    }

    @GetMapping(value = "/find")
    public List<User> find(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<User> querySpecification = new QuerySpecification(criteriaList);
        List<User> users = userService.findAll(querySpecification);
        return users;
    }

    @GetMapping(value = "/{userId}/deactivate")
    public User deactivate(@PathVariable String userId) {
        return userService.disableUser(userId);
    }

}

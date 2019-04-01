package etech.admin.rest;

import etech.admin.domain.User;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.UserService;
import etech.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<User> add(@RequestBody User user) {

        if(userService.get(user.getUsername()).isPresent()){

            throw new ConflictException(String.format("The user %s already defined.", user.getUsername()));
        }

        User addedUser = userService.save(user);

        return new ResponseEntity(addedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity get(@PathVariable String username) {
        ResponseEntity<User> responseEntity = null;

        Optional<User> user = userService.get(username);

        if(!user.isPresent()){

            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

        }else{

            responseEntity = new ResponseEntity(user.get(), HttpStatus.FOUND);
        }

        return responseEntity;
    }

    @Transactional
    @DeleteMapping(value = "/{username}")
    public ResponseEntity delete(@PathVariable String username) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> user = userService.get(username);

        if(user.isPresent()){

            userService.delete(username);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> sysUser = userService.get(user.getUsername());

        if(sysUser.isPresent()){

            user.setUserId(sysUser.get().getUserId());

            User updatedUser = userService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {

        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<User>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<User> querySpecification = new QuerySpecification(criteriaList);

        return new ResponseEntity(userService.find(querySpecification), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}/deactivate")
    public ResponseEntity<User> deactivate(@PathVariable String username) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> sysUser = userService.get(username);

        if(sysUser.isPresent()){

            User user = sysUser.get();

            user.setEnabled(false);

            User updatedUser = userService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{username}/activate")
    public ResponseEntity<User> activate(@PathVariable String username) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> sysUser = userService.get(username);

        if(sysUser.isPresent()){

            User user = sysUser.get();

            user.setEnabled(true);

            User updatedUser = userService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

}

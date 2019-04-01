package etech.admin.rest;

import etech.admin.domain.User;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityController<User> {

    @Autowired
    UserService baseService;

    @GetMapping(value = "/{username}/deactivate")
    public ResponseEntity<User> deactivate(@PathVariable String username) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> sysUser = baseService.get(username);

        if (sysUser.isPresent()) {

            User user = sysUser.get();

            user.setUserId(sysUser.get().getUserId());

            user.setEnabled(false);

            User updatedUser = baseService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{username}/activate")
    public ResponseEntity<User> activate(@PathVariable String username) {

        ResponseEntity<User> responseEntity = null;

        Optional<User> sysUser = baseService.get(username);

        if (sysUser.isPresent()) {

            User user = sysUser.get();

            user.setUserId(sysUser.get().getUserId());

            user.setEnabled(true);

            User updatedUser = baseService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }
}


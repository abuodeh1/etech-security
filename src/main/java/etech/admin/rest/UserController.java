package etech.admin.rest;

import etech.admin.domain.Role;
import etech.admin.domain.User;
import etech.admin.domain.UserRole;
import etech.admin.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityControllerCRUD<User, UserDTO> {

    @Autowired
    private UserService userService;



    @Override
    public User buildEntity() {
        return new User();
    }

    @Override
    public UserDTO buildDTO() {
        return new UserDTO();
    }
}


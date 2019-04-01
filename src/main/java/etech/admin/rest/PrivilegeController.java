package etech.admin.rest;

import etech.admin.domain.Privilege;
import etech.admin.domain.User;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/privilege")
public class PrivilegeController extends EntityController<Privilege> {

}


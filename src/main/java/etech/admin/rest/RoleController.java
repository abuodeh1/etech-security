package etech.admin.rest;

import etech.admin.domain.Role;
import etech.admin.dto.RoleDTO;
import etech.admin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController extends EntityControllerCRUD<Role, RoleDTO> {

    @Autowired
    private RoleService roleService;


    @Override
    public Role buildEntity() {
        return new Role();
    }

    @Override
    public RoleDTO buildDTO() {
        return new RoleDTO();
    }
}

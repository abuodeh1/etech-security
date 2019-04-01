package etech.admin.rest;

import etech.admin.domain.Role;
import etech.admin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController extends EntityController<Role> {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/{code}/deactivate")
    public ResponseEntity<Role> deactivate(@PathVariable String code) {

        ResponseEntity<Role> responseEntity = null;

        Optional<Role> sysRole = roleService.get(code);

        if(sysRole.isPresent()){

            Role role = sysRole.get();

            role.setRoleId(sysRole.get().getRoleId());

            role.setEnabled(false);

            Role updatedRole = roleService.save(role);

            responseEntity = new ResponseEntity(updatedRole, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{code}/activate")
    public ResponseEntity<Role> activate(@PathVariable String code) {

        ResponseEntity<Role> responseEntity = null;

        Optional<Role> sysRole = roleService.get(code);

        if(sysRole.isPresent()){

            Role role = sysRole.get();

            role.setRoleId(sysRole.get().getRoleId());

            role.setEnabled(true);

            Role updatedRole = roleService.save(role);

            responseEntity = new ResponseEntity(updatedRole, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

}

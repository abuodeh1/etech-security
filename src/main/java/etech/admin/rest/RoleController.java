package etech.admin.rest;

import etech.admin.domain.Role;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.RoleService;
import etech.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Role> add(@RequestBody Role role) {
        if(roleService.get(role.getCode()).isPresent()){

            throw new ConflictException(String.format("The Role %s already defined.", role.getName()));
        }

        Role addedRole = roleService.save(role);

        return new ResponseEntity(addedRole, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{roleID}")
    public ResponseEntity get(@PathVariable String roleID) {
        ResponseEntity<Role> responseEntity = null;

        Optional<Role> role = roleService.get(roleID);

        if(!role.isPresent()){

            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

        }else{

            responseEntity = new ResponseEntity(role.get(), HttpStatus.FOUND);
        }

        return responseEntity;
    }

    @Transactional
    @DeleteMapping(value = "/{roleCode}")
    public ResponseEntity delete(@PathVariable String roleCode) {

        ResponseEntity<Role> responseEntity = null;

        Optional<Role> role = roleService.get(roleCode);

        if(role.isPresent()){

            roleService.delete(roleCode);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role role) {

        ResponseEntity<Role> responseEntity = null;

        Optional<Role> sysGroup = roleService.get(role.getCode());

        if(sysGroup.isPresent()){

            role.setRoleId(sysGroup.get().getRoleId());

            Role updatedRole = roleService.save(role);

            responseEntity = new ResponseEntity(updatedRole, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<List<Role>> getAll() {

        return new ResponseEntity(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<Role>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<Role> querySpecification = new QuerySpecification(criteriaList);

        return new ResponseEntity(roleService.find(querySpecification), HttpStatus.OK);
    }

//    @GetMapping(value = "/search")
//    public List<Role> find(@RequestBody List<SearchCriteria> criteriaList) {
//        QuerySpecification<Role> querySpecification = new QuerySpecification<>(criteriaList);
//        List<Role> authorities = roleService.findAll(querySpecification);
//        return authorities;
//    }

    @GetMapping(value = "/{roleID}/deactivate")
    public Role deactivate(@PathVariable String roleID) {
        return roleService.disableRole(roleID);
    }


}

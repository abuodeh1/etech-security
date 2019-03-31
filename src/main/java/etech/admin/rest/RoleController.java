package etech.admin.rest;

import etech.admin.domain.Role;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping(value = "/{roleID}")
    public Role getRole(@PathVariable String roleID) {
        return roleService.get(roleID);
    }

    @DeleteMapping (value = "/{roleID}")
    public void deleteRole(@PathVariable String roleID) {
        roleService.delete(roleID);
    }

    @PutMapping
    public Role updateRole(@RequestBody Role role) {
        return roleService.update(role);
    }

    @GetMapping()
    public List<Role> getAllroles() {
        List roleList = new ArrayList();
        roleList= roleService.getAllRoles();
        return roleList;
    }

    @GetMapping(value = "/search")
    public List<Role> findRole(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<Role> querySpecification = new QuerySpecification<>(criteriaList);
        List<Role> roles = roleService.findAll(querySpecification);
        return roles;
    }

    @GetMapping(value = "/{roleID}/disable")
    public Role disableRole(@PathVariable String roleID) {
        return roleService.disableRole(roleID);
    }


}

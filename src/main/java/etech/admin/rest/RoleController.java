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
    public Role add(@RequestBody Role role) {
        try {
            return roleService.create(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @GetMapping(value = "/{roleID}")
    public Role get(@PathVariable String roleID) {
        return roleService.get(roleID);
    }

    @DeleteMapping (value = "/{roleID}")
    public void delete(@PathVariable String roleID) {
        roleService.delete(roleID);
    }

    @PutMapping
    public Role update(@RequestBody Role role) throws Exception {
        return roleService.update(role);
    }

    @GetMapping()
    public List<Role> getAll() {
        List roleList = new ArrayList();
        roleList= roleService.getAllRoles();
        return roleList;
    }

    @GetMapping(value = "/search")
    public List<Role> find(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<Role> querySpecification = new QuerySpecification<>(criteriaList);
        List<Role> authorities = roleService.findAll(querySpecification);
        return authorities;
    }

    @GetMapping(value = "/{roleID}/deactivate")
    public Role deactivate(@PathVariable String roleID) {
        return roleService.disableRole(roleID);
    }


}

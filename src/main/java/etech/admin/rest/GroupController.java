package etech.admin.rest;

import etech.admin.domain.Group;
import etech.admin.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController extends BaseSecurityController{

    @Autowired
    GroupService groupService;

    @PostMapping
    public Group createUser(@RequestBody Group group) {
        return groupService.create(group);
    }

    @GetMapping(value = "/{groupID}")
    public Group getGroup(@PathVariable String groupID) {
        return groupService.get(groupID);
    }

    @DeleteMapping(value = "/{groupID}")
    public void deleteUser(@PathVariable String groupID) {
        groupService.delete(groupID);
    }

    @PutMapping
    public Group updateUser(@RequestBody Group group) {
        return groupService.update(group);
    }

}

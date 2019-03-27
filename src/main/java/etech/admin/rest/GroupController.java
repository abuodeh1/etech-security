package etech.admin.rest;

import etech.admin.domain.Group;
import etech.admin.domain.User;
import etech.admin.services.GroupService;
import etech.admin.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController  {

    @Autowired
    GroupService groupService;

    @PostMapping
    public Group createUser(@RequestBody Group group) {
        return groupService.create(group);
    }

    @GetMapping(value = "/{groupID}")
    public Group getGroup(@PathVariable String groupID)  {
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

    @GetMapping()
    public List<Group> getAllGroups() throws Exception {
        List groupList = new ArrayList();
        groupList= groupService.getAllGroup();
        return groupList;
    }

}

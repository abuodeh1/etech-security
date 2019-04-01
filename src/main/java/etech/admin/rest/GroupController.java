package etech.admin.rest;

import etech.admin.domain.Group;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public Group add(@RequestBody Group group) {
        try {
            return groupService.create(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/{groupID}")
    public Group get(@PathVariable String groupID) {
        return groupService.get(groupID);
    }

    @DeleteMapping(value = "/{groupID}")
    public void delete(@PathVariable String groupID) {
        groupService.delete(groupID);
    }

    @PutMapping
    public Group update(@RequestBody Group group) {
        try {
            return groupService.update(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping()
    public List<Group> getAll() {
        List groupList = new ArrayList();
        groupList= groupService.getAllGroup();
        return groupList;
    }

    @GetMapping(value = "/find")
    public List<Group> findGroup(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<Group> querySpecification = new QuerySpecification(criteriaList);
        List<Group> groups = groupService.findAll(querySpecification);
        return groups;
    }
}

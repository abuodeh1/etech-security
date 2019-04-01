package etech.admin.rest;

import etech.admin.domain.Group;
import etech.admin.domain.User;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.GroupService;
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
@RequestMapping(value = "/api/admin/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Group> add(@RequestBody Group group) {
        if(groupService.get(group.getCode()).isPresent()){

            throw new ConflictException(String.format("The group %s already defined.", group.getName()));
        }

        Group addedGroup = groupService.save(group);

        return new ResponseEntity(addedGroup, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{groupID}")
    public ResponseEntity get(@PathVariable String groupID) {
            ResponseEntity<Group> responseEntity = null;

            Optional<Group> group = groupService.get(groupID);

            if(!group.isPresent()){

                responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

            }else{

                responseEntity = new ResponseEntity(group.get(), HttpStatus.FOUND);
            }

            return responseEntity;
        }

    @Transactional
    @DeleteMapping(value = "/{groupCode}")
    public ResponseEntity delete(@PathVariable String groupCode) {

        ResponseEntity<Group> responseEntity = null;

        Optional<Group> user = groupService.get(groupCode);

        if(user.isPresent()){

            groupService.delete(groupCode);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody Group group) {

        ResponseEntity<User> responseEntity = null;

        Optional<Group> sysGroup = groupService.get(group.getCode());

        if(sysGroup.isPresent()){

            group.setGroupId(sysGroup.get().getGroupId());

            Group updatedUser = groupService.save(group);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;

    }


    @GetMapping()
    public ResponseEntity<List<Group>> getAll() {

        return new ResponseEntity(groupService.getAllGroup(), HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<Group>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<Group> querySpecification = new QuerySpecification(criteriaList);

        return new ResponseEntity(groupService.find(querySpecification), HttpStatus.OK);
    }

}

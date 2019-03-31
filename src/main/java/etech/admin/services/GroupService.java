package etech.admin.services;

import etech.admin.domain.Group;
import etech.admin.repositories.GroupRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group create(Group group) throws Exception {

        Optional<Group> checkUser = groupRepository.findById(group.getCode());

        if (checkUser.isPresent() && (checkUser.get().getCode().equals(group.getCode()))) {

            throw new Exception("Group already exists");

        } else {
            return groupRepository.save(group);
        }

    }

    public Group get(String id) {

        Optional<Group> group = groupRepository.findById(id);

        return group.isPresent() ? group.get() : null;
    }

    public void delete(String id) {
        if (get(id) != null)

            groupRepository.deleteById(id);
    }

    public Group update(Group group) throws Exception {

        Optional<Group> checkgroup = groupRepository.findById(group.getCode());

        if (checkgroup.isPresent()) {
            return groupRepository.save(group);
        } else {
            throw new Exception("Group not exist");
        }
    }

    public List<Group> getAllGroup() {
        List groupList = new ArrayList();
        groupList = groupRepository.findAll();
        return groupList;
    }

    public List<Group> findAll(QuerySpecification<Group> groupSpecification) {
        return groupRepository.findAll(groupSpecification);
    }

}


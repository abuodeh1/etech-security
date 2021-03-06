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
public class GroupService implements EntityService<Group> {

    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group) {

        return groupRepository.save(group);

    }

    public Optional<Group> get(String groupCode) {

        Optional<Group> group = groupRepository.findGroupByCode(groupCode);

        return group;
    }

    public boolean delete(String code) {
        Optional<Group> user = get(code);

        if (user.isPresent()) {

            groupRepository.delete(user.get());

            return true;
        }

        return false;
    }

    @Override
    public List<Group> getAll() {

        return groupRepository.findAll();
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

    public List<Group> find(QuerySpecification<Group> userSpecification) {

        return groupRepository.findAll(userSpecification);

    }

}


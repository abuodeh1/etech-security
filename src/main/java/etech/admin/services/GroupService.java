package etech.admin.services;

import etech.admin.domain.Group;
import etech.admin.domain.User;
import etech.admin.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group create(Group group) {

        return groupRepository.save(group);
    }

    public Group get(String id) {

        Optional<Group> group = groupRepository.findById(id);

        return group.isPresent() ? group.get() : null;
    }

    public void delete(String id) {
        if ( get(id) != null )

            groupRepository.deleteById(id);
    }

    public Group update(Group group) {

        return groupRepository.save(group);
    }

    public List<Group> getAllGroup() {
        List  groupList = new ArrayList();
        groupList=groupRepository.findAll();
        return groupList;
    }

}


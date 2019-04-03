package etech.admin.services;

import etech.admin.domain.Role;
import etech.admin.domain.UserRole;
import etech.admin.repositories.UserRoleRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService implements EntityService<UserRole> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole save(UserRole userRole) {

        return userRoleRepository.save(userRole);

    }

    public List<UserRole> find(QuerySpecification<UserRole> userSpecification) {

        return userRoleRepository.findAll(userSpecification);

    }

    public Optional<UserRole> get(String id) {

        return null;

    }

    public boolean delete(String code) {

        Optional<UserRole> role = get(code);

        if (role.isPresent()) {

            userRoleRepository.delete(role.get());

            return true;
        }

        return false;
    }

    public List<UserRole> getAll() {

        return userRoleRepository.findAll();
    }

}

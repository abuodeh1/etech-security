package etech.admin.services;

import etech.admin.domain.Role;
import etech.admin.repositories.RoleRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements EntityService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {

        return roleRepository.save(role);

    }

    public List<Role> find(QuerySpecification<Role> userSpecification) {

        return roleRepository.findAll(userSpecification);

    }

    public Optional<Role> get(String id) {

        return roleRepository.findRoleByCode(id);

    }

    public boolean delete(String code) {

        Optional<Role> role = get(code);

        if (role.isPresent()) {

            roleRepository.delete(role.get());

            return true;
        }

        return false;
    }

    public List<Role> getAll() {

        return roleRepository.findAll();
    }

}

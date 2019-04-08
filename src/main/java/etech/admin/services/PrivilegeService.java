package etech.admin.services;

import etech.admin.domain.Privilege;
import etech.admin.repositories.PrivilegeRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService implements EntityService<Privilege> {


    @Autowired
    private PrivilegeRepository privilegeRepository;

    public Privilege save(Privilege privilege) {

        return privilegeRepository.save(privilege);

    }

    public List<Privilege> find(QuerySpecification<Privilege> querySpecification) {

        return privilegeRepository.findAll(querySpecification);

    }

    public Optional<Privilege> get(String id) {

        return privilegeRepository.findPrivilegeByCode(id);

    }

    public boolean delete(String code) {

        Optional<Privilege> role = get(code);

        if (role.isPresent()) {

            privilegeRepository.delete(role.get());

            return true;
        }

        return false;
    }

    public List<Privilege> getAll() {

        return privilegeRepository.findAll();
    }
}

package etech.admin.services;

import etech.admin.domain.Role;
import etech.admin.repositories.RoleRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;



    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public List<Role> findAll(QuerySpecification<Role> roleSpecification){
        return roleRepository.findAll(roleSpecification);
    }

    public Role save(Role role){


            return roleRepository.save(role);


    }

    public Optional<Role> get(String id) {

        return   roleRepository.findRoleByCode(id);


    }

    public void delete(String id) {

        if ( get(id) != null )

            roleRepository.deleteByCode(id);
    }

    public Role update(Role role) throws Exception {

        Optional<Role> checkgroup = roleRepository.findById(role.getCode());

        if (checkgroup.isPresent()) {
            return roleRepository.save(role);
        } else {
            throw new Exception("Role not exist");
        }
    }

    public List<Role> getAllRoles() {
        List  roleList = new ArrayList();
        roleList=roleRepository.findAll();
        return roleList;
    }

    public Role disableRole(String roleID) {

        Optional<Role> role1= roleRepository.findById(roleID);
        role1.get().setEnabled(false);

        Role role2 =  roleRepository.save(role1.get());

        return role2;

    }
    public List<Role> find(QuerySpecification<Role> userSpecification) {

        return roleRepository.findAll(userSpecification);

    }
}

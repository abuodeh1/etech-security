package etech.admin.repositories;

import etech.admin.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> , JpaSpecificationExecutor<Role> {

    Optional<Role> findRoleByCode(String code);

}
package etech.admin.repositories;

import etech.admin.domain.Role;
import etech.admin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> , JpaSpecificationExecutor<Role> {
}
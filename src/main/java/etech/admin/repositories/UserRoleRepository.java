package etech.admin.repositories;

import etech.admin.domain.Role;
import etech.admin.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> , JpaSpecificationExecutor<UserRole> {


}
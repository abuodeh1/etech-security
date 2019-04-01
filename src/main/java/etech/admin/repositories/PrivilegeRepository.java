package etech.admin.repositories;

import etech.admin.domain.Privilege;
import etech.admin.domain.User;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String>, JpaSpecificationExecutor<Privilege> {

    Optional<Privilege> findPrivilegeByCode(String code);

}
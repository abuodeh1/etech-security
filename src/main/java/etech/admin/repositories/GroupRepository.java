package etech.admin.repositories;

import etech.admin.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, String>, JpaSpecificationExecutor<Group> {

    Optional<Group> findGroupByCode(String code);
    Optional<Group> deleteByCode(String code);

}
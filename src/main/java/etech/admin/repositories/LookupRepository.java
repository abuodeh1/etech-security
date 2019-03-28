package etech.admin.repositories;

import etech.admin.domain.Lookup;
import etech.admin.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, String>, JpaSpecificationExecutor<Lookup> {

    @Query
	public List<Lookup> GetAllParentsLookup();

    @Query
    public List<Lookup> GetAllChildsLookup(String id);

    @Query
    public List<Lookup> GetChildLookup(String id,String parent);


}

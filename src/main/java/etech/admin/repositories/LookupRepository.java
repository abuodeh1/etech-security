package etech.admin.repositories;

import etech.admin.domain.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, String>, JpaSpecificationExecutor<Lookup> {

    Optional<Lookup> findLookupByCode(String code);

    @Query
	public  List<Lookup> getAllParentsLookup();

    @Query
    public List<Lookup> getAllChildsLookup(String id);

    @Query
    public  Lookup getChildLookup(String id, String parent);

    @Query
    Lookup getParentLookup(String code);

//    @Modifying
//    @Transactional
//    @Query
//    public void attachChildLookup (String parent,String id);

    @Query
    public List<Lookup> GetAllParentsLookupForAllList();
}

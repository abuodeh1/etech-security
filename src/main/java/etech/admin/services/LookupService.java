package etech.admin.services;

import etech.admin.domain.Lookup;
import etech.admin.domain.Role;
import etech.admin.repositories.LookupRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LookupService {

    @Autowired
    LookupRepository lookupRepository;

    public void save(Lookup lookup){

        lookupRepository.save(lookup);
    }

    public List<Lookup> findAll(){
        return lookupRepository.findAll();
    }

    public List<Lookup> findAll(QuerySpecification<Lookup> lookupSpecification){
        return lookupRepository.findAll(lookupSpecification);
    }

    public Lookup create(Lookup lookup) {

        return lookupRepository.save(lookup);
    }

    public Lookup get(String id) {

        Optional<Lookup> lookup = lookupRepository.findById(id);

        return lookup.isPresent() ? lookup.get() : null;
    }

    public void delete(String id) {

        if ( get(id) != null )

            lookupRepository.deleteById(id);
    }

    public Lookup update(Lookup lookup) {

        return lookupRepository.save(lookup);
    }

    public List<Lookup> getAllLookups() {
        List  lookupList = new ArrayList();
        lookupList=lookupRepository.findAll();
        return lookupList;
    }


    public Lookup disableLookup(String lookupID) {

        Optional<Lookup> lookup= lookupRepository.findById(lookupID);
        lookup.get().setEnabled(false);

        Lookup Lookup2=  lookupRepository.save(lookup.get());

        return Lookup2;

    }
}

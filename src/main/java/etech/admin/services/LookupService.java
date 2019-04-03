package etech.admin.services;

import etech.admin.domain.Lookup;
import etech.admin.repositories.LookupRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LookupService implements EntityService<Lookup> {

    @Autowired
    private LookupRepository lookupRepository;


    @Override
    public List<Lookup> getAll() {
        return lookupRepository.findAll();
    }

    @Override
    public List<Lookup> find(QuerySpecification<Lookup> querySpecification) {
        return null;
    }

    @Override
    public Optional<Lookup> get(String code) {
        return Optional.empty();
    }

    public Lookup save(Lookup lookup){

        return lookupRepository.save(lookup);
    }

    @Override
    public boolean delete(String code) {
        return false;
    }




//
//    public List<Lookup> findAll() {
//        return lookupRepository.findAll();
//    }
//
//    public List<Lookup> findAll(QuerySpecification<Lookup> lookupSpecification) {
//        return lookupRepository.findAll(lookupSpecification);
//    }
//
//    public Lookup create(Lookup lookup) throws Exception {
//
//        Optional<Lookup> checkLookup = lookupRepository.findById(lookup.getCode());
//
//        if (checkLookup.isPresent() && (checkLookup.get().getCode().equals(lookup.getCode()))) {
//
//            throw new Exception("Lookup already exists");
//
//        } else {
//            return lookupRepository.save(lookup);
//        }
//
//    }
//
////    public Lookup get(String id) {
////
////        Optional<Lookup> lookup = lookupRepository.findById(id);
////
////        return lookup.isPresent() ? lookup.get() : null;
////    }
////
////    public void delete(String id) {
////
////        if (get(id) != null)
////
////            lookupRepository.deleteById(id);
////    }
//
//    public Lookup update(Lookup lookup) throws Exception {
//        Optional<Lookup> checkLookup = lookupRepository.findById(lookup.getCode());
//
//        if (checkLookup.isPresent()) {
//            return lookupRepository.save(lookup);
//        } else {
//            throw new Exception("Lookup not exist");
//        }
//
//    }
//
//    public List<Lookup> getAllLookups() {
//        List lookupList = new ArrayList();
//        lookupList = lookupRepository.findAll();
//        return lookupList;
//    }
//
//    public List<Lookup> getAllLookups2() {
//        List lookupList = new ArrayList();
//        lookupList = lookupRepository.findAll();
//
//
//
//        return lookupList;
//    }
//
//
//    public Lookup disableLookup(String lookupID) {
//
//        Optional<Lookup> lookup = lookupRepository.findById(lookupID);
//        lookup.get().setEnabled(false);
//
//        Lookup Lookup2 = lookupRepository.save(lookup.get());
//
//        return Lookup2;
//
//    }
//
//    public String getParentLookup(String lookupID) {
//
//        Optional<Lookup> lookup = lookupRepository.findById(lookupID);
//        lookup.get().getParent();
//
//        return lookup.get().getParent();
//
//    }
//
//    public List<Lookup> getAllParentLookup() {
//
//        List<Lookup> lookup= lookupRepository.GetAllParentsLookup();
//
//        return  lookup;
//    }
//
//    public String getChildLookup(String lookupID) {
//
//        Optional<Lookup> lookup= lookupRepository.findById(lookupID);
//        lookup.get().getParent();
//
//        return  lookup.get().getParent();
//        ///not ready ..................................
//    }
//
//    public List<Lookup> GetAllChildsLookup(String  id) {
//
//        List<Lookup> lookup= lookupRepository.GetAllChildsLookup(id);
//
//        return  lookup;
//    }
//    public List<Lookup> GetChildLookup(String  id ,String  parentID) {
//
//        List<Lookup> lookup= lookupRepository.GetChildLookup(id,parentID);
//
//        return  lookup;
//    }
//    public void attachChildLookup(String  parentID ,String ID ) {
//
//        lookupRepository.attachChildLookup(parentID,ID);
//
//
//    }



}

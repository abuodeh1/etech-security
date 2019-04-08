package etech.admin.rest;

import etech.admin.domain.Lookup;
import etech.admin.dto.LookupDTO;
import etech.admin.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController extends EntityControllerCRUD<Lookup, LookupDTO> {

    @Autowired
    LookupService lookupService;


    @GetMapping(value = "/parent")
    public ResponseEntity<List<Lookup>> getAllParentLookup() {

        return new ResponseEntity(lookupService.getAllParentLookup(), HttpStatus.OK);
    }

    @GetMapping(value = "/parent/{code}")
    public ResponseEntity<Lookup> getParentLookup(@PathVariable  String code) {

        return new ResponseEntity(lookupService.getParentLookup(code), HttpStatus.OK);
    }

    @GetMapping(value = "/parent/{parent}/childs")
    public ResponseEntity<List<Lookup>> getAllChildsLookup(@PathVariable String parent) {

        return new ResponseEntity(lookupService.getAllChildsLookup(parent), HttpStatus.OK);
    }

//    @GetMapping(value = "/{lookupID}/{parent}")
//    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
//        return lookupService.getChildLookup(lookupID,parent);
//    }

//    @GetMapping(value = "/{parentID}/{lookupID}/attach")
//    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
//       lookupService.attachChildLookup(parentID,lookupID);
//    }

    @Override
    public Lookup buildEntity() {
        return new Lookup();
    }

    @Override
    public LookupDTO buildDTO() {
        return new LookupDTO();
    }
}

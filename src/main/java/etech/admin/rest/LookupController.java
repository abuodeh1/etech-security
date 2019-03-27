package etech.admin.rest;

import etech.admin.domain.Lookup;
import etech.admin.domain.Role;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController {



    @Autowired
    LookupService lookupService;

    @PostMapping
    public Lookup createLookup(@RequestBody Lookup lookup) {
        return lookupService.create(lookup);
    }

    @GetMapping(value = "/{lookupID}")
    public Lookup getlookup(@PathVariable String lookupID) {
        return lookupService.get(lookupID);
    }

    @DeleteMapping (value = "/{lookupID}")
    public void deleteLookup(@PathVariable String lookupID) {
        lookupService.delete(lookupID);
    }

    @PutMapping
    public Lookup updateLookup(@RequestBody Lookup lookup) {
        return lookupService.update(lookup);
    }

    @GetMapping()
    public List<Lookup> getAlllookups() {
        List lookupList = new ArrayList();
        lookupList= lookupService.getAllLookups();
        return lookupList;
    }

    @GetMapping(value = "/search")
    public List<Lookup> findLookup(@RequestBody List<SearchCriteria> criteriaList) {
        QuerySpecification<Lookup> querySpecification = new QuerySpecification<>(criteriaList);
        List<Lookup> lookups = lookupService.findAll(querySpecification);
        return lookups;
    }

    @GetMapping(value = "/{roleID}/disable")
    public Lookup disableRole(@PathVariable String lookupID) {
        return lookupService.disableLookup(lookupID);
    }


}

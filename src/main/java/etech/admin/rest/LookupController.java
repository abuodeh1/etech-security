package etech.admin.rest;

import etech.admin.domain.Lookup;
import etech.admin.dto.LookupDTO;
import etech.admin.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController extends EntityControllerCRUD<Lookup, LookupDTO> {

    @Autowired
    LookupService lookupService;

//    @GetMapping(value = "/{roleID}/deactive")
//    public Lookup deactiveRole(@PathVariable String lookupID) {
//        return lookupService.disableLookup(lookupID);
//    }

    @GetMapping(value = "/lookupID/parent")
    public String getParentLookup(@PathVariable String lookupID) {
        return lookupService.getParentLookup(lookupID);
    }

    @GetMapping(value = "/AllParent")
    public List<Lookup> getAllParentLookup() {
        return lookupService.getAllParentLookup();
    }

    @GetMapping(value = "/{lookupID}/AllChilds")
    public List<Lookup> getAllChildsLookup(@PathVariable String lookupID) {
        return lookupService.GetAllChildsLookup(lookupID);
    }

    @GetMapping(value = "/{lookupID}/{parent}")
    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
        return lookupService.GetChildLookup(lookupID,parent);
    }

    @GetMapping(value = "attach/{parentID}/{lookupID}")
    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
       lookupService.attachChildLookup(parentID,lookupID);
    }


    @Override
    public Lookup buildEntity() {
        return new Lookup();
    }

    @Override
    public LookupDTO buildDTO() {
        return new LookupDTO();
    }
}

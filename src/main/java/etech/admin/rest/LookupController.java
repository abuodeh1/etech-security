package etech.admin.rest;

import etech.admin.domain.Lookup;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController extends EntityController<Lookup>{

    @Autowired
    LookupService lookupService;



    @GetMapping(value = "/{roleID}/deactive")
    public Lookup deactiveRole(@PathVariable String lookupID) {
        return lookupService.disableLookup(lookupID);
    }

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

    @GetMapping(value = "/test")
    public List<Lookup> getAlllookups2() {
        List<Lookup> lookupList = new ArrayList();
        lookupList= lookupService.GetAllParentsLookupForAllList();

        for (int i =0 ; i<lookupList.size();i++){

            lookupList.get(i).setChildList(getAllChildsLookup(lookupList.get(i).getCode()));

            for (int j =0 ; j<lookupList.get(i).getChildList().size();j++) {

                lookupList.get(i).getChildList().get(j).setChildList(getAllChildsLookup(lookupList.get(i).getChildList().get(j).getCode()));
            }
        }
        return lookupList;
//        List<Lookup> customersWithMoreThan100Points = lookupList
//                .stream()
//                .filter(c -> c.getParent() != "0")
//                .collect(Collectors.toMap(lookupList,List <Lookup> ));
//
//        return customersWithMoreThan100Points;

    }


}

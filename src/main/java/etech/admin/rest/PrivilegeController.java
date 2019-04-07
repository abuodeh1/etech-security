package etech.admin.rest;

import etech.admin.domain.Privilege;
import etech.admin.dto.PrivilegeDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/privilege")
public class PrivilegeController extends EntityControllerCRUD<Privilege, PrivilegeDTO> {

    @Override
    public Privilege buildEntity() {
        return new Privilege();
    }

    @Override
    public PrivilegeDTO buildDTO() {
        return new PrivilegeDTO();
    }
}


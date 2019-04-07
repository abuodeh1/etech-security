package etech.admin.rest;

import etech.admin.domain.DefaultEntity;
import etech.admin.dto.DefaultDTO;
import etech.admin.services.EntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public abstract class EntityControllerActivation<T extends DefaultEntity, D extends DefaultDTO> {

    @Autowired
    EntityService<T> baseService;

    @GetMapping(value = "/{username}/deactivate")
    public ResponseEntity<D> deactivate(@PathVariable String username) {

        ResponseEntity<D> responseEntity = null;

        Optional<T> sysUser = baseService.get(username);

        if (sysUser.isPresent()) {

            T user = sysUser.get();

            user.setId(sysUser.get().getId());


            user.setEnabled(false);

            T updatedUser = baseService.save(user);

            D userDTO = buildDTO();

            BeanUtils.copyProperties(updatedUser, userDTO,"password");

            responseEntity = new ResponseEntity(userDTO, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{username}/activate")
    public ResponseEntity<D> activate(@PathVariable String username) {

        D userDTO = buildDTO();

        ResponseEntity<D> responseEntity = null;

        Optional<T> sysUser = baseService.get(username);

        if (sysUser.isPresent()) {

            T user = sysUser.get();

            user.setId(sysUser.get().getId());

            user.setEnabled(true);

            T updatedUser = baseService.save(user);

            BeanUtils.copyProperties(updatedUser, userDTO);

            responseEntity = new ResponseEntity(userDTO, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }
    public abstract T buildEntity();
    public abstract D buildDTO();

}

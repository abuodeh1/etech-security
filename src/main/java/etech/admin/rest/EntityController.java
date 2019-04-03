package etech.admin.rest;

import etech.admin.domain.DefaultEntity;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.EntityService;
import etech.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class EntityController<T extends DefaultEntity> {

    @Autowired
    EntityService<T> baseService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<T> add(@RequestBody T user) {

        if(baseService.get(user.getCode()).isPresent()){

            throw new ConflictException(String.format("The user %s already defined.", user.getCode()));
        }

        DefaultEntity addedUser = baseService.save(user);

        return new ResponseEntity(addedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<T> get(@PathVariable String code) {
        ResponseEntity<T> responseEntity = null;

        Optional<T> user = baseService.get(code);

        if(user.isPresent()){

            responseEntity = new ResponseEntity(user.get(), HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity delete(@PathVariable String code) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> user = baseService.get(code);

        if(user.isPresent()){

            baseService.delete(code);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T user) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> sysUser = baseService.get(user.getCode());

        if(sysUser.isPresent()){

            user.setId(sysUser.get().getId());

            T updatedUser = baseService.save(user);

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<List<T>> getAll() {

        return new ResponseEntity(baseService.getAll(), HttpStatus.OK);
    }

    @PostMapping( value = "/find")
    public ResponseEntity<List<T>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<T> querySpecification = new QuerySpecification(criteriaList);

        return new ResponseEntity(baseService.find(querySpecification), HttpStatus.OK);
    }
}

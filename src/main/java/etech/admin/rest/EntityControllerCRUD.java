package etech.admin.rest;

import etech.admin.domain.DefaultEntity;
import etech.admin.domain.User;
import etech.admin.dto.DefaultDTO;
import etech.admin.rest.find.QuerySpecification;
import etech.admin.rest.find.SearchCriteria;
import etech.admin.services.EntityService;
import etech.exception.ConflictException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class EntityControllerCRUD<T extends DefaultEntity, D extends DefaultDTO> extends EntityControllerActivation<T, D > {

    @Autowired
    EntityService<T> baseService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<T> add(@RequestBody D dto) {

        Optional<T> entity = baseService.get(dto.getCode());

        if(entity.isPresent()){

            throw new ConflictException(String.format("The %s already defined.", dto.getCode()));
        }

        T newEntity = buildEntity();

        BeanUtils.copyProperties(dto, newEntity);

        T addedUser = baseService.save(newEntity);

        BeanUtils.copyProperties(addedUser, dto, "password");

        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<T> get(@PathVariable String code) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(code);

        if(entity.isPresent()){

            D dto = buildDTO();

            BeanUtils.copyProperties(entity.get(), dto, "password");

            responseEntity = new ResponseEntity(dto, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity delete(@PathVariable String code) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(code);

        if(entity.isPresent()){

            baseService.delete(code);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody D dto) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(dto.getCode());

        if(entity.isPresent()){

            T newEntity = buildEntity();

            BeanUtils.copyProperties(dto, newEntity);

            newEntity.setId(entity.get().getId());

            T updatedUser = baseService.save(newEntity);

            BeanUtils.copyProperties(newEntity, dto, "password");

            responseEntity = new ResponseEntity(updatedUser, HttpStatus.OK);

        }else{

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<List<T>> getAll() {

        List<T> entities = baseService.getAll();

        List<D> dtos = new ArrayList<>();

        entities.stream().forEach( entity -> {
            D dto = buildDTO();
            BeanUtils.copyProperties(entity, dto, "password");
            dtos.add(dto);
        });
        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @PostMapping( value = "/find")
    public ResponseEntity<List<T>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<T> querySpecification = new QuerySpecification(criteriaList);

        List<T> entities = baseService.find(querySpecification);

        List<D> dtos = new ArrayList<>();

        entities.stream().forEach( entity -> {
            D dto = buildDTO();
            BeanUtils.copyProperties(entity, dto, "password");
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    public abstract T buildEntity();
    public abstract D buildDTO();
}

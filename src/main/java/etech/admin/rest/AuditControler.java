package etech.admin.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import etech.admin.domain.Group;
import etech.admin.domain.User;
import etech.logging.AuditQueryResult;
import etech.logging.CustomRevision;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/audit")
public class AuditControler implements Serializable {

    @Autowired
    private EntityManager entityManager;

    @GetMapping(value = "/user/{username}")
    public List getUserAudit(@PathVariable String username) {

        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        //AuditQuery query = auditReader.createQuery().forEntitiesAtRevision(User.class, 2);

        AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(User.class, false, true);
        auditQuery.add(AuditEntity.id().eq(username));
        auditQuery.addOrder(AuditEntity.revisionNumber().desc());

        return auditQuery.getResultList();
    }

    @GetMapping(value = "/group/{code}")
    public List<AuditQueryResult<Group>> getGroupAudit(@PathVariable String code) {

        List<AuditQueryResult<Group>> auditQueryResultList = new ArrayList<>();

        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        //AuditQuery query = auditReader.createQuery().forEntitiesAtRevision(Group.class, 2);

        AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Group.class, false, true);
        //auditQuery.add(AuditEntity.id("code").eq(code));
        auditQuery.addOrder(AuditEntity.revisionNumber().desc());

        List result = auditQuery.getResultList();
        result.forEach(rs -> {
            Object[] objects = (Object[]) rs;
            auditQueryResultList.add(new AuditQueryResult(objects[0], (CustomRevision)objects[1], (RevisionType) objects[2]));
        });


        return auditQueryResultList;
    }
}

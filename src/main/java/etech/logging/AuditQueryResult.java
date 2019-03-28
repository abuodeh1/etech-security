package etech.logging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.envers.RevisionType;

import java.io.Serializable;

public class AuditQueryResult<T> implements Serializable {

    private final T entity;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private final CustomRevision revision;
    private final RevisionType type;

    public AuditQueryResult(T entity, CustomRevision revision, RevisionType type) {
        this.entity = entity;
        this.revision = revision;
        this.type = type;
    }

    public T getEntity() {
        return entity;
    }

    public CustomRevision getRevision() {
        return revision;
    }

    public RevisionType getType() {
        return type;
    }


}
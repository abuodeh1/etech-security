package etech.admin.domain;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPROLES")
public class GroupRole {


    @EmbeddedId
    private GroupRoleIdentity groupRoleIdentity;

    private long lastModified;

    public GroupRole() {
        setLastModified(new Date().getTime());
    }

    public GroupRoleIdentity getGroupRoleIdentity() {
        return groupRoleIdentity;
    }

    public void setGroupRoleIdentity(GroupRoleIdentity groupRoleIdentity) {
        this.groupRoleIdentity = groupRoleIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}
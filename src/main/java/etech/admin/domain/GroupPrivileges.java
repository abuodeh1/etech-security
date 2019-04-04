package etech.admin.domain;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPPRIVILEGES")
public class GroupPrivileges {

    @EmbeddedId
    private GroupPrivilegesIdentity groupPrivilegesIdentity;

    private long lastModified;

    public GroupPrivileges() {
        setLastModified(new Date().getTime());
    }

    public GroupPrivilegesIdentity getGroupPrivilegesIdentity() {
        return groupPrivilegesIdentity;
    }

    public void setGroupPrivilegesIdentity(GroupPrivilegesIdentity groupPrivilegesIdentity) {
        this.groupPrivilegesIdentity = groupPrivilegesIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

}

package etech.admin.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

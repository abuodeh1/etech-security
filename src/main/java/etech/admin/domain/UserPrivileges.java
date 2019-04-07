package etech.admin.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="USERPRIVILEGES")
public class UserPrivileges {

    @EmbeddedId
    private UserPrivilegesIdentity userPrivilegesIdentity;

    private long lastModified;

    public UserPrivileges() {
        setLastModified(new Date().getTime());
    }


    public UserPrivilegesIdentity getUserPrivilegesIdentity() {
        return userPrivilegesIdentity;
    }

    public void setUserPrivilegesIdentity(UserPrivilegesIdentity userPrivilegesIdentity) {
        this.userPrivilegesIdentity = userPrivilegesIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}

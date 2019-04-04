package etech.admin.domain;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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

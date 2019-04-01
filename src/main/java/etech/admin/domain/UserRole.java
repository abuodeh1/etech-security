package etech.admin.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="USERROLES")
public class UserRole {

    @EmbeddedId
    private UserRoleIdentity userRoleIdentity;

    private long lastModified;


    public UserRole() {
        setLastModified(new Date().getTime());
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public UserRoleIdentity getUserRoleIdentity() {
        return userRoleIdentity;
    }

    public void setUserRoleIdentity(UserRoleIdentity userRoleIdentity) {
        this.userRoleIdentity = userRoleIdentity;
    }
}

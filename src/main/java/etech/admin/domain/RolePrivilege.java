package etech.admin.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="ROLEPRIVILEGE")
public class RolePrivilege {

    @EmbeddedId
    private RolePrivilegeIdentity rolePrivilegesIdentity;

    private long lastModified;

    public RolePrivilege() {
        setLastModified(new Date().getTime());
    }

    public RolePrivilegeIdentity getRolePrivilegesIdentity() {
        return rolePrivilegesIdentity;
    }

    public void setRolePrivilegesIdentity(RolePrivilegeIdentity rolePrivilegesIdentity) {
        this.rolePrivilegesIdentity = rolePrivilegesIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}

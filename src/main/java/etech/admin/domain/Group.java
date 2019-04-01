package etech.admin.domain;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPS")
public class Group /*extends AuditInfo*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    private String code;
    private String name;
    private String description;
    private boolean enabled;

    public Group() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}

package etech.admin.domain;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Lookup.GetAllParentsLookup", query = "select DISTINCT(c.parent) from Lookup c"),
        @NamedQuery(name = "Lookup.GetAllParentsLookupForAllList", query = "select c from Lookup c where c.parent='0'"),
        @NamedQuery(name = "Lookup.GetAllChildsLookup", query = "select c  from Lookup c where c.parent=?1"),
        @NamedQuery(name = "Lookup.GetChildLookup", query = "select c.name  from Lookup c where c.parent=?1 and c.code=?2 "),
        @NamedQuery(name = "Lookup.attachChildLookup", query = "update Lookup  set parent=?1 Where code=?2")
})
@Audited
@EntityListeners(value = AuditingEntityListener.class)
@Entity(name="Lookup")
public class Lookup extends DefaultEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lookupId;
    private String code;
    private String name;
    private String description;
    private boolean enabled;
    private String parent;
    private boolean preferred;
    @Transient
    private List<Lookup> childList;

    @Override
    public String getCode() {
        return code;
    }
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int getId() {
        return lookupId;
    }

    @Override
    public void setId(int id) {
        this.lookupId = id;
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public int getLookupId() {
        return lookupId;
    }

    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
    }

    public List<Lookup> getChildList() {
        return childList;
    }

    public void setChildList(List<Lookup> childList) {
        this.childList = childList;
    }
}

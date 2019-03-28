package etech.admin.domain;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = "Lookup.GetAllParentsLookup", query = "select DISTINCT(c.parent) from Lookup c"),
        @NamedQuery(name = "Lookup.GetAllChildsLookup", query = "select DISTINCT(c.name)  from Lookup c where c.parent=?1"),
        @NamedQuery(name = "Lookup.GetChildLookup", query = "select c.name  from Lookup c where c.parent=?1 and c.code=?2 ")

})
@Entity(name="Lookup")
public class Lookup {



    @Id
    private String code;
    private String name;
    private String description;
    private boolean enabled;
    private String parent;
    private boolean prefered;

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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isPrefered() {
        return prefered;
    }

    public void setPrefered(boolean prefered) {
        this.prefered = prefered;
    }



}

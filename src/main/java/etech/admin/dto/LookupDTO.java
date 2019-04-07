package etech.admin.dto;

import etech.admin.domain.Lookup;

import java.util.List;

public class LookupDTO extends DefaultDTO {

    private String code;
    private String name;
    private String description;
    private boolean enabled;
    private String parent;
    private boolean preferred;

    private List<Lookup> childList;

    @Override
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

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public List<Lookup> getChildList() {
        return childList;
    }

    public void setChildList(List<Lookup> childList) {
        this.childList = childList;
    }
}

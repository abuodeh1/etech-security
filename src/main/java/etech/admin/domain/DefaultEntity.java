package etech.admin.domain;

public abstract class DefaultEntity {

    private String code;

    public abstract String getCode();

    public abstract void setCode(String code);

    public abstract int getId();

    public abstract void setId(int id);
}

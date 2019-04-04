package etech.admin.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name = "USERS")
public class User extends DefaultEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    private String email;

    private String code;

    private String name;

    @JsonIgnore
    @JsonProperty(value = "password")
    private String password;

    private long created;

    private String mobile;

    private boolean enabled;

    /*private String office;

    private String branch;

    private String department;

    private String directorate;*/

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumns({
//            @JoinColumn(name = "userId", referencedColumnName = "userId")
//    })
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<UserRole> userRoles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<UserPrivileges> userPrivileges;


    public User() {
    }

    public User(@NotEmpty String username, @NotEmpty String password, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.password = password;
        this.enabled = true;
        setCreated(new Date().getTime());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /*public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDirectorate() {
        return directorate;
    }

    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }*/

    /*public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
*/
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public String getCode() {
        return username;
    }

    public void setCode(String code) {
        this.username = code;
    }

    @Override
    public int getId() {
        return userId;
    }

    @Override
    public void setId(int id) {
        this.userId = id;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<UserPrivileges> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(List<UserPrivileges> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }
}

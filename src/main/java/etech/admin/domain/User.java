package etech.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="USERS")
public class User implements UserDetails {

//    @Id
//    private String user_id;
    @Id
    private String username;


    private int userID;

    private String email;

    private String name;

    @JsonIgnore
    @JsonProperty(value = "password")
    private String password;

    private LocalDateTime created;

    private String mobile;

    private boolean enabled;

    private String office;

    private String branch;

    private String department;

    private String directorate;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",
//            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
//    private User_Role user_role;

    public User() {
    }

    public User(@NotEmpty String username, @NotEmpty String password, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.password = password;
        this.enabled = true;
        setCreated(LocalDateTime.now());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
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

    public String getOffice() {
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
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

//    public User_Role getUser_role() {
//        return user_role;
//    }
//
//    public void setUser_role(User_Role user_role) {
//        this.user_role = user_role;
//    }
}

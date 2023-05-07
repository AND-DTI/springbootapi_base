package com.arjuncodes.studentsystem.model.dts1;
import javax.persistence.*;
import javax.persistence.Id;
//import org.hibernate.annotations.Immutable;
import org.springframework.security.core.GrantedAuthority;
import com.arjuncodes.studentsystem.model.dts1.keys.User_RoleKey;



@Entity
//@Immutable
@Table(name = "user_role", 
       uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "roleid" }) }
)
@IdClass(User_RoleKey.class)
public class User_Role implements GrantedAuthority {

    @Id
    @Column(columnDefinition = "char(10)", unique = true)
    private String username;

    @Id
    @Column(columnDefinition = "int", unique = true)
    private Integer roleid;

    @Column(columnDefinition = "char(20)")
    private String rolename;

    @Column(columnDefinition = "char(8)")
    private String dtacad;



    public User_Role() {

    }

    public User_Role(String username, Integer roleid, String rolename, String dtacad) {
        super();
        this.username = username;
        this.roleid = roleid;
        this.rolename = rolename;
        this.dtacad = dtacad;
    }

    public String getUsername() {        return username;    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleid() {        return roleid;    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    //public String getRolname() {        return rolename;    }
    public void setRolname(String rolename) {
        this.rolename = rolename;
    }

    public String getDtacad() {        return dtacad;    }
    public void setDtacad(String dtacad) {
        this.dtacad = dtacad;
    }

    @Override
    public String getAuthority() {        
        return this.rolename;
    }



}

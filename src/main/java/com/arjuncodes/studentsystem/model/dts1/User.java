package com.arjuncodes.studentsystem.model.dts1;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




@Entity
@Table(name = "user")
public class User implements UserDetails {
    

    
    @Id
    @Column(columnDefinition = "char(10)", unique = true)
    private String username;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(columnDefinition = "enum('S', 'N')")
    private String ativo;

    @Column(columnDefinition = "varchar(100)")
    private String password;

    @Column(columnDefinition = "varchar(200)")
    private String token;

    @OneToMany
    @JoinColumn(name = "username", referencedColumnName = "username")
    private List<User_Role> roles;

    //@ManyToMany
    /*@OneToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "username"),
        inverseJoinColumns = @JoinColumn(name = "roleid")
    )    
    private List<User_Role> roles;
*/

    
    /*@ManyToMany(fetch = FetchType.EAGER)
	private Set<Perfil> perfis;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
    */


    public String getUsername() {        return username;    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {        return name;    }
    public void setName(String name) {
        this.name = name;
    }

    private String getAtivo() {        return ativo;    }
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getPassword() {        return password;    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {        return token;    }
    public void setToken(String token) {
        this.token = token;
    }

    
    public User(){

    }


    //Details methods:
    //@Override
    //public String getUsername() {   return username;    } //if user indentification has fild name <> "username"




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
   /*public Collection<? extends GrantedAuthority> getAuthorities(
        Collection<Role> roles) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role: roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
                role.getPrivileges().stream()
                .map(p -> new SimpleGrantedAuthority(p.getName()))
                .forEach(authorities::add);
            }
    
    return authorities;
    }*/
    /*public Collection<? extends GrantedAuthority> getAuthorities() {
             
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return authorities;
        
    }*/

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
    
        return this.getAtivo().equals("S");

    }

}

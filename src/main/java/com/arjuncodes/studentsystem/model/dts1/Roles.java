package com.arjuncodes.studentsystem.model.dts1;

//import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.annotation.Generated;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
    
    //private UUID roleid;

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( columnDefinition="int" )
    private long roleid;
           
    @Column( columnDefinition="char(20)" )
    private String rolename; 
    
    @Column( columnDefinition="char(255)" )
    private String roledesc;     

    @Column( columnDefinition="int" )
    private long dtcad;
    
    
    
    
   
    public long getRoleid() {        return roleid;    }
    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }
    /*public UUID getRoleid() {
        return roleid;
    }
    public void setRoleid(UUID roleid) {
        this.roleid = roleid;
    }*/
    public String getRolename() {        return rolename;    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {        return roledesc;    }
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public long getDtcad() {        return dtcad;    }
    public void setDtcad(long dtcad) {
        this.dtcad = dtcad;
    }


    public Roles(){
        super();
    }

    public Roles(String rolename, String roledesc){
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

}

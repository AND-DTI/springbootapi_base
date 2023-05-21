package com.arjuncodes.studentsystem.model.dts1.keys;

import java.io.Serializable;




public class User_RoleKey implements Serializable{

    private String username;
			
	private Integer roleid;
	
	

    public User_RoleKey(){

    }

    public User_RoleKey(String username, Integer roleid ) { 
        this.username = username;
        this.roleid = roleid;        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }


}

package com.and.apibase.model.dts1.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel
public class User_RoleDTO {
    

    @ApiModelProperty(position=0, hidden=false)
    private long roleid;
           
    @ApiModelProperty(position=1, value="Role Name", example="KEY_USER")
    private String rolename; 
        
    @ApiModelProperty(position=2, value="Role description")
    private String roledesc;

    
    public User_RoleDTO(long roleid, String rolename, String roledesc) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

    public User_RoleDTO(){

    }

    public long getRoleid() {        return roleid;    }
    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {        return rolename;    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {        return roledesc;    }
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

        

}

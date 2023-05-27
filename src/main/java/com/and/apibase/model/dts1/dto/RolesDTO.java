package com.and.apibase.model.dts1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel
public class RolesDTO {
    

    @ApiModelProperty(hidden=true)
    private long roleid;
           
    @ApiModelProperty(position=0, value="Role Name", example="KEY_USER")
    private String rolename; 
        
    @ApiModelProperty(position=1, value="Role description")
    private String roledesc;

    @ApiModelProperty(position=2, value="Data Cadastro", example="2014-10-03")
    private String dt_cadastro;

    
    public RolesDTO(String rolename, String roledesc, String dt_cadastro){
        this.rolename = rolename;
        this.roledesc = roledesc;
        this.dt_cadastro = dt_cadastro;
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

    public String getDt_cadastro() {        return dt_cadastro;    }
    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
    

}

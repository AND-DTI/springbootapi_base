package com.arjuncodes.studentsystem.model.dts1.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompAttach_put {
    

    @ApiModelProperty(position=1, value="Attach name", example="C120007.PDF")
    private String atachname;
        
    @ApiModelProperty(position=2, value="Component technical drawing (Base64)")
	private String fileBase64;
    

    public CtpcompAttach_put(String atachname, String fileBase64) {
        this.atachname = atachname;
        this.fileBase64 = fileBase64;
    }





    public CtpcompAttach_put(){
        
    }  

  
       
    

    public String getAtachname() {        return atachname;    }
    public void setAtachname(String atachname) {
        this.atachname = atachname;
    }

    public String getFileBase64() {        return fileBase64;    }
    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    
}
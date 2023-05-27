package com.and.apibase.model.dts1.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompAttach_post {
    
    @ApiModelProperty(position=0, value="Attach ID")
    private long atachid;
        
    //@ApiModelProperty(position=0, value="Component ID")
    //private long compid; //this post comes always with as list od a CTPCOMP

    @ApiModelProperty(position=1, value="Attach name", example="C120007.PDF")
    private String atachname;
        
    @ApiModelProperty(position=1, value="Attach type", example="2D")
    private String atachtp;	

    @ApiModelProperty(position=2, value="Component technical drawing (Base64)")
	private String fileBase64;
    

    
    public CtpcompAttach_post(){
        
    } 

    public CtpcompAttach_post(long atachid, String atachname, String atachtp, String fileBase64) {
        this.atachid = atachid;
        this.atachname = atachname;
        this.atachtp = atachtp;
        this.fileBase64 = fileBase64;
    }


    public long getAtachid() {        return atachid;    }
    public void setAtachid(long atachid) {
        this.atachid = atachid;
    }    

    public String getAtachname() {        return atachname;    }
    public void setAtachname(String atachname) {
        this.atachname = atachname;
    }

    public String getAtachtp() {        return atachtp;    }
    public void setAtachtp(String atachtp) {
        this.atachtp = atachtp;
    }
    public String getFileBase64() {        return fileBase64;    }
    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    
}
package com.arjuncodes.studentsystem.model.dts1.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpattachDTO {
    
    @ApiModelProperty(position=0, value="Attach ID")
    private long atachid;
        
    @ApiModelProperty(position=0, value="Component ID")
    private long compid;

    //@ApiModelProperty(position=1, value="Component Code", example="C120007")
    //private String nroit;    
    @ApiModelProperty(position=1, value="Attach name", example="C120007.PDF")
    private String atachname;    
        
    @ApiModelProperty(position=2, value="Component technical drawing (Base64)")
	private String fileBase64;

    @ApiModelProperty(position=7, value="Audit - System name", example="FRONTENDXYZ.APP")
	private String itaudsys;
				
    @ApiModelProperty(position=8, value="Audit - User ", example="SB037635")
	private String itaudusr;
	
	@ApiModelProperty(position=9, value="Audit - Host ", example="HDAMDTNNNN")
    private String itaudhst;	



    public CtpattachDTO(){
        
    }   
    
    public CtpattachDTO(long compid, String atachname, String fileBase64, String itaudsys, String itaudusr, String itaudhst) {
        this.compid = compid;
        this.atachname = atachname;
        this.fileBase64 = fileBase64;
        this.itaudsys = itaudsys;
        this.itaudusr = itaudusr;
        this.itaudhst = itaudhst;
    }

    public CtpattachDTO(long atachid, long compid, String atachname, String fileBase64, String itaudsys, String itaudusr, String itaudhst) {
        this.atachid = atachid;
        this.compid = compid;
        this.atachname = atachname;
        this.fileBase64 = fileBase64;
        this.itaudsys = itaudsys;
        this.itaudusr = itaudusr;
        this.itaudhst = itaudhst;
    }    
 
    public long getAtachid() {        return atachid;    }
    public void setAtachid(long atachid) {
        this.atachid = atachid;
    }    

    public long getCompid() {        return compid;    }
    public void setCompid(long compid) {
        this.compid = compid;
    }

    public String getAtachname() {        return atachname;    }
    public void setAtachname(String atachname) {
        this.atachname = atachname;
    }   

    public String getFileBase64() {        return fileBase64;    }
    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    public String getItaudsys() {        return itaudsys;    }
    public void setItaudsys(String itaudsys) {        this.itaudsys = itaudsys;    }

    public String getItaudusr() {        return itaudusr;    }
    public void setItaudusr(String itaudusr) {        this.itaudusr = itaudusr;    }

    public String getItaudhst() {        return itaudhst;    }
    public void setItaudhst(String itaudhst) {        this.itaudhst = itaudhst;    }    
    
}
package com.arjuncodes.studentsystem.model.dts1.dto;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompDTOpost implements Serializable{
    

    @ApiModelProperty(position=0, value="Component ID")
    private long compid;
        	
    @ApiModelProperty(position=1, value="Component Code", example="C120007")
    private String nroit;
		    
    @ApiModelProperty(position=2, value="Component description", example="Espaçador direito")
	private String nom_it;
		
    @ApiModelProperty(position=3, value="Component technical drawing (Base64)")
	private String fileBase64;

	@ApiModelProperty(position=4, value="Register date (YYYY-MM-DD)", example="2014-10-03")
	private String dtacadS; 

	@ApiModelProperty(position=5, value="User", example="37635")
	private Integer usrcad;
	
	@ApiModelProperty(position=6, value="Obs")
	private String obs;
	
    @ApiModelProperty(position=7, value="Audit - System name", example="PROGXYZ.JAVA")
	private String itaudsys;
			
	@ApiModelProperty(position=8, value="Audit - User ", example="SB037635")
	private String itaudusr;
	
	@ApiModelProperty(position=9, value="Audit - Host ", example="SAHDAMVQAPP001")
    private String itaudhst;	

  /*private String itauddt;		
				
	private String itaudhr;	*/    				
	    
    

    public long getCompid() {        return compid;    }
    public void setCompid(long compid) {
        this.compid = compid;
    }

    public String getNroit() {        return nroit;    }
    public void setNroit(String nroit) {
        this.nroit = nroit;
    }

    public String getNom_it() {        return nom_it;    }
    public void setNom_it(String nom_it) {
        this.nom_it = nom_it;
    }

    public String getFileBase64() {        return fileBase64;    }
    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    public String getDtacadS() {        return dtacadS;    }
    public void setDtacadS(String dtacadS) {
        this.dtacadS = dtacadS;
    }

    public Integer getUsrcad() {        return usrcad;    }
    public void setUsrcad(Integer usrcad) {
        this.usrcad = usrcad;
    }

    public String getObs() {        return obs;    }
    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getItaudsys() {        return itaudsys;    }
    public void setItaudsys(String itaudsys) {
        this.itaudsys = itaudsys;
    }

    public String getItaudusr() {        return itaudusr;    }
    public void setItaudusr(String itaudusr) {
        this.itaudusr = itaudusr;
    }

    public String getItaudhst() {        return itaudhst;    }
    public void setItaudhst(String itaudhst) {
        this.itaudhst = itaudhst;
    }


}
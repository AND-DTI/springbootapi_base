package com.arjuncodes.studentsystem.model.dts1.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompDTOput implements Serializable{
    
        
	@ApiModelProperty(value="Component Code", example="C120007")
    private String nro_it;
		    
    @ApiModelProperty(value="Component description", example="Espaçador direito")
	private String nom_it;
	
	@ApiModelProperty(value="Component technical drawing (Base64)")
	private String fileBase64;
	
    @ApiModelProperty(value="Register date (YYYY-MM-DD)", example="2014-10-03")
	private String dtacadS; /*do custom map to DB2*/

	@ApiModelProperty(value="User", example="37635")
	private Integer usrcad;
	
	@ApiModelProperty(value="Obs", example="To attend project...")
	private String obs;

	@ApiModelProperty(value="Audit - System name", example="PROGXYZ.JAVA")
	private String itaudsys;
			
	@ApiModelProperty(value="Audit - User ", example="SB037635")
	private String itaudusr;
	    
    @ApiModelProperty(value="Audit - Host ", example="SAHDAMVQAPP001")
	private String itaudhst;
	
    /*private String itauddt;
				
	private String itaudhr;	*/



    
    public String getNro_it() {        return nro_it;    }
    public void setNro_it(String nro_it) {
        this.nro_it = nro_it;
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

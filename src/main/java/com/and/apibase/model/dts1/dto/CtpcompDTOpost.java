package com.and.apibase.model.dts1.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompDTOpost implements Serializable{
    

    @ApiModelProperty(position=0, value="Component ID")
    private long compid;
        	
    @ApiModelProperty(position=1, value="Component Code", example="C120007")
    private String nroit;
		    
    @ApiModelProperty(position=2, value="Component description", example="Espaçador direito")
	private String nomit;
		
	@ApiModelProperty(value="Obs/Espec", example="Espec. Téc... project...")
	private String obsit;

    @ApiModelProperty(value="Register date (YYYY-MM-DD)", example="2014-10-03")
	private String dtacads; /*do custom map to DB2*/

	//@ApiModelProperty(value="User", example="37635")
	//private Integer usrcad; //matricula

    @ApiModelProperty(value="User", example="SB037635")
	private String usrcads; //username
	    
    @ApiModelProperty(value="Category", example="MANUT")
    private String category;
	
    @ApiModelProperty(position=7, value="attachs")
    private List<CtpcompAttach_post> attachs = new ArrayList<CtpcompAttach_post>();

    
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

    public String getNomit() {        return nomit;    }
    public void setNomit(String nomit) {
        this.nomit = nomit;
    }

    public String getObsit() {        return obsit;    }
    public void setObsit(String obsit) {        
        this.obsit = obsit;    
    }
        
    public String getDtacads() {        return dtacads;    }
    public void setDtacads(String dtacads) {
        this.dtacads = dtacads;
    }

    /*public Integer getUsrcad() {        return usrcad;    }
    public void setUsrcad(Integer usrcad) {
        this.usrcad = usrcad;
    }*/

    public String getUsrcads() {        return usrcads;    }
    public void setUsrcads(String usrcads) {
        this.usrcads = usrcads;
    }    

    public String getCategory() {        return category;    }
    public void setCategory(String category) {
        this.category = category;
    }

    public List<CtpcompAttach_post> getAttachs() {        return attachs;    }
    public void setAttachs(List<CtpcompAttach_post> attachs) {
        this.attachs = attachs;
    }


    public String getItaudsys() {        return itaudsys;    }
    public void setItaudsys(String itaudsys) {        this.itaudsys = itaudsys;    }

    public String getItaudusr() {        return itaudusr;    }
    public void setItaudusr(String itaudusr) {        this.itaudusr = itaudusr;    }

    public String getItaudhst() {        return itaudhst;    }
    public void setItaudhst(String itaudhst) {        this.itaudhst = itaudhst;    }


}
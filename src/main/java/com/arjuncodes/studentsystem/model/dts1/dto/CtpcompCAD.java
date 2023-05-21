package com.arjuncodes.studentsystem.model.dts1.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompCAD implements Serializable{
    
        
    @ApiModelProperty(position=0, value="Component ID")
    private long compid;
	
    @ApiModelProperty(position=1, value="Component Code") 
    private String nroit;
		    
    @ApiModelProperty(position=2, value="Component description")
	private String nomit;
	
	@ApiModelProperty(position=3, value="Component technical drawing (PDF)")
	private String pdffil;

	@ApiModelProperty(position=4, value="Register date (YYYYMMDD)")
	private String dtacad; 

	@ApiModelProperty(position=5, value="User")
	private Integer usrcad;
	
	@ApiModelProperty(position=6, value="Obs")
	private String obs;

    @ApiModelProperty(position=7, value="attachs")
    private List<CtpcompAttach_post> attachs = new ArrayList<CtpcompAttach_post>();
    



    public CtpcompCAD(){

    }

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

    public String getPdffil() {        return pdffil;    }
    public void setPdffil(String pdffil) {
        this.pdffil = pdffil;
    }

    public String getDtacad() {        return dtacad;    }
    public void setDtacad(String dtacad) {
        this.dtacad = dtacad;
    }

    public Integer getUsrcad() {        return usrcad;    }
    public void setUsrcad(Integer usrcad) {
        this.usrcad = usrcad;
    }

    public String getObs() {        return obs;    }
    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<CtpcompAttach_post> getAttachs() {        return attachs;    }
    public void setAttachs(List<CtpcompAttach_post> attachs) {
        this.attachs = attachs;
    }    

   


    
}
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

	@ApiModelProperty(value="Obs/Espec", example="Espec. Téc... project...")
	private String obsit;    
	
	@ApiModelProperty(position=4, value="Register date (YYYYMMDD)")
	private String dtacads; 

	@ApiModelProperty(position=5, value="User")
	private Integer usrcad;
	
    @ApiModelProperty(value="Category", example="MANUT")
    private String category;

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

    public String getObsit() {        return obsit;    }
    public void setObsit(String obsit) {
        this.obsit = obsit;
    }

    public String getDtacads() {        return dtacads;    }
    public void setDtacads(String dtacads) {
        this.dtacads = dtacads;
    }
        
    public Integer getUsrcad() {        return usrcad;    }
    public void setUsrcad(Integer usrcad) {
        this.usrcad = usrcad;
    }

    public String getCategory() {        return category;    }
    public void setCategory(String category) {
        this.category = category;
    }      

    public List<CtpcompAttach_post> getAttachs() {        return attachs;    }
    public void setAttachs(List<CtpcompAttach_post> attachs) {
        this.attachs = attachs;
    }

    

   


    
}
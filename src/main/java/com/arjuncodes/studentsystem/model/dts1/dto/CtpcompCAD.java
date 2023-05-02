package com.arjuncodes.studentsystem.model.dts1.dto;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompCAD implements Serializable{
    
        
    @ApiModelProperty(position=0, value="Component Code")//, example="C120007")
    private long compid;
	
    @ApiModelProperty(position=1, value="Component Code")//, example="C120007")
    private String nro_it;
		    
    @ApiModelProperty(position=2, value="Component description")//, example="Espaçador direito")
	private String nom_it;
	
	@ApiModelProperty(position=3, value="Component technical drawing (PDF)")//, example="C120007.PDF")
	private String pdffil;

	@ApiModelProperty(position=4, value="Register date (YYYYMMDD)")//, example="2014-10-03")
	private String dtacad; 

	@ApiModelProperty(position=5, value="User")//, example="37635")
	private Integer usrcad;
	
	@ApiModelProperty(position=6, value="Obs")//, example="To attend project...")
	private String obs;

	/*@ApiModelProperty(value="Audit - System name", example="PROGXYZ.JAVA")
	private String itaudsys;
			
	@ApiModelProperty(value="Audit - User ", example="SB037635")
	private String itaudusr;
	    
    @ApiModelProperty(value="Audit - Host ", example="SAHDAMVQAPP001")
	private String itaudhst;
	*/
    /*private String itauddt;
				
	private String itaudhr;	*/


    public long getCompid() {        return compid;    }
    public void setCompid(long compid) {
        this.compid = compid;
    }
    
    public String getNro_it() {        return nro_it;    }
    public void setNro_it(String nro_it) {
        this.nro_it = nro_it;
    }

    public String getNom_it() {        return nom_it;    }
    public void setNom_it(String nom_it) {
        this.nom_it = nom_it;
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

    
}

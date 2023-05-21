package com.arjuncodes.studentsystem.model.dts1.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class CtpcompDTOput implements Serializable{
    
        
	@ApiModelProperty(value="Component Code", example="C120007")
    private String nroit;
		    
    @ApiModelProperty(value="Component description", example="Espaçador direito")
	private String nomit;
		
    @ApiModelProperty(value="Register date (YYYY-MM-DD)", example="2014-10-03")
	private String dtacadS; /*do custom map to DB2*/

	@ApiModelProperty(value="User", example="37635")
	private Integer usrcad;
	
	@ApiModelProperty(value="Obs", example="To attend project...")
	private String obs;

    @ApiModelProperty(position=7, value="attachs")
    private List<CtpcompAttach_put> attachs = new ArrayList<CtpcompAttach_put>();

    	
    @ApiModelProperty(value="Audit - System name", example="PROGXYZ.JAVA")
	private String itaudsys;
			
	@ApiModelProperty(value="Audit - User ", example="SB037635")
	private String itaudusr;
	    
    @ApiModelProperty(value="Audit - Host ", example="SAHDAMVQAPP001")
	private String itaudhst;
	
    /*private String itauddt; <- calculated by system
	private String itaudhr;	*/



    
    public String getNroit() {        return nroit;    }
    public void setNroit(String nroit) {
        this.nroit = nroit;
    }

    public String getNomit() {        return nomit;    }
    public void setNomit(String nomit) {
        this.nomit = nomit;
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

    public List<CtpcompAttach_put> getAttachs() {        return attachs;    }
    public void setAttachs(List<CtpcompAttach_put> attachs) {
        this.attachs = attachs;
    }


    public String getItaudsys() {        return itaudsys;    }
    public void setItaudsys(String itaudsys) {        this.itaudsys = itaudsys;    }

    public String getItaudusr() {        return itaudusr;    }
    public void setItaudusr(String itaudusr) {        this.itaudusr = itaudusr;    }

    public String getItaudhst() {        return itaudhst;    }
    public void setItaudhst(String itaudhst) {        this.itaudhst = itaudhst;    }    

    
}

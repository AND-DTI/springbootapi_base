package com.arjuncodes.studentsystem.model.dts1;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.IdClass;
//import com.arjuncodes.studentsystem.model.dts1.keys.CtpcompKey;




@Entity
@Table(name = "ctpcomp")
//@IdClass(CtpcompKey.class)
public class Ctpcomp  implements Serializable{

/*	ID do componente                         COMPID          15 
	Código componente                        NRO_IT     A    20 
	Descricao componente                     NOM_IT     A    50 
	Caminho desenho                          PDFFIL     A   200 
	DTA CADASTRO                             DTACAD          11 
	MAT USR CADASTRO                         USRCAD          10 
	OBSERVAÇÃO                               OBS        A    50 
	AUDITORIA SISTEMA                        ITAUDSYS   A    40 
	AUDITORIA USUÁRIO                        ITAUDUSR   A    10 
	AUDITORIA MÁQUINA                        ITAUDHST   A    10 
	AUDITORIA DATA                           ITAUDDT    A     8 
	AUDITORIA HORA                           ITAUDHR    A     8 	
*/

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="bigint" ) //decimal(15,0) DB2
	private long compid;
	
	//@Id
	@Column( columnDefinition="char(20)" )
	private String nroit;
	
	@Column( columnDefinition="char(50)" )
	private String nomit;
	
	@Column( columnDefinition="char(200)" )
	private String pdffil;

	@Column( columnDefinition="char(8)" ) //decimal(11,0) DB2 *alter to C(8) in DB2
	private String dtacad;

	@Column( columnDefinition="int" ) //decimal(10,0) DB2
	private Integer usrcad;
	
	@Column( columnDefinition="char(50)" )
	private String obs;

	@Column( columnDefinition="char(40)" )
	private String itaudsys;
			
	@Column( columnDefinition="char(10)" )
	private String itaudusr;

	@Column( columnDefinition="char(20)" ) //old 3 - fix in DB2
	private String itaudhst;	
	
    @Column( columnDefinition="char(8)" )
	private String itauddt;		
				
	@Column( columnDefinition="char(8)" )
	private String itaudhr;	



    public Ctpcomp() {
		
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

    public String getItauddt() {        return itauddt;    }
    public void setItauddt(String itauddt) {
        this.itauddt = itauddt;
    }

    public String getItaudhr() {        return itaudhr;    }
    public void setItaudhr(String itaudhr) {
        this.itaudhr = itaudhr;
    }

}
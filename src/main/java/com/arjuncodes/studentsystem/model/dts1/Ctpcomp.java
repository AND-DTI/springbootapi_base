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

/*	COMPID      0015P        ID do componente
	NROIT       0020A        Código componente
	NOMIT       0070A        Nome/resumo comp.
	OBSIT       0250A        Observação/espec.
	DTACAD      0015P        Data cadastro (unix)
	DTACADS     0008A        Dt. cadatro yyyymmdd'
	USRCAD      0010P        Matrícula usuário
	CATEGORY    0010A        Component category
	IDSE        0032A        ID externo (SoftExp)
	SEQIT       0015P        Seq. automatica IT	  */ 	


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="bigint" ) //decimal(15,0) DB2
	private long compid;
	
	@Column( columnDefinition="char(20)" )
	private String nroit;
	
	@Column( columnDefinition="char(50)" )
	private String nomit;
	
	@Column( columnDefinition="char(250)" )
	private String obsit;

	@Column( columnDefinition="int" ) 
	private long dtacad;

    @Column( columnDefinition="char(8)" ) 
	private String dtacads;

	@Column( columnDefinition="int" ) 
	private Integer usrcad;
	
	@Column( columnDefinition="char(10)" )
	private String category;

    @Column( columnDefinition="char(32)" )
	private String idse;

	@Column( columnDefinition="int" ) 
	private Integer seqit;    

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

    public String getObsit() {        return obsit;    }
    public void setObsit(String obsit) {
        this.obsit = obsit;
    }

    public long getDtacad() {        return dtacad;    }
    public void setDtacad(long dtacad) {
        this.dtacad = dtacad;
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

    public String getIdse() {        return idse;    }
    public void setIdse(String idse) {
        this.idse = idse;
    }

    public Integer getSeqit() {        return seqit;    }
    public void setSeqit(Integer seqit) {
        this.seqit = seqit;
    }


    public String getItaudsys() {        return itaudsys;    }
    public void setItaudsys(String itaudsys) {        this.itaudsys = itaudsys;    }

    public String getItaudusr() {        return itaudusr;    }
    public void setItaudusr(String itaudusr) {        this.itaudusr = itaudusr;    }

    public String getItaudhst() {        return itaudhst;    }
    public void setItaudhst(String itaudhst) {        this.itaudhst = itaudhst;    }

    public String getItauddt() {        return itauddt;    }
    public void setItauddt(String itauddt) {        this.itauddt = itauddt;    }

    public String getItaudhr() {        return itaudhr;    }
    public void setItaudhr(String itaudhr) {        this.itaudhr = itaudhr;    }    

}
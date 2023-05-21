package com.arjuncodes.studentsystem.model.dts1;
import java.io.Serializable;
import javax.persistence.*;
import static com.arjuncodes.studentsystem.utils.Auxiliar.*;

@Entity
@Table(name = "ctpint")
public class Ctpint implements Serializable{
    
/*  INTID         15P   ID transaction
    IDREG         15P   Id registrer orig
    TABLEFROM     10A   Orig table
    TABLETO       10A   Destiny table
    SYSFROM       20A   Orig System
    SYSTO         20A   Destiny System
    INTDESC      100A   Integration descrip.
    INTSTATUS      1P   Status integration
    DTREPLY        8A   Replication date
    HRREPLY        8A   Replication hour */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="bigint" )
	private long intid;
		
    @Column( columnDefinition="bigint" )
	private long idreg;

    @Column( columnDefinition="char(10)" )
	private String tablefrom;

    @Column( columnDefinition="char(10)" )
	private String tableto;    
    
    @Column( columnDefinition="char(20)" )
	private String sysfrom;

    @Column( columnDefinition="char(20)" )
	private String systo;

    @Column( columnDefinition="char(100)" )
	private String intdesc;

    @Column( columnDefinition="decimal(1,0)" )
	private int intstatus;
    
    @Column( columnDefinition="char(8)" )
	private String dtreply;
    
    @Column( columnDefinition="char(8)" )
	private String hrreply;
    
    @Column( columnDefinition="char(40)" )
	private String itaudsys;			
	@Column( columnDefinition="char(10)" )
	private String itaudusr;
	@Column( columnDefinition="char(20)" )
	private String itaudhst;	
	@Column( columnDefinition="char(8)" )
	private String itauddt;						
	@Column( columnDefinition="char(8)" )
	private String itaudhr;	    


    public Ctpint(){

    }
    
    public Ctpint(long idreg, String tablefrom, String tableto, String sysfrom, String systo, String intdesc, int intstatus) {
        this.idreg = idreg;
        this.tablefrom = tablefrom;
        this.tableto = tableto;
        this.sysfrom = sysfrom;
        this.systo = systo;
        this.intdesc = intdesc;
        this.intstatus = intstatus;
    }

	public long getIntid() {        return intid;    }
    public void setIntid(long intid) {
        this.intid = intid;
    }

    public long getIdreg() {        return idreg;    }
    public void setIdreg(long idreg) {
        this.idreg = idreg;
    }

    public String getTablefrom() {        return tablefrom;    }
    public void setTablefrom(String tablefrom) {
        this.tablefrom = tablefrom;
    }

    public String getTableto() {        return tableto;    }
    public void setTableto(String tableto) {
        this.tableto = tableto;
    }

    public String getSysfrom() {        return sysfrom;    }
    public void setSysfrom(String sysfrom) {
        this.sysfrom = sysfrom;
    }

    public String getSysto() {        return systo;    }
    public void setSysto(String systo) {
        this.systo = systo;
    }

    public String getIntdesc() {        return intdesc;    }
    public void setIntdesc(String intdesc) {
        this.intdesc = intdesc;
    }

    public int getIntstatus() {        return intstatus;    }
    public void setIntstatus(int intstatus) {
        this.intstatus = intstatus;
    }

    public String getDtreply() {        return dtreply;    }
    public void setDtreply(String dtreply) {
        this.dtreply = dtreply;
    }

    public String getHrreply() {        return hrreply;    }
    public void setHrreply(String hrreply) {
        this.hrreply = hrreply;
    }

	public String getItaudsys() {		return trimNull(itaudsys);	}
	public void setItaudsys(String itaudsys) {		this.itaudsys = itaudsys; }

	public String getItaudusr() {		return itaudusr;	}
	public void setItaudusr(String itaudusr) {		this.itaudusr = itaudusr; }

	public String getItaudhst() {		return itaudhst;	}
	public void setItaudhst(String itaudhst) {		this.itaudhst = itaudhst; }

	public String getItauddt() {		return itauddt;	}
	public void setItauddt(String itauddt) {		this.itauddt = itauddt;	}

	public String getItaudhr() {		return itaudhr;	}
	public void setItaudhr(String itaudhr) {		this.itaudhr = itaudhr;	}    

}

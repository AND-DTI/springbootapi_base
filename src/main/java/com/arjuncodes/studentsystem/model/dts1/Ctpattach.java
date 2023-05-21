package com.arjuncodes.studentsystem.model.dts1;
import static com.arjuncodes.studentsystem.utils.Auxiliar.*;
import java.io.Serializable;
import javax.persistence.*;






@Entity
@Table(name = "ctpattach")
public class Ctpattach  implements Serializable{

/*	ATACHID       15P   ID attach
    ATACHTB       10A   Attach related table
    ATACHNAME     40A   Attach name 
    ATACHPATH    150A   Attach original path
    B64FILE       47A   Base64 file
    PUBPATH      150A   User or Public path 
	ATACHOBS     250A    */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column( columnDefinition="bigint" )
	private long atachid;
	
	@Column( columnDefinition="char(10)" )
	private String atachtb;	

	@Column( columnDefinition="bigint" )
	private long regid;	//ctpcomp ref
				
	@Column( columnDefinition="char(40)" )
	private String atachname;
		
	@Column( columnDefinition="char(150)" )
	private String atachpath;

	@Column( columnDefinition="char(47)" ) 
	private String b64file;

    @Column( columnDefinition="char(150)" )
	private String pubpath;

	@Column( columnDefinition="char(250)" )
	private String atachobs;

	
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





	public Ctpattach() {
		
	}
	
	public Ctpattach(String atachtb, long regid, String atachname, String atachpath, String b64file, String pubpath, String atachobs, 
					 String itaudsys, String itaudusr, String itaudhst, String itauddt, String itaudhr) {		
		this.atachtb = atachtb;
		this.regid = regid;
		this.atachname = atachname;
		this.atachpath = atachpath;
		this.b64file = b64file;
		this.pubpath = pubpath;
		this.atachobs = atachobs;
		this.itaudsys = itaudsys;
		this.itaudusr = itaudusr;
		this.itaudhst = itaudhst;
		this.itauddt = itauddt;
		this.itaudhr = itaudhr;
	}


	public Ctpattach(long atachid, String atachtb, long regid, String atachname, String atachpath, String b64file, String pubpath, String atachobs, 
					 String itaudsys, String itaudusr, String itaudhst, String itauddt, String itaudhr) {		
		this.atachid = atachid;
		this.atachtb = atachtb;
		this.regid = regid;
		this.atachname = atachname;
		this.atachpath = atachpath;
		this.b64file = b64file;
		this.pubpath = pubpath;
		this.atachobs = atachobs;
		this.itaudsys = itaudsys;
		this.itaudusr = itaudusr;
		this.itaudhst = itaudhst;
		this.itauddt = itauddt;
		this.itaudhr = itaudhr;
	}	

	public long getAtachid() {        return atachid;    }
    public void setAtachid(long atachid) {
        this.atachid = atachid;
    }

    public String getAtachtb() {        return atachtb;    }
    public void setAtachtb(String atachtb) {
        this.atachtb = atachtb;
    }

	public long getRegid() { 	return regid;	}
	public void setRegid(long regid) {
		this.regid = regid;
	}
		
    public String getAtachname() {        return trimNull(atachname);    }
    public void setAtachname(String atachname) {
        this.atachname = atachname;
    }

    public String getAtachpath() {        return trimNull(atachpath);    }
    public void setAtachpath(String atachpath) {
        this.atachpath = atachpath;
    }

    public String getB64file() {        return trimNull(b64file);    }
    public void setB64file(String b64file) {
        this.b64file = b64file;
    }

    public String getPubpath() {        return trimNull(pubpath);    }
    public void setPubpath(String pubpath) {
        this.pubpath = pubpath;
    }    

	public String getAtachobs() {		return atachobs;	}
	public void setAtachobs(String atachobs) {
		this.atachobs = atachobs;
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

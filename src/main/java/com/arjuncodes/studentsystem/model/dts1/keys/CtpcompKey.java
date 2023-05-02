package com.arjuncodes.studentsystem.model.dts1.keys;

import java.io.Serializable;




public class CtpcompKey implements Serializable{

    private long compid;
			
	private String nro_it;
	
	

    public CtpcompKey(){

    }

    public CtpcompKey(long compid, String nro_it ) { 
        this.compid = compid;
        this.nro_it = nro_it;        
    }

    public String CtpcompKeyStr(){        
        return "key["+this.compid+" / "+this.nro_it;
    }

}

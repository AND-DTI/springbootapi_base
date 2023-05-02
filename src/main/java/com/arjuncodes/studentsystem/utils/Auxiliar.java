package com.arjuncodes.studentsystem.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Auxiliar {



    public static String trimNull(String field) {
        return field == null ? "" : field.trim();        
    }


    public static String nvl(String str, String nullText) {
        return str == null ? nullText : str;        
    }
    

    public static String nvl2(String valor){
        return valor + "####";
    }


    public static void saveFile(String file, String content) throws FileNotFoundException{

		PrintStream ps = new PrintStream(
            new FileOutputStream(file, true)
        ); 
        
        //ps.println(); 
        ps.print(content);        
        ps.close();

	}


    public static String decodeBase64(String encodedString, String outputPDF, String outputB64, String fileServer) {
        
        Boolean decodificado =false;
        String decodeError ="";
       

        try {

        
            try{

                saveFile(fileServer+"//"+outputB64, encodedString); 
                decodificado = true;

            } catch (FileNotFoundException e) {
                //save log
                decodeError = e.getMessage();
                decodificado = false;
            }


           

        } catch (Exception e) {
            //save log
            decodeError = e.getMessage();
            decodificado = false;
        }

        if(decodificado){
            return "OK";
        }else{
            return decodeError;
        }
        

    }



    




    /*public Aux(){

    }*/


    /*public static class text {

        public static String masc1(String texto){
            return "mascText1";
        }
    }*/

    public static String nvl(String valor){
        return valor + "####";
    }

    public static class text {

        public static String nvl2(){

            return "nvl2";
        }
    }
}

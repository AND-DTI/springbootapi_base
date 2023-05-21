package com.arjuncodes.studentsystem.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//import java.nio.file.NoSuchFileException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

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



    public static void saveFile(String file, String content) throws IOException {//, NoSuchFileException{

		
        try{
            FileUtils.delete(new File(file));
        }catch(Exception e){

        }
                
        PrintStream ps = new PrintStream(
            new FileOutputStream(file, true)
        ); 
        
        //ps.println(); //add blank line
        ps.print(content+"\n");        
        ps.close();

	}    


    public static String decodeBase64(String encodedString, String outputPDF, String outputB64, String fileServer, String fileServerPUB) {
        
        Boolean decodificado =false;
        String decodeError ="";       
        

        try {

        
            try{
                

                //Save encoded content                
                saveFile(fileServer+"//"+outputB64, encodedString); 


                // decode the encoded string 
                byte[] decodedBytes = Base64
                    .getDecoder()
                    .decode(encodedString);
                
                    
                //Write file for decoded image
                File outputIMG = new File(fileServer+"//"+outputPDF);
                FileUtils.writeByteArrayToFile(outputIMG, decodedBytes);


                //Send copy to CTP Server
                File outputIMG_copy = new File(fileServerPUB+"//"+outputPDF);
                FileUtils.copyFile(outputIMG, outputIMG_copy);

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



    
    public static String readFile(String fileSource) {

        String content = "";

        try {

            File file = new File(fileSource);

            content = FileUtils.readFileToString(file, "UTF-8");            
            
        } catch (IOException e) {
            
        }

        return content;
        

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

package com.arjuncodes.studentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class StudentsystemApplicationTests {

	@Test
	void contextLoads() {

		System.out.println("testeing...");

	}



	private String inputFilePath = "avatar-1.jpg";
    private String outputFilePath = "test_image_copy.jpg";
	private String outputTXT = "src\\test\\resources\\IMG_base64.txt";

	@Test
	public void fileToBase64StringConversion() throws IOException {
        
		// load file from /src/test/resources
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader
          .getResource(inputFilePath)
          .getFile());

        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);


		  //Save encoded content:
		  /*File inputFileTXT = new File(classLoader
          .getResource(outputTXT)
          .getFile());*/
		  //String pathFile = classLoader. + "//";
		  saveFile(outputTXT, encodedString);
		  //FileUtils.writeStringToFile(new File(inputFileTXT), encodedString, encodedString, null, false);
		

        // create output file
        File outputFile = new File(inputFile
          .getParentFile()
		  .getAbsolutePath() + "\\" + outputFilePath);
          //.getAbsolutePath() + File.pathSeparator + outputFilePath);
		
		  File outputFile2 = new File("src\\test\\resources\\"+outputFilePath);


        // decode the string and write to file
        byte[] decodedBytes = Base64
          .getDecoder()
          .decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile2, decodedBytes);

        assertTrue(FileUtils.contentEquals(inputFile, outputFile));
    }


	public void saveFile(String file, String content) throws FileNotFoundException{

		PrintStream ps = new PrintStream(
            new FileOutputStream(file, true)
        ); 
        
        ps.println(); 
        ps.print(content);        
        ps.close();


	}

}

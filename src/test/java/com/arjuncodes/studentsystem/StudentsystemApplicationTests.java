package com.arjuncodes.studentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Base64;
//import java.util.Optional;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.and.apibase.model.dts1.Customers;
import com.and.apibase.model.dts1.dto.CustomersDTO;

//import ch.qos.logback.core.Context;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class StudentsystemApplicationTests {

	@Test
	void contextLoads() {

		System.out.println("testeing...");

	}



  /*ModelMapper mapper;
  //GameRepository gameRepository; 

  @BeforeEach
  public void setup() {
      this.mapper = new ModelMapper();
      mapper.addConverter(myConverter);
      //this.gameRepository = new GameRepository();
  }*/



  private static ModelMapper mapper = new ModelMapper();

  private static Converter<CustomersDTO, Customers> myConverter = new Converter<CustomersDTO, Customers>()
    {
        public Customers convert(MappingContext<CustomersDTO, Customers> context)
        {
          CustomersDTO s = context.getSource(); //origem
          Customers d = new Customers(); //destinbo //*context.getDestination() bug Null
            d.setAmount(s.getProduct_id());
            //d.setOrder_id(Integer.valueOf(s.getOrder())); //String to int example
            //d.setLarge(s.getMass() > 25);
            return d;
        }
    };


  /*static{
    mapper.addConverter(getConverterCustomerDTOType(), CustomersDTO.class, Customers.class);
  }

  private static Converter<CustomersDTO, Customers> getConverterCustomerDTOType() {
    return context -> Optional.ofNullable(context.getSource())
      .map(amount -> product_id)
      .orElse(null);
  }*/



@Test
public void moddelMapperTest(){

  //TypeMap<CustomersDTO, Customers> propertyMapper = this.mapper.createTypeMap(CustomersDTO.class, Customers.class);
  mapper.addConverter(myConverter);
  
/* 
  propertyMapper.addMapping(CustomersDTO::getOrder, Customers::setOrder_id);
  propertyMapper.addMappings(
    mapper -> mapper.skip(Customers::setAmount)
    //mapper -> Customers::setOrder_id, CustomersDTO::getOrder
    //mapper -> CustomersDTO::getOrder, Customers::setOrder_id
    //mapper -> mapper.Game::getTimestamp, GameDTO::setCreationTime
   );
  */
  
  Customers cu = new Customers();  
  CustomersDTO cuDTO = new CustomersDTO("00010", 1005, 50);
  //mapper.addConverter(myConverter);
  cu = mapper.map(cuDTO, Customers.class); //old: this.mapper...

  System.out.println(cu.toString());


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

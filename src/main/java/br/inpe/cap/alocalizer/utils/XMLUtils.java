package br.inpe.cap.alocalizer.utils;

import java.io.File;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.inpe.cap.alocalizer.output.Output;

public class XMLUtils {

	public static void createXMLFile(Output output, String projectPath) {
		
		Path outputPath = java.nio.file.Paths.get(projectPath, output.getProjectName() + ".xml");
				
		File file = new File(outputPath.toString());
		try {
				        
	        JAXBContext jaxbContext = JAXBContext.newInstance(Output.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	        jaxbMarshaller.setProperty("jaxb.encoding", "UTF-8"); 
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            

	        jaxbMarshaller.marshal(output, file);
	        //jaxbMarshaller.marshal(output, System.out);

	      } catch (JAXBException e) {
	        e.printStackTrace();
	      }
	}

}
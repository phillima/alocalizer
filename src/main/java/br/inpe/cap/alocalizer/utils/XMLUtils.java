package br.inpe.cap.alocalizer.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.inpe.cap.alocalizer.ALocalizerReport;
import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.Output;

public class XMLUtils {

	public static void createXMLFile(Output output) {
		
		File file = new File(output.getProjectName() + ".xml");
		try {
	        
	        JAXBContext jaxbContext = JAXBContext.newInstance(Output.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        jaxbMarshaller.marshal(output, file);
	        jaxbMarshaller.marshal(output, System.out);

	      } catch (JAXBException e) {
	        e.printStackTrace();
	      }
	}

}
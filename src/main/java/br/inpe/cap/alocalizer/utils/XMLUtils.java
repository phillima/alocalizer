package br.inpe.cap.alocalizer.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.inpe.cap.alocalizer.output.ALocalizerResult;

public class XMLUtils {

	public static void createXMLFile(ALocalizerResult representation) {
		
		 try {
	        File file = new File(representation.getName()+".xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(representation.getClass());
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	        // output pretty printed
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        jaxbMarshaller.marshal(representation, file);
	        jaxbMarshaller.marshal(representation, System.out);

	      } catch (JAXBException e) {
	        e.printStackTrace();
	      }
	}

}
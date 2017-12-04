package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"annotationName","annotAttributeRep"})
public class AnnotationsRep {

	private String annotationName;
	private List<AnnotAttributeRep> annotAttributeRep;

	public AnnotationsRep(String annotationName, List<AnnotAttributeRep> annotAttributeRep) {
		this.annotationName = annotationName;
		this.annotAttributeRep = annotAttributeRep;
	}

	//GETTER AND SETTERS
	@XmlAttribute(name = "name")
	public String getAnnotationName() {
		return annotationName;
	}
	public void setAnnotationName(String annotationName) {
		this.annotationName = annotationName;
	}
	@XmlElement(name = "attributes")
	public List<AnnotAttributeRep> getAnnotAttributeRep() {
		return annotAttributeRep;
	}
	public void setAnnotAttributeRep(List<AnnotAttributeRep> annotAttributeRep) {
		this.annotAttributeRep = annotAttributeRep;
	}
	
}

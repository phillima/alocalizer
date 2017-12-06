package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"annotationName","annotAttributes"})
public class AnnotationsResult {

	private String annotationName;
	private List<AnnotAttribute> annotAttributes;

	public AnnotationsResult(String annotationName, List<AnnotAttribute> annotAttributeRep) {
		this.annotationName = annotationName;
		this.annotAttributes = annotAttributeRep;
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
	public List<AnnotAttribute> getAnnotAttributes() {
		return annotAttributes;
	}

	public void setAnnotAttributes(List<AnnotAttribute> annotAttributes) {
		this.annotAttributes = annotAttributes;
	}
	
}

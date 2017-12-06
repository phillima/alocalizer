package br.inpe.cap.alocalizer.output;

import javax.xml.bind.annotation.XmlAttribute;

public class AnnotAttribute {
	
	private String attributeName;
	private String attributeValue;
	
	public AnnotAttribute(String attributeName, String attributeValue) {
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}
	
	@XmlAttribute(name = "name")
	public String getAnotAttributes() {
		return attributeName;
	}
	public void setAnotAttributes(String anotAttributes) {
		this.attributeName = anotAttributes;
	}
	@XmlAttribute(name = "value")
	public String getAnotAttributesValues() {
		return attributeValue;
	}
	public void setAnotAttributesValues(String anotAttributesValues) {
		this.attributeValue = anotAttributesValues;
	}

}

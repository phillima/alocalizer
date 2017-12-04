package br.inpe.cap.alocalizer.output;

import javax.xml.bind.annotation.XmlAttribute;

public class AnnotAttributeRep {
	
	private String anotAttribute;
	private String anotAttributesValue;
	
	public AnnotAttributeRep(String anotAttribute, String anotAttributesValue) {
		this.anotAttribute = anotAttribute;
		this.anotAttributesValue = anotAttributesValue;
	}
	
	@XmlAttribute(name = "name")
	public String getAnotAttributes() {
		return anotAttribute;
	}
	public void setAnotAttributes(String anotAttributes) {
		this.anotAttribute = anotAttributes;
	}
	@XmlAttribute(name = "value")
	public String getAnotAttributesValues() {
		return anotAttributesValue;
	}
	public void setAnotAttributesValues(String anotAttributesValues) {
		this.anotAttributesValue = anotAttributesValues;
	}

}

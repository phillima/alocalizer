package br.inpe.cap.alocalizer.output;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "element")
@XmlType (propOrder={"packageName","className","modifiers","annotations"})
public class FieldRepresentation extends Representation{
	
	public FieldRepresentation() {
		this.type = "field";
	}
	
	public FieldRepresentation(String fieldName, List<String> modifiers, List<AnnotationsRep> annotations,
			String className, String packageName) { 
		this();
		initialize(fieldName, modifiers, annotations, className, packageName);
		
	}
	
}

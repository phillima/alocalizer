package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "element")
@XmlType (propOrder={"packageName","className","modifiers","annotations"})
public class TypeDeclarationRepresentation extends Representation {
	
	public TypeDeclarationRepresentation() {
		this.type = "class";
	}
	
	public TypeDeclarationRepresentation(String typeDeclarationName, List<String> modifiers, List<AnnotationsRep> annotations,
			String className, String packageName) {
		this();
		initialize(typeDeclarationName, modifiers, annotations, className, packageName);
	}
	
}

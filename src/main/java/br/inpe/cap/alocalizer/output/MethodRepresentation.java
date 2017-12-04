package br.inpe.cap.alocalizer.output;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "element")
@XmlType (propOrder={"packageName","className","modifiers","annotations"})
public class MethodRepresentation extends Representation{


	public MethodRepresentation() {
		this.type = "method";
	}
	
	public MethodRepresentation(String methodName, List<String> modifiers, List<AnnotationsRep> annotations,
			String className, String packageName) {
		this();
		initialize(methodName, modifiers, annotations, className, packageName);
	}
	
}

package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"packageName","className","signature","superClass","interfaces","annotations"})
public class ALocalizerResult {
	
	private String name;
	private String type;
	private List<AnnotationsResult> annotations;
	private String className;
	private String packageName;
	private List<String> signature;
	private String fullyQualifiedName;
	private String superClass;
	private List<String> interfaces;
	
	public ALocalizerResult() {}
	
	public ALocalizerResult(String name, List<String> signature, List<AnnotationsResult> annotations, 
			String className, String packageName, String type, String superClass, List<String> interfaces) {
		this.name = name;
		this.signature = signature;
		this.annotations = annotations;
		this.className = className;
		this.packageName = packageName;
		this.type = type;
		this.superClass = superClass;
		this.interfaces = interfaces;
	}
	
	public ALocalizerResult(String className, String packageName) {
		this.className = className;
		this.packageName = packageName;
	}

	//GETTERS AND SETTERS
	@XmlElementWrapper(name = "signature")
	@XmlElement(name = "name")
	public List<String> getSignature() {
		return signature;
	}
	public void setSignature(List<String> signature) {
		this.signature = signature;
		}
	@XmlAttribute(name = "name")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElementWrapper(name = "annotations", required = false)
	@XmlElement(name = "annotation", required = false)
	public List<AnnotationsResult> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(List<AnnotationsResult> annotations) {
		this.annotations = annotations;
	}
	@XmlElement(name = "package")
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	} 
	@XmlElement(name = "class")
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@XmlTransient
	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}
	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}
	@XmlElement(name ="superclass", required=false)
	public String getSuperClass() {
		return superClass;
	}
	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
	@XmlElementWrapper(name ="interfaces",required=false)
	@XmlElement(name ="name")
	public List<String> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(List<String> interfaces) {
		this.interfaces = interfaces;
	}
}

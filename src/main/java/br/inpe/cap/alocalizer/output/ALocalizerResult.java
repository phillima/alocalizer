package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "element")
@XmlType (propOrder={"packageName","className","modifiers","annotations"})
public class ALocalizerResult {
	
	private String name;
	private String type;
	private List<AnnotationsResult> annotations;
	private String className;
	private String packageName;
	private List<String> modifiers;
	private String fullyQualifiedName;
	
	public ALocalizerResult() {
	}
	
	public ALocalizerResult(String name, List<String> modifiers, List<AnnotationsResult> annotations, String className,
			String packageName, String type) {
		this.name = name;
		this.modifiers = modifiers;
		this.annotations = annotations;
		this.className = className;
		this.packageName = packageName;
		this.type = type;
	}
	
	public ALocalizerResult(String className, String packageName) {
		this.className = className;
		this.packageName = packageName;
	}

	//GETTERS AND SETTERS
	@XmlElementWrapper(name = "modifiers")
	@XmlElement(name = "name")
	public List<String> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<String> methodModifier) {
		this.modifiers = methodModifier;
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
	@XmlElementWrapper(name = "annotations")
	@XmlElement(name = "annotation")
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

}

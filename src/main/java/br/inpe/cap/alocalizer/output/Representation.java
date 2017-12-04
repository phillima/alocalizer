package br.inpe.cap.alocalizer.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class Representation {
	
	protected String name;
	protected String type;
	protected List<AnnotationsRep> annotations;
	protected String className;
	protected String packageName;
	protected List<String> modifiers;
	
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
	public List<AnnotationsRep> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(List<AnnotationsRep> annotations) {
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
	
	//HELPER METHODS
	protected void initialize(String name, List<String> modifiers, List<AnnotationsRep> annotations, String className,
			String packageName) {
		this.name = name;
		this.modifiers = modifiers;
		this.annotations = annotations;
		this.className = className;
		this.packageName = packageName;
	}

}

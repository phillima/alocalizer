package br.inpe.cap.alocalizer.output;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.inpe.cap.alocalizer.ALocalizerReport;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Output {
	
	@XmlAttribute(name = "name")
	private String projectName;
	@XmlElementWrapper(name = "elements")
	@XmlElement(name = "element")
	private List<ALocalizerResult> results;
	
	public Output() {
		
	}
	
	public Output(ALocalizerReport report) {
		this.projectName = report.getProjectName();
		results = new ArrayList<>();
		for (ALocalizerResult aLocalizerResult : report.all()) 
			results.add(aLocalizerResult);
	}
	
	public String getProjectName() {
		return this.projectName;
	}
}

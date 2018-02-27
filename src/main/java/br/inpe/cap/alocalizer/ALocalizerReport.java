package br.inpe.cap.alocalizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.inpe.cap.alocalizer.output.ALocalizerResult;

public class ALocalizerReport {
	
	private int numberOfCompilationUnits;
	private int numberOfAnnotations;
	private int numberOfAnnotatedClasses;
	private int numberOfNullClasses;
	private String projectName;
	private Map<String, ALocalizerResult> results;
	
	public ALocalizerReport() {
		this.results = new HashMap<String, ALocalizerResult>();
	}

	public void add(ALocalizerResult al) {
		results.put(al.getFullyQualifiedName(), al);
	}

	public ALocalizerResult get(String name) {
		return results.get(name);
	}
	
	public Collection<ALocalizerResult> all() {
		return results.values();
	}
	
	public void incrementNumberOfAnnotations(int numberOfAnnotations) {
		this.numberOfAnnotations += numberOfAnnotations;
	}
	
	public void incrementNumberOfAnnotatedClasses() {
		this.numberOfAnnotatedClasses++;
	}

	public ALocalizerResult getByFullyQualifiedName(String name) {
		for (ALocalizerResult al : all()) {
			if (al.getFullyQualifiedName().equals(name))
				return al;
		}
		return null;
	}
	
	//GETTERS and SETTERS
	public int getNumberOfAnnotations() {
		return numberOfAnnotations;
	}
	public void setNumberOfAnnotations(int numberOfAnnotations) {
		this.numberOfAnnotations = numberOfAnnotations;
	}
	public int getNumberOfCompilationUnits() {
		return numberOfCompilationUnits;
	}
	public void setNumberOfCompilationUnits(int numberOfCompilationUnits) {
		this.numberOfCompilationUnits = numberOfCompilationUnits;
	}
	public String getProjectName() {
		return this.projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getNumberOfAnnotatedClasses() {
		return numberOfAnnotatedClasses;
	}
	public void setNumberOfAnnotatedClasses(int numberOfAnnotatedClasses) {
		this.numberOfAnnotatedClasses = numberOfAnnotatedClasses;
	}
	public int getNumberOfNullClasses() {
		return numberOfNullClasses;
	}
	public void setNumberOfNullClasses(int numberOfNullClasses) {
		this.numberOfNullClasses = numberOfNullClasses;
	}
}

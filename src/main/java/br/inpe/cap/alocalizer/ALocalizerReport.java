package br.inpe.cap.alocalizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.inpe.cap.alocalizer.output.ALocalizerResult;

public class ALocalizerReport {
	
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
	
	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Collection<ALocalizerResult> all() {
		return results.values();
	}

	public ALocalizerResult getByFullyQualifiedName(String name) {
		for (ALocalizerResult al : all()) {
			if (al.getFullyQualifiedName().equals(name))
				return al;
		}

		return null;
	}
	
}

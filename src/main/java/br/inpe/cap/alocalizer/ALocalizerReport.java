package br.inpe.cap.alocalizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.inpe.cap.alocalizer.output.ALocalizerResult;


public class ALocalizerReport {

	private Map<String, ALocalizerResult> results;

	public ALocalizerReport() {
		this.results = new HashMap<String, ALocalizerResult>();
	}

	public void add(ALocalizerResult al) {
		results.put(al.getFilePath(), al);
	}

	public ALocalizerResult get(String name) {
		return results.get(name);
	}

	public Collection<ALocalizerResult> all() {
		return results.values();
	}

	public ALocalizerResult getByClassName(String name) {
		for (ALocalizerResult al : all()) {
			if (al.getClassName().equals(name))
				return al;
		}

		return null;
	}
	
}

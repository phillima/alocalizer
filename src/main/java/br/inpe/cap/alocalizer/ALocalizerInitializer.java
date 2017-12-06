package br.inpe.cap.alocalizer;

import java.nio.file.Path;
import java.util.List;

import br.inpe.cap.alocalizer.output.Output;
import br.inpe.cap.alocalizer.utils.FileUtils;
import br.inpe.cap.alocalizer.utils.XMLUtils;

public class ALocalizerInitializer {

	public void start(String string) {

		List<Path> projects = FileUtils.listProjects(string);
		
		for (Path path : projects) {
			ALocalizerReport report = new ALocalizer().calculate(path.toString());
			XMLUtils.createXMLFile(new Output(report));
		}
		
	}
}

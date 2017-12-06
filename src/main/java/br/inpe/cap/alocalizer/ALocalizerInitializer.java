package br.inpe.cap.alocalizer;

import java.nio.file.Path;
import java.util.List;

import br.inpe.cap.alocalizer.output.Output;
import br.inpe.cap.alocalizer.utils.FileUtils;
import br.inpe.cap.alocalizer.utils.XMLUtils;

public class ALocalizerInitializer {

	public void start(String string) {

		List<Path> projects = FileUtils.listProjects(string);
		ALocalizerReport report;
		
		for (Path path : projects) {
			report = new ALocalizer().calculate(path.toString());
			report.setProjectName(FileUtils.extractFinalWord(path.toString()));
			XMLUtils.createXMLFile(new Output(report));
		}
		
	}
}

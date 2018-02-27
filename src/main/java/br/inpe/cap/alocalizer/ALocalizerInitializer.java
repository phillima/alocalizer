package br.inpe.cap.alocalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.alocalizer.output.Output;
import br.inpe.cap.alocalizer.utils.FileUtils;
import br.inpe.cap.alocalizer.utils.XMLUtils;

public class ALocalizerInitializer {

	
	public void start(String projectPath) {
		List<Path> projects = FileUtils.listProjects(projectPath);
		List<ALocalizerReport> reports = new ArrayList<>(); 
		for (Path path : projects) {
			ALocalizerReport report = new ALocalizer().calculate(path.toString());
			XMLUtils.createXMLFile(new Output(report),projectPath);
			reports.add(report);
		}
		
		//CSV
		OutputStream csv = null;
		try {
			csv = new FileOutputStream(projectPath + File.separator + "report.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(csv);
		ps.println("component,num-classes,num-annot,num-annotated-classes,num-null-class");
		for (ALocalizerReport report_ : reports) {
			ps.println(
					report_.getProjectName() + "," +
					report_.getNumberOfCompilationUnits() + "," +
					report_.getNumberOfAnnotations() + "," +
					report_.getNumberOfAnnotatedClasses() + "," +
					report_.getNumberOfNullClasses()
				);
		}
		ps.close();
	}
}

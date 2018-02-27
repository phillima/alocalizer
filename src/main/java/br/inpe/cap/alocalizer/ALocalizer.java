package br.inpe.cap.alocalizer;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import br.inpe.cap.alocalizer.utils.FileUtils;

public class ALocalizer {

	public ALocalizerReport calculate(String projectPath) {
		
		
		String[] srcDirs = FileUtils.getAllDirs(projectPath);
		String[] javaFiles = FileUtils.getAllJavaFiles(projectPath);
		Executor storage = new Executor(projectPath);
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		Map<String, String> options = JavaCore.getOptions();
		JavaCore.setComplianceOptions(JavaCore.VERSION_1_8, options);
		parser.setCompilerOptions(options);
		parser.setEnvironment(null, srcDirs, null, true);
		parser.createASTs(javaFiles, null, new String[0], storage, null);
		
		ALocalizerReport report = storage.getReport();
		report.setNumberOfCompilationUnits(javaFiles.length);
		
		return report;
		
	}

}

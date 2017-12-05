package br.inpe.cap.alocalizer;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.utils.ClassUtils;
import br.inpe.cap.alocalizer.utils.FileUtils;

public class ALocalizer {

	public ALocalizerReport calculate(String filePath) {
		
		
		String[] srcDirs = FileUtils.getAllDirs(filePath);
		String[] javaFiles = FileUtils.getAllJavaFiles(filePath);
		
		Executor storage = new Executor();
		
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		
		Map<String, String> options = JavaCore.getOptions();
		JavaCore.setComplianceOptions(JavaCore.VERSION_1_8, options);
		parser.setCompilerOptions(options);
		parser.setEnvironment(null, srcDirs, null, true);
		parser.createASTs(javaFiles, null, new String[0], storage, null);
		
		return storage.getReport();
		
	}

}

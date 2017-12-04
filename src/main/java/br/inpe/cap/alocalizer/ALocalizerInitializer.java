package br.inpe.cap.alocalizer;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.inpe.cap.alocalizer.utils.FileUtils;

public class ALocalizerInitializer {

	public static void initialize(String pathName) {
		
		List<Path> paths = FileUtils.findFiles("_test");
		ALocalizer aLocalizer = new ALocalizer();
		
		for (Path path : paths) {
			System.out.println("Path name = " + path.toString());
			String sourceFilePath = FileUtils.readFileAsString(path);
			
			ASTParser parser = ASTParser.newParser(AST.JLS8);
		    String javaFile = FileUtils.readFileAsString(sourceFilePath);
		    parser.setSource(javaFile.toCharArray());
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
			parser.setResolveBindings(true);
			
			final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
			aLocalizer.localize(cu);
		}
	}
}

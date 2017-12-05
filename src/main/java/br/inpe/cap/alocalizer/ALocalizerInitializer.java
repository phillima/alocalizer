package br.inpe.cap.alocalizer;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.inpe.cap.alocalizer.utils.FileUtils;

public class ALocalizerInitializer {

	public static void main(String[] args) {
		
		ALocalizerReport report = new ALocalizer().calculate("teste");
		
	}
}

package br.inpe.cap.alocalizer;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.FileASTRequestor;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;


import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.utils.ClassUtils;


public class Executor extends FileASTRequestor{

	private ALocalizerReport report;
	
	public Executor() {
		this.report = new ALocalizerReport();
	}
	
	@Override
	public void acceptAST(String sourceFilePath, 
			CompilationUnit cu) {
		
		ALocalizerResult result = null;
		ElementVisitor elementVis = new ElementVisitor();
		
		try {
			ClassUtils info = new ClassUtils();
			cu.accept(info);
			if(info.getClassName()==null) return;
		
			result = new ALocalizerResult(sourceFilePath, info.getClassName(), info.getType());
			
			elementVis.execute(cu, result, report);
			elementVis.setResult(result);
			report.add(result);
		} catch(Exception e) {
		}
	}
	
	public ALocalizerReport getReport() {
		return this.report;
	}
	
	

}

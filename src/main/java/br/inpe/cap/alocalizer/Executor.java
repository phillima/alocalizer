package br.inpe.cap.alocalizer;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;


public class Executor extends ASTVisitor{
	
	@Override
	public boolean visit(TypeDeclaration node) {
		checkForAnnotations(node);
		return super.visit(node);
	}
	
	@Override
	public boolean visit(FieldDeclaration node) {
		checkForAnnotations(node);
		return super.visit(node);
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		checkForAnnotations(node);
		return super.visit(node);
	}

	public void execute(CompilationUnit cu) {
		cu.accept(this);
	}
	
	public void setResult(String className, String packageName) {
	}
	
	//Inner helper methods
	private boolean checkForAnnotations(BodyDeclaration node) {
		for (Object obj : node.modifiers()) {
			if(obj instanceof Annotation) { 
				return true;
			}
		}
		return false;
	}

}

package br.inpe.cap.alocalizer;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.inpe.cap.alocalizer.output.ALocalizerResult;

public class ElementVisitor extends ASTVisitor{

	private String name;
	
	@Override
	public boolean visit(TypeDeclaration node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		name = node.getName().toString();
		return super.visit(node);
	}
	
	@Override
	public boolean visit(FieldDeclaration node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}
	
	
	public void execute(CompilationUnit cu, ALocalizerResult result, ALocalizerReport report) {
		cu.accept(this);
	}

	public void setResult(ALocalizerResult result) {
		result.setName(name);
	}

}

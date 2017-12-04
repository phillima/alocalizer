package br.inpe.cap.alocalizer.utils;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ClassUtils extends ASTVisitor {

	private String className;
	private String type;
	private String packageName;

	@Override
	public boolean visit(TypeDeclaration node) {
		
		getFullClassName(node.resolveBinding());
		
		if(node.isInterface()) type = "interface";
		else type = "class";
		
		return false;
	}

	@Override
	public boolean visit(EnumDeclaration node) {
		type = "enum";
		getFullClassName(node.resolveBinding());
		return false;
	}
	
	//GETTERS
	public String getClassName() {
		return className;
	}
	
	public String getType() {
		return type;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	//INNER HELPER METHODS
	private void getFullClassName(ITypeBinding binding) {
		if(binding!=null) {
			this.className = binding.getBinaryName();
			this.packageName = binding.getPackage().getName().toString();
		}
	}
}

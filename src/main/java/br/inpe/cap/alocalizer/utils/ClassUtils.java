package br.inpe.cap.alocalizer.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ClassUtils extends ASTVisitor {

	private String className;
	private String type;
	private String packageName;
	private String superClass;
	private List<String> interfaces;

	@Override
	public boolean visit(TypeDeclaration node) {
		
		getFullClassName(node.resolveBinding());
		if(node.isInterface()) type = "interface";
		else type = "class";
		if(node.getSuperclassType() != null)
			superClass = node.getSuperclassType().toString();
		else
			superClass = null;
		interfaces = new ArrayList<>();
		for (Object _interface : node.superInterfaceTypes()) 
			interfaces.add(_interface.toString());
		return super.visit(node);
	}
	
	@Override
	public boolean visit(AnnotationTypeDeclaration node) {
		type="annotation-declaration";
		getFullClassName(node.resolveBinding());
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
	public String getSuperClass() {
		return superClass;
	}
	public List<String> getInterfaces() {
		return interfaces;
	}
	//INNER HELPER METHODS
	private void getFullClassName(ITypeBinding binding) {
		if(binding!=null) {
			this.className = binding.getBinaryName();
			this.packageName = binding.getPackage().getName().toString();
		}
	}
}

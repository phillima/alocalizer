package br.inpe.cap.alocalizer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.AnnotAttribute;
import br.inpe.cap.alocalizer.output.AnnotationsResult;

public class ElementVisitor extends ASTVisitor{

	private String className, packageName;
	private ALocalizerReport report;
	
	@Override
	public boolean visit(EnumDeclaration node) {
		ALocalizerResult ar = new ALocalizerResult();
		String name = node.getName().toString();
		checkForModifiers(node, ar, null);
		String type = "enum";
		setAlocalizerResult(ar, name, type);
		report.add(ar);
		return super.visit(node);
	}
	
	@Override
	public boolean visit(TypeDeclaration node) {
		ALocalizerResult ar = new ALocalizerResult();
		String name = node.getName().toString();
		checkForModifiers(node, ar, null);
		String type = (node.isInterface() ? "interface" : "class");
		setAlocalizerResult(ar, name, type);
		report.add(ar);
		return super.visit(node);
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		ALocalizerResult ar = new ALocalizerResult();
		String name = node.getName().toString();
		checkForModifiers(node,ar,node.getReturnType2().toString());
		setAlocalizerResult(ar, name, "method");
		report.add(ar);
		return super.visit(node);
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		ALocalizerResult ar = new ALocalizerResult();
		String name = "";
		Object obj = node.fragments().get(0);
		if(obj instanceof VariableDeclarationFragment) {
			name = ((VariableDeclarationFragment)obj).getName().toString();
		}
		checkForModifiers(node,ar,node.getType().toString());
		setAlocalizerResult(ar, name, "field");
		report.add(ar);
		return super.visit(node);
	}
	
	
	public void execute(CompilationUnit cu, ALocalizerReport report, String className, String packageName) {
		this.packageName = packageName;
		this.className = className;
		this.report = report;
		cu.accept(this);
	}
	
	//INNER HELPER METHODS
	private void checkForModifiers(BodyDeclaration node, ALocalizerResult ar, String returnType) {
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		List<String> signature = new ArrayList<>();
		for (Object obj : node.modifiers()) {
			if(obj instanceof Annotation) {
				Annotation anot = (Annotation)obj;
				List<AnnotAttribute> attrRep = checkForAttributes(anot);
				annotations.add(new AnnotationsResult(anot.getTypeName().toString(), attrRep));
			}else //other modifiers
				signature.add(obj.toString());
		}
		signature.add(returnType);
		ar.setAnnotations(annotations);
		ar.setSignature(signature);
	}

	private List<AnnotAttribute> checkForAttributes(Annotation anot) {
		
		List<AnnotAttribute> attrRep = new ArrayList<>();
		if(anot.isMarkerAnnotation())
			return null;
		if(anot.isSingleMemberAnnotation()) 
			attrRep.add(new AnnotAttribute("value", ((SingleMemberAnnotation)anot).getValue().toString()));
		if(anot.isNormalAnnotation()) {
			NormalAnnotation normalAnot = (NormalAnnotation)anot;
			final List<MemberValuePair> pairs = normalAnot.values();
			for (MemberValuePair values : pairs) {
				attrRep.add(new AnnotAttribute(values.getName().toString(), values.getValue().toString()));
			}
		}
		return attrRep;
	}
	
	private void setAlocalizerResult(ALocalizerResult ar, String name, String type) {
		if(type.equals("class") || type.equals("enum"))
			ar.setFullyQualifiedName(className);
		else
			ar.setFullyQualifiedName(className + "." + name);
		ar.setClassName(className);
		ar.setPackageName(packageName);
		ar.setType(type);
		ar.setName(name);
	}
}

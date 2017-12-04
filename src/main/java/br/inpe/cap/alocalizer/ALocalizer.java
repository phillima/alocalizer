package br.inpe.cap.alocalizer;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;


import br.inpe.cap.alocalizer.utils.ClassUtils;

public class ALocalizer extends ASTVisitor {

	public void localize(CompilationUnit cu) {
		ClassUtils info = new ClassUtils();
		cu.accept(info);
		if(info.getClassName()==null) return;
	
		Executor exec = new Executor();
		exec.execute(cu);
		exec.setResult(info.getClassName(), info.getPackageName());
	}

	public ALocalizerReport calculate(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

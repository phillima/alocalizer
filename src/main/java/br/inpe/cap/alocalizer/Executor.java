package br.inpe.cap.alocalizer;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FileASTRequestor;
import br.inpe.cap.alocalizer.utils.ClassUtils;
import br.inpe.cap.alocalizer.utils.FileUtils;


public class Executor extends FileASTRequestor{

	private ALocalizerReport report;
	private int nullCLasses;
	public Executor(String projectPath) {
		this.report = new ALocalizerReport();
		report.setProjectName(FileUtils.extractFinalWord(projectPath));
	}
	
	@Override
	public void acceptAST(String sourceFilePath, 
			CompilationUnit cu) {
		
		ElementVisitor elementVis = new ElementVisitor();
		
		try {
			ClassUtils info = new ClassUtils();
			cu.accept(info);
			System.out.println("Class Name: " + info.getClassName());
			if(info.getClassName()==null ) {
				nullCLasses++;
				return;
			}
			elementVis.execute(cu,report,info.getClassName(),info.getPackageName()
					,info.getSuperClass(), info.getInterfaces());
			elementVis.getAnnotations();
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public ALocalizerReport getReport() {
		this.report.setNumberOfNullClasses(nullCLasses);
		return this.report;
	}

}

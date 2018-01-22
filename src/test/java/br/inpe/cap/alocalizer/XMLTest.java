package br.inpe.cap.alocalizer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.AnnotAttribute;
import br.inpe.cap.alocalizer.output.AnnotationsResult;
import br.inpe.cap.alocalizer.output.Output;
import br.inpe.cap.alocalizer.utils.FileUtils;
import br.inpe.cap.alocalizer.utils.XMLUtils;

public class XMLTest {
	
	private static List<String> signature = new ArrayList<>();
	private static List<Path> paths = new ArrayList<>();
	private static String outputPath = "";
	
	@BeforeClass
	public static void initialize() {
		
		signature.add("public");
		signature.add("static");
		signature.add("void");
		outputPath = System.getProperty("user.dir");
	}
	
	@Test	
	public void testClassOneMethod() {
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		annotations.add(new AnnotationsResult("@Annotation1", null));
		
		ALocalizerResult method1 = new ALocalizerResult("method1", signature, annotations, "Method1", "br.inpe.cap", "method");
		ALocalizerReport report = new ALocalizerReport();
		report.add(method1);
		report.setProjectName("method1");
		
		XMLUtils.createXMLFile(new Output(report), outputPath);
		
		paths.add(Paths.get("method1.xml"));
		
		assertEquals(FileUtils.readFileAsString("test/xml/method1.xml"), FileUtils.readFileAsString("method1.xml"));
	}
	
	@Test
	public void testClassOneField() {
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		annotations.add(new AnnotationsResult("@Annotation1", null));
		
		ALocalizerResult field1 = new ALocalizerResult("field1", signature, annotations,"Field1" ,"br.inpe.cap", "field");
		ALocalizerReport report = new ALocalizerReport();
		report.add(field1);
		report.setProjectName("field1");
		XMLUtils.createXMLFile(new Output(report), outputPath);
		
		paths.add(Paths.get("field1.xml"));
		
		assertEquals(FileUtils.readFileAsString("test/xml/field1.xml"), FileUtils.readFileAsString("field1.xml"));
	}
	
	@Test
	public void testAnnotationWithAttributes() {
		
		AnnotAttribute attr1 = new AnnotAttribute("value1","1");
		AnnotAttribute attr2 = new AnnotAttribute("value2","2");

		List<AnnotAttribute> attributes = new ArrayList<>();
		attributes.add(attr1);
		attributes.add(attr2);
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		annotations.add(new AnnotationsResult("@Annotation1", attributes));
		
		ALocalizerResult field2 = new ALocalizerResult("field2", signature, annotations,"Field2" ,"br.inpe.cap", "field");
		ALocalizerReport report = new ALocalizerReport();
		report.add(field2);
		report.setProjectName("field2");
		XMLUtils.createXMLFile(new Output(report), outputPath);
		
		paths.add(Paths.get("field2.xml"));
		
		assertEquals(FileUtils.readFileAsString("test/xml/field2.xml"), FileUtils.readFileAsString("field2.xml"));
	}
	
	@Test
	public void testNoAnnotation() {
		
		List<String> signature = new ArrayList<>();
		signature.add("public");
		
		ALocalizerResult clazz = new ALocalizerResult("Clazz", signature, null, "Clazz" ,"br.inpe.cap", "class");
		ALocalizerReport report = new ALocalizerReport();
		report.add(clazz);
		report.setProjectName("clazz");
		XMLUtils.createXMLFile(new Output(report), outputPath);
		
		paths.add(Paths.get("clazz.xml"));
		
		assertEquals(FileUtils.readFileAsString("test/xml/clazz.xml"), FileUtils.readFileAsString("clazz.xml"));
	}
	
	@AfterClass
	public static void deleteFiles() {
		for (Path path : paths) {
			try {
				Files.deleteIfExists(path);
			} catch (IOException e) {
			}
		}
	}
}

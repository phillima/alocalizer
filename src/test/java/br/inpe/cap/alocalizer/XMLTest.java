package br.inpe.cap.alocalizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.AnnotAttribute;
import br.inpe.cap.alocalizer.output.AnnotationsResult;
import br.inpe.cap.alocalizer.utils.FileUtils;
import br.inpe.cap.alocalizer.utils.XMLUtils;

public class XMLTest {
	
	private static List<String> modifiers = new ArrayList<>();
	
	
	@BeforeClass
	public static void initialize() {
		
		modifiers.add("public");
		modifiers.add("static");
		modifiers.add("void");
	}
	
	@Test	
	public void testClassOneMethod() {
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		annotations.add(new AnnotationsResult("@Annotation1", null));
		
		ALocalizerResult method1 = new ALocalizerResult("method1", modifiers, annotations, "Method1", "br.inpe.cap", "method");
		
		XMLUtils.createXMLFile(method1);
		
		assertEquals(FileUtils.readFileAsString("test/xml/method1.xml"), FileUtils.readFileAsString("method1.xml"));
	}
	
	@Test
	public void testClassOneField() {
		
		List<AnnotationsResult> annotations = new ArrayList<>();
		annotations.add(new AnnotationsResult("@Annotation1", null));
		
		ALocalizerResult field1 = new ALocalizerResult("field1", modifiers, annotations,"Field1" ,"br.inpe.cap", "field");
		
		XMLUtils.createXMLFile(field1);
		
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
		
		ALocalizerResult field2 = new ALocalizerResult("field2", modifiers, annotations,"Field2" ,"br.inpe.cap", "field");
		
		XMLUtils.createXMLFile(field2);
		
		assertEquals(FileUtils.readFileAsString("test/xml/field2.xml"), FileUtils.readFileAsString("field2.xml"));
	}
}

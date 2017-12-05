package br.inpe.cap.alocalizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.AnnotAttributeRep;
import br.inpe.cap.alocalizer.output.AnnotationsRep;
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
		
		List<AnnotationsRep> annotations = new ArrayList<>();
		annotations.add(new AnnotationsRep("@Annotation1", null));
		
		ALocalizerResult method1 = new ALocalizerResult("method1", modifiers, annotations, "Method1", "br.inpe.cap", "method");
		
		XMLUtils.createXMLFile(method1);
		
		assertEquals(FileUtils.readFileAsString("test/xmlTest/method1.xml"), FileUtils.readFileAsString("method1.xml"));
	}
	
	@Test
	public void testClassOneField() {
		
		List<AnnotationsRep> annotations = new ArrayList<>();
		annotations.add(new AnnotationsRep("@Annotation1", null));
		
		ALocalizerResult field1 = new ALocalizerResult("field1", modifiers, annotations,"Field1" ,"br.inpe.cap", "field");
		
		XMLUtils.createXMLFile(field1);
		
		assertEquals(FileUtils.readFileAsString("test/xmlTest/field1.xml"), FileUtils.readFileAsString("field1.xml"));
	}
	
	@Test
	public void testAnnotationWithAttributes() {
		
		AnnotAttributeRep attr1 = new AnnotAttributeRep("value1","1");
		AnnotAttributeRep attr2 = new AnnotAttributeRep("value2","2");

		List<AnnotAttributeRep> attributes = new ArrayList<>();
		attributes.add(attr1);
		attributes.add(attr2);
		
		List<AnnotationsRep> annotations = new ArrayList<>();
		annotations.add(new AnnotationsRep("@Annotation1", attributes));
		
		ALocalizerResult field2 = new ALocalizerResult("field2", modifiers, annotations,"Field2" ,"br.inpe.cap", "field");
		
		XMLUtils.createXMLFile(field2);
		
		assertEquals(FileUtils.readFileAsString("test/xmlTest/field2.xml"), FileUtils.readFileAsString("field2.xml"));
	}
}

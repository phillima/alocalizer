package br.inpe.cap.alocalizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.inpe.cap.alocalizer.output.ALocalizerResult;
import br.inpe.cap.alocalizer.output.AnnotAttribute;
import br.inpe.cap.alocalizer.output.AnnotationsResult;

public class AlocalizerTest {

	private static ALocalizerReport report;
	
	@BeforeClass
	public static void initialzer() {
		String testFilePath = System.getProperty("user.dir") + "/test";
		System.out.println(testFilePath);
		report = new ALocalizer().calculate(testFilePath);
	}
	
	@Test
	public void testMarkerAnnotation() {
		
		List<String> signature = new ArrayList<>();
		signature.add("public");
		signature.add("void");
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Method1Test.method1");
		assertEquals("method1", a.getName());
		assertEquals("annotation.Method1Test", a.getClassName());
		assertEquals("annotation", a.getPackageName());
		assertEquals("Annotation1", a.getAnnotations().get(0).getAnnotationName());
		for(int i = 0; i < signature.size(); i++)
			assertEquals(signature.get(i), a.getSignature().get(i));
	}
	
	@Test
	public void testAnnotationSimpleAnnotation() {
		
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Method2Test.method2");
		List<AnnotationsResult> anotRep = new ArrayList<>();
		for (AnnotationsResult annotationsRep : a.getAnnotations()) {
			assertEquals("Annotation1", annotationsRep.getAnnotationName());
			for (AnnotAttribute attribue : annotationsRep.getAnnotAttributes()) {
				assertEquals("value", attribue.getAnotAttributes());
				assertEquals("2", attribue.getAnotAttributesValues());
			}
		}
	}
	
	@Test
	public void testNormalAnnotation() {
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Method3Test.method3");
		List<AnnotationsResult> anotRep = new ArrayList<>();
		
		for(AnnotationsResult ar : a.getAnnotations()) {
			AnnotAttribute attr1 = ar.getAnnotAttributes().get(0);
			assertEquals("value1", attr1.getAnotAttributes());
			assertEquals("1", attr1.getAnotAttributesValues());
			
			AnnotAttribute attr2 = ar.getAnnotAttributes().get(1);
			assertEquals("value2", attr2.getAnotAttributes());
			assertEquals("2", attr2.getAnotAttributesValues());
		}
		
	}
	
	@Test
	public void testMultipleNormalAnnotation() {
		
		List<String> signature = new ArrayList<>();
		signature.add("private");
		signature.add("int");
		
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Field4Test.x");
		
		AnnotationsResult ar = a.getAnnotations().get(0);
		AnnotAttribute attr1 = ar.getAnnotAttributes().get(0);
		assertEquals("value1", attr1.getAnotAttributes());
		assertEquals("1", attr1.getAnotAttributesValues());
		
		AnnotAttribute attr2 = ar.getAnnotAttributes().get(1);
		assertEquals("value2", attr2.getAnotAttributes());
		assertEquals("2", attr2.getAnotAttributesValues());
		
		AnnotationsResult ar2 = a.getAnnotations().get(1);
		AnnotAttribute attr3 = ar2.getAnnotAttributes().get(0);
		assertEquals("value2", attr3.getAnotAttributes());
		assertEquals("2", attr3.getAnotAttributesValues());
		
		AnnotAttribute attr4 = ar2.getAnnotAttributes().get(1);
		assertEquals("value3", attr4.getAnotAttributes());
		assertEquals("3", attr4.getAnotAttributesValues());
		
		ALocalizerResult a2 = report.getByFullyQualifiedName("annotation.Field4Test.y");
		
		for(AnnotationsResult ar5 : a2.getAnnotations()) {
			List<AnnotAttribute> attr = ar5.getAnnotAttributes();
			assertNull(attr);
		}
		
		ALocalizerResult a3 = report.getByFullyQualifiedName("annotation.Field4Test.z");
	
		AnnotationsResult ar6 = a3.getAnnotations().get(0);
		AnnotAttribute attr5 = ar6.getAnnotAttributes().get(0);
		assertEquals("value1", attr5.getAnotAttributes());
		assertEquals("\"Dark\"", attr5.getAnotAttributesValues());
		
		AnnotAttribute attr6 = ar6.getAnnotAttributes().get(1);
		assertEquals("value2", attr6.getAnotAttributes());
		assertEquals("\"Souls\"", attr6.getAnotAttributesValues());
		
		
		for(int i = 0; i < signature.size(); i++)
			assertEquals(signature.get(i), a.getSignature().get(i));
		
	}
	
	@Test
	public void testEnum() {
		List<String> signature = new ArrayList<>();
		signature.add("public");
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Enum1");
		assertEquals("Enum1", a.getName());
		assertEquals("annotation.Enum1", a.getClassName());
		assertEquals("annotation", a.getPackageName());
		assertEquals("enum", a.getType());
		assertEquals("AnnotationEnum", a.getAnnotations().get(0).getAnnotationName());
		for(int i = 0; i < signature.size(); i++)
			assertEquals(signature.get(i), a.getSignature().get(i));
	}
	
	@Test
	public void testClass() {
		List<String> signature = new ArrayList<>();
		signature.add("public");
		ALocalizerResult a = report.getByFullyQualifiedName("annotation.Clazz");
		assertEquals("Clazz", a.getName());
		assertEquals("annotation.Clazz", a.getClassName());
		assertEquals("annotation", a.getPackageName());
		assertEquals("class", a.getType());
		assertEquals("AnnotationClazz", a.getAnnotations().get(0).getAnnotationName());
		for(int i = 0; i < signature.size(); i++)
			assertEquals(signature.get(i), a.getSignature().get(i));
	}
	
}

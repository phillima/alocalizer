package br.inpe.cap.alocalizer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.inpe.cap.alocalizer.output.ALocalizerResult;

public class AlocalizerTest {

	private static ALocalizerReport report;
	
	@BeforeClass
	public static void initialzer() {
		report = new ALocalizer().calculate("test");
	}
	
	@Test
	public void testName() {
		
		ALocalizerResult a = report.getByClassName("annotation.Method1Test");
		Assert.assertEquals("method1", a.getName());
	}
	
	
}

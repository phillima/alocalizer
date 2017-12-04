package br.inpe.cap.alocalizer;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlocalizerTest {

	private static ALocalizerReport report;
	
	@BeforeClass
	public void initialzer() {
		report = new ALocalizer().calculate("test");
	}
	
	@Test
	public void testName() {
		
		ALocalizerResult a = report.getByClassName("cbo.Coupling1");
		Assert.assertEquals(1, a.getLoc());
		
	}
	
	
}

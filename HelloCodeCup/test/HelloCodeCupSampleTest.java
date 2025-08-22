// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import static org.junit.Assert.*;

import org.junit.Test;


public class HelloCodeCupSampleTest {

	@Test
	public void testSayHelloToCodeCup_Sample() {
		HelloCodeCup HCC = new HelloCodeCup();
		assertEquals("Hello CodeCup 7", HCC.sayHelloToCodeCup(7));
	}
}

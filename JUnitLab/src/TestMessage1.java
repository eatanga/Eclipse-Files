import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.MessageUtil;

public class TestMessage1 {
	String message ="Robert";
	MessageUtil messageUtil = new MessageUtil(message);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Inside testPrintMessage()");
		assertEquals(message, messageUtil.printMessage());
	}
	@Test
	public void testMessageLength() {
	   System.out.println("Inside testOfMessageLength()");
	   int messageLength = message.length();
	 assertTrue(messageLength == messageUtil.returnMessageLength());
	}
	@Test
	public void testMessageNotNull() {
	   System.out.println("Inside testOfMessageNotNull()");
	   assertNotNull(messageUtil.printMessage( ));
	}

}

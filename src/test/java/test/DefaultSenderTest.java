package test;

import com.mycompany.mail.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.mycompany.mail.MailFactory;

public class DefaultSenderTest {
	MailFactory SM;
	
	@Before
	public void setUp(){
		SM = MailFactory.getFactory(MailMode.EMAIL);
	}
	
	@Test
	public void testdefineContent() {
		assertEquals("Teste", SM.defineContent("Teste"));
	}
	
	@Test
	public void testdefineSubject(){
		assertEquals("Teste", SM.defineSubject("Teste"));
	}

	@Test
	public void testdefineSender(){
		assertEquals("Teste", SM.defineSender("Teste"));
	}
	
	@Test
	public void testdefinePassword(){
		assertEquals("Teste", SM.definePassword("Teste"));
	}
	
}
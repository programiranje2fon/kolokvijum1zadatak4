package ispravka_koda;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ispisivac2Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void metoda_ispisiTrougao() {	
		
		Ispisivac2.ispisiTrougao();
		
		assertEquals("Metoda ne ispisuje trougao kako treba", 
				"*****" + System.lineSeparator() +
				"****" + System.lineSeparator() + 
				"***" + System.lineSeparator() + 
				"**" + System.lineSeparator() + 
				"*" + System.lineSeparator(), outContent.toString());
	}
	
}

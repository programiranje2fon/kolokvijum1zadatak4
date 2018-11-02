package eksponati.slike;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SlikaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Slika instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Slika();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));		
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void metoda_toString() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setCena(25.5);
		instance.setDatumPrijema(new GregorianCalendar(2011,10,2));
		
		String s = instance.toString();
		
		assertTrue("NE vraca se naziv", s.contains("Slika1"));		
		assertTrue("NE vraca se autor", s.contains("Autor2"));		
		assertTrue("NE vraca se cena", s.contains("25.5"));
		assertTrue("NE vraca se datum prijema", s.contains("2011"));	
		assertTrue("NE vraca se napomena da je u pitanju slika", s.contains("lika"));
	}

	

}

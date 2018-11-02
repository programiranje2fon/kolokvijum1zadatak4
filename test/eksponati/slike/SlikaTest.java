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
	public void metoda_ispisi() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setCena(25.5);
		instance.setDatumPrijema(new GregorianCalendar(2011,10,2));
		
		instance.ispisi();
		
		assertTrue("NE ispisuje se naziv", outContent.toString().contains("Slika1"));		
		assertTrue("NE ispisuje se autor", outContent.toString().contains("Autor2"));		
		assertTrue("NE ispisuje se cena", outContent.toString().contains("25.5"));
		assertTrue("NE ispisuje se datum prijema", outContent.toString().contains("2011"));	
		assertTrue("NE ispisuje se napomena da je u pitanju slika", outContent.toString().contains("lika"));
	}

	

}

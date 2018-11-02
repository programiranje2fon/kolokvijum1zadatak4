package eksponati.skulpture;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SkulpturaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	Skulptura instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Skulptura();
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
	public void metoda_setMaterijal() {
		instance.setMaterijal("srebro");
		
		assertEquals("Ako se unese srebro, atribut ne dobija tu vrednost", "srebro", instance.getMaterijal());
	}

	@Test
	public void metoda_ispisi() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setCena(25.5);
		instance.setMaterijal("bronza");
		instance.setDatumPrijema(new GregorianCalendar(2011,10,2));
		
		instance.ispisi();
		
		assertTrue("NE ispisuje se naziv", outContent.toString().contains("Slika1"));		
		assertTrue("NE ispisuje se autor", outContent.toString().contains("Autor2"));		
		assertTrue("NE ispisuje se cena", outContent.toString().contains("25.5"));
		assertTrue("NE ispisuje se materijal", outContent.toString().contains("bronza"));
		assertTrue("NE ispisuje se datum prijema", outContent.toString().contains("2011"));	
		assertTrue("NE ispisuje se napomena da je u pitanju skulptura", outContent.toString().contains("kulptur"));
	}

}

package eksponati.skulpture;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

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
	public void atribut_materijal() {
		assertTrue("U klasi nije definisan atribut materijal", TestUtil.doesFieldExist(Skulptura.class, "materijal"));
	}
	
	@Test
	public void atribut_autor_vidljivost() {
		assertTrue("Atribut materijal nije privatan", TestUtil.hasFieldModifier(Skulptura.class, "materijal", Modifier.PRIVATE));
	}

	@Test
	public void metoda_setMaterijal() {
		instance.setMaterijal("srebro");
		
		assertEquals("Ako se unese srebro, atribut ne dobija tu vrednost", "srebro", instance.getMaterijal());
	}

	@Test
	public void metoda_toString() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setCena(25.5);
		instance.setMaterijal("bronza");
		instance.setDatumPrijema(new GregorianCalendar(2011,10,2));
		
		String s = instance.toString();
		
		assertTrue("NE vraca se naziv", s.contains("Slika1"));		
		assertTrue("NE vraca se autor", s.contains("Autor2"));		
		assertTrue("NE vraca se cena", s.contains("25.5"));
		assertTrue("NE vraca se materijal", s.contains("bronza"));
		assertTrue("NE vraca se datum prijema", s.contains("2011"));	
		assertTrue("NE vraca se napomena da je u pitanju skulptura", s.contains("kulptur"));
	}

}

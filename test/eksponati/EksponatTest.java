package eksponati;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class EksponatTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Eksponat instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Eksponat();
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
	public void atribut_autor() {
		assertTrue("U klasi nije definisan atribut autor", TestUtil.doesFieldExist(Eksponat.class, "autor"));
	}
	
	@Test
	public void atribut_autor_vidljivost() {
		assertTrue("Atribut autor nije privatan", TestUtil.hasFieldModifier(Eksponat.class, "autor", Modifier.PRIVATE));
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(Eksponat.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(Eksponat.class, "naziv", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setAutor() {
		instance.setAutor("Pera Mikic");
		
		assertEquals("Ako se unese Pera Mikic kao autor, atribut ne dobija tu vrednost", "Pera Mikic", instance.getAutor());
	}
	
	@Test
	public void metoda_setAutor_Null() {
		instance.setAutor(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_setAutor_PrazanString() {
		instance.setAutor("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa praznog Stringa", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut autor", null, instance.getAutor());
	}

	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Mona Liza");
		
		assertEquals("Ako se unese Mona Liza kao naziv, atribut ne dobija tu vrednost", "Mona Liza", instance.getNaziv());
	}
	
	@Test
	public void metoda_setNaziv_Null() {
		instance.setNaziv(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_setNaziv_PrazanString() {
		instance.setNaziv("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa praznog Stringa", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut naziv", null, instance.getAutor());
	}
	
	@Test
	public void metoda_setCena() {
		instance.setCena(34.5);
		
		assertEquals("Ako se unese cena 34.5, atribut ne dobija tu vrednost", 34.5, instance.getCena(),0.001);
	}
	
	@Test
	public void metoda_setCena_Negativna() {
		instance.setCena(-0.5);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa negativne cene", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Ako se unese cena -0.5, atribut ipak greskom dobija tu vrednost", 0.0, instance.getCena(),0.001);
	}

	@Test
	public void metoda_setDatumPrijema() {
		GregorianCalendar datum = new GregorianCalendar(2011, 10, 3);
		instance.setDatumPrijema(datum);
		
		assertEquals("Ako se unese 3.11.2011. kao datum prijema, atribut ne dobija tu vrednost", datum, instance.getDatumPrijema());
	}

	@Test
	public void metoda_setDatumPrijema_Buduci() {
		GregorianCalendar datum = new GregorianCalendar(3011, 10, 3);
		instance.setDatumPrijema(datum);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa buduceg datuma", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Ako se unese 3.11.3011. kao datum prijema, atribut ipak greskom dobija tu vrednost", null, instance.getDatumPrijema());
	}
	
	@Test
	public void metoda_setDatumPrijema_NULL() {
		instance.setDatumPrijema(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL datuma", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_equals() {
		instance.setAutor("Pera");
		instance.setNaziv("Eksponat");
		instance.setCena(33.4);
		instance.setDatumPrijema(new GregorianCalendar(2000,3,4));
		
		Eksponat e2 = new Eksponat();
		e2.setAutor("Pera");
		e2.setNaziv("Eksponat");
		e2.setCena(22.2);
		e2.setDatumPrijema(new GregorianCalendar(2011,2,1));
		
		assertEquals("Ako je unet autor Pera i naziv eksponata Eksponat za oba objekta, metoda vraca false", true, instance.equals(e2));
	}
	
	@Test
	public void metoda_equals_FalseAutor() {
		instance.setAutor("Pera");
		instance.setNaziv("Eksponat");
		instance.setCena(33.4);
		instance.setDatumPrijema(new GregorianCalendar(2000,3,4));
		
		Eksponat e2 = new Eksponat();
		e2.setAutor("Pera2");
		e2.setNaziv("Eksponat");
		e2.setCena(22.2);
		e2.setDatumPrijema(new GregorianCalendar(2011,2,1));
		
		assertEquals("Ako je nije isti autor za oba objekta, metoda ipak vraca true", false, instance.equals(e2));
	}
	
	@Test
	public void metoda_equals_FalseNaziv() {
		instance.setAutor("Pera");
		instance.setNaziv("Eksponat");
		instance.setCena(33.4);
		instance.setDatumPrijema(new GregorianCalendar(2000,3,4));
		
		Eksponat e2 = new Eksponat();
		e2.setAutor("Pera");
		e2.setNaziv("Eksponat2");
		e2.setCena(22.2);
		e2.setDatumPrijema(new GregorianCalendar(2011,2,1));
		
		assertEquals("Ako je nije isti naziv za oba objekta, metoda ipak vraca true", false, instance.equals(e2));
	}
	
	@Test
	public void metoda_toString() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setCena(25.5);
		instance.setDatumPrijema(new GregorianCalendar(2011,10,2));
		
		String s = instance.toString();
		
		assertTrue("NE vraca se naziv eksponata", s.contains("Slika1"));		
		assertTrue("NE vraca se autor", s.contains("Autor2"));		
		assertTrue("NE vraca se cena eksponata", s.contains("25.5"));
		assertTrue("NE vraca se datum prijema", s.contains("2011"));		
	}
	
}

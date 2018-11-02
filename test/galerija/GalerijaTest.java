package galerija;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eksponati.Eksponat;
import eksponati.skulpture.Skulptura;
import eksponati.slike.Slika;
import test.TestUtil;

public class GalerijaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Galerija instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Galerija();
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
	public void atribut_eksponati() {
		assertTrue("U klasi nije definisan atribut eksponati", TestUtil.doesFieldExist(Galerija.class, "eksponati"));
	}
	
	@Test
	public void atribut_eksponati_vidljivost() {
		assertTrue("Atribut eksponati nije privatan", TestUtil.hasFieldModifier(Galerija.class, "eksponati", Modifier.PRIVATE));
	}

	@Test (timeout = 2000)
	public void konstruktor_Galerija() {
		Eksponat[] niz = (Eksponat[]) TestUtil.getFieldValue(instance, "eksponati");
		
		assertEquals("Konstruktor ne inicijalizuje niz na kapacitet 100", 100, niz.length);
	}

	@Test (timeout = 2000)
	public void metoda_unesiEksponat() {
		Slika s = new Slika();
		Skulptura sk = new Skulptura();
		
		s.setNaziv("Slika");
		s.setAutor("Pera");
		
		sk.setNaziv("Skulptura");
		sk.setAutor("Mika");
		
		instance.unesiEksponat(s);
		instance.unesiEksponat(sk);
		
		Eksponat[] niz = (Eksponat[]) TestUtil.getFieldValue(instance, "eksponati");
		
		assertEquals("Ako se unese eksponat slika, metoda ne postavlja sliku na prvo slobodno mesto",s,niz[0]);
		assertEquals("Ako se unesu dva eksponata, slika pa skulptura, metoda ne postavlja skulpturu na prvo slobodno mesto",sk,niz[1]);
		for (int i=2;i<niz.length;i++)
			assertEquals("Metoda greskom popunjava sva slobodna mesta",null,niz[i]);
		
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiEksponat_NizPrepun() {
		for (int i=1;i<=100;i++) {
			Eksponat e = new Eksponat();
			e.setNaziv("Eksponat"+i);
			e.setAutor("Autor"+i);
			
			instance.unesiEksponat(e);
		}
		
		Eksponat e = new Eksponat();
		e.setNaziv("EksponatPreko");
		e.setAutor("AutorPreko");
		
		instance.unesiEksponat(e);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa u prepun niz", "GRESKA", outContent.toString().trim().toUpperCase());				
	}

	@Test (timeout = 2000)
	public void metoda_unesiEksponat_NULL() {
		
		instance.unesiEksponat(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());				
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiEksponat_Duplikat() {
		Slika s = new Slika();
		Skulptura sk = new Skulptura();
		
		s.setNaziv("Slika");
		s.setAutor("Pera");
		
		sk.setNaziv("Skulptura");
		sk.setAutor("Mika");
		
		instance.unesiEksponat(s);
		instance.unesiEksponat(sk);
		
		Skulptura duplikat = new Skulptura();
		duplikat.setNaziv("Skulptura");
		duplikat.setAutor("Mika");

		instance.unesiEksponat(duplikat);
		
		Eksponat[] niz = (Eksponat[]) TestUtil.getFieldValue(instance, "eksponati");
		
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa duplikata", "GRESKA", outContent.toString().trim().toUpperCase());				
		for (int i=2;i<niz.length;i++)
			assertNotEquals("Metoda greskom ipak unosi duplikat u niz",duplikat,niz[i]);
		
	}

	

	@Test (timeout = 2000)
	public void metoda_uvediPopust() {
		int proslaGod = (new GregorianCalendar()).get(GregorianCalendar.YEAR)-1;
		
		Slika s = new Slika();
		s.setDatumPrijema(new GregorianCalendar(proslaGod, 1, 1));
		s.setNaziv("Slika");
		s.setAutor("Pera");
		s.setCena(100.0);
		
		Skulptura sk = new Skulptura();
		sk.setDatumPrijema(new GregorianCalendar(1980, 1, 1));
		sk.setNaziv("Skulptura");
		sk.setAutor("Mika");
		sk.setCena(200.0);
		
		Skulptura sk2 = new Skulptura();
		sk2.setDatumPrijema(new GregorianCalendar(proslaGod, 1, 1));
		sk2.setNaziv("Skulptura2");
		sk2.setAutor("Mika");
		sk2.setCena(300.0);

		instance.unesiEksponat(s);
		instance.unesiEksponat(sk);
		instance.unesiEksponat(sk2);
		
		instance.uvediPopust(10.5);

		Eksponat[] niz = (Eksponat[])TestUtil.getFieldValue(instance, "eksponati");
		
		assertEquals("Metoda ne uvodi popust od 10.5% za "+s.toString()+" cena je", 89.5,niz[0].getCena(), 0.001);
		assertEquals("Metoda ne uvodi popust od 10.5% za "+sk2.toString()+" cena je", 268.5,niz[2].getCena(), 0.001);
		assertEquals("Metoda GRESKOM uvodi popust za "+sk.toString()+" cena je", 200,niz[1].getCena(), 0.001);
		
	}

	@Test (timeout = 2000)
	public void metoda_vratiNajskuplje() {
		Slika s = new Slika();
		s.setNaziv("Slika");
		s.setAutor("Pera");
		s.setCena(100.0);
		
		Skulptura sk = new Skulptura();
		sk.setNaziv("Skulptura");
		sk.setMaterijal("bronza");
		sk.setAutor("Mika");
		sk.setCena(200.0);
		
		Skulptura sk2 = new Skulptura();
		sk2.setNaziv("Skulptura2");
		sk2.setMaterijal("bronza");
		sk2.setAutor("Mika");
		sk2.setCena(300.0);
		
		Skulptura sk3 = new Skulptura();
		sk3.setNaziv("Skulptura3");
		sk3.setMaterijal("bronza");
		sk3.setAutor("Zika");
		sk3.setCena(100.0);

		Skulptura sk4 = new Skulptura();
		sk4.setNaziv("Skulptura4");
		sk4.setMaterijal("drvo");
		sk4.setAutor("Laza");
		sk4.setCena(500.0);

		instance.unesiEksponat(s);
		instance.unesiEksponat(sk);
		instance.unesiEksponat(sk2);
		instance.unesiEksponat(sk3);
		instance.unesiEksponat(sk4);
		
		Skulptura[] niz = instance.vratiNajskuplje();
		
		assertEquals("Niz nije duzine 2", 2, niz.length);
		assertTrue("Uneto je 5 eksponata:"+s+sk+sk2+sk3+sk4+" ali se najskuplja skulptura cene 300 ne nalazi u rezultatu", sk.equals(niz[0]) || sk.equals(niz[1]));
		assertTrue("Uneto je 5 eksponata:"+s+sk+sk2+sk3+sk4+" ali se druga najskuplja skulptura cene 200 ne nalazi u rezultatu", sk2.equals(niz[0]) || sk2.equals(niz[1]));

	}

}

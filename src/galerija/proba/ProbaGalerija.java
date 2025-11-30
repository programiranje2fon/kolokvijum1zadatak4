package galerija.proba;

import java.util.GregorianCalendar;

import eksponati.skulpture.Skulptura;
import galerija.Galerija;

public class ProbaGalerija {

	public static void main(String[] args) {
		Galerija g = new Galerija();
		
		Skulptura s = new Skulptura();
		
		s.setAutor("Petar Markovic");
		s.setNaziv("Bista majke");
		s.setMaterijal("bronza");
		s.setDatumPrijema(new GregorianCalendar(2017, 6, 12));
		
		g.unesiEksponat(s);
	}

}

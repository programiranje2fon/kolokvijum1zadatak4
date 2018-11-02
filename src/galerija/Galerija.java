package galerija;

import java.util.GregorianCalendar;

import eksponati.Eksponat;
import eksponati.skulpture.Skulptura;

public class Galerija {
	
	private Eksponat[] eksponati;
	
	public Galerija() {
		eksponati = new Eksponat[100];
	}
	
	private boolean daLiJeUNizu(Eksponat e) {
		for (int i=0; i<eksponati.length; i++)
			if (eksponati[i] != null && eksponati[i].equals(e))
				return true;
		
		return false;
	}
	
	public void unesiEksponat (Eksponat e) {
		if (e == null || daLiJeUNizu(e) == true) {
			System.out.println("GRESKA");
			return;
		}
		
		for (int i=0; i<eksponati.length; i++)
			if (eksponati[i] == null) {
				eksponati[i] = e;
				return;
			}

		System.out.println("GRESKA");
	}
	
	public void uvediPopust(double procenatPopusta) {
		GregorianCalendar trenutni = new GregorianCalendar();
		
		int proslaGodina = trenutni.get(GregorianCalendar.YEAR) -1;
		
		for (int i=0;i<eksponati.length;i++)
			if (eksponati[i]!=null && 
				eksponati[i].getDatumPrijema().get(GregorianCalendar.YEAR) == proslaGodina) {
				double novaCena = eksponati[i].getCena() * (100-procenatPopusta)/100;
				
				eksponati[i].setCena(novaCena);
			}
	}
	
	public Skulptura[] vratiNajskuplje() {
		Skulptura[] niz = new Skulptura[2];
		
		int max1Indeks = -1;

		for (int i=0; i<eksponati.length; i++)
			if (eksponati[i]!=null && eksponati[i] instanceof Skulptura &&
					((Skulptura)(eksponati[i])).getMaterijal().equals("bronza"))
				if (max1Indeks == -1 || eksponati[max1Indeks].getCena() < eksponati[i].getCena())
					max1Indeks = i;
		
		int max2Indeks = -1;
		
		for (int i=0; i<eksponati.length; i++)
			if (i!=max1Indeks && 
					eksponati[i]!=null && eksponati[i] instanceof Skulptura &&
					((Skulptura)(eksponati[i])).getMaterijal().equals("bronza"))
				if (max2Indeks == -1 || eksponati[max2Indeks].getCena() < eksponati[i].getCena())
					max2Indeks = i;
		
		if (max1Indeks != -1) niz[0] = (Skulptura)eksponati[max1Indeks];
		if (max2Indeks != -1) niz[1] = (Skulptura)eksponati[max2Indeks];
		
		return niz;
	}

}

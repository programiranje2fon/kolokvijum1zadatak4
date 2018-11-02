package galerija;

import eksponati.Eksponat;

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
		
	}

}

package eksponati.skulpture;

import eksponati.Eksponat;

public class Skulptura extends Eksponat {
	
	private String materijal;

	public String getMaterijal() {
		return materijal;
	}

	public void setMaterijal(String materijal) {
		this.materijal = materijal;
	}
	
	public void ispisi() {
		super.ispisi();
		System.out.println("Materijal: " + materijal);
		System.out.println("U pitanju je skulptura");
	}

}

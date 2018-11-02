package eksponati;

import java.util.GregorianCalendar;

public class Eksponat {
	
	private String naziv;
	
	private String autor;
	
	private double cena;
	
	private GregorianCalendar datumPrijema;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty())
			System.out.println("GRESKA");
		else
			this.naziv = naziv;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == null || autor.isEmpty())
			System.out.println("GRESKA");
		else
			this.autor = autor;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		if (cena <= 0)
			System.out.println("GRESKA");
		else
			this.cena = cena;
	}

	public GregorianCalendar getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(GregorianCalendar datumPrijema) {
		if (datumPrijema == null || datumPrijema.after(new GregorianCalendar()))
			System.out.println("GRESKA");
		else
			this.datumPrijema = datumPrijema;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Eksponat))
			return false;
		
		Eksponat eksponat2 = (Eksponat)(o);
		
		if (naziv.equals(eksponat2.naziv) && autor.equals(eksponat2.autor))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Naziv=" + naziv + ", autor=" + autor + ", cena=" + cena + ", datumPrijema=" + datumPrijema;
	}
	
	
	

}

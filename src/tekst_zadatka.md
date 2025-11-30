# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javnu klasu **Eksponat** u paketu **eksponati** koja ima:

* Privatni atribut **naziv** koji predstavlja naziv eksponata.

* Privatni atribut **autor** koji predstavlja ime i prezime autora u formatu "IME PREZIME".

* Privatni atribut **cena** koji predstavlja cenu eksponata (npr. 29,95).

* Privatni atribut **datumPrijema** tj. datum kada je eksponat primljen u galeriju (klasa GregorianCalendar).

* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za atribute naziv i autor su null i prazan String a cena mora da bude veća od nule. Takođe, datum prijema ne sme da bude null i mora da se odnosi na neki trenutak koji nije posle trenutnog datuma i vremena. U slučaju unosa nedozvoljenih vrednosti potrebno je ispisati na ekranu reč "GRESKA".

* Redefinisanu metodu **toString** koja vraća String sa svim podacima o eksponatu.

* Redefinisanu **equals** metodu koja proverava da li je unet objeka klase Eksponat i vraća false ako nije. Metoda vraća true ako jeste unet objeka klase Eksponat i ako se vrednosti atributa naziv i autor podudaraju sa nazivom i autorom unetog objekta. 

Napraviti javnu klasu **Slika** u paketu **eksponati.slike** koja nasleđuje klasu Eksponat i ima:

* Redefinisanu javnu metodu **toString** koja vraća String sa SVIM podacima o slici, a taj String sadrži i napomenu da je eksponat, u ovom slučaju, slika.

Napraviti javnu klasu **Skulptura** u paketu **eksponati.skulpture** koja nasleđuje klasu Eksponat i ima:

* Privatni atribut **materijal** koji predstavlja naziv materijal od kojeg je napravljena skulptura.

* Odgovarajuće javne get i set metode za ovaj atribut

* Redefinisanu javnu metodu **toString** koja vraća String sa SVIM podacima o skulpturi, a taj String sadrži i napomenu da je eksponat, u ovom slučaju, skulptura.

Napraviti javnu klasu **Galerija** u paketu **galerija** koja ima:

* Privatni atribut **eksponati** koji predstavlja niz objekata klase Eksponat. (NAPOMENA: Niz eksponata sa izložbe će zapravo da sadrži objekte klase Slika i objekte klase Skulptura)

* Javni konstruktor koji inicijalizuje niz na 100 elemenata.

* Javnu metodu **unesiEksponat** koja kao parametar prima objekat klase Eksponat i unosi ga u niz na prvo slobodno mesto. Mesto u nizu je slobodno ako je element na tom mestu NULL. Unošenje se vrši samo ako uneti objekat nema null vrednost, ako u nizu ima mesta i ako se u nizu već ne nalazi isti eksponat. U suprotnom, ispisati poruku o grešci.

* Javnu metodu **uvediPopust** koja kao ulazni parametar dobija procentualni iznos popusta (npr.7,5%) i spušta cene svih onih eksponata koji su primljeni u galeriju u toku prethodne godine. Pri tome, potrebno je utvrditi koja je bila prethodna godina na osnovu trenutnog datuma.

* Javnu metodu **vratiNajskuplje** koja vraća niz objekata klase Skulptura koji sadrži tačno dve najskuplje skulpture (iz galerije) napravljene od bronze.

Napraviti javnu klasu **ProbaGalerija** u paketu **galerija.proba** koja u okviru main metode pravi jedan objekat klase Galerija, i unosi jedan eksponat: skulpturu od bronze "Bista majke" autora "Petra Markovica" koja je primljena 12.07.2017. u galeriju.

# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja bi trebalo da ispisuje trougao (od znakova *) na ekranu. Ideja je da se u prvom redu na ekranu ispiše pet zvezdica, u drugom redu četiri... a u poslednjem jedna, tako da bi konačan izlaz na ekranu trebalo da izgleda ovako:

	*****
	****
	***
	**
	*

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti klasu **Ispisivac2** u paketu **ispravka_koda**, prekucati u nju kod koji je dat  i, uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Koristeći main metodu iz test klase, pozvati metodu ispisiTrougao() i proveriti njen rad.

	package ispravka_koda;
	
	class Ispisivac2 {
		static void ispisiTrougao() {
			int i=5;
			while (i>1){
				for (int j = 1; j > i; j++);
					System.out.print('*');
					System.out.println();
					i--;
			    }	
		}
	}

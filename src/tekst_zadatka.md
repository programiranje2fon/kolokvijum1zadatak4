# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**



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

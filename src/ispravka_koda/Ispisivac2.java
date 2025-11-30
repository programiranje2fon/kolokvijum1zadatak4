package ispravka_koda;

class Ispisivac2 {
	
	static void ispisiTrougao() {
		int i = 5;
		while (i >= 1) {
			for (int j = 1; j <= i; j++)
			System.out.print('*');
			System.out.println();
			i--;
		}
	}
	
}
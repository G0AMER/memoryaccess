public class Main {

	public static void main(String[] args) {
		Monitor M = new Monitor();
		Processus P1 = new Processus(M, 4);
		Processus P2 = new Processus(M, 8);
		Processus P3 = new Processus(M, 7);
		Processus P4 = new Processus(M, 9);
		Processus P5 = new Processus(M, 2);
		Processus P6 = new Processus(M, 5);
		P1.start();
		P2.start();
		P3.start();
		P4.start();
		P5.start();
		P6.start();
	}
}

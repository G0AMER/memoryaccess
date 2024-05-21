package tn.enis.amount;

public class Processus extends Thread {
	private Monitor M;
	private int amount;

	Processus(Monitor M, int amount) {
		this.M = M;
		this.amount = amount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			M.request(amount);
			M.accessMemory(amount);
			M.release(amount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

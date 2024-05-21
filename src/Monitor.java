import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
	private int cellules = 10;
	private int cellulesDispo = cellules;
	private final Lock lock = new ReentrantLock();
	private final Condition C1 = lock.newCondition();

	void request(int amount) throws InterruptedException {
		lock.lock();
		try {
			while (amount > cellulesDispo) {
				C1.signal();
				System.out.println("Request " + amount + " enter");
				C1.await();
				System.out.println("Request " + amount + " quitte");
			}
			cellulesDispo -= amount;

		} finally {
			lock.unlock();
		}

	}

	void release(int amount) throws InterruptedException {
		lock.lock();
		try {
			cellulesDispo += amount;
			System.out.println("Release " + amount);
			C1.signal();
		} finally {
			lock.unlock();
		}
	}

	void accessMemory(int amount) {
		System.out.println(amount + " access memory");
	}

}

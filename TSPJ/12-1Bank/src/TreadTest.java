public class TreadTest {
	public static void main(String[] args) throws InterruptedException {
		BankAccount b = new BankAccount(); // b : 공유데이터
		In in = new In(b);
		Out out = new Out(b);
		Thread p = new Thread(new In(b));
		Thread c1 = new Thread(new Out(b), "c1");
		Thread c2 = new Thread(new Out(b), "c2");

		p.start();
		c1.start();
		c2.start();
		p.join(); // p가 끝나길 기다린다. p의 실행을 중단하지는 않는다.
		c1.interrupt();
		c2.interrupt();
//		    c.join();  //c가 끝나길 기다린다. c의 실행을 중단하지는 않는다.
		// 끝나면 아래 명령문으로 진행
		System.out.println("\nbalance = " + b.getBalance());
	}
}// class ThreadTest

class BankAccount {
	Integer balance = 5000;

	void deposit(int amount) {
		synchronized (this) {
			balance = balance + amount;
			System.out.println("천원 저금/ 남은 금액:" + balance);
			notifyAll();
		}
	}

	void withdraw(int amount) {
		synchronized (this) {
			while(balance == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			balance = balance - amount;
			System.out.println(Thread.currentThread().getName()+"  천원 인출/ 남은 금액:" + balance);
		}
	}

	int getBalance() {
		return balance;
	}

}// class BankAccount

class In implements Runnable // extends Thread
{
	BankAccount b;

	In(BankAccount b) {
		this.b = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
			b.deposit(1000);
		} // for
	}// run
}// class In

class Out implements Runnable // extends Thread
{
	BankAccount b;

	Out(BankAccount b) {
		this.b = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
			b.withdraw(1000);

		} // for
	} // run
}// class Out

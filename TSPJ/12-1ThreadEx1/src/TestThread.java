

public class TestThread {

	public static void main(String[] args) throws InterruptedException{
		
		System.out.println(Thread.currentThread());
		TimerThread th1 = new TimerThread("th1",100);
		TimerThread th2 = new TimerThread("th2",300);
		TimerThread th3 = new TimerThread("th3",500);
		th1.start(); //>> run()을 호출한다 				
		th2.start(); 
		th3.start(); 
		Thread.sleep(1000); //>> main의 스레드가 1초 쉰다 
		th1.interrupt();
		th2.interrupt();
		th3.interrupt();
		th1.join(); //>> th1이 끝나야 다음 명령어가 실행된다.
		th2.join(); 
		th3.join(); 
		System.out.println("main 종료"); // 인터럽트보다 메인 종료가 먼저 뜨기도 한다
		// 종료가 떳다고 메인 스레드가 종료된것이 아니라 모든 스레드가 끝나면 종료된다.
	}

}

class TimerThread extends Thread {
	int n=0;
	int gap;
	public TimerThread(String n,int g) {
		super(n);
		gap = g;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName()+":"+n);
			n++;
			try {
				sleep(gap); //>> 예외처리 없이 못쓴다
			}
			catch(InterruptedException e) // 예외객체를 e로 받는다
			{   System.out.println("interrupted");
				//e.printStackTrace(); // 오류 내용을 출력
				return;
			}
		}
	}
}

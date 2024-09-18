
public class SynchronizedEx {

	public static void main(String [] args)  {
		SharedBoard board = new SharedBoard(); 
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();
	}

}

class StudentThread extends Thread {

	private SharedBoard board; // 집계판의 주소

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}	
	@Override
	public void run() {
		for(int i=0; i<10; i++)
			try {
				board.add();
				Thread.sleep((int)(Math.random()*500)); // try catch 오류 발생
			}catch(InterruptedException e){
				System.out.println("err");
			}
			
	}
}

class SharedBoard {	
	private int sum = 0; // 집계판의 합
	
	synchronized public void add()  {
		int n = sum;
		n += 1; // 1 증가
//		Thread.sleep((int)(Math.random()*500)); // 오류 발생
		sum = n; // 증가한 값을 집계합에 기록		
		System.out.println(Thread.currentThread().getName( )+" : "+sum);
	}
	
	public int getSum() { return sum; }
}

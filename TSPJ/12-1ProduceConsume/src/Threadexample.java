import java.util.LinkedList;
 

class RunThreadProduce implements Runnable {
	PC pc;
	
	RunThreadProduce(PC p)
	{ pc = p; }
	@Override
	public void run() {
		try { pc.produce(); }
        catch (InterruptedException e) {   }
	}
}

class RunThreadConsume implements Runnable {
	PC pc;
	
	RunThreadConsume(PC p)
	{ pc = p; }
	@Override
	public void run() {
		try { pc.consume(); }
        catch (InterruptedException e) {   }
	}
}
public class Threadexample {
    public static void main(String[] args) 
    {       
        PC pc = new PC(); 
        RunThreadProduce rtp = new RunThreadProduce(pc);
        Thread p = new Thread(rtp,"p0");

        RunThreadConsume rtc = new RunThreadConsume(pc);
        Thread c = new Thread(rtc, "c0");
        
        rtc = new RunThreadConsume(pc);
        Thread c1 = new Thread(rtc, "c1");

//        Thread p0 = new Thread( new Runnable() {
//            public void run()
//            {   try { pc.produce(); }
//                catch (InterruptedException e) {   }
//            }
//        },"p0"); //Runnable Thread 간단한 표현
//         
//        Thread c0 = new Thread( new Runnable() {
//            public void run()
//            {   try { pc.consume(); }
//                catch (InterruptedException e) {   }
//            }
//        },"c0"); //Runnable Thread 간단한 표현
           
        c.start();
        p.start();  
        c1.start();
        
    } //main
}//class Threadexample 

    class PC {     // 공유 객체
 
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 5;
        int value = 0;
 
        // Function called by producer thread p
        public void produce() throws InterruptedException
        {
            
            while (true) {
               synchronized (this)  //this == 객체 pc
                {                    
                    while (list.size() == capacity)  
						wait();
					list.add(value);
					System.out.println("produce " + value);
					value++;
					//notify(); // 기다리는 것 중 하나만 꺠운다
					notifyAll();
					Thread.sleep(500);
					// wait();
				}
            }//while
        }//produce()
 
        // Function called by consumer thread t2
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {  
                	if (list.size() == 0)  
                        this.wait();
					int val = list.removeFirst();
					System.out.println("\t" + "consume " + val);
					System.out.println("\t" + Thread.currentThread().getName() + " " + val);
					notify();
					Thread.sleep(500);
                }
            }//while
        }//consume()
    }//class PC
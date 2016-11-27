package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadEvenOdd implements Runnable {
	private boolean isEven;
	private int count;
	static Semaphore s = new Semaphore(1);
	static Semaphore t = new Semaphore(0);
	ThreadEvenOdd(boolean flag, int c){
		isEven = flag;
		count = c;
	}

	@Override
	public void run() {
		if (isEven){
			try {
				printEven(count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			try {
				printOdd(count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void printOdd(int count) throws InterruptedException{
		int c = 1;
		for(int i=0;i<count;i++){
			s.acquire(1);
			System.out.println(c);
			c = c+2;
			t.release(1);
		}
	}

	private void printEven(int count) throws InterruptedException{
		int c = 2;
		for(int i=0;i<count;i++){
			t.acquire(1);
			System.out.println(c);
			c = c+2;
			s.release(1);
		}
	}

	public static void main(String[] args) throws InterruptedException{
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(new Thread(new ThreadEvenOdd(true,20)));
		Thread.sleep(2000);
		es.submit(new Thread(new ThreadEvenOdd(false,20)));
		es.shutdown();
	}
}

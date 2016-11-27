package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenOdd {

	Lock lock = new ReentrantLock();
	Condition isEven= lock.newCondition();
	Condition isOdd= lock.newCondition();
	private boolean isEvenPrinted = true;

	void printEven(int i) throws InterruptedException {
		lock.lock();
		try {
			if (isEvenPrinted) {
				isEven.await();
			}
			System.out.println(i);
			isEvenPrinted = true;
			isOdd.signalAll();
		} finally {
			lock.unlock();
		}
	}

	void printOdd(int i) throws InterruptedException {
		lock.lock();
		try {
			if (!isEvenPrinted) {
				isOdd.await();
			}
			System.out.println(i);
			isEvenPrinted = false;
			isEven.signalAll();
		} finally {
			lock.unlock();
		}
	}

    private static class OddNumberGenerator implements Runnable {
        private PrintEvenOdd q;
        private int max;

        public OddNumberGenerator(PrintEvenOdd q, int max) {
            this.q = q;
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 1; i < max; i = i + 2) {
                try {
                    q.printOdd(i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class EvenNumberGenerator implements Runnable {
        private PrintEvenOdd printer;
        private int max;

        public EvenNumberGenerator(PrintEvenOdd printer, int max) {
            this.printer = printer;
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 2; i <= max; i = i + 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

	public static void main(String[] args) throws InterruptedException {
        int maxNumber = 10;
        PrintEvenOdd toe = new PrintEvenOdd();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new EvenNumberGenerator(toe, maxNumber));
        Thread.sleep(1000);
        es.submit(new OddNumberGenerator(toe, maxNumber));
        es.shutdown();
	}
}

package threads;


import java.util.concurrent.BlockingQueue;

public class PooledThread extends Thread {

	private BlockingQueue<Runnable> taskQueue;
	private volatile boolean  isStopped = false;

	public PooledThread(BlockingQueue<Runnable> taskQueue){
		this.taskQueue=taskQueue;
	}

    public void run(){
		System.out.println("pooled thread:"+ Thread.currentThread().getName());
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch(Exception e){
                Thread t = Thread.currentThread();
                t.getUncaughtExceptionHandler().uncaughtException(t, e);
            }
        }
    }

    public void doStop(){
        isStopped = true;
        this.interrupt();
    }

    public boolean isStopped(){
        return isStopped;
    }

}

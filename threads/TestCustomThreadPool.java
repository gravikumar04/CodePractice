package threads;

public class TestCustomThreadPool {

    public static void main(String[] args){
    	CustomThreadPool threadPool=new CustomThreadPool(2); //create 2 threads in ThreadPool
        Runnable task=new Task();
        try {
			threadPool.execute(task);
	        threadPool.execute(task);
	        threadPool.execute(task);
	        threadPool.execute(task);
	        threadPool.execute(task);
	        threadPool.execute(task);
	        Thread.sleep(10000);
	        threadPool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
 }
}

class Task implements Runnable{
    @Override
    public void run() {
           try {
                  Thread.sleep(2000);
                  System.out.println(Thread.currentThread().getName()
                               +" is executing task.");
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
    }
};


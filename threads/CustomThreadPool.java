package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private int poolSize;
	private BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
	private List<PooledThread> threads;
	private volatile boolean  poolShutDownInitiated = false;

	public CustomThreadPool(int poolSize){
		this.poolSize = poolSize;
		threads = new ArrayList<PooledThread>(this.poolSize);

	    for(int i=0; i<this.poolSize; i++){
	        threads.add(new PooledThread(taskQueue));
	    }
	    for(PooledThread thread : threads){
	        thread.start();
	    }
	}

    public void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
            throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
        System.out.println("task has been added.");
        this.taskQueue.put(task);
    }

    public void shutdown(){
        this.poolShutDownInitiated = true;
        for(PooledThread thread : threads){
            thread.doStop();
         }
        System.out.println("ThreadPool SHUTDOWN initiated.");
     }

}

package stack;

public class SyncStack<T> implements IStack<T> {

    private int top= -1; // shared resource which needs be protected
    private T[] stackArray;
    private static final int DEFAULT_SIZE = 10;

    @SuppressWarnings("unchecked")
    public SyncStack(int size) {
        stackArray = (T[]) new Object[size];
    }

    public SyncStack() {
       this(DEFAULT_SIZE);
    }

    public synchronized T push(T element){
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
        stackArray[++top] = element;
        notify();
        return element;
    }

    public synchronized T pop() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException iex) {
            	iex.printStackTrace();
            }
        }
        T element = stackArray[top];
        stackArray[top--] = null; // to prevent memory leak
        notify();
        return element;
    }

    public synchronized T peek(){
        if (isEmpty())
            throw new MyStackException("Stack is empty");
        return stackArray[top];
    }

    public synchronized boolean isEmpty() {
        return top == -1;
    }

    public synchronized boolean isFull() {
        return top == stackArray.length;
    }

	public  static  void main(String args[]) throws InterruptedException{
		SyncStack<Integer> ms = new SyncStack<Integer>();
    	for(int i= 0 ; i< 10;i++){
    		System.out.println(ms.push(i));
    	}
    	Thread.sleep(500);
    	for(int i= 0 ; i<10 ;i++){
    		System.out.println("pop"+ms.pop());
    	}

	}
}
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack {
	AtomicReference<Node> ar = new AtomicReference<>();
	AtomicInteger ai = new AtomicInteger(0);
	
	public void push(int data){
		Node newHead = new Node(data);
		ai.incrementAndGet();
		Node prevHead;
        do{
            prevHead = ar.get();
            newHead.next=prevHead;
        }while(!ar.compareAndSet(prevHead, newHead));
	}
	
	public int peek(){
		Node prevHead = ar.get();
		if(prevHead==null)
				return -1;
		return prevHead.data;		
	}
	
	public boolean isEmpty(){
		Node tmp = ar.get();
		if(tmp==null){
			return true;
		}
		return false;
	}
	
	public int size(){
		return ai.intValue();
	}
	
	
	public int pop(){
		Node newHead;
		Node prevHead;
		prevHead = ar.get();
		do{ 
			if(prevHead==null)
				return -1; // throw exception
			newHead = prevHead.next;
		}while(!ar.compareAndSet(prevHead, newHead));
		ai.decrementAndGet();
		return prevHead.data;
	}
	
	
	static class Node{
		final int data;
		Node next;
		public Node(int data) { this.data = data; }
	}
	
	public  static  void main(String args[]){
		ConcurrentStack cs = new ConcurrentStack();
		cs.push(10);
		cs.push(20);
		System.out.println(cs.peek());
		System.out.println(cs.size());
		System.out.println(cs.pop());
		System.out.println(cs.isEmpty());
		System.out.println(cs.size());
		System.out.println(cs.peek());
		System.out.println(cs.pop());
		System.out.println(cs.isEmpty());
		System.out.println(cs.size());
		
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		
	}

}

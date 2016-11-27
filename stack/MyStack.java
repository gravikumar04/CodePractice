package stack;

public class MyStack<E> implements IStack<E>{
    private int top;
    private E[] storage;

    @SuppressWarnings("unchecked")
	public MyStack(int capacity) {
          if (capacity <= 0)
                throw new IllegalArgumentException("Stack's capacity must be positive");
          storage = (E[])new Object[capacity];
          top = -1;
    }
    @Override
    public E push(E value) {
          if (isFull()){
                throw new MyStackException("Stack's underlying storage is overflow");
          }
          top++;
          System.out.println("PUSH"+top);
          storage[top] = value;
          return value;
    }
    @Override
    public E peek() {
          if (isEmpty()){
                throw new MyStackException("Stack is empty");
          }
          return storage[top];
    }

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		return (top == storage.length);
	}
	@Override
    public E pop() {
          if (isEmpty()){
                throw new MyStackException("Stack is empty");
          }
          System.out.println("POP"+top);
          E e = storage[top];
          top--;
          return e;
    }

    public static void main(String[] args) throws Exception{
    	MyStack<Integer> ms = new MyStack<Integer>(5);
    	for(int i= 0 ; i< 5 ;i++){
    		System.out.println(ms.push(i));
    	}

    	for(int i= 0 ; i< 5 ;i++){
    		System.out.println(ms.pop());
    	}
    }
}


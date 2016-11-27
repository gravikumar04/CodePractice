package linkedlist;

public class LinkedStack {
	Node top=null;
	int count =0;

	// insert first
	public void push(int data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(null);
		if(top==null){
			top=newNode;
		}else{
			newNode.setNext(top);
			top=newNode;
		}
		count++;
	}

	// delete first
	public int pop(){
		if(isEmpty()){
			System.out.println("Empty stack exception");
		}
		Node tmp = top;
		top=tmp.getNext();
		count--;
		return tmp.getData();
	}

	public boolean isEmpty(){
		return top==null;
	}

	void display(){
		Node tmp=top;
		while(tmp!=null){
			System.out.println(tmp.getData());
			tmp=tmp.getNext();
		}

	}

	public static void main(String a[]) {
		LinkedStack sl = new LinkedStack();
		sl.push(1);
		sl.push(2);
		sl.push(3);
		sl.display();
		sl.pop();
		sl.pop();
		sl.display();
		sl.pop();
	}

}

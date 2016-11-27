package linkedlist;

public class ReverseLinkedList {

	private Node head =null;
	private Node tail = null;
	// 1--> 2--> 3--> 4

	public Node reverse(Node head){
		Node prev = null;
		Node curr = null;
		Node next = head;
		while(next!=null){
			curr = next;
			next = next.getNext();
			curr.setNext(prev);
			prev=curr;
		}
		head=curr;
		return head;
	}

	// prints nodes
	public void print(Node head){
		while(head!=null){
			System.out.println(head.getData());
			head=head.getNext();
		}
	}

	public Node getHead(){
		return head;
	}

	public Node getTail(){
		return tail;
	}

	// this adds after first element
	public void add(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		if(head==null){
			head = newNode;
			tail=head;
		}else{
			tail.setNext(newNode);
			tail=newNode;
		}
	}

	public static void main(String a[]) {

		ReverseLinkedList sl = new ReverseLinkedList();
		sl.add(1);
		sl.add(2);
		sl.add(3);
		sl.add(4);
		sl.print(sl.getHead());
		System.out.println("==");
		Node n = sl.reverse(sl.getHead());
		sl.print(n);
	}
}
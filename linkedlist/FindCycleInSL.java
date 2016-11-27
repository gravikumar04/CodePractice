package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindCycleInSL {

	Node head =null;
	Node tail = null;

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

	public boolean hasLoop( Node first ) {
	    if ( first == null ) return false;
	    Node turtle = first;
	    Node hare = first;
	    while ( hare.getNext() != null && hare.getNext().getNext() != null ) {
	         turtle = turtle.getNext();
	         hare = hare.getNext().getNext();
	         if ( turtle == hare ) return true;
	    }
	    return false;
	}

	public Node removeLoop(Node root) {
		Set<Node> set = new HashSet<Node>();
		Node temp = root;
		set.add(temp);
		while (temp.getNext() != null) {
			if (!set.contains(temp.getNext()))
				set.add(temp.getNext());
			else // we have found the loop
			{
				temp.setNext(null);
				break;
			}
			temp = temp.getNext();
		}
		return temp;
	}

	public void print(Node head) {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}



	public static void main(String a[]) {

		FindCycleInSL sl = new FindCycleInSL();

		sl.add(1);
		sl.add(2);
		sl.add(3);
		sl.add(4);

		Node start = sl.getHead();
		Node tail = sl.getTail();
		tail.setNext(start);
		System.out.println(sl.hasLoop(start));
		Node x = sl.removeLoop(start);
		System.out.println("removed loop element : "+x.getData());
		sl.print(start);

	}

}

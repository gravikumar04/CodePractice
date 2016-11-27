package linkedlist;

class Node {

    private int data;
    private Node ref;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return ref;
    }
    public void setNext(Node ref) {
        this.ref = ref;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
}

package OldTests;


public class Node {
	private PointForTest1 data;
	private Node next;
	
	public Node() {
		this.data=null;
		this.next=null;
	}
	
	public Node(PointForTest1 p1) {
		this.data=p1;
		this.next=null;
	}

	public Node(PointForTest1 d, Node n) {
		this.data=d;
		this.next=n;
	}
	
	public PointForTest1 getData() {
		return data;
	}

	public void setData(PointForTest1 data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return ""+this.data.toString();
	}
}

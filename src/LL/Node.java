package LL;

public class Node {
	private int data;
	private Node next;
	
	public Node(int d) {
		this.data=d;
		this.next=null;
	}
	
	public Node(int d, Node n) {
		this.data=d;
		this.next=n;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return ""+this.data;
	}
	
}

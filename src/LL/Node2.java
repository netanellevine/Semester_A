package LL;

public class Node2 {
	private int data;
	private Node2 next;
	
	public Node2(int d) {
		this.data=d;
		this.next=null;
	}
	
	public Node2(int d, Node2 n) {
		this.data=d;
		this.next=n;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node2 getNext() {
		return this.next;
	}

	public void setNext(Node2 next) {
		this.next = next;
	}
	
	public String toString() {
		return ""+this.data;
	}
	
}

package HomeWork;

public class LLNode {
	private int data;
	private LLNode next;

	public LLNode(int d, LLNode n) {
		this.data = d;
		this.next = n;
	}

	public LLNode(int d) {
		this.data = d;
		this.next=null;
	}

	public LLNode getNext() {
		return this.next;
	}

	public void setNext(LLNode other) {
		this.next = other;
	}

	public int getData() {
		return this.data;
	}

	public String toString() {
		return "" + this.data;
	}
}

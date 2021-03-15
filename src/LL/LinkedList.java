package LL;

public class LinkedList {
	private Node2 head;

	public LinkedList() {
		this.head = null;
	}

	public void addLast(int data) {
		if (this.head == null) {
			this.head = new Node2(data);
		} else {
			Node2 pointer = this.head;
			while (pointer.getNext() != null) {
				pointer = pointer.getNext();
			}
			pointer.setNext(new Node2(data));
		}
	}

	public void addFirst(int data) {
		Node2 n = new Node2(data);
		if (this.head == null) {
			this.head = n;
		} else {
			n.setNext(this.head);
			this.head = n;
		}
	}

	public void addAt(int data, int ind) {
		boolean flag = false;
		int count = 0;
		Node2 temp = this.head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
			count++;
			if (count == ind - 1) {
				Node2 curr = new Node2(data);
				curr.setNext(temp.getNext());
				temp.setNext(curr);
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.err.println("the Index: " + ind + ", does not exist in the list");
		}
	}

	public void addFew(int... params) {
		for (int p : params) {
			this.addFirst(p);
		}
	}

	public void remove(int data) {
		boolean flag = false;
		if (this.head.getData() == data) {
			this.head = this.head.getNext();
		}
		Node2 temp = this.head;
		while (temp.getNext() != null) {
			if (temp.getNext().getData() == data) {
				temp.setNext(temp.getNext().getNext());
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if (!flag) {
			System.err.println("The data: " + data + ", does not exist in the list");
		}
	}

	public Node2 getHead() {
		return this.head;
	}

	public void setHead(Node2 head) {
		this.head = head;
	}

	public String toString() {
		String ans = "";
		Node2 temp = this.head;
		while (temp.getNext() != null) {
			ans += "" + temp.toString() + " --> ";
			temp = temp.getNext();
		}
		return ans + temp;
	}
	
	
	
	
	
	
}

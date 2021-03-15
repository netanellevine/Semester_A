package OldTests;

public class LinkedListPoint {
	private Node head;
	private int size;

	public LinkedListPoint() {
		this.head = null;
		this.size = 0;
	}

	public LinkedListPoint(Node next, PointForTest1 p) {
		this.head = new Node(p);
		this.head.setNext(next);
		size = 1;
	}

	public void add(PointForTest1 p) {
		double distP = PointForTest1.distFrom00(p);
		Node curr = new Node(p);
		if (this.head == null) {
			this.head = new Node(p);
		} 
		else if (distP < PointForTest1.distFrom00(this.head.getData())) {
			curr.setNext(this.head);
			this.head = curr;
		} 
		else {
			Node temp = this.head;
			while (temp.getNext() != null && (distP < PointForTest1.distFrom00(temp.getData()))) {
				temp = temp.getNext();
			}
			curr.setNext(temp.getNext());
			temp.setNext(curr);
		}
		size++;
	}

	public void remove(PointForTest1 p) {
		if (this.head.getData().equals(p)) {
			this.head = this.head.getNext();
			size--;
		} 
		else {
			Node pointer = this.head;
			while (pointer.getNext() != null) {
				if (pointer.getNext().getData().equals(p)) {
					if (pointer.getNext().getNext() != null) {
						pointer.setNext(pointer.getNext().getNext());
						size--;
					} 
					else {
						pointer.setNext(null);
						size--;
						break;
					}
				}
				pointer = pointer.getNext();
			}
		}
	}
	
	
	public boolean contains(PointForTest1 p) {
		if(p==null || this.size==0) {return false;}
		Node pointer=this.head;
		while(pointer!=null) {
			if(pointer.getData().equals(p)) {
				return true;
			}
			pointer=pointer.getNext();
		}
		return false;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		String s = "";
		Node t = head;
		while (t != null) {
			s += " " + t.toString();
			t = t.getNext();
		}
		return "LinkedListPoint [" + s + "]";
	}
}

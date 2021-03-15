package OldTests;

public class LinkedListDouble {
	private NodeD head, tail;
	int size;

	public LinkedListDouble() {
		head = tail = null;
		size = 0;
	}

	public NodeD getHead() {
		return head;
	}

	public NodeD getTail() {
		return tail;
	}

	public void setHead(NodeD h) {
		head = h;
	}

	public void setTail(NodeD t) {
		tail = t;
	}

	public void add(Object item) {
		if (head == null)
			head = tail = new NodeD(null, null, item);
		else {
			NodeD n = new NodeD(tail, null, item);
			tail.setNext(n);
			tail = n;
		}
		size++;
	}

	public String toString() {
		String s = "[";
		if (head != null) {
			s = s + head.toString() + ", ";
			for (NodeD n = head.getNext(); n != null; n = n.getNext()) {
				s = s + n.toString() + ", ";
			}
			s = s.substring(0, s.length() - 2);
		}
		return s + "]";
	}

	public boolean contains(Object item) {
		boolean ans = false;
		NodeD n = head;
		while (n != null && !n.getData().equals(item)) {
			n = n.getNext();
		}
		if (n != null)
			ans = true;
		return ans;
	}

	public int size() {
		return size;
	}

	public void reverse(LinkedListDouble l) {
		if (l.getHead() != null) {
			NodeD prev, next, cur, newTail;
			cur = newTail = l.getHead();
			prev = null;
			while (cur != null) {
				next = cur.getNext();
				cur.setNext(prev);
				prev = cur;
				cur = next;
			}
			l.setHead(prev);
			l.setTail(newTail);
		}
	}

	public NodeD Cycle(NodeD p) {
		NodeD slow = p;
		NodeD fast = p.getNext();
		while (slow != fast) {
			if (fast == null || fast.getNext() == null) {
				return null;
			}
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow.getNext();
	}
	
	
	
	public boolean removeK(int pos,int k) {
		if(pos>size-1 || k>size || pos<0 || k<0) {
			return false;
		}
		NodeD temp=this.head;
		int count=0;
		while(temp.getNext()!=null && size!=size-k) {
			temp=temp.getNext();
			count++;
			int sum=0;
			while(count==pos-1 && sum!=k) {
				temp.setNext(temp.getNext().getNext());
				sum++;
				size--;
			}
		}
		return true;
	}
	
	
	
}

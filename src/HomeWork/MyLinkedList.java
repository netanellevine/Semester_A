package HomeWork;

public class MyLinkedList {
	private LLNode head,tail;
	private int size = 0;;

	
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	
	public LLNode getHead() {
		return this.head;
	}


	public void setHead(LLNode head) {
		this.head = head;
	}


	public LLNode getTail() {
		return this.tail;
	}


	public void setTail(LLNode tail) {
		this.tail = tail;
	}


	public void clear() {
		this.head = this.tail = null;
		size = 0;
	}
	
	
	public void AddFirst(int data) {
		LLNode newNode = new LLNode(data);
		if (this.head == null) {
			this.head = newNode;
		} 
		else {
			LLNode current = this.head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		this.size++;
	}
	
	public void AddLast(int data) {
		LLNode tmp = new LLNode(data, null);
		if (size >= 1) {
			this.tail.setNext(tmp);
			this.tail = tmp;
		} else {
			this.head = tail = tmp;
		}
		this.size++;
	}
	
	public void AddFew(int... params) {
		for(int p:params) {
			this.AddFirst(p);
		}
	}
	public int getSize() {
		return this.size;
	}

	public int at(int i) {
		try {
			LLNode current = this.head;
			for (int j = 0; j < i; j++) {
				current = current.getNext();
				if (current == null) {
//				throw new ArrayIndexOutOfBoundsException();
					throw new NoSuchEntryException(j + 1);
				}
			}
			return current.getData();
		} 
		catch (NoSuchEntryException ex) {
			System.err.println("No entery number: " + ex.getEntry());
			ex.printStackTrace();
			return -1;
		}
	}

	public boolean contains(int data) {
		LLNode current = head;
		while(current != null) {
			if(current.getData()==data) {
				return true;
			}
				else {
					current=current.getNext();	
			}
		}
		return false;
	}
	
	
	
	public boolean swap(int i, int j) {
		if (i < 0 || i >= this.size || j < 0 || j >= this.size || i == j) {return false;}
		if (i > j) {
			int temp = i;
			i = j;
			j = temp;
		}
		// get the ith Node, and the Node before.
		LLNode prevI = null, currI = this.head;
		int c = 0;
		
		while (c != i) {
			prevI = currI;
			currI = currI.getNext();
			c++;
		}
		LLNode prevJ = null, currJ = this.head;
		c = 0;
		while (c != j) {
			prevJ = currJ;
			currJ = currJ.getNext();
			c++;
		}
		if (prevI != null) {
			prevI.setNext(currJ);
		} 
		else {
			this.head = currJ;
		}
		prevJ.setNext(currI);
		//swap between the next 
		LLNode tmp = currI.getNext();
		currI.setNext(currJ.getNext());
		currJ.setNext(tmp);
		if (j == this.size - 1) {
			this.tail = currI;
		}
		return true;	
	}
	

	
	
	
	
	
	
}

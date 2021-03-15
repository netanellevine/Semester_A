package LL;



public class LL_main {

	public static void main(String[] args) {
		LinkedList lst= new LinkedList();
		lst.addFirst(7);
		lst.addFirst(6);
		lst.addFirst(4);
		lst.addFirst(3);
		lst.addFirst(2);
		lst.addFirst(1);
		System.out.println(lst.toString());
		lst.addAt(5, 0);
		System.out.println(lst.toString());
		lst.remove(2);
		System.out.println(lst.toString());
		lst.addFew(1,2,3,4,6);
		System.out.println(lst.toString());
		lst.addLast(7);
		System.out.println(lst.toString());
	}

}

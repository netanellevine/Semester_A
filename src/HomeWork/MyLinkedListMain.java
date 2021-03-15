package HomeWork;

public class MyLinkedListMain {

	public static void main(String[] args) throws NoSuchEntryException {
		MyLinkedList ll = new MyLinkedList();
		ll.AddFirst(1);
		ll.AddFirst(5);
		ll.AddFirst(10);
		System.out.println(ll.at(1));
		System.out.println(ll.at(5));
		System.out.println(new ArithmeticException());

	}

}

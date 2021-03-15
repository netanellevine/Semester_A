package temp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

public class TestArrayList {

	public static void main(String[] args) {
		// Part 1		
		//ArrayList<String> dynArray = new ArrayList<String>();
		LinkedList<String> dynArray = new LinkedList<String>();
		dynArray.add("abc");
		dynArray.add("xyz");
		dynArray.add("I love Java");
		dynArray.add(0,"Wait! I am the first");
		System.out.println(dynArray);
		
		dynArray.remove("xyz");
		if(dynArray.contains("xyz"))
			System.out.println("Immposible!");
		else
			System.out.println("Sounds good. We now have " + dynArray.size() + " itmes.");
		int index = dynArray.indexOf("I love Java");
		System.out.println("And \"I love Java\" is in index: " + index);
		
		boolean wasChanged = dynArray.add("abc");
		if(wasChanged)
			System.out.println("This is not a set! Here is the array: " + dynArray);
		else
			System.out.println("Immposible!");
		wasChanged = dynArray.remove("nanana");
		if(wasChanged)
			System.out.println("Immposible!");
		String res = dynArray.remove(1);
		System.out.println("This is what I removed from index 1: " + res);
		
		if(dynArray.isEmpty())
			System.out.println("Immposible!");
		
		res = dynArray.set(2, "abcdefg");
		System.out.println("This is what I replaced in index 2: " + res);
		
		// first way to iterate over the elements
		// you can also change the values by calling set
		for(int i=0; i < dynArray.size() ;++i)
			System.out.print("{" + dynArray.get(i) + "} ");
		System.out.println();
		
		
		
		
		// Part 2 - second way to iterate over the elements
		Iterator<String> iter1 = dynArray.iterator();
		while(iter1.hasNext())
			System.out.print("[" + iter1.next() + "] "); 
		System.out.println();
		for(iter1 = dynArray.iterator(); iter1.hasNext() ;)
		{
			if(iter1.next().equals("I love Java"))
				iter1.remove();
		}
		
		
		
		
		// Part 3 - third way to iterate over the elements
		for(String str : dynArray)
			System.out.print("|" + str + "| ");
		System.out.println();
		

		
		// Part 4 - ListIterator
		System.out.print("In reverse order: ");
		ListIterator<String> iter2 = dynArray.listIterator(dynArray.size());
		while(iter2.hasPrevious())
			System.out.print("[" + iter2.previous() + "] "); 
		System.out.println();
		iter2 = dynArray.listIterator();
		iter2.next();
		iter2.add("I love C++");
		iter2.next();
		iter2.set("I also love Java");
		for(String str : dynArray)
			System.out.print("|" + str + "| ");
		System.out.println();
		iter2 = dynArray.listIterator();
		System.out.println("I am at index: " + iter2.nextIndex());
		iter2.next();
		iter2.next();
		System.out.println("I reached index: " + iter2.nextIndex());

		
		
		// Part 5
		ArrayList<Integer> arrayInt = new ArrayList<Integer>();
		int x = 12;
		arrayInt.add(x);
		arrayInt.add(2);
		arrayInt.add(4);
		arrayInt.set(1,13);
		System.out.println(arrayInt);
	}

}

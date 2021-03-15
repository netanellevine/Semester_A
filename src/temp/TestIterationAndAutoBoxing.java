package temp;

import java.util.*;

public class TestIterationAndAutoBoxing {
	public static void main(String []args){
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// populates list with initial values
        for(int i=0; i < 8 ;++i)
        	numbers.add(i);
		
        System.out.println(numbers.toString());
		
        // index based
        for (int index=0; index < numbers.size(); index++) {
            numbers.set(index, numbers.get(index)*2); 
        }
        System.out.println(numbers);

        // for-each
        for (Integer number : numbers) {
            number++; // number = new Integer(number+1);
        }
        System.out.println(numbers);

        // Iterator
        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            number++;
        }
        System.out.println(numbers);

        // ListIterator
        for (ListIterator<Integer> iter = numbers.listIterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            iter.add(number+1);
        }
        System.out.println(numbers);

        // Iterator remove
        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            if (number % 2 == 0)    // if number is even 
                iter.remove();      // remove it from the collection
        }
        System.out.println(numbers);

        // ListIterator set
        for (ListIterator<Integer> iter = numbers.listIterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            iter.set(number/2);     // divide each element by 2
        }
        System.out.println(numbers);
        
        numbers.remove(3);
        numbers.remove(3);
        System.out.println(numbers);
        numbers.remove((Integer)6);
        System.out.println(numbers);
     }
}

package OldTests;
import HomeWork.LLNode;
import HomeWork.MyLinkedList;

public class SaedQuestionsForTest {

	public static void main(String[] args) {
		System.out.println(moveMost("helloiamhappyhihihi"));
		int[] arr={1,2,3,4};
		printAllSubSets(arr);
		String str="abcdcb";
		System.out.println(single2(str));
		
		LinkedListDouble sll = new LinkedListDouble();
        sll.add("a");
        sll.add("b");
        sll.add("c");
        sll.add("d");
        sll.add("e");
        sll.add("f");
        System.out.println("Before: "+sll);
        System.out.println(sll.removeK(2, 3));
        System.out.println("After: "+sll);
	
	}

	/*
	 * input: String of letters, output: String of the 
	 * letters that are found max one time in the string
	 * and the order does not change
	 */
	public static String single(String s) {
		String res="";
		for(int i = 0 ;i<s.length();i++) {
			int c =0 ;
			for(int j = 0 ;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					c++;
				}
				if(c==1) {
					res+=s.charAt(i);
				}
			}
		}
		return res;
	}
	
	public static String single2(String s) {
		String res="";
		for(int i = 0 ;i<s.length();i++) {
			String temp=""+s.charAt(i);
			int countChar = s.length() - s.replaceAll(temp, "").length();
			if(countChar==1) {
				res+=""+temp;
			}
		}
		return res;
	}
	// move the most frequent char to the end of the string
	public static String moveMost(String str) {
		char mostFreq = getMostFreq(str);
		String prefix = "", suffix = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == mostFreq) {
				suffix += str.charAt(i);
			} else {
				prefix += str.charAt(i);
			}
		}
		return (prefix + suffix);
	}

	private static char getMostFreq(String str) {
		int max = 0, maxIndex = -1;
		for (int i = 0; i < str.length(); i++) {
			if (maxIndex != -1 && str.charAt(i) == str.charAt(maxIndex)) {
				continue;
			} else {
				int count = 1;
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(j) == str.charAt(i)) {
						count++;
					}
				}
				if (count >= max) { // if we want to move the last char that has most freq, we add =
					max = count;
					maxIndex = i;
				}
			}
		}
		return str.charAt(maxIndex);
	}

	// reverse the LinkedList in a regular way
	public static void IterReverse(MyLinkedList lst) {
		if (lst.getHead() != null) {
			LLNode prev, curr, next, newTail;
			prev = null;
			newTail = curr = lst.getHead();
			while (curr != null) {
				next = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = next;
			}
			lst.setHead(prev);
			lst.setTail(newTail);
		}
	}

	// reverse the LinkedList in a recursive way
	public static void recReverse(MyLinkedList lst) {
		if (lst.getHead() != null) {
			LLNode newTail = lst.getHead();
			LLNode newHead = recReverse(null, lst.getHead(), lst.getHead().getNext());
			lst.setHead(newHead);
			lst.setTail(newTail);
		}
	}

	public static LLNode recReverse(LLNode prev, LLNode current, LLNode next) {
		if (current == null) {
			return prev;
		}
		current.setNext(prev);
		if (next != null) {
			return recReverse(current, next, next.getNext());
		} else {
			return recReverse(current, next, null);
		}
	}

	// print all the optinal subsets of the array
	public static void printAllSubSets(int[] arr) {
		boolean[] currentSet = new boolean[arr.length];
		printAllSubSets(arr, currentSet, 0);

	}

	public static void printAllSubSets(int[] arr, boolean[] currentSet, int i) {
		if (i == arr.length) {
			printTrues(arr, currentSet);
		} 
		else {
			currentSet[i] = false;
			printAllSubSets(arr, currentSet, i + 1);
			currentSet[i] = true;
			printAllSubSets(arr, currentSet, i + 1);
		}
	}

	public static void printTrues(int[] arr, boolean[] currentSet) {
		System.out.print("[");
		for (int i = 0; i < currentSet.length; i++) {
			if (currentSet[i]==true) {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println("]");
	}
	
	
	
	
	
	
	
	
}

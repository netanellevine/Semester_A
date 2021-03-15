package Lectures;



public class Lecture_2 {

	public static void main(String[] args) {
		
		String s = "Hello";
		String t = "World";
		System.out.println(s.compareTo(t));
		
//		int n=1000000000;
//		int[] test = new int[n];
//		test[0] = 0;
//		for(int i=1; i<test.length; i++)
//			test[i] = test[i-1] + (int)(2 * Math.random());
//		int[] test = {1,2,6,9,12,14,17,20};
//		
//		long start_time = System.currentTimeMillis();
//		System.out.println(binary_search(test,-1));
//		long end_time = System.currentTimeMillis();
//		
//		System.out.println("binary search: " + (end_time - start_time));
	}
	
	
	// Assume array a is increasing
	// O(log n)
	public static int binary_search(String[] a, String q) {
		int start = 0, end = a.length - 1;
		while (start != end) {
			int middle = (start + end) / 2;
			if (q.compareTo(a[middle]) > 0) {
				start = middle + 1;
			} else {
				end = middle;
			}
		}
		if (q.equals(a[start])) return start;
		else return -1;
	}

	
	
	// Assume array a is increasing
	// O(log n)
	public static int binary_search0(int[] a, int q) {
		int start = 0, end = a.length - 1;
		while (start != end) {
			int middle = (start + end) / 2;
			if (q > a[middle]) {
				start = middle + 1;
			} else {
				end = middle;
			}
		}
		if (q == a[start]) return start;
		else return -1;
	}
	
	
	// Assume array a is increasing
	// O(log n)
	public static boolean binary_search(int[] a, int q) {
		int start = 0, end = a.length - 1;
		while (start != end) {
			int middle = (start + end) / 2;
			if (q > a[middle]) {
				start = middle + 1;
			} else {
				end = middle;
			}
		}
		return q == a[start];
	}

	// The most efficient
	// Assume array a is increasing
	// O(log n)
	public static boolean binary_search2(int[] a, int q) {
		int start = 0, end = a.length - 1;
		while (start != end) {
			int middle = (start + end) / 2;
			if (q == a[middle]) {return true;} 
			else if (q > a[middle]) {
				start = middle + 1;
			} 
			else {
				end = middle;
			}
		}
		return q == a[start];
	}

	
	// Assume array a is increasing
	// O(log n)
	public static boolean binary_search3(int[] a, int q) {
		int start = 0, end = a.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (q == a[middle]) {return true;} 
			else if (q > a[middle]) {
				start = middle + 1;
			} 
			else {
				end = middle - 1;
			}
		}
		return false;
	}
	
	
	// Assume array a is increasing
	// O(log n)
	public static boolean binary_search_recursive(int[] a, int q) {
		return binary_search_recursive(a, q, 0, a.length -1);
	}
	
	
	// Assume array a is increasing
	// O(log n)
	public static boolean binary_search_recursive(int[] a, int q, int start, int end) {
		if(start == end)
		return q == a[start];
		int middle = (start + end)/2;
		if(q>a[middle])
			return binary_search_recursive(a, q, middle + 1, end);
		else 
			return binary_search_recursive(a, q, start, middle);
	}
	
	
	// O(n)
	public static boolean search(int[] a, int q) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == q) {return true;}
		}
			return false;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


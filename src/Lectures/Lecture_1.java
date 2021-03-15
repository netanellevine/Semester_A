package Lectures;

public class Lecture_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fibonacci1(5));
		System.out.println(fibonacci2(10));
		
//		Hanoi(4);
		
		/*
		int n=100;
		int[] test = new int[n];
		for(int i=0; i<test.length; i++)
			test[i] = (int)(n * Math.random());

		long start_time = System.currentTimeMillis();
		minElement(test);
		long end_time = System.currentTimeMillis();

		System.out.println("minElement: " + (end_time - start_time));

		start_time = System.currentTimeMillis();
		minElement2(test);
		end_time = System.currentTimeMillis();

		System.out.println("minElement2: " + (end_time - start_time));
		 */
	}

	// O(1)
	public static int firstElement(int[] a) {
		System.out.println("Hi there!");
		return a[0];
	}

	// O(n)
	public static int minElement(int[] a) {
		int min = a[0]; // 2 operations
		for(int i=1; i<a.length; i++) // 1 + 5n operations
			if(a[i]<min) min = a[i];
		return min; // 1 operation
	}

	// O(n^2)
	public static int minElement2(int[] a) {
		for(int i=0; i<a.length; i++) {
			boolean smallest = true;
			for(int j=0; j<a.length; j++)
				if(a[j] < a[i]) smallest = false;
			if(smallest) return a[i];
		}
		return -1;
	}

	// O(1)
	public static void print1(int n) {
		System.out.println("Hi!");
	}

	// O(n)
	public static void print2(int n) {
		for(int i=0; i<n; i++)
			System.out.println("Hi!");
	}

	// O(n^2)
	public static void print3(int n) {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				System.out.println("Hi!");
	}
	
	// O(n^3)
	public static void print4(int n) {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++)
					System.out.println("Hi!");
	}
	
	// O(log n)
	public static void print5(int n) {
		for(int i=1; i<=n; i=2*i)
			System.out.println("Hi!");			
	}
	
	// O(n^2)
	// (n-1) + (n-2) + (n-3) + (n-4) + ... = sigma(n-1)
	public static boolean repeat(int[] a) {
		for(int i=0; i<a.length; i++)
			for(int j=i+1; j<a.length; j++)
				if(a[i] == a[j])
					return true;
		return false;
	}
	
	// O(n)
	public static int sigma(int n) {
		if(n==0) 
			return 0;
		else 
			return n + sigma(n-1);
	}
	
	// O(n)
	public static int factorial(int n) {
		if(n==1)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	// O(n)
	public static int fibonacci1(int n) {
		int[] a = new int[n+1];
		a[0] = 0;
		a[1] = 1;
		for(int i=2; i<a.length; i++)
			a[i] = a[i-1] + a[i-2];
		return a[n];
	}
	
	// 2^O(n)
	public static int fibonacci2(int n) {
		if(n==0 || n==1)
			return n;
		else
			return fibonacci2(n-1) + fibonacci2(n-2);
	}
	
	public static void Hanoi(int n) {
		Hanoi(n, 'A', 'C', 'B');
	}
	
	public static void Hanoi(int n, char origin, char dest, char other) {
		if(n==1)
			System.out.println("move one disk from " + origin + " to " + dest);
		else {
			Hanoi(n-1, origin, other, dest);
			System.out.println("move one disk from " + origin + " to " + dest);
			Hanoi(n-1, other, dest, origin);
		}
	}
}

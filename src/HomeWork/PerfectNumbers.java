package HomeWork;

import java.util.Scanner;

public class PerfectNumbers {

	public static void main(String[] args) {
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a number");		
//		int num = sc.nextInt();
//		sc.close();
		int sum = 0 ;
		for (int num = 1 ; num < Integer.MAX_VALUE ; num ++) {
		sum = sumOfNum (num) ;
		if (sum==(2*num)) {
			System.out.println("The number " + num + " is a perfect number!");
		}
//		else {
//			System.out.println("The number " + num + " is not a perfect number!");
//		}
		}
	}
	public static int sumOfNum (int num) {
		int n , sum = 0 ;
		n = num ; 
		for ( ; num > 0 ; num--) {
			if ((n % num) == 0) {
				sum = sum + num ;
			}
		}
		return sum ;

	}
}



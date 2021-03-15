package HomeWork;
import java.util.Scanner;
public class MaxDigit {
	// this program receive a number and prints the Max digit of this num.


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		int max = maxDigit(num);
		sc.close();
		System.out.println("the Max digit of this num is: " + max);

	}



	public static int maxDigit (int num) {		
		int max = 0 ;
		int i ;
		int jNum = num ;
		for ( i = 0; i < num; i++ , num/=10) {			
		}
		int arr [] = new int [i];
		for (int j = 0; j < arr.length; j++) {
			arr [j] = jNum%10;
			jNum/=10;
			if (max < arr[j]) {
				max = arr[j];
			}
		}
		return max;
	}


		}










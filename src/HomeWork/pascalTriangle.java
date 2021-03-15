package HomeWork;

import java.util.Scanner;

public class pascalTriangle {

	public static int factorialNum (int a) {
		int factorial = 1 ;
		for (; a>1 ; a--) {
			factorial *= a;
		}
		return factorial;
	}

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int factorialN = 1 ;
		int factorialK = 1 ;
		int factorialNK = 1 ;
		int nk , p , M , N , K , n , k ;
		System.out.println("Enter a number");
		M = sc.nextInt();
		sc.close();
		System.out.println();

		for ( N = 0 ; N <= M ; N++) {

			for ( K = 0 ; K <= N ; K++) {
				nk = (N - K);
				factorialNK = factorialNum (nk) ;
				factorialN = factorialNum (N) ;
				factorialK = factorialNum (K) ;
				//				for (nk = (N - K); nk > 1 ; nk--) {
				//					factorialNK = factorialNK * nk ;
				//				}
				//				for (k = K ; k > 1 ; k--) {
				//					factorialK = factorialK * k ;
				//				}
				//				for (n = N ; n > 1 ; n--) {
				//					factorialN = factorialN * n ;
				//				}

				p =  factorialN / (factorialK * factorialNK) ;	
				System.out.print("  " + p + "  ");			
			}
			System.out.println();
		}
	}
}




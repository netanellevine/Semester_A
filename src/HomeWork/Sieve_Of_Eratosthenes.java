package HomeWork;

import java.util.Arrays;

public class Sieve_Of_Eratosthenes {

	public static void main(String[] args) {
		boolean[] Eratosthenes = new boolean[1000];
		SieveOfEratosthenes(Eratosthenes);
		int[] allPrimeNumbers= allPrime(Eratosthenes);
		System.out.println("There is "+allPrimeNumbers.length+ " Prime Numbers between 0 and "+Eratosthenes.length);
		System.out.println(Arrays.toString(allPrimeNumbers));
	}



	/* This function calculates all the prime number in the range of a N number
	*  using the Sieve Of Eratosthenes algorithm */
	public static void SieveOfEratosthenes (boolean[] a){
		int k=0;
		for (int z=2; z < a.length ; z++ ) {
			a[z]= true;
		}
		for (int i = 2; i < Math.sqrt(a.length); i++) {
			if (a[i]) { k=2*i; }
			while (k<a.length) {
				a[k]=false;
				k+=i;
			}
		}

	}




	public static int[] allPrime (boolean[] a) {
		int sumOfTrue=0;
		int[] arr= new int [a.length];
		for (int i = 2 ,  k = 0; i < a.length; i++) {
			if(a[i]) {
				sumOfTrue++;
				arr[k]=i;
				k++;
			}
		}
		int[] allPrimeNumbers = new int [sumOfTrue];
		for (int i = 0; i < allPrimeNumbers.length; i++) {
			allPrimeNumbers[i]=arr[i];
		}
		return allPrimeNumbers;
	}
}

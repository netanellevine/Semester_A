package Ex1;



import java.util.Scanner;

	/*
	 * This class checks the GPCD of two natural numbers
	 * using  Euclid's algorithm.
	*/


public class Ex1 {
	
	/* This method checks whether an integer given 
	 * is a Prime number.
	 * @in - natural numbers.
	 * @out - true if the number is prime.
	 */
	private static boolean isPrime(int num) {
		boolean prime=true;
		int i=2;
		while (num >=(i*i)) {    			   
			if ((num%i)!=0) {
				i++;
			}
			else {
				prime=false;
				break;
			}
		}
		return prime;
	} 


	public static void main(String[] args) {
		int num1,num2,a,b,newNum;	
		if(args.length > 0 ) {
			num1 = Integer.parseInt(args[0]);
			num2 = Integer.parseInt(args[1]);			
		}
		else { 
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the first number for max prime GCD: ");
			num1 = sc.nextInt();
			System.out.println("Enter the second number for max prime GCD: ");
			num2 = sc.nextInt();
			System.out.println("Computes the GPCD("+num1+","+num2+") =");
			sc.close();
		}
		a=num1;
		b=num2;
		while (a>0 && b>0) {
			if (a>b) {
				a=a%b;
			}
			else {
				b=b%a;				
			}			
		}
		if (a==0){ 
			newNum = b;
		}
		else {
			newNum = a;
		}         
		while (newNum > 1) {
			if ((num1 % newNum == 0) && (num2 % newNum == 0)) {	
				if (isPrime (newNum))  {
					System.out.println("Max Prime Common Divider: "+newNum);
					break; 
				}
			} 
			newNum--; 
		}
		if (newNum==1) {
			System.out.println("Max Prime Common Divider: "+newNum); 
		}
	}

}

package HomeWork;

import java.util.Scanner;

public class QuadraticEquation {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the first number");
		int a = sc.nextInt();
		System.out.println("Enter the second number");		
		int b = sc.nextInt();
		System.out.println("Enter the third number");
		int c = sc.nextInt();
		sc.close();
		System.out.print(a+"x^2");
		System.out.print(b>0 ? "+"+ b +"x": b +"x");
		System.out.println(c>0 ? "+"+c+"=0" : c+"=0");
		double x1, x2;		
		int discriminant = discriminant ( a, b, c) ; 
		if (discriminant >0) {
			x1 = (-b + Math.sqrt(discriminant))/(2*a);
			x2 = (-b - Math.sqrt(discriminant))/(2*a);
			System.out.println("x1= "+x1);
			System.out.println("x2= "+x2);
		}
		else if (discriminant == 0){
			x1= (-b)/(2*a);
			System.out.println("x1= "+x1);
		}
		else   {
			System.out.println("This equation has no values , the discriminant must be positive.");
		}
	}
	public static int discriminant (int a, int b, int c) {
		int discriminant;
		discriminant = (b*b) - (4*(a*c));
		return (discriminant);	 
	}
}



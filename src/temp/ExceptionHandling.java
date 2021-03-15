
package temp;import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		divideNumbersFromUser();
	}
	
	public static int divide(int num1, int num2) throws ArithmeticException {
		return num1/num2;
	}
	
	public static int inputAndDivideNumbers() throws ArithmeticException, InputMismatchException {
			Scanner s = new Scanner(System.in);
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			return divide(num1,num2);
	}
	
	public static void divideNumbersFromUser() {
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Please enter two numbers:");
			try {
				int res = inputAndDivideNumbers();
				System.out.println("The result is: " + res);
				isValid = true;
			}
			catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Input must be two numbers!");
			}
		}
	}

}

package temp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestExceptions {
	public static void main(String[] args)   {
		boolean isValid = false;
		while(!isValid) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter two numbers:");
			try {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();

				int res = n1 / n2;
				System.out.println("The result is: " + res);
				isValid = true;
			}
			catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Input must be two numbers!");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}

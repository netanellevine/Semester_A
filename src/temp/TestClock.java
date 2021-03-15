package temp;
public class TestClock {
	public static void main(String[] args) {
		// tests for the class Clock
		Clock c1 = new Clock();
		Clock c2 = new Clock(12,30);
		
		boolean res;
		do
		{
			int h = MyConsole.readInt("Enter hours: ");
			res = c1.setHours(h);
		} while (res != true);
		
		do
		{
			int m = MyConsole.readInt("Enter minutes: ");
			res = c1.setMinutes(m);
		} while (res != true);

		System.out.println("c1 time is: " + c1);
		String both = "both times: 1- " + c1 + ", 2- " + c2;
		System.out.println(both);
		c1.tickAndPrint();
	}
}

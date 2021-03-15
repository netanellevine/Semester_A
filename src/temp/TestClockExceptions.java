package temp;
public class TestClockExceptions {
	public static void main(String[] args) {
		Clock c = null;
		boolean isValid = false;

		try {
			c = new Clock(20,20);
			c.setHours(200);
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c);
		
		
		while(!isValid) {
			try {
				int h = MyConsole.readInt("Enter hours: ");
				int m = MyConsole.readInt("Enter minutes: ");
				c = new Clock(h,m);
				System.out.println("The time is: " +c);
				isValid = true;
			}
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

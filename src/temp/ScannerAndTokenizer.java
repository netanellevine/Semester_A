package temp;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerAndTokenizer {

	public static void main(String[] args) {
		// tests for StringTokenizer - Part 1
		System.out.println("Part 1");
		String str = "This is String , split by StringTokenizer/Scanner,,created by student";
		StringTokenizer st = new StringTokenizer(str);
		
		System.out.println("---- Split by space");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		System.out.println("---- Split by comma ',' ");
		StringTokenizer st2 = new StringTokenizer(str,",");	
		while(st2.hasMoreTokens())
			System.out.println(st2.nextToken());
		
		System.out.println("---- Split by comma ',' OR space");
		StringTokenizer st3 = new StringTokenizer(str,", ");	
		while(st3.hasMoreTokens())
			System.out.println(st3.nextToken());
		
		
		
		
		// tests for Scanner - Part 2
		MyConsole.readString("Press the enter key to continue ------ Part 2, test for scanner on a string");
		Scanner sc1 = new Scanner(str);
		System.out.println("---- Split by space ");
		while(sc1.hasNext())
			System.out.println(sc1.next());
		sc1.close();
		
		System.out.println("---- Split by comma ',' ");
		sc1 = new Scanner(str);
		sc1.useDelimiter(",");
		while(sc1.hasNext())
			System.out.println(sc1.next());
		sc1.close();
		
		System.out.println("---- Split by comma ',' AND space");
		sc1 = new Scanner(str);
		sc1.useDelimiter(", ");
		while(sc1.hasNext())
			System.out.println(sc1.next());
		sc1.close();
		
		
		
		
		
		
		// Part 3
		MyConsole.readString("Press the enter key to continue ------ Part 3, test for scanner on an input stream");
		sc1 = new Scanner(System.in);
		System.out.println("Please enter the first integer");
		int i1 = sc1.nextInt();
		System.out.println("Please enter the second integer");
		int i2 = sc1.nextInt();
		System.out.println("You entered: " + i1 + ", " + i2);
		
		// now examine the use of a buffer
		System.out.println("Please enter the first double");
		double d1 = sc1.nextDouble();
		System.out.println("Please enter the second double");
		double d2 = sc1.nextDouble();
		System.out.println("You entered: " + d1 + ", " + d2);
		
		// we can read different data types
		System.out.println("Please enter byte,  short, long, float, boollean and char");
		byte by = sc1.nextByte();
		short s = sc1.nextShort();
		long l = sc1.nextLong();
		float f = sc1.nextFloat();
		boolean bo = sc1.nextBoolean();
		char c = sc1.next().charAt(0);
		System.out.printf("You entered: %d, %d, %d, %f, %b, %c \n", by, s, l, f, bo, c);
		
		// we can read strings with white spaces
		System.out.println("Please enter a string");
		Scanner sc2 = new Scanner(System.in);
		str = sc2.nextLine();
		System.out.println("You enterd " + str);
		
		// why did we use a new scanner?
		System.out.println("Please enter an int");
		i1 = sc2.nextInt();
		System.out.println("You enterd " + i1);
		System.out.println("Please enter a string");
		str = sc2.nextLine();
		System.out.println("You enterd " + str);
		System.out.println("V2: Please enter an int");
		i1 = sc2.nextInt();
		System.out.println("V2: You enterd " + i1);
		System.out.println("V2: Please enter a string");
		sc2.nextLine();
		str = sc2.nextLine();
		System.out.println("V2: You enterd " + str);
		
		
		
		
		
		
		
		
		
		
		// Part 4 - we can use the hasNext patter also with streams
		MyConsole.readString("Press the enter key to continue ------ Part 4");
		System.out.println("Please enetr integers. Anything else to quit");
        int sum = 0, count = 0;
 
        // Check if an int value is available
        while (sc2.hasNextInt())
        {
            // Read an int value
            int num = sc2.nextInt();
            sum += num;
            count++;
        }
        int avg = sum / count;
        System.out.println("Average: " + avg);
         
        sc1.close();
        sc2.close();
	}

}

package temp;
import java.util.Arrays;

public class CompareStringsAndArrays {

	public static boolean compareIntArrays(int[] a, int[] b)
	{
		if(a.length != b.length)
			return false;
		for(int i=0; i < a.length ;++i)
			if(a[i] != b[i])
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		// == between arrays
		int[] a = {1, 2, 3};
	    int[] b = {1, 2, 3};
	    int[] c = b;
	    System.out.println("a == b? :" + (a == b));
		System.out.println("a == c? :" + (a == c));
		System.out.println("b == c? :" + (b == c));
		
		System.out.println("a == b (with my function)? :" + compareIntArrays(a,b));
		System.out.println("a == b (with build-in function)? :" + Arrays.equals(a, b));
		
		// we can also use this library for copying arrays
		int[] d = Arrays.copyOf(a,a.length);
		System.out.println("a == d (with build-in function)? :" + Arrays.equals(a, d));
		
				
		// == between strings
		String s1 = "abcd";
		String s2 = "abcd";
		String s3 = "ab";
		String s4 = "cd";
		String s5 = s3+s4;
		String s6 = "ab" + "cd";
		String s7 = new String("abcd");
		
		System.out.println("s1==s5? " + (s1 == s5)); // why?
		System.out.println("s1==s2? " + (s1 == s2)); // why?
		System.out.println("s1==s6? " + (s1 == s6)); // why?
		System.out.println("s1==s7? " + (s1 == s7)); // why?
		System.out.println("s1==s5 (with equal)? " + s1.equals(s5));
		
		String s8 = "ABCD";
		System.out.println("s1.equals(s8)? "+ s1.equals(s8));
		System.out.println("s1.equalsIgnoreCase(s8)? "+ s1.equalsIgnoreCase(s8));

	}

}

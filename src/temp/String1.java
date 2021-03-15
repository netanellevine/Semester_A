package temp;
public class String1 {
	
	public static void f(String s){
		s = "xyz";
		System.out.println("in f(s) s is: "+s);
	}
	
	public static void main(String[] args) {
		
		// length, concatenation
		String s = "abcd";
		String w = "ghi";
		System.out.println("s="+s+" , the length of s is "+s.length());
		s = s + "ef";
		s = s.concat(w);  // s.concat(w) will not work!!
		System.out.println("s="+s+" , the length of s is "+s.length());
		
		// substring		
		String t = s.substring(2,5);
		System.out.println(t);
		t = s.substring(2);
		System.out.println(t);
		
		// char at	
		char c = s.charAt(1);
		System.out.println("the second char in s is: "+c);
		
		// indexof
		s="Hello World";
		int i = s.indexOf('o');
		System.out.println("s.indexOf('o') = "+i);
		i = s.indexOf('o', i+1);
		System.out.println("s.indexOf('o',i+1) = "+i);
		
		// replace
		s = s.replace("l", "x"); // note that we assigned the result back into s. Why?
		System.out.println(s); 
		s = s.replaceFirst("x", "l");
		System.out.println(s);
		String str = MyConsole.readString("get str: ");
		String s1 = MyConsole.readString("get s1: ");
		String s2 = MyConsole.readString("get s2: ");
		str = str.replace(s1,s2); 
		System.out.println(str);
		
		// contains
		System.out.println(str.contains(s1));
		System.out.println(str.contains(s2));
		
		// compare two strings
		System.out.println("abcd".compareTo("ab"));   // the difference in lengths
		System.out.println("abcd".compareTo("xabc")); // the difference between 'x' and 'a'
		System.out.println("code of a: "+(int)'a' + ", code of x: "+(int)'x'); 
		System.out.println("xyz".compareTo("abcde"));
		System.out.println("xyz".compareTo("xyz"));
		System.out.println("With upper case, the difference is: " + "abc".compareTo("Abc"));
		System.out.println("Ignore upper case, the difference is: " + "aBc".compareToIgnoreCase("AbC"));
		
		// cases
		System.out.println("abcd".toUpperCase());
		System.out.println("abcd".toLowerCase());		
		
		// function
		System.out.println("Before f(s) s is: "+s);
		f(s);
		System.out.println("after f(s) s is: "+s); // Why?
		
		// operations		
		System.out.println("3+4 = "+(3+4)+" != "+3+4);
				
		// split
		t = "to be or not to be";
		String arr[] = t.split(" ");
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
		t = "to be or, not to be";
		arr = t.split(", ");
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
		t = "to be or not to be";
		arr = t.split("");
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
	}
}

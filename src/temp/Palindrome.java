package temp;
// This class checks whether a word is a palindrome (symmetric).
// Ex: acedggdeca

public class Palindrome {
    public static void main(String[] args) {
    	// get a word to test
    	String mystring = MyConsole.readString("Enter a word:");
    	// test if it's a palindrome
    	boolean isPal = isPalindrome(mystring);
    	// print
    	System.out.println("Is " + mystring + " a palindrome? " + isPal);
    }

    // This function takes a string and checks if it's a palindrome
    public static boolean isPalindrome(String s) {
    	// assume s is a palindrome
    	boolean answer = true;
    	// get length of s
    	int len = s.length();
    	// compare index 0 to index len-1
    	//         index 1 to index len-2
    	//         index 2 to index len-3, etc.
    	for (int i=0; i < len; i++)
    	{
    		char first = s.charAt(i);
    		char second = s.charAt(len-1-i);
    		// if they are not equal, s is not a palindrome
    		if(first != second)
    			answer = false;
    	}
    	return answer;
    }
}
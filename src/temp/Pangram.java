package temp;
// This class checks whether a Sting is a pangram - contains each letter
// of the alphabet at least once.
// Ex: "the quick brown fox jumps over the lazy dog"

public class Pangram {
    public static void main(String[] args) {
    	// get a sentence to test
    	String mystring = MyConsole.readString("Enter a sentence:");
    	// test if it's a pangram
    	boolean isPan = isPangram(mystring);
    	// print
    	System.out.println("Is sentence a pangram? " + isPan);
    }

    // This function takes a string and checks if it's a pangram
    public static boolean isPangram(String s) {
    	s = s.toLowerCase();    	
    	// step through all 26 letters
    	for (char myc = 'a'; myc <= 'z' ;myc++)
    	{
    		// if the letter is not contained in s, s is not a pangram
    		if(s.contains("" + myc) == false)
    			return false;
    	}
    	return true;
    }
}
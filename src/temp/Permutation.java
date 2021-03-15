package temp;
// This class checks whether one sentence is a permutation (reordering) of another
// Ex: "Hello World" and "rdlllo HoWe"

public class Permutation {
    public static void main(String[] args) {
    	String s1 = MyConsole.readString("Enter first sentence:");
    	String s2 = MyConsole.readString("Enter second sentence:");
    	// test 
    	boolean isPerm = isPermutation(s1,s2);
    	// print
    	System.out.println("Is " + s2 + " a permutation of " + s1 + "? " + isPerm);
    }

    public static boolean isPermutation(String s, String t) {
     	
    	while( s.length() != 0 )
    	{
    		// get first letter of s
    		String f = s.substring(0,1);

    		// fine where f is found in t
    		int index = t.indexOf(f);

    		// if f isn't in t, t is not a permutation of s
    		if(index == -1)
    			return false;
    		else
    		{
    			// remove letter from both s and t
    			s = s.substring(1);
    			t = t.substring(0,index) + t.substring(index+1);
    		}
    	}
    	
    	if(t.length() != 0)
    		return false;
    	return true;
    }
}
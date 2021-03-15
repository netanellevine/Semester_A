package temp;
// This class checks whether a password is valid.

public class Password {

    public static void main(String[] args) {
    	// get a username 
    	String user = MyConsole.readString("Enter username:");
	
    	boolean valid;
    	String passw;

    	// This loop runs until a valid password is entered
    	do
    	{
    		// get a new password.
    		passw = MyConsole.readString("Enter new password:");
    		// check if the password is valid
    		valid = isValid(user, passw);
    		if (valid == false)
    			System.out.println(passw + " is not a valid password");
    	} while (valid == false);
	
    	// the while loop exits with a valid password
    	System.out.println("Password is valid");
    }

    // This function takes the username and password and checks if the password is valid
    // A valid password:
    // - is of length at least 8
    // - is not the same as the username
    // - is not 12345678
    // - does not contain a space " "
    // - contains at least two numbers
    // - contains at least one of ! * ( ) 

    public static boolean isValid(String username, String password) {
    	if ( (password.length() < 8) || (password.equals(username)) || password.equals("12345678") || password.contains(" "))
    		return false;

    	// if password contains none of ! * ( )
    	if ( (password.contains("!")==false) && (password.contains("*")==false) && 
    			(password.contains("(")==false) && (password.contains(")")==false) )
    		return false;
	

    	// now count how many different numbers are in the password
    	int counter = 0;
    	for (int i = 0; i <= 9; i++)
    	{
    		// change i from int into a String
    		if(password.contains("" + i))
    			counter++;
    	}

    	// if password doesn't have at least two numbers
    	if (counter < 2)
    		return false;

    	return true;
    }
}
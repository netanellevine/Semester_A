package temp;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
	
    	Scanner sc = new Scanner(System.in);

    	// get secret word from user
    	System.out.println("Enter secret word: ");
    	String word = sc.next();

    	// print_word is what will be printed out
    	char[] print_word = new char[word.length()];
    	for(int i=0; i<print_word.length; i++)
    		print_word[i] = '_';

    	// while the user has more guesses left, and hasn't yet guessed word
    	int guess = 0;
    	int letters_left = word.length();
    	while(guess < 10 && letters_left > 0)
    	{
    		// print out word
    		for(int i=0; i<print_word.length; i++)
    			System.out.print(print_word[i]);

    		// get letter guess
    		System.out.println("\n" + (10-guess) + " guesses left. Guess a letter: ");
    		char letter = sc.next().charAt(0);

    		// check if the letter is in the secret word
    		boolean good_guess = false;		
    		for(int i=0; i<word.length(); i++)
    		{
    			char myc = word.charAt(i);
    			// if letter is in the secret word and hasn't been guessed yet
    			if(letter == myc && letter != print_word[i])
    			{
    				// it's a good guess
    				good_guess = true;
    				letters_left--;
    				// the printed out word will now have the guessed letter in it
    				print_word[i] = myc;
    			}
    		}
		
    		if(good_guess == true)
    			System.out.println("Good guess! \n");
    		else
    		{
    			System.out.println("Wrong! \n");
    			guess++;
    		}
    	}

    	// after the while loop exits, check if user guessed all letters
    	if(letters_left == 0)
    	{
    		// print out word
    		for(int i=0; i<print_word.length; i++)
    			System.out.print(print_word[i]);
    		System.out.println("\n You win!");
    	}

    	// if user didn't guess all the letters
    	else
			System.out.println("You lose!");
    	sc.close();
    }
}

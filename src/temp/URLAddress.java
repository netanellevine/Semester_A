package temp;
import java.util.StringTokenizer; 
import java.util.Scanner;

public class URLAddress {
	public static void main(String[] args) {
	
		// gets from the user an Internet address, and return the main part
		// Ex: http://www.yahoo.com/news/sports
		// returns: www.yahoo.com

		// First get the address from user
		System.out.println("Enter Address:");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		// Split the line into substrings (tokens), using the symbols "/" 
		StringTokenizer st = new StringTokenizer(line, "/");

		// get the first word
		String word = st.nextToken();

		// if word is "http:" or "https:", then ignore it and get the next word
		if(word.equals("http:") || word.equals("https:")) {
			word = st.nextToken();
		}

		System.out.println(word);
		sc.close();
	}
}

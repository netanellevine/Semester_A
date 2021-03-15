package temp;
public class TestChar {

	public static void main(String[] args) {
		char c = 'a';
		System.out.println(c+" code(a) = "+(int)c); 
		for (int i='a'; i<='z'; i=i+1){
			System.out.print(i + ", ");
		}
		System.out.println();
		for (char i='a'; i<='z'; i++){
			System.out.print(i + ", ");
		}
		System.out.println();
		for (int i='A'; i<='Z'; i=i+1){
			System.out.print(i + ", ");
		}
		System.out.println();
		boolean b = 'A'=='a';
		System.out.println("A==a? "+b);
		System.out.println("a==a? "+('a'=='a'));
		for (int i='à'; i<='ú'; i=i+1){
			System.out.print(i + ", ");
		}
		System.out.println();
		for (char i='à'; i<='ú'; i++){
			System.out.print(i + ", ");
		}
		System.out.println();
		for (char i='à'; i<='ú'; i++){
			System.out.print("\u200e"); // The left-to-right mark, which is an invisible formatting character
			System.out.print(i + ", ");
		}
	}

}

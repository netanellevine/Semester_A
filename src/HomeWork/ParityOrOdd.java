package HomeWork;

public class ParityOrOdd {

	public static void main(String[] args) {		
		int arr [] = {1,2,3,4,5,6,7,8,20,30,47,49};
		Parity_or_odd (arr);
	}
	public static void Parity_or_odd(int arr[]) {
		int newArr []  = new int [arr.length] ;
		int m = 0 ;
		for (int i = 0; i < arr.length; i++) {
			if (arr [i]%2 == 0) {
				for (int j = 0; j < arr.length; j++) {						
					if (arr[i] >= arr[j]) {
						newArr[m] = arr[i];
					}
					else {
						newArr[m] = 0 ;
					}
				}
				if (newArr[m] != 0) {
					System.out.print(newArr[m]+",");
					m++;
				
				}
			}
			}
			
		}
}

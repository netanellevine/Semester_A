package HomeWork;

public class Simetrical {

	public static void main(String[] args) {
		boolean s=false;
		int [] arr = {1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1} ;
		int l=arr.length-1;
		//      int a , b;
		for (int i = 0; i < arr.length/2; i++) {
			s = false;
			//    	  a=arr[i];
			//    	  b=arr[l];
			if (arr[i]== arr[l-i]) {
				s = true;
			}
			else { 
				s = false;
				break;
			}
		}
		if (s){ System.out.println(" symetrical"); }
		else { System.out.println(" not symetrical");	}
	}

}



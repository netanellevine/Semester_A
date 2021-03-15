package HomeWork;


public class Pitagores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int a ;
		int b ;
		int c ;
		double apow , bpow , cpow ;
		
		c = 3 ;
		while  ( (c < 1000 )  ) {
			b = 2 ;				
			while  ( (b < 1000 ) &&( b < c ) ) {
				a = 1 ;
				while  ( (a < 1000 ) &&( a < b )  && ( a < c ) ) {
					apow = Math.pow(a,2);
					bpow = Math.pow(b,2);
					cpow = Math.pow(c,2);
					if (apow + bpow == cpow) {	
						System.out.println(a + "^2 + " + b + "^2 = " + c + "^2     ==     " + apow + " + " + bpow + " = " + cpow);
						//System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
					}
					a++ ;
				}	
				b++ ;
			}
			c++ ;
		}		

	}
}



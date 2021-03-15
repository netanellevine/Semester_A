package OldTests;

public class Test7_2019_SemesterA_SecondChance {

	public static void main(String[] args) {
		System.out.println(spehnic(20677));
        int arr[][] = {
                {2,4,-5,6,2},
                {3,5,0,-2,1},
                {7,3,-2,8,2},
                {0,1,9,5,6},
                {7,1,3,0,-1}
            };
            System.out.println(calcSumDiag(arr));
            String a="abcdefghijklmonpqrstuvwxyz";
            String b="babcdfefghijklmoonpqrstyuvwxyz";
            a="2abcde22";
            b="xyz2aaa2";
            System.out.println(mergeString(a,b));
        }
	
	
	//question 1
	public static boolean spehnic(int num) {
		if(num==1) {return false;}
		int count=0;
		for(int i= 2;i<=num;i++) {
			if(num%i==0 && isPrime(i)) {
				count++;
				num=num/i;
			}
			if(count==3 && num==1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	
	//question 2
	public static int calcSumDiag(int[][] arr) {
		return calcSumDiagRec(arr,0);
	}
	
	public static int calcSumDiagRec(int[][] arr, int i) {
		if(arr.length-1==i) {
			return arr[i][i];
		}
		else {
			return arr[i][i]+ calcSumDiagRec(arr,i+1);
		}
	}
	
	
	//question 3
	public static String mergeString(String a, String b) {
		String ans= "";
		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			if(a.contains(""+b.charAt(i))) {
				ans+="" +b.charAt(i);
				a=a.replace(""+b.charAt(i), "");
				b=b.replace(""+b.charAt(i), "");
				i--;
			}
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

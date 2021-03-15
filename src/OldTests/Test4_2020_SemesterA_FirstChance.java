package OldTests;

import java.util.Arrays;

public class Test4_2020_SemesterA_FirstChance {

	public static void main(String[] args) {
		System.out.println(powerful(72));
		String str = "RSSR";
		System.out.println(balanced(str));
		int[][]arr= {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		spiral(arr);
        int b[][] = {
                { 1, 2, 3, 4, 5},
                {16,17,18,19, 6},
                {15,24,25,20, 7},
                {14,23,22,21, 8},
                {13,12,11,10, 9}
            };
        System.out.println();
        spiral(b);

	}

	// question 1
	public static boolean powerful(int num) {
		int[] arr = Test3_2020_SemesterA_SecondChance.SieveOfEratosthenes(num / 2);
		for (int i = 0; i < arr.length; i++) {
			if (num % arr[i] == 0) {
				if (num % (arr[i] * arr[i]) != 0) {
					return false;
				}
			}
		}

		return true;
	}

	// question 1
	public static boolean powerful2(int num) {
		if (num == 1) {
			return true;
		}
		if (isPrime(num)) {
			return false;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0 && isPrime(i)) {
				if (num % (i * i) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// question 2
	public static int balanced(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int count = 0;
		String beginOfStr = "";
		for (int i = 0; i < str.length(); i++) {
			beginOfStr += ""+str.charAt(i);
			int countS = beginOfStr.length() - beginOfStr.replaceAll("S", "").length();
			int countR = beginOfStr.length() - beginOfStr.replaceAll("R", "").length();
			if (countS == countR) {
				count++;
			}
		}
		return count;
	}
	
	
	
	// question 3
	public static void spiral(int[][] arr) {
		int raws = arr.length-1;
		int colum = arr[0].length-1;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[0][i]+" ");
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i][colum]+" ");
		}
		for (int i = arr.length-2 ; i >= 0; i--) {
			System.out.print(arr[raws][i]+" ");
		}
		for (int i = arr.length-2 ; i > 0; i--) {
			System.out.print(arr[i][0]+" ");
		}
		if(arr.length-1>=2) {
		int[][]newArr=new int[raws-1][colum-1];
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				newArr[i-1][j-1]=arr[i][j];
			}
		}
		spiral(newArr);
		}
		else if(arr.length==1) {
			for (int i = 0; i < arr.length-1; i++) {
				System.out.print(arr[0][i]+" ");
			}
		}
		
	}
	
	
	// question 3
	   public static void spiral2(int[][] a) {
	        int len = a.length;
	        for(int i=0; i<=len/2; i++)
	            printRound(i,a);
	    }
	    public static void printRound(int k, int[][] a) {
	        int len = a.length;
	        for(int i=k; i<len-k; i++)
	            System.out.print(a[k][i]+" ");
	        for(int i=k+1; i<len-k; i++)
	            System.out.print(a[i][len-1-k]+" ");
	        for(int i=k+1; i<len-k; i++)
	            System.out.print(a[len-1-k][len-1-i]+" ");
	        for(int i=k+1; i<len-k-1; i++)
	            System.out.print(a[len-1-i][k]+" ");
	    }
}

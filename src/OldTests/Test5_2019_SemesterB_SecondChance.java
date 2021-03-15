package OldTests;

public class Test5_2019_SemesterB_SecondChance {

	public static void main(String[] args) {
		System.out.println(heartBeat(5));
		int[] arr = { -1, 2, 3, 6, 1, 8, 4, -2 };
		int[] arr2 = { 1, 2, 3, 4, 5 };
		System.out.println(isDivisible2(arr));

	}

	// question 1
	public static double heartBeat(int n) {
		if (n == 1) {
			return 55;
		}
		if (n == 2) {
			return 57;
		}
		if (n % 5 == 0) {
			return 3 + heartBeat(n - 1);
		} else {
			return 2 + (((heartBeat(n - 1) + heartBeat(n - 2)) / 2));
		}
	}

	// question 2
	public static boolean isDivisible(int[] arr) {
		int sumL = 1;
		int sumR = 1;
		int sumMid = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				for (int k = 0; k <= i; k++) {
					sumL *= arr[k];
				}
				for (int m = arr.length - 1; m >= j; m--) {
					sumR *= arr[m];
				}
				for (int l = i + 1; l < j; l++) {
					sumMid *= arr[l];
				}
			}

		}
		return (sumL * sumR == sumMid);
	}
	
	// question 2
    public static boolean isDivisible2(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-1; j > 0; j--) {
                if(leftMul(a,i)*rightMul(a,j) == betweenMul(a,i,j))
                    return true;
            }
        }
        return false;
    }

    private static int leftMul(int[] a, int j) {
        int ans = 1;
        for (int i=0; i<=j ; i++)
            ans *= a[i];
        return ans;
    }
    private static int rightMul(int[] a, int i) {
        int ans = 1;
        for (int j=a.length-1; j>=i ; j--)
            ans *= a[j];
        return ans;
    }
    private static int betweenMul(int[] a, int i, int j) {
        int b = 1;
        for (int k = i+1; k<j ; k++)
            b*=a[k];
        return b;
    }
}

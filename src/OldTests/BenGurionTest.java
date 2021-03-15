package OldTests;

import java.util.Arrays;

public class BenGurionTest {

	public static void main(String[] args) {
//		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
//		System.out.println(canChange(48,6,coins));
//		System.out.println(canChange(48,5,coins));
//		System.out.println(canChange(48,4,coins));
		int[] coins2 = { 1, 3, 6, 12, 24, 30, 60 };
		System.out.println(canChange2(48, 2, coins2));

	}

	public static boolean canChange(int sum, int k, int[] coins) {
		int[] a = new int[0];
		int[] b = new int[0];
		return canChange(coins, a, b, k, sum);

	}

	public static boolean canChange(int[] coins, int[] a, int[] b, int k, int sum) {
		if (coins.length > 0) {
			int[] coins1 = Arrays.copyOf(coins, coins.length - 1);
			int[] a1 = Arrays.copyOf(a, a.length + 1);
			a1[a1.length - 1] = coins[coins.length - 1];
			int[] b1 = b;
			int[] coins2 = Arrays.copyOf(coins, coins.length - 1);
			int[] b2 = Arrays.copyOf(b, b.length + 1);
			b2[b2.length - 1] = coins[coins.length - 1];
			int[] a2 = a;
//			System.out.println(Arrays.toString(coins));
//			System.out.println(Arrays.toString(coins1));
//			System.out.println(Arrays.toString(coins2));
//			System.out.println();
//			System.out.println(Arrays.toString(a));
//			System.out.println(Arrays.toString(a1));
//			System.out.println(Arrays.toString(b1));
//			System.out.println();
//			System.out.println(Arrays.toString(b));
//			System.out.println(Arrays.toString(a2));
//			System.out.println(Arrays.toString(b2));
//			System.out.println();
			return canChange(coins1, a1, b1, k, sum) || canChange(coins2, a2, b2, k, sum);
		}
		if ((a.length <= k || b.length <= k) && a.length > 0 && b.length > 0) {
			int sumA = 0;
			int sumB = 0;
			int i = 0;
			int count = 0;
			while (i < a.length) {
				sumA += a[i];
				i++;
				count++;
				if (count == k) {
					break;
				}
			}
			int j = 0;
			count = 0;
			while (j < b.length) {
				sumB += b[j];
				j++;
				count++;
				if (count == k) {
					break;
				}
			}
			if (sumA == sum || sumB == sum) {
				return true;
			}
		}
		return false;
	}

	
	public static boolean canChange2(int sum, int k, int[] coins) {
		return canChange2(sum,k,coins,0);
	}
	
	private static boolean canChange2(int sum, int k, int[] coins, int index) {
		if(sum==0) {
			return true;
		}
		else if(sum<0 || k==0 ||index==coins.length) {
			return false;
		}
		else 
		return canChange2(sum-coins[index],k-1,coins,index) || 
				canChange2(sum,k,coins,index+1);
	}
	
	
	
	
	
	
	
}

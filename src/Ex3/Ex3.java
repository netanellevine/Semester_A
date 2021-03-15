package Ex3;

import java.util.Arrays;

public class Ex3 {
	// @author Netanel Levine
	// ID 312512619

	public static String myID() {
		return "312512619";
	}
	
	
	/*@moveCharToLast:
	 * moveCharToLast receives a String of chars and a single char. it changes all
	 * the indexes of the char and moves them to the end of the String recursively.
	 * returning a new String. if the char does not exist in the String it returns
	 * the original string.  */
	public static String moveCharToLast(String str, char ch) {
		if (str.isEmpty() || (str.length()==1)) {
			return str;
		}
		int index = str.indexOf(ch);
		if (str.indexOf(ch) == -1) {
			return str;
		}
		String newStr = str.substring(0, index) + str.substring(index + 1);
		return moveCharToLast(newStr, ch) + ch;
	}

	
	/*@reduce:
	 * reduce receives a String of chars and removes all the duplicate following
	 * chars in the String recursively, returning a new String with maximum one same
	 * char in a row.  */
	public static String reduce(String str) {
		if (str.isEmpty() || (str.length()==1)) {
			return str;
		}
		char ch = str.charAt(0);
		if (str.charAt(0) == str.charAt(1)) {
			return reduce(str.substring(0, 1) + str.substring(2));
		}
		return ch + reduce(str.substring(1));
	}

	
	/*@mySplit
	 * mySplit receives an array of integers and return true/false if the array
	 * can be divides in two different arrays according to some rules .
	 * 1) the summ of all the numbers of each of the array is equal.
	 * 2) every number from the original array will be divided in one of the two ew arrays. 
	 * 3) all the numbers that divides by 5 is in one array.
	 * 4) all the numbers that divides by 3 and not 5 will be on the other array.
	 * all the procces and calculation are made by a Helper function: mySplitHelper.
	 * mySplitHelper is a recursion function and it will return true/false to mySplit if the array 
	 * can be divides in to two equals groups.  */
	public static boolean mySplit(int[] nums) {
		if (isZero(nums)) { // if the summ of array is zero return true because it can be divided.
			return true;
		}
		if (isNotEven(nums)) { // if the summ of array is uneven number return false because uneven number
			return false;      // can not be divided in 2.
		}
		int[] a = new int[0];
		int[] b = new int[0];
		return mySplitHelper(nums, a, b); // call to mySplitHelper to check if the array can be split.
	}

	
	/*@mySplitHelper
	 * mySplitHelper receives an array and a two empty arrays.
	 * First, mySplitHelper will start recursively to split the first array 
	 * in to the two empty arrays, the recursion will stop when mySplitHelper
	 * will split it to all the possible scenarios.
	 * Second, mySplitHelper go through the terms that we want to split the array.
	 * if it can be split according to the terms mySplitHelper will return true to mySplit
	 * else false.   */
	public static boolean mySplitHelper(int[] nums, int[] a, int[] b) {
		if (nums.length > 0) { // when the length of nums is 0 the recursion will stop.
			int[] nums1 = Arrays.copyOf(nums, nums.length - 1);
			int[] a1 = Arrays.copyOf(a, a.length + 1);
			a1[a1.length - 1] = nums[nums.length - 1];
			int[] b1 = b;
			int[] nums2 = Arrays.copyOf(nums, nums.length - 1);
			int[] b2 = Arrays.copyOf(b, b.length + 1);
			b2[b2.length - 1] = nums[nums.length - 1];
			int[] a2 = a;
			return ((mySplitHelper(nums1, a1, b1)) || (mySplitHelper(nums2, a2, b2))); // the recursion returns two 
		} 																			// different options each time.
		if (SumOfArray(a) != SumOfArray(b)) { // if the summ of the arrays is not equals return false.
			return false;
		}
		else {
			int count5a = 0;
			int count3a = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] % 5 == 0) {
					count5a++; // count how many times 5 divides in array a.
				}
				else if (a[i] % 3 == 0 && a[i] % 5 != 0) {
					count3a++; // count how many times 3 divides (not with 5) in array a.
				}
			}
			int count5b = 0;
			int count3b = 0;
			for (int i = 0; i < b.length; i++) {
				if (b[i] % 5 == 0) {
					count5b++; // count how many times 5 divides in array b.
				} else if (b[i] % 3 == 0 && b[i] % 5 != 0) {
					count3b++; // count how many times 3 divides (not with 5) in array b.
				}
			}
			if ((count5a >= count5b && count5b == 0) || (count5b >= count5a && count5a == 0)) { // check if only one array 
																							// has numbers that divided by 5.
				if ((count3a >= count3b && count3b == 0) || (count3b >= count3a && count3a == 0)) { // check if only one array
					return true; // return true if both terms are true.                       // has numbers that divided by 3.
				}
			}
			else {
				return false;
			}
			return false;
		}
	}
	
	
	/*@sumOfNeighbours:
	 * sumOfNeighbours receives a matrix of integers, and calculates the summ of all
	 * the neighbours of a number in the matrix, for each of the numbers in the
	 * matrix. (assuming that the minimum matrix will be 2X2). Returns a new matrix
	 * after it finishes to calculate  all the numbers. sumOfNeighbours works in
	 * three steps because there are three kinds of numbers in the matrix:
	 * 1) The edges has 3 neighbours.
	 * 2) The frame has 5 neighbours. 
	 * 3) The inside has 8 neighbours.
	 * First it calculates all the four edges of the matrix and if the
	 * matrix is 2X2 it returns the new matrix. Second it calculates all the four
	 * frames of the matrix. Third it calculates all the inside of the matrix.  */
	public static int[][] sumOfNeighbours(int[][] mat) {
		int mRawsInd = mat.length - 1; // max Raws Index
		int mColsInd = mat[0].length - 1; // max Columns Index
		int[][] newMat = new int[mat.length][mat[0].length];
		newMat[0][0] = mat[1][0] + mat[0][1] + mat[1][1]; // top left edge
		newMat[0][mColsInd] = mat[0][mColsInd - 1] + mat[1][mColsInd - 1] + mat[1][mColsInd]; // bottom left edge
		newMat[mRawsInd][0] = mat[mRawsInd - 1][0] + mat[mRawsInd][1] + mat[mRawsInd - 1][1]; // top right edge
		newMat[mRawsInd][mColsInd] = mat[mRawsInd - 1][mColsInd - 1] + mat[mRawsInd - 1][mColsInd] 
				+ mat[mRawsInd][mColsInd - 1]; // bottom right edge
		if (mRawsInd == 1 && mColsInd == 1) {
			return newMat;
		}
		for (int i = 1; i < mColsInd; i++) { // the upper part of the frame
			newMat[0][i] = mat[0][i - 1] + mat[1][i - 1] + mat[1][i] + mat[1][i + 1] + mat[0][i + 1];
		}
		for (int i = 1; i < mRawsInd; i++) { // the left part of the frame
			newMat[i][0] = mat[i - 1][0] + mat[i - 1][1] + mat[i][1] + mat[i + 1][1] + mat[i + 1][0];
		}
		for (int i = 1; i < mRawsInd; i++) { // the right part of the frame
			newMat[i][mColsInd] = mat[i - 1][mColsInd] + mat[i - 1][mColsInd - 1] + mat[i][mColsInd - 1] 
					+ mat[i + 1][mColsInd - 1] + mat[i + 1][mColsInd];
		}
		for (int i = 1; i < mColsInd; i++) { // the bottom part of the frame
			newMat[mRawsInd][i] = mat[mRawsInd][i - 1] + mat[mRawsInd - 1][i - 1] + mat[mRawsInd - 1][i] 
					+ mat[mRawsInd - 1][i + 1] + mat[mRawsInd][i + 1];
		}
		for (int i = 1; i < mColsInd; i++) { // all the remaining, the inside of the matrix
			for (int j = 1; j < mRawsInd; j++) {
				newMat[j][i] = mat[j - 1][i - 1] + mat[j - 1][i] + mat[j - 1][i + 1] + mat[j][i + 1] + mat[j + 1][i + 1]
						+ mat[j + 1][i] + mat[j + 1][i - 1] + mat[j][i - 1];
			}
		}
		return newMat;
	}

	
	/*@caesarCipherText:
	 * caesarCipherText receives a String of letters and a key of nutral number
	 * (between -26 and 26). caesarCipherText changes each of the letters in the
	 * String according to the key given, but spaces in the String remain the same.
	 * (for example "abcdefg" with key of 1 will change to "bcdefgh")
	 * Returns a new String with the changes. 
	 * caesarCipherText works for both ways, if it will be given an encrypted String
	 * and a minus key(that suits for the reverse),
	 * caesarCipherText will return the not encrypted String.  */
	public static String caesarCipherText(String str, int key) {
		if (key > 26 || key < -26) { // if the key is not a small caption letter it will return an empty string.
			return "";
		}
		char[] arr = new char[str.length()];
		String newStr = "";
		for (int i = 0; i < arr.length; i++) {
			if (str.charAt(i) == 32) { // if at index i there is space don't change it.
				arr[i] += 32;
			}
			else if ((str.charAt(i) + (key) < 123) && (str.charAt(i) + (key) > 96)) { // if after the add of the key it's
				arr[i] += (str.charAt(i) + (key)); // in the range of 97 to 122 (a-z in ASCII) add the key.
			}
			else if ((str.charAt(i) + (key) < 97)) { // if after the add of the key it's below 97
				arr[i] += ((str.charAt(i) + (key)) + 26); // (when given a negetive key) add 26 plus the key.
			}
			else { // else means it's bigger then 123 so add the key minus 26.
				arr[i] += ((str.charAt(i) + (key)) - 26);
			}
			newStr += arr[i];
		}
		return newStr;
	}

	
	/*vigenereCipherText:
	 * vigenereCipherText receives a String of letters and a String key(of letters).
	 * vigenereCipherText goal is to encrypt a sentence according to Vigenere
	 * Cipher. First VCT(shortcut) uses a side function keyToNumbers that turns the
	 * String key to an array of integers (a=0, b=1, c=2 ...z=25) in the same order
	 * of the string chars. Second VCT changes each char of the String according to
	 * the number written in the array, and when the array is over it's starts the
	 * array from the beginning until it finishes to go through the whole String.
	 * (when a char from the String is space, it will remain space but the index of
	 * the array still moves on) VCT returns a new String encrypted  */
	public static String vigenereCipherText(String str, String key) {
		if (str.isEmpty()) { // if the string is empty return an empty string.
			return "";
		}
		int[] arrKey = keyToNumbers(key); // converts the chars to a numbers.
		if (arrKey == null) { // if the key is not a small caption letter it will return an empty string.
			return "";
		}
		char[] arr = new char[str.length()];
		String encryptedStr = "";
		int j = 0;
		for (int i = 0; i < arr.length; i++, j++) {
			if (j == arrKey.length) { // every time j equals to the array length it will
				j = 0; // because the key has finished and no it will start all over again.
			}
			if (str.charAt(i) == 32) { // if at index i there is space don't change it.
				arr[i] += 32;
			}
			else if ((str.charAt(i) + arrKey[j] < 123) && (str.charAt(i) + arrKey[j] > 96)) { // if after the add of the key
				arr[i] += ((str.charAt(i)) + (arrKey[j])); // it's in the range of 97 to 122 (a-z in ASCII) add the key num
			}
			else { // else means it's bigger then 123 after the add of the key num,
				arr[i] += (((str.charAt(i)) + (arrKey[j])) - 26); // so add minus 26 plus the key num.
			}
			encryptedStr += arr[i];
		}
		return encryptedStr;
	}

	
	/*@vigenereDecipherText:
	 * vigenereDecipherText receives an encrypted String of letters, and doing the
	 * oppsite from vigenereCipherText. vigenereDecipherText returns a new String
	 * that is not encrypted according to Vigenere Cipher rules.  */
	public static String vigenereDecipherText(String str, String key) {
		if (str.isEmpty()) { // if the string is empty return an empty string.
			return "";
		}
		int[] arrKey = keyToNumbers(key); // converts the chars to a numbers.
		if (arrKey == null) { // if the key is not a small caption letter it will return an empty string.
			return "";
		}
		char[] arr = new char[str.length()];
		String notEncryptedStr = "";
		int j = 0;
		for (int i = 0; i < arr.length; i++, j++) {
			if (j == arrKey.length) { // every time j equals to the array length it will
				j = 0; // because the key has finished and no it will start all over again.
			}
			if (str.charAt(i) == 32) { // if at index i there is space don't change it.
				arr[i] += 32;
			}
			else if ((str.charAt(i) - arrKey[j] < 123) && (str.charAt(i) - arrKey[j] > 96)) { // if after the minus of the key
				arr[i] += ((str.charAt(i)) - (arrKey[j])); // it's in the range of 97 to 122 (a-z in ASCII) so minus key num
			}
			else if ((str.charAt(i) - arrKey[j] < 97)) { // if after the minus of the key num it's below 97
				arr[i] += (((str.charAt(i)) - (arrKey[j])) + 26); // add 26 minus the key.
			}
			notEncryptedStr += arr[i];
		}
		return notEncryptedStr;
	}

	
	/*keyToNumbers:
	 * keyToNumbers receives a String of chars(letters) and converts it to an array
	 * of integers. that a=0, b=1 c=2,...z=25. returning an array based on the value
	 * of each letter in the length of the orignal String.  */
	private static int[] keyToNumbers(String key) {
		int[] arrKey = new int[key.length()];
		for (int i = 0; i < arrKey.length; i++) {
			if (key.charAt(i) < 96 || key.charAt(i) > 123) {
				return null;
			}
			arrKey[i] = key.charAt(i) - 97; // the arrKey will receive a number between 0 to 26.
		}
		return arrKey;
	}
	
	
	/*@SumOfArray
	 * SumOfArray checks the summ of the array and returns it  */
	private static int SumOfArray(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	
	/*@isNotEven
	 * isNotEven checks if the array given is not Even.
	 * if it's not Even it will returns true to mySplit
	 * and mySplit will automaticlly will return false because,  un even number
	 * can not be divides in 2.  */
	private static boolean isNotEven(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum % 2 == 1;
	}
	
	
	/*@isZero
	 * isZero checks if the array given is array of only zeros
	 * and if it doest , it return true to mySplit
	 * so that mySplit will automaticlly return true without doing recursion.  */
	private static boolean isZero(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	
	
}

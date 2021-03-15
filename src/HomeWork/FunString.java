package HomeWork;

public class FunString {

	public static void main(String[] args) {
		String str="12345654321";
		System.out.println((str));
		System.out.println("The reverse String is: "+(reverse(str)));
		if(isStringSimetrical(str)) {
		System.out.println("the String is Simetrical");
		}
		else{
			System.out.println("the String is not Simetrical");
		}
		String str2 = "1001001";
		double num = binaryToDecimal(str2);
		System.out.println("The Binary number: " + str2 + ", equals to the Decimal number: " + binaryToDecimal(str2));
		System.out.println("The Decimal numer: " + num + ", equals to the Binary number: " + decimalToBinary(num));
		String str3="102411555610";
		System.out.println(isStringBinaryNum(str3));
		String[] s= {"sss","123","0"};
		
	}

	
	
	
	// This function receives a String that represent a Binary number and returns
	// it's Deciaml value as a double.
	public static double binaryToDecimal(String str) {
		int num = 0;
		String newStr = reverse(isStringBinaryNum(str));
		for (int i = 0; i <= newStr.length() - 1; i++) {
			num += (newStr.charAt(i) - '0') * (Math.pow(2, i));
		}
		return num;
	}

	
	
	
	
	public static String decimalToBinary(double num) {
		String str = "";
		if (num == 0) {
			return str += "0";
		}
		while (num >= 1) {
			str +=  (int)num % 2;
			num = num / 2;
		}
		return reverse(str);
	}

	
	
	public static String isStringBinaryNum(String str) {
		String newStr="";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='1' || str.charAt(i)=='0') {
				newStr+=str.charAt(i);
			}
		}
			return newStr;
	}
	
	
	// This function returns the String given but reversed
	public static String reverse(String str) {
		char[] ch = str.toCharArray();
//		for (int i = 0 ,  j=ch.length-1; i < j; i++, j--) {
//			char temp= ch[j];
//			ch[j]=ch[i];
//			ch[i]=temp;
//		}
		String newStr = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			newStr += ch[i];
		}
		return newStr;
	}

	
	
	
	
	// This function checks if the String given is Simetrical and returns True or
	// false
	public static boolean isStringSimetrical(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
			if (ch[i] != ch[j]) {
				return false;
			}
		}
		return true;
	}

}

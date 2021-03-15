package OldTests;

import java.util.Scanner;
public class Test8_2019_SemesterA_FirstChance {

	public static void main(String[] args) {
		System.out.println("i= "+marsenne(10));
//		simCoin();
		System.out.println(single("abracadabra"));
	}

	//question 1
	public static long marsenne(int i) {
		if (i > 0) {
			return (long) recMarsenne(i, 1);
		} else {
			return 1;
		}
	}

	public static long recMarsenne(int i, int j) {
		if (i > 0) {
			System.out.print((long) Math.pow(2, j) - 1 + " ");
			return (long) recMarsenne(i - 1, j + 1);
		} else {
			System.out.println();
			return (long) Math.pow(2, j - 1) - 1;
		}
	}

	
	// question 2
	public static void simCoin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the probabillity for receiving 0: ");
		double prob = sc.nextDouble();
		System.out.println("Enter the amounts of trys: ");
		int trys = sc.nextInt();
		sc.close();
		int sucssess = 0;
		int attempts = trys;
		while (attempts > 0) {
			int temp = (int) (Math.random() * 2);
			if (temp == 0) {
				sucssess++;
			}
			attempts--;
		}
		double dif = prob - (double) sucssess / trys;
		System.out.println("The difference is: " + dif);
	}
	
	
	//question 3
	public static String single(String s) {
		String newStr="";
		for (int i = 0; i < s.length(); i++) {
			String temp=s.charAt(i)+"";
			int count=s.length()-s.replace(temp,"").length();
			if(count==1) {
				newStr+=temp;
			}
			else {
				s=s.replace(temp,"");
				i--;
			}	
		}
		return newStr;
	}
	
    private static String single1(String s) {
        int a[] = new int['z'];
        for (int i = 0; i < s.length(); i++){
            a[s.charAt(i)]++;
        }
        String temp = "";
        for (int i = 0; i < s.length(); i++){
            if(a[s.charAt(i)] == 1)
                temp += s.charAt(i);
        }
        return temp;
    }
	
    private static String single2(String s) {
        int a[] = new int[25];
        for (int i = 0; i < s.length(); i++){
            a[s.charAt(i)-'a']++;
        }
        String temp = "";
        for (int i = 0; i < a.length; i++){
            if(a[i]==1)
                temp += ""+(char)('a'+i);
        }
        return temp;
    }
	

	
	
	
	
	
	
	
	
	
	
	
	
}

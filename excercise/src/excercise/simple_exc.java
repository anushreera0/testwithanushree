package excercise;

import java.util.Scanner;

public class simple_exc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scr=new Scanner(System.in);
		String str=scr.nextLine();
		String reverse="";
		reverse=reverse(str,reverse);
		palindrome(str,reverse);
	}

	public static String reverse(String str,String reverse) {
		for(int i=0;i<str.length();i++) {
			reverse=str.charAt(i)+reverse;
		}
		System.out.printf("reversed: %s\n",reverse);
		return reverse;
	}
	public static String palindrome(String str, String reverse) {
		if(str.equals(reverse)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
		return reverse;
	}
}


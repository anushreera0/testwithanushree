package excercise;

import java.util.ArrayList;
import java.util.Scanner;

public class practiceJava {
	
	//Sum of first 10 natural numbers using for loop
	public static void naturalNum() {
		int i=0;
		int sum = 0;
		for(i=0;i<=10;i++) {
			sum=sum+i;
			
		}
		System.out.printf("Sum:"+sum+"\n");
	}
	
	//odd numbers from 1 to 10
	public static void oddNum() {
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		int i=1;
		for(i=1;i<=10;i++) {
			//System.out.println(i+"\n");
			numbers.add(i);
			i=i+1;
			
		}
		System.out.println(numbers);
	}
	
//			1. How do you reverse a string in Java?
	public static String reverseString(String str) {
		
//		StringBuilder reversed=new StringBuilder();
//		char[] ch=str.toCharArray();
//		for(int i=ch.length-1;i>=0;i--) {
//			reversed.append(ch[i]);
//		}
//	
//		return reversed.toString();
		String reversedString="";
		char[] ch=str.toCharArray();
		for (int i=str.length()-1;i>=0;i--) {
			reversedString=reversedString+ch[i];
		}
		return reversedString.toString();
	}
//			2. How do you swap two numbers without using a third variable in Java?
	public static void swaptwoNums() {
		int a=25,b=45;
		System.out.println("Before integ1="+a+"\t integ2="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After integ1="+a+"\t integ2="+b);
	}
//			3. Write a Java program to check if a vowel is present in a string.
	public static int checkVowelInString(String str) {
		str=str.toLowerCase();
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u') {
				count+=1;
			}
			
		}
		return count;
	}
//			4. Write a Java program to check if the given number is a prime number.
	public static void checkPrime(int num) {	
			
		if(num==1||num<=0) {
			
			
		}
		for(int i=0; i<=num/2; i++) {
			if(num%i==0) {
				
			}
			else {
				
			}
		}
		
	}
//			5. Write a Java program to print a Fibonacci sequence using recursion.
//			6. How do you check if a list of integers contains only odd numbers in Java?
//			7. How do you check whether a string is a palindrome in Java?
//			8. How do you remove spaces from a string in Java?
//			9. How do you remove leading and trailing spaces from a string in Java?
//			10. How do you sort an array in Java?
//			11. How do you create a deadlock scenario programmatically in Java?
//			12. How can you find the factorial of an integer in Java?
//			13. How do you reverse a linked list in Java?
//			14. How do you implement a binary search in Java?
//			15. Write a Java program that illustrates merge sort.
//			16. Can you create a pyramid of characters in Java?
//			17. Write Java program that checks if two arrays contain the same elements.
//			18. How do you get the sum of all elements in an integer array in Java?
//			19. How do you find the second largest number in an array in Java?
//			20. How do you shuffle an array in Java?
//			21. How can you find a string in a text file in Java?
//			22. How do you print a date in specific format in Java?
//			23. How do you merge two lists in Java?
//			24. Write a Java program that sorts HashMap by value.
//			25. How do you remove all occurrences of a given character from an input string in Java?
//			26. How do you get distinct characters and their count in a string in Java?
//			27. Can you prove that a String object in Java is immutable programmatically?
//			28. Can you write some code to showcase inheritance in Java?
//			29. How do you show a diamond problem with multiple inheritance in Java?
//			30. How do you illustrate a try catch example in Java?
//			31. Write a Java program to show a NullPointerException.
//			32. How do you create a record in Java?
//			33. How do you create text blocks in Java?
//			34. Show an example of switch expressions and multi-label case statements in Java.
//			35. How do you compile and run a Java class from the command line?
//			36. How do you create an enum in Java?
//			37. How do you use the forEach() method in Java?
//			38. How do you write an interface with default and static method?
//			39. How do you create a functional interface?
//			40. Show an example of using lambda expressions in Java.
//			41. Show examples of overloading and overriding in Java.
	public static void main(String[] args) {
		naturalNum();
		oddNum();
		System.out.println(reverseString("Love you so much"));
		swaptwoNums();
		System.out.println(checkVowelInString("I am about to Leave s"));
//		Scanner sc=new Scanner(System.in);
//		int num=sc.nextInt();
		checkPrime(1);
		
	}

}

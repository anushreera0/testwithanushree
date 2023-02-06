package excercise;

import java.util.ArrayList;

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
	
	//
	public static void main(String[] args) {
		naturalNum();
		oddNum();
	}

}

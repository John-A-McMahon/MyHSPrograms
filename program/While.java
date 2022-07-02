package program;
import java.lang.Math;

public class While {
public static void main(String[] args) {
	System.out.println(containsADigit(90001,1));
	System.out.println(containsBothDigits(90001,1,9));
	System.out.println(countOddDigits(-90011));
	printNumbers(5);
	System.out.println();
	System.out.println(printNumbersWithDashes(123));
}
public static boolean containsADigit(int num, int d) {
	num =Math.abs(num);
	d =Math.abs(d);
	while (num%10!=d) {
		num=num/10;
		if (num==0&&d!=0) {
			return false;
		}
		else if (num==d) {break;}
	}
	return true;
}
public static boolean containsBothDigits(int num, int digit1,int digit2) {
	
	boolean d1 = false;
	boolean d2 = false;
	num =Math.abs(num);
	digit1 =Math.abs(digit1);
	digit2 =Math.abs(digit2);
	while (num%10!=digit1) {
		num=num/10;
		if (num==0&&digit1!=0) {
			return false;
		}
		else if (num==digit1) {break;}
	}
	d1 = true;
	while (num%10!=digit2) {
		num=num/10;
		if (num==0&&digit2!=0) {
			return false;
		}
		else if (num==digit2) {break;}
	}
	d2 = true;
	return d1&&d2;
}

public static int countOddDigits(int num) {
	num =Math.abs(num);
	int sum = 0;
	while (num>0) {
		if (num%2==1) {
			sum = sum+1;
		}
		num=num/10;
	}
	return sum;
}

public static void printNumbers(int max){
	max =Math.abs(max);
	//int sum =0;
	int i = 1;
	while(i<=max) {
		//sum = sum + i;
		System.out.print("["+i+"]");
		i++;
	}
}

public static String printNumbersWithDashes(int num) {
	num =Math.abs(num);
	String str ="";
	while(num>0) {
		str=str+(num%10)+"-";
		num=num/10;
	}
	str=str.substring(0, str.length()-1);
	return str;
}

public static void printOdd() {
	int i =1;
	while(i<100) {
		System.out.println(i);
		i+=2;
	}
}
public static void printMultiples(int num, int n) {
	int i =num;
	while(num>0) {
		
		System.out.println(num);
		num=num-n;
	}
}
public static void printFourFive(int low, int high) {
	int i = low;
	while (i<high) {
		if (i%4==0&&i%5!=0) {
			System.out.println(i);
		}
		i++;
	}
}

public static void displayNumbers(int num) {
	int i = 0;
	while (i<num) {
		System.out.println(i);
	}
}
public static void displayNumbers(int begin, int end) {
	int i = begin;
	while (i<end) {
		System.out.println(i);
	}
}
public static void tenOnLine(int num) {
	int i = 0;
	while (i<num) {
		
		System.out.print(i+", ");
		if (i%10==0) {
			System.out.println();
		}
	}
}
}

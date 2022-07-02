
public class Digits {
	public static void main(String[] args) {
		//N%10 = last digit
		//n/10 = removes lastdigit
		printOddDigits(1233);
	}
	public static void printDigits(int num) {
		if (num < 10) {
			System.out.println(num);
		}
		else {
			System.out.println(num%10);
			printDigits(num/10);
		}
	}
	public static void printEvenDigits(int num) {
		if (num < 10) {
			if (num%2==0) {
				System.out.println(num);
			}
			
		}
		else {
			if ((num%10)%2==0) {
			System.out.println(num%10);
			
			}
			printEvenDigits(num/10);
			}
			
		}
	public static void printOddDigits(int num) {
		if (num < 10) {
			if (num%2==1) {
				System.out.println(num);
			}
			
		}
		else {
			if ((num%10)%2==1) {
			System.out.println(num%10);
			
			}
			printOddDigits(num/10);
			}
			
		}
	public static int sumDigits(int n) {
		if (n<10) {
			return n;
		}
		else {
			return (n%10)+sumDigits(n/10);
		}
	}
}

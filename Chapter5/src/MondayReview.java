import java.util.Scanner;
public class MondayReview {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(factorial(4));
		
	}
	public static boolean canVote(int age) {
		return age>=18;
	}
	public static int factorial(int n) {
		if (n==0) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
}

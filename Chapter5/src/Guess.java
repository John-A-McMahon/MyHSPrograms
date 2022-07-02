import java.util.Scanner;

public class Guess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		int secretNum = 100;
		int guess = 0;
		while (guess != secretNum) {
			System.out.println("Your guess:");
			guess = sc.nextInt();
			if (guess>secretNum) {
				System.out.println("Lower");
			}
			if (guess<secretNum) {
				System.out.println("Higher");
			}
		}
		*/
		guess(100);
		System.out.println("You got it congrats!");
		
	}
	public static void guess(int secret) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Your guess?:");
		int guess = sc.nextInt();
		if (guess>secret) {
			System.out.println("Lower");
			guess(secret);
		}
		if (guess<secret) {
			System.out.println("Higher");
			guess(secret);
		}
		
	}

}

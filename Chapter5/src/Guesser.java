import java.util.Scanner;
import java.lang.Math;
public class Guesser {
	public static void main (String[] args) {
		g(0,1);
	}
	public static int g(int guess,int m) {
		Scanner sc = new Scanner(System.in);
		if (guess!=m) {
			System.out.println("You guess");
			guess = sc.nextInt();
			if (guess ==m) {
				System.out.println("You win");
			}
			else {
				return g(0,m);
			}
			
		}
		return g(0,m);
		
		
	}
}

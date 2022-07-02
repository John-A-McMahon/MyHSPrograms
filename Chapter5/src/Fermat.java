import java.util.Scanner;
import java.lang.Math;
public class Fermat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		System.out.println("a:");
		int a = keyboard.nextInt();
		System.out.println("b:");
		int b = keyboard.nextInt();
		System.out.println("c:");
		int c = keyboard.nextInt();
		System.out.println("n:");
		int n = keyboard.nextInt();
		
		if (Math.pow(a, n)+Math.pow(b, n)== Math.pow(c, n)&&n>=2) {
			System.out.println("Holy smokes Fermat was wrong!");
		}
		else {
			System.out.println("No, that does not work");
		}
		
	}

}


public class Factorial {
	public static void main(String[] args) {
		System.out.println(0.25-3);
	}

	public static int f(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * f(n - 1);
		}
	}
}

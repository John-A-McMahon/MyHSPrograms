
public class Ch6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oddSum(6));
	}

	public static boolean isDivisible(int n, int m) {
		return (n % m == 0);
	}

	public static boolean isTriangle(int a, int b, int c) {
		return (a + b > c) && (a + c > b) && (b + c > a);
	}

	public static double multadd(double a, double b, double c) {
		return (a * b) + c;
	}

	public static double expsum(double x) {
		return multadd(x, Math.pow(Math.E, -x), Math.sqrt(1 - Math.pow(Math.E, -x)));
	}

	public static int prod(int m, int n) {
		if (m == n) {
			return n;
		} else {

			return n * prod(m, n - 1);
		}
	}

	public static int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		}
		if (m > 0 && n == 0) {
			return ack(m - 1, 1);
		}
		if (m > 0 && n > 0) {
			return ack(m - 1, ack(m, n - 1));
		}
		return ack(m - 1, ack(m, n - 1));

	}

	public static double power(double x, double n) {
		if (n == 1) {
			return x;
		}
		if (n == 0) {
			return 1;
		} else {
			return x * power(x, n - 1);
		}
	}

	public static int oddSum(int n) {
		if (n % 2 == 0) {
			System.out.println("Odd plz");
			return 0;
		}

		else if (n == 1) {
			return 1;
		}
		return n + oddSum(n - 2);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}


public class Multadd {
	public static void main (String[] args) {
		
		System.out.println(multadd(Math.sin(Math.PI/4),1,Math.cos(Math.PI/4)/2));
		System.out.println(multadd(Math.log(10),1,Math.log(20)));
		System.out.println(expsum(1));
	}
	public static double multadd(double a, double b, double c) {
		return (a * b) + c;
	}
	public static double expsum(double x) {
		return multadd(x,Math.exp(-x),Math.sqrt(1 - Math.exp(-x)));
	}
}

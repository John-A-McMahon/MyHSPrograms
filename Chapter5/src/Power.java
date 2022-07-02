
public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(-2,5));

	}
	public static double power(double n,int i) {
		if (i<-1) {
			return n*power(n,i+1);
		}
		if (i==0) {
			return 1;
		}
		if (i==1||i==-1) {
			return n;
		}
		else {
			return n*power(n,i-1);
		}
	}

}

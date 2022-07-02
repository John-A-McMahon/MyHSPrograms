
public class EnoughTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(enoughTimeForLaunch(12,30,11,0));
		System.out.println((int)-2.75-0.5);

	}
public static boolean enoughTimeForLaunch(int h1,int m1,int h2,int m2) {
	return (60*(h2-h1))+(m2-m1)>=45;
}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
hailstone(5,0);
hailstone(8,0);
	}
	public static void hailstone(int n,int i) {
		if (i==0) {
			System.out.print(n+",");
		}
		if(n==1) {
			System.out.println();
		}
		else if(n%2==0) {
			System.out.print(n/2+",");
			hailstone(n/2,i+1);
		}
		else if (n%2!=0) {
			System.out.print((n*3+1)+",");
			hailstone(n*3+1,i+1);
		}
	}

}

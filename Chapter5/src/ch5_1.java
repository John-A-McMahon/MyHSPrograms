public class ch5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for (int i = 10; i>0; i-=1) {
			System.out.println(i);
		}
		System.out.println("BLAST OFF YALL!!!");
		
		
		
*/
		
	}
	public static void Count(int n) {
		if (n>0) {
			n-=1;
			System.out.println(n);
			Count(n);
		}
	}

}

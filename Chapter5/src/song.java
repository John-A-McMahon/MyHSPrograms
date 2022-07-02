
public class song {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chant(99,"Yummy milk");
		

	}
	public static void chant(int n,String drink) {
		System.out.println(n+ " bottles of "+drink +" on the wall!");
		System.out.println(n+ " bottles of "+drink +" on the wall!");
		System.out.println("Take one down pass it around!");
		System.out.println((n-1)+ " bottles of "+drink +" on the wall!\n");
		if (n>1) {
			chant(n-1,drink);
		}
		else {
			
			System.out.println("NO bottles of "+drink +" on the wall!");
			System.out.println("NO bottles of "+drink +" on the wall!");
			System.out.println("Take one down pass it around!");
			System.out.println("NO bottles of "+drink +" on the wall!\n");
		}
		
	}

}

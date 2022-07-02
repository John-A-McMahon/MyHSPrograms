package program;

public class SwapPairs {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String[] a = {"four", "score", "and", "seven", "years", "ago"};
		swapPairs(a);
		System.out.println();
		String[] b = {"to", "be", "or", "not", "to", "be", "hamlet"};
		swapPairs(b);
		
		
		

	}
	public static String[] swapPairs(String[] a) {
		String placeholder = "";
		for(int i = 0; i<a.length-1; i+=2) {
			placeholder=a[i];
			a[i]=a[i+1];
			a[i+1]=placeholder;
		}
		System.out.print("{");
		for(int i = 0; i<a.length; i++) {
			System.out.print("\"");
			System.out.print(a[i]);
			System.out.print("\",");
		}
		System.out.print("}");
		return a;
	}

}

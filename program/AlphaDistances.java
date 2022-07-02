package program;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
public class AlphaDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("First String:");
		String s1=sc.nextLine();
		System.out.println("Second String:");
		String s2 = sc.nextLine();
System.out.println(alphaD(s1,s2));
	}
	public static ArrayList<Integer> alphaD(String s1, String s2){
		s1=s1.toUpperCase();
		s2=s2.toUpperCase();
		ArrayList<Integer> n  =new ArrayList<>();
		if(s1.length()!=s2.length()) {
			System.out.println("Must be equal length!");
			return n;
		}
		for(int i = 0; i<s1.length();i++) {
			if(s2.charAt(i)-s1.charAt(i)<0) {
				n.add((int) (s2.charAt(i)-s1.charAt(i))+26);
			}
			else {
				n.add((int) Math.abs(s2.charAt(i)-s1.charAt(i)));
			}
			
			
		}
		for(int i = 0; i<n.size(); i++) {
			if(i>0&&n.get(i)!=n.get(i-1)) {
				break;
			}
			if(i==n.size()-1) {
				System.out.println("It is probrobly a shift "+n.get(i) +" cipher");
			}
		}
		return n;
	}
	

}

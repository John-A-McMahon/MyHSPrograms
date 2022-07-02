package program;
import java.util.Scanner;
public class Palindrama {
public static void main(String[] args) {
Scanner sc =new Scanner(System.in);
System.out.println("word:");
String word = sc.nextLine();
int longest = 0;
for(int i = 0; i<word.length(); i++) {
	for(int e =word.length()-1; e>0; e--) {
		if(word.charAt(i)==word.charAt(e)) {
			if(isPalindrome(word.substring(i,e+1))){
				longest = word.substring(i,e+1).length()+2;
			}
		}
	}
}
System.out.println(longest);
}

public static boolean firstLast(String word){
	for(int i = 0; i<word.length(); i++) {
		if(word.charAt(i)==word.charAt(word.length()-i)) {
			return true;
		}
	}
	return false;
}
public static boolean isPalindrome(String s1) {
	  s1=s1.toLowerCase();
	  String s2 = "";
	  for(int i = s1.length()-1; i>=0; i--) {
		  s2=s2+s1.charAt(i);
	  }
	  if(s1.equals(s2)) {
		  return true;
	  }
	  return false;
}
}

package program;
import java.util.Scanner;
public class HawaiianWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String input = "";
		String word = "";
		System.out.println("Do you want to pronounce a word in hawaiian?(y,yes,n,no)");
		input = sc.nextLine();
		while(!input.equals("n")&&!input.equalsIgnoreCase("NO")) {
			System.out.println("word:");
			word = sc.nextLine();
		System.out.println(pronciation(word));
		
		do {
			System.out.println("Do you want to pronounce another word in hawaiian?(y,yes,n,no)");
			input = sc.nextLine();
		}
		while(!input.equals("n")&&!input.equalsIgnoreCase("NO")&&!input.equals("y")&&!input.equalsIgnoreCase("YES"));
		
		}
	}

	public static String pronciation(String word) {
		String p = "";
		word=word.toLowerCase();
		String rest = "";
		for (int i = 0; i < word.length(); i++) {
			rest = word.substring(i,word.length());
			
			if(!(word.charAt(i)=='p'||word.charAt(i)=='k'||word.charAt(i)=='h'||word.charAt(i)=='l'||word.charAt(i)=='m'||word.charAt(i)=='n'||word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'||word.charAt(i)==' '||word.charAt(i)=='\'')) {
				return word.charAt(i)+" is not a valid hawaiian character";
			}
			//consonants p,k,h,l,m,n
			if(word.charAt(i)=='p'||word.charAt(i)=='k'||word.charAt(i)=='h'||word.charAt(i)=='l'||word.charAt(i)=='m'||word.charAt(i)=='n') {
				p+=word.charAt(i)+"";
			}
			
			if(word.charAt(i)==' '){
		        p=p.substring(0,p.length()-1);
		        p+=""+' '+"";
		      }
			
			//w
			if (word.indexOf("w") >= 0 ) {

				if (i == 0 && (word.charAt(0) == 'w')) {
					p += word.charAt(0)+" ";
				} else if (i > 0 && (word.charAt(i) == 'w')&&(word.charAt(i-1) == 'i'||word.charAt(i-1) == 'e' )) {
					p += "v ";
				}
				else {
					p+="w ";
				}
			}
			
			
			//vowels
			if(rest.indexOf("ai")+i==i||rest.indexOf("ae")+i==i) {
				p+="eye-";
				i++;
			}
			else if(rest.indexOf("ao")+i==i||rest.indexOf("aw")+i==i||rest.indexOf("ou")+i==i) {
				p+="ow-";
				i++;
			}
			else if(rest.indexOf("ei")+i==i) {
				p+="ay-";
				i++;
			}
			else if(rest.indexOf("eu")+i==i) {
				p+="eh-oo-";
				i++;
			}
			else if(rest.indexOf("iu")+i==i) {
				p+="ew-";
				i++;
			}
			else if(rest.indexOf("oi")+i==i) {
				p+="oy-";
				i++;
			}
			else if(rest.indexOf("ui")+i==i) {
				p+="ooey-";
				i++;
			}
			else if(rest.indexOf("a")+i==i) {
				p+="ah-";
				//i++;
			}
			else if(rest.indexOf("e")+i==i) {
				p+="eh-";
				//i++;
			}
			else if(rest.indexOf("i")+i==i) {
				p+="ee-";
				//i++;
			}
			else if(rest.indexOf("o")+i==i) {
				p+="oh-";
				//i++;
			}
			else if(rest.indexOf("u")+i==i) {
				p+="oo-";
				//i++;
			}
			if(rest.indexOf("\'")+i==i) {
		        p=p.substring(0,p.length()-2);
						p+="\'";
						//i++;
					}
			
			
		}
		if(p.charAt(p.length()-1)=='-') {
			p=p.substring(0,p.length()-1);
		}
		return p.substring(0,1).toUpperCase()+p.substring(1,p.length());
	}

}

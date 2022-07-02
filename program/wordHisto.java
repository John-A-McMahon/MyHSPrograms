package program;

import java.util.ArrayList;

public class wordHisto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "William Shakespeare (bapt. 26 April 1564 – 23 April 1616)[a] was an English playwright, poet, and actor, widely regarded as the greatest writer in the English language and the world's greatest dramatist.[2][3][4] He is often called England's national poet and the \"Bard of Avon\" (or simply \"the Bard\").[5][b] His extant works, including collaborations, consist of some 39 plays,[c] 154 sonnets, three long narrative poems, and a few other verses, some of uncertain authorship. His plays have been translated into every major living language and are performed more often than those of any other playwright.[7] They also continue to be studied and reinterpreted.\n"
				+ "\n"
				+ "Shakespeare was born and raised in Stratford-upon-Avon, Warwickshire. At the age of 18, he married Anne Hathaway, with whom he had three children: Susanna and twins Hamnet and Judith. Sometime between 1585 and 1592, he began a successful career in London as an actor, writer, and part-owner of a playing company called the Lord Chamberlain's Men, later known as the King's Men. At age 49 (around 1613), he appears to have retired to Stratford, where he died three years later. Few records of Shakespeare's private life survive; this has stimulated considerable speculation about such matters as his physical appearance, his sexuality, his religious beliefs, and whether the works attributed to him were written by others.[8][9][10]\n"
				+ "\n"
				+ "Shakespeare produced most of his known works between 1589 and 1613.[11][12][d] His early plays were primarily comedies and histories and are regarded as some of the best work produced in these genres. He then wrote mainly tragedies until 1608, among them Hamlet, Romeo and Juliet, Othello, King Lear, and Macbeth, all considered to be among the finest works in the English language.[2][3][4] In the last phase of his life, he wrote tragicomedies (also known as romances) and collaborated with other playwrights.\n"
				+ "\n"
				+ "Many of Shakespeare's plays were published in editions of varying quality and accuracy in his lifetime. However, in 1623, two fellow actors and friends of Shakespeare's, John Heminges and Henry Condell, published a more definitive text known as the First Folio, a posthumous collected edition of Shakespeare's dramatic works that included all but two of his plays.[13] The volume was prefaced with a poem by Ben Jonson, in which Jonson presciently hailed Shakespeare in a now-famous quote as \"not of an age, but for all time\".[13]";
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		String temp=" ";
		char t;
		ArrayList<Character> symbols = new ArrayList<>();
		symbols.add(',');
		symbols.add('.');
		symbols.add('?');
		symbols.add('!');
		symbols.add('*');
		symbols.add(';');
		symbols.add('\'');
		symbols.add('"');
		symbols.add('(');
		symbols.add(')');
		symbols.add('\n');
		
		
		
		
		for(int i=0; i<text.length(); i++) {
			t=text.charAt(i);
			if(symbols.contains(t)) {
				text=text.substring(0, i)+text.substring(i+1);
			}
		}
		
		
		
		String tText=text;
		
		
		
		
		
		
		
		
		
		for(int i=0; i<text.length(); i+=1) {
			if(text.charAt(i)!=' ') {
				tText=text.substring(i);
				if(tText.contains(" ")) {
					temp=tText.substring(0,tText.indexOf(' '));
				}
				else {
					temp=tText.substring(0);
				}
				
				if(!words.contains(temp)) {
					words.add(temp);
					count.add(0);
				}
				
				
				count.set(words.indexOf(temp), count.get(words.indexOf(temp))+1);
				i=text.indexOf(tText)+temp.length();
			}
		}
		
		//System.out.println(words);
		
		for(int i=0; i<words.size(); i++) {
			System.out.println(words.get(i)+": "+count.get(i));
		}

	}

}

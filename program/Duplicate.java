package program;
import java.util.ArrayList;
public class Duplicate{
  
 public static void main(String[] args){
   
  String[] commonWords = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","that","it","he","was","for","with","his","they","I","at","be","this","have","from","that","it","he","was","for","or","one","had","by","word","but","not","do","how","their","what","all","were","we","when","your","can","said","that","it","he","was","for","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","not","what","all","were","we","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"}; 
  //System.out.println(commonWords.length);
  System.out.println(duplicate(commonWords));
  System.out.println("There were "+(commonWords.length-duplicate(commonWords).size())+" duplicate words in the array");
  
   
 }
 public static ArrayList<String> duplicate(String[] commonWords){
	 ArrayList<String> words = new ArrayList<>();
	   for(String word : commonWords) {
		   if(!words.contains(word)) {
			   words.add(word);
		   }
	   }
	   return words;
 }

  
}

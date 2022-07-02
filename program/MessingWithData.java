package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MessingWithData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"));
			
			for(int i=2; i<10; i++) {
				bw.write(i+" "+"\n");
				
			}
			
			
			bw.close();
			
			System.out.println(fileToString("myFile.txt"));
			
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String fileToString(String file) {
		
		String output = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while(reader.ready()) {
				output+=reader.readLine()+"\n";
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return output;
	}

}

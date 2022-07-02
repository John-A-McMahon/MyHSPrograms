package program;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import java.applet.*;
import java.net.*;
public class Magic8Ball {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		//AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        Clip clip;
		try {
			clip = AudioSystem.getClip();
			//clip.open(ais);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//JOptionPane.showMessageDialog(null, "Welcome to magic 8 ball!");
		
		String input = "";
		while (!input.equals("classic") && !input.equals("new")) {
			System.out.println("Which 8 ball do you want to use (classic or new)?");
			input = sc.nextLine();
		}
		if (input.equals("classic")) {

			while (true) {
				System.out.println("type:");
				input = sc.nextLine();
				System.out.println(classic8Ball(input));
			}
		}
		if (input.equals("new")) {
			System.out.println("Rules:");
			System.out.println("use proper grammar");
			System.out.println("Start with question words (who,what,when,where,why,how)");
			while (true) {
				System.out.println("type:");
				input = sc.nextLine();
				if(input.equals("bye")) {
					System.out.println("Bye!");
					break;
				}
				System.out.println(new8Ball(input));
			}
		}

	}

	public static String classic8Ball(String question) {
		String[] possibleResponses = { "As I see it, yes.", "Ask again later.", "Better not tell you now.",
				"Cannot predict now.", "Concentrate and ask again.", "Don’t count on it.", "It is certain.",
				"It is decidedly so.", "Most likely.", "My reply is no.", "My sources say no.", "Outlook not so good.",
				"Outlook good.", "Reply hazy, try again.", "Signs point to yes.", "Very doubtful.", "Without a doubt.",
				"Yes.", "Yes – definitely.", "You may rely on it." };
		return possibleResponses[(int) (Math.random() * possibleResponses.length + 1)];
	}

	public static String new8Ball(String question) {
		// String[] possibleResponses = {"As I see it, yes.","Ask again later.","Better
		// not tell you now.","Cannot predict now.","Concentrate and ask again.","Don’t
		// count on it.","It is certain.","It is decidedly so.","Most likely.","My reply
		// is no.","My sources say no.","Outlook not so good.","Outlook good.","Reply
		// hazy, try again.","Signs point to yes." ,"Very doubtful.","Without a
		// doubt.","Yes.","Yes – definitely.","You may rely on it."};
		// return possibleResponses[(int) (Math.random()*possibleResponses.length+1)];
		String q = question;
		String response = "";
		String[] taunts= {"come on talk to me!","Say something!","Hello?"};
		String[] feeling= {"good","meh","another day..."};
		if(q.length()<2) {
			return taunts[(int)(Math.random()*3)];
		}
		if (q.charAt(q.length() - 1) == '?') {
			q = q.substring(0, q.length() - 1);
		}
		ArrayList<String> words = new ArrayList<>();
		while (q.length() > 0) {
			if (q.indexOf(' ') == -1) {
				words.add(q);
				break;
			}
			words.add(q.substring(0, q.indexOf(' ')));
			q = q.substring(q.indexOf(' ') + 1);

		}
		
		
		if(words.get(0).equals("yes")) {
			return "OK";
		}
		if(words.get(0).equals("no")) {
			return "OK";
		}

		// who
		if (words.size() >= 3 && words.get(0).equalsIgnoreCase("who")) {

			if (words.get(1).equalsIgnoreCase("is")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know who " + response + "is";
			}

			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("you")) {
				return "I am the DLC for the magic 8 ball";
			}
			if (words.get(1).equalsIgnoreCase("are")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know who " + response + "is";
			}
		}
		// what
		if (words.size() >= 4 && words.get(0).equalsIgnoreCase("what")) {
			if (words.get(1).equalsIgnoreCase("is") && words.get(2).equalsIgnoreCase("your")
					&& words.get(3).equalsIgnoreCase("name")) {
				return "My name is 8-ball";
			}
			if (words.get(1).equalsIgnoreCase("is")
					&& (words.get(3).equalsIgnoreCase("divided") || words.get(3).equalsIgnoreCase("times")
							|| words.get(3).equalsIgnoreCase("plus") || words.get(3).equalsIgnoreCase("minus"))) {
				return "How about you use a calculator";
			}
			if (words.get(1).equalsIgnoreCase("is") && words.get(2).equalsIgnoreCase("a")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know what " + response + "is";
			}
			if (words.get(1).equalsIgnoreCase("are")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know what " + response + "are";
			}

		}

		
		if (words.size() >= 3 && words.get(0).equalsIgnoreCase("where")) {
			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("you")) {
				return "I am in your computer";
			}
			if (words.get(1).equalsIgnoreCase("is") ) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know where " + response + "is";
			}
			if (words.get(1).equalsIgnoreCase("are") ) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know where " + response + "are";
			}
			
		}
		
		// when
		if (words.size() >= 4 && words.get(0).equalsIgnoreCase("when")) {
			if (words.get(1).equalsIgnoreCase("should") && words.get(2).equalsIgnoreCase("I")) {
				for (int i = 3; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "IDK when you should "+response;
			}
			if (words.get(1).equalsIgnoreCase("are")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know when " + response + "are";
			}
			if (words.get(1).equalsIgnoreCase("is")) {
				for (int i = 2; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know when " + response + " is";
			}
		}

		// why
		if (words.size() >= 4 && words.get(0).equalsIgnoreCase("why")) {
			if (words.get(1).equalsIgnoreCase("am")) {
				return "Because you are a " + words.get(3) + " person.";
			}
			if (words.get(1).equalsIgnoreCase("should") && words.get(2).equalsIgnoreCase("I")) {
				return "Because you should.";
			}
			if (words.get(1).equalsIgnoreCase("did") && words.get(2).equalsIgnoreCase("you")) {
				return "That does not matter";
			}
			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("you")) {
				return "Are you saying that I am " + words.get(3) + "?";
			}
			if (words.get(1).equalsIgnoreCase("is") && words.get(2).equalsIgnoreCase("he")) {
				return "Maybe you should ask him why " + words.get(2) + " is like that?";
			}
			if (words.get(1).equalsIgnoreCase("is") && words.get(2).equalsIgnoreCase("she")) {
				return "Maybe you should ask her why " + words.get(2) + " is like that?";
			}
			if (words.get(1).equalsIgnoreCase("is") && words.get(2).equalsIgnoreCase("it")) {
				return "Maybe you should ask it why " + words.get(2) + " is like that?";
			}
			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("they")) {
				return "Why don't you ask them " + "?";
			}
			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("we")) {
				return "Shouldn't you know that " + "?";
			}
		}
		if (words.size() >= 3 && words.get(0).equalsIgnoreCase("how")) {
			if (words.get(1).equalsIgnoreCase("are") && words.get(2).equalsIgnoreCase("you")) {
				return "I am "+feeling[(int)(Math.random()*3)];
			}
			if (words.get(1).equalsIgnoreCase("am") && words.get(2).equalsIgnoreCase("I")) {
				return "You should know that!";
			}
			if (words.get(1).equalsIgnoreCase("old") && words.get(2).equalsIgnoreCase("are")) {
				return "How RUDE!";
			}
			if (words.get(1).equalsIgnoreCase("do") && words.get(2).equalsIgnoreCase("I")) {
				for (int i = 3; i < words.size(); i++) {
					response += words.get(i) + " ";
				}
				return "I do not know how to " + response + "";
			}
		}

		if(Math.random()<0.9) {
			return words.get(0) + "!";
		}
		else {
			return classic8Ball(question);
		}
	}

}

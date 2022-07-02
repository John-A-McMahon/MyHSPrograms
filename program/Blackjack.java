package program;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
public class Blackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean showStory=false;
		boolean playForChips=false;
		
		String move = "";
		boolean playerBusted = false;
		boolean dealerBusted = false;
		int bet = 0;
		int wallet = 100;
		String name = "";
		String keepPlaying = "";
		String response = "";
		String payTaxes = "";
		
		
		
		
		Scanner sc = new Scanner(System.in);
		if(showStory) {
			System.out.println("Welcome to blackjack!");
			System.out.println("What is your name?");
			name = sc.nextLine();
			
			if(name.equals("")) {
				System.out.println("OK stranger");
				name = "Stranger";
			}
		}
		else {
			name="player";
		}
		
		
		
		
		boolean playing = true;
		
		while (playing) {
		playerBusted = false;
		dealerBusted = false;
		response = "";
			
		if(playForChips) {
			System.out.println("How much are you betting?");
			bet = 0;
			while(bet<=0) {
				System.out.println("Wallet:"+wallet+" potato chips in wallet");
				bet = sc.nextInt();
				if(bet==0) {
					System.out.println("Come on! dont be a cheapscate!");
				}
				else if(bet<0) {
					System.out.println("invalid bet");
				}
			}
		}
		
		
		
		
		ArrayList<Integer> cards = new ArrayList<>();
		for(int i = 1; i<53; i++) {
			cards.add(i%13+1);
		}
		ArrayList<Integer> dealerHand = new ArrayList<>();
		
		ArrayList<Integer> playerHand = new ArrayList<>();
		
		ArrayList<Integer> secondPlayerHand = new ArrayList<>();
		
		//dealers cards
		dealerHand.add(cards.get((int)(Math.random()*51+1)));
		cards.remove(cards.indexOf(dealerHand.get(0)));
		dealerHand.add(cards.get((int)(Math.random()*50+1)));
		cards.remove(cards.indexOf(dealerHand.get(1)));
		
		
		
		//your cards
		playerHand.add(cards.get((int)(Math.random()*cards.size()+1)));
		cards.remove(cards.indexOf(playerHand.get(0)));
		
		playerHand.add(cards.get((int)(Math.random()*cards.size()+1)));
		cards.remove(cards.indexOf(playerHand.get(1)));
		
		
		
		showHand(dealerHand,"one","Dealer");
		showHand(playerHand,"all",name);
		
		do {
		System.out.println("What will you do?");
		move = sc.nextLine();
		if(playerHand.size()==2&&move.equals("surrender")) {
			
			System.out.println(name+" Surrendered");
			break;
		}
		
		//split
		if(playerHand.size()==2&&playerHand.get(0)==playerHand.get(1)&&move.equals("split")&&bet*2<=wallet) {
			
			
			playerHand.add(cards.get((int)(Math.random()*cards.size()+0)));
			cards.remove(cards.indexOf(playerHand.get(playerHand.size()-1)));
			
			playerHand.add(cards.get((int)(Math.random()*cards.size()+0)));
			cards.remove(cards.indexOf(playerHand.get(playerHand.size()-1)));
			
			
			secondPlayerHand.add(playerHand.get(0));
			playerHand.remove(0);
			secondPlayerHand.add(playerHand.get(1));
			playerHand.remove(1);
			
			showHand(playerHand,"all",name);
			showHand(secondPlayerHand,"all",name+"(split hand)");
			
			
		}
		
		if(move.equals("hit")) {
			playerHand.add(cards.get((int)(Math.random()*cards.size()+0)));
			cards.remove(cards.indexOf(playerHand.get(playerHand.size()-1)));
			showHand(playerHand,"all","Player");
			if(handSum(playerHand)>21) {
				playerBusted = true;
				break;
			}
		}
		if(move.equals("double")&&bet*2<=wallet) {
			bet*=2;
			System.out.println(name+" doubled bet to "+bet);
			playerHand.add(cards.get((int)(Math.random()*cards.size()+0)));
			cards.remove(cards.indexOf(playerHand.get(playerHand.size()-1)));
			showHand(playerHand,"all","Player");
			if(handSum(playerHand)>21) {
				playerBusted = true;
				break;
			}
			break;
		}
		}
		while(!move.equals("stand"));
		
		if(move.equals("surrender")) {
			wallet-=bet/2;
			//continue;
			
		}
		else {
		
		System.out.println();
		if(move.equals("stand")||move.equals("double")) {
			showHand(dealerHand,"all","Dealer");
			while(handSum(dealerHand)<16) {
				System.out.println("Dealer hit!");
				dealerHand.add(cards.get((int)(Math.random()*cards.size()+0)));
				cards.remove(cards.indexOf(dealerHand.get(dealerHand.size()-1)));
				showHand(dealerHand,"all","Dealer");
			}
			if(handSum(dealerHand)>21) {
				dealerBusted = true;
			}
		}
		
		if(playerBusted) {
			System.out.println(name+" BUSTED!, "+name+" lost");
			wallet-=bet;
		}
		else if(dealerBusted) {
			System.out.println("Dealer BUSTED!, "+name+" won");
			wallet+=bet;
		}
		else if(21-handSum(dealerHand)<21-handSum(playerHand)) {
			System.out.println("DEALER WAS CLOSER TO 21!, "+name+" lost");
			wallet-=bet;
		}
		else if(21-handSum(dealerHand)>21-handSum(playerHand)) {
			System.out.println(name+" Was CLOSER TO 21!, "+name+" won");
			wallet+=bet;
		}
		else if(((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
				|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
				&& !((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
						|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
			System.out.println(name+" got a BLACKJACK");
			System.out.println(name+" won");
			wallet+=(bet*3)/2;
		}
		else if(!((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
				|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
				&& ((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
						|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
			System.out.println("Dealer got a BLACKJACK");
			wallet-=(bet*3)/2;
			
		}
		else {
			System.out.println("PUSH");
		}
		
		}
		
		
		
		
		
		//split hand
		if(secondPlayerHand.size()==2) {
			
			
			
			if(dealerBusted) {
				System.out.println("Dealer BUSTED!, "+name+" won");
				wallet+=bet;
			}
			else if(21-handSum(dealerHand)<21-handSum(playerHand)) {
				System.out.println("DEALER WAS CLOSER TO 21!, "+name+" lost");
				wallet-=bet;
			}
			else if(21-handSum(dealerHand)>21-handSum(playerHand)) {
				System.out.println(name+" Was CLOSER TO 21!, "+name+" won");
				wallet+=bet;
			}
			else if(((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
					|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
					&& !((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
							|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
				System.out.println(name+" got a BLACKJACK");
				System.out.println(name+" won");
				wallet+=(bet*3)/2;
			}
			else if(!((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
					|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
					&& ((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
							|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
				System.out.println("Dealer got a BLACKJACK");
				wallet+=(bet*3)/2;
			}
			else {
				System.out.println("PUSH");
			}
		}
		
		
		
		System.out.println("Do you want to play again (y or n)");
		do {
			keepPlaying = sc.nextLine();
		}
		while(!keepPlaying.equals("y")&&!keepPlaying.equals("n"));
			
		
		if(keepPlaying.equals("y")) {
			continue;
		}
		if(keepPlaying.equals("n")) {
			break;
		}
		
		
		
		
		}
		if(showStory) {
			if(wallet==0) {
				System.out.println(name+"wasted all of his potato chips on blackjack and was kicked out.");
			}
			if(wallet==100) {
				System.out.println(name+"broke even and had an OK time");
			}
			if(wallet>100) {
				System.out.println(name+" made a profit! will "+name+" pay taxes?");
				while(!payTaxes.equals("y")&&!payTaxes.equals("n")) {
					payTaxes = sc.nextLine();
				}
				if(payTaxes.equals("y")) {
					wallet = (int) (wallet - (wallet-100)*0.2);
					System.out.println(name+" walked away with "+wallet+" potato chips");
				}
				if(payTaxes.equals("n")) {
					System.out.println(name+" was arrested for tax evasion");
				}
			}
		}
		
		

	}
	
	public static void showHand(ArrayList<Integer> hand,String s,String name) {
		if(s.equals("one")) {
			if(hand.get(0)==1) {
				System.out.println(name+"'s hand:A");
			}
			else if(hand.get(0)>1&&hand.get(0)<11) {
				System.out.println(name+"'s hand:"+hand.get(0));
			}
			else if(hand.get(0)>10) {
				if(hand.get(0)==11) {
					System.out.println(name+"'s hand:J");
				}
				if(hand.get(0)==12) {
					System.out.println(name+"'s hand:Q");
				}
				if(hand.get(0)==13) {
					System.out.println(name+"'s hand:K");
				}
				
			}
		}
		
		
		if(s.equals("all")) {
			System.out.print(name+"'s hand:");
			for(int i = 0; i<hand.size(); i++) {
				if(hand.get(i)==1) {
					System.out.print("A ");
				}
				else if(hand.get(i)>1&&hand.get(i)<11) {
					System.out.print(hand.get(i)+" ");
				}
				else if(hand.get(i)>10) {
					if(hand.get(i)==11) {
						System.out.print("J ");
					}
					if(hand.get(i)==12) {
						System.out.print("Q ");
					}
					if(hand.get(i)==13) {
						System.out.print("K ");
					}
					
				}
			}
			
		}
	}
		
	public static int handSum(ArrayList<Integer> hand) {
		int sum = 0;
		if(!hand.contains(1)) {
			for(int i = 0; i<hand.size(); i++) {
				if(hand.get(i)>10) {
					sum+=10;
				}
				else {
					sum+=hand.get(i);
				}
				
			}
			return sum;
		}
		else {
			int numAces=0;
			for(int i = 0; i<hand.size(); i++) {
				if(hand.get(i)>10) {
					sum+=10;
				}
				else if(hand.get(i)==1) {
					numAces++;
				}
				else {
					sum+=hand.get(i);
				}
			}
			for(int i=0; i<numAces; i++) {
				if(sum<11) {
					sum+=11;
					}
				else {
					sum+=1;
				}
				}
			}
			
		return sum;
		
		
	}
	
	}



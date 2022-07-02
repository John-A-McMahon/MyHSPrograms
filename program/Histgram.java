package program;
import java.lang.Math;
public class Histgram {
public static void main(String[] args) {
	//int[] coins = flipCoins(1000);
	int[] dice = rollDice(10);
	//printMe(dice);
	int[] h = histo(dice);
	
	
	
	System.out.println(sumDice(h));
	//System.out.println("heads: "+histo(dice)[0]+" tails:"+histo(dice)[1]);
}

public static int sumDice(int[] h) {
int sum = 0;
	
	sum+=h[0];
	sum+=h[1]*2;
	sum+=h[2]*3;
	sum+=h[3]*4;
	sum+=h[4]*5;
	sum+=h[5]*6;
	return sum;
}
public static void printMe(int[] nums) {
	for (int n : nums) {
		System.out.println(n);
	}
}
public static int[] histo(int[] nums) {
	int[] h = {0,0,0,0,0,0};
	for (int n : nums) {
		if(n==0) {
			h[0]++;
		}
		if(n==1) {
			h[1]++;
		}
		if(n==2) {
			h[2]++;
		}
		if(n==3) {
			h[3]++;
		}
		if(n==4) {
			h[4]++;
		}
		if(n==5) {
			h[5]++;
		}
	}
	return h;
}
public static int[] flipCoins(int n) {
	int[] coins = new int[n];
	for (int i = 0; i<n-1; i++) {
		if(Math.random()*2>=1) {
			coins[i]=1;
		}else {
			coins[i]=0;
		}
	}
	return coins;
}
public static int[] rollDice(int n) {
	int[] rolls = new int[n];
	for (int i = 0; i<n-1; i++) {
		rolls[i] =(int) (Math.random()*6+1);
	}
	return rolls;
}

}

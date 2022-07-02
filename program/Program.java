package program;

import java.lang.Math;
import java.lang.Math;
import java.util.Scanner;

public class Program {

	public static void println(String text) {
		System.out.println(text);
	}

	public static void println(int text) {
		System.out.println(text);
	}

	public static void println(char text) {
		System.out.println(text);
	}

	public static void println(double text) {
		System.out.println(text);
	}

	public static void printOdd(int n) {
		if (n == 0) {

		} else if ((n % 10) % 2 == 0) {
			// System.out.println(n%10);
			printOdd(n / 10);
		} else {
			System.out.println(n % 10);
			printOdd(n / 10);
		}

	}

	public static String season(int month, int day) {
		if (month > 12 || day > 31 || month < 1 || day < 1) {
			return "You clearly dont know how to calandar";
		}
		if (month < 3 || (month == 3 && day <= 15) || (month == 12 && day >= 16)) {
			return month + "/" + day + " is winter";
		}
		if (month < 6 || (month == 6 && day <= 15)) {
			return month + "/" + day + " is spring";
		}
		if (month < 9 || (month == 9 && day <= 15)) {
			return month + "/" + day + " is summer";
		} else {
			return month + "/" + day + " is fall";
		}
	}

	public static int maxOf(int a, int b) {
		if (a < b) {
			return b;
		}
		if (a > b) {
			return a;
		} else {
			return 0;
		}
	}

	public static boolean larger(double a, double b) {
		return a > b;
	}

	public static boolean evenlyDivisible(int a, int b) {
		return (a % b) == 0 || (b % a) == 0;
	}

	public static void threeHeads() {
		int coin1 = (int) (Math.random() * 2 + 1);
		int coin2 = (int) (Math.random() * 2 + 1);
		int coin3 = (int) (Math.random() * 2 + 1);
		while (coin1 != 1 && coin2 != 1 && coin3 != 1) {
			coin1 = (int) (Math.random() * 2 + 1);
			coin2 = (int) (Math.random() * 2 + 1);
			coin3 = (int) (Math.random() * 2 + 1);

			System.out.println(coin1 + " " + coin2 + " " + coin3);

		}
	}

	public static void clearConsole() {
		System.out.flush();
	}

	public static char[][] pathfinder(char[][] map) {
		int x = 0;
		int y = 0;
		int playerX = x;
		int playerY = y;
		int goalX = x;
		int goalY = y;
		String instruction = "";
		for (char[] a : map) {
			x = 0;
			for (char c : a) {
				if (c == 'p') {
					playerX = x;
					playerY = y;
				}
				if (c == 'x') {
					goalX = x;
					goalY = y;
				}
				// System.out.print(c);
				x++;
			}
			y++;

		}
		if (playerX < goalX && map[playerY][playerX + 1] != 't') {
			instruction = "right";
		}
		if (playerX > goalX && map[playerY][playerX - 1] != 't') {
			instruction = "left";
		}
		if (playerY < goalY && map[playerY + 1][playerX] != 't') {
			instruction = "down";
		}
		if (playerY > goalY && map[playerY - 1][playerX] != 't') {
			instruction = "up";
		}

		if ((playerX + 1 <= map.length && map[playerY][playerX + 1] == 't')
				&& (playerX - 1 >= 0 && map[playerY][playerX - 1] == 't')
				&& (playerY + 1 < map.length && map[playerY + 1][playerX] == 't')) {
instruction = "up";
		}
		if ((playerX + 1 <= map.length && map[playerY][playerX + 1] == 't')
				&& (playerX - 1 >= 0 && map[playerY][playerX - 1] == 't')
				&& (playerY - 1 >= 0 && map[playerY - 1][playerX] == 't')) {
			instruction="down";
		}
		if ((playerX + 1 <= map.length && map[playerY][playerX + 1] == 't')
				&& (playerX - 1 >= 0 && map[playerY][playerX - 1] == 't')
				&& (playerY - 1 >= 0 && map[playerY - 1][playerX] == 't')) {
			instruction="down";
		}

		if (instruction.equals("up")) {

			if ((playerX + 1 < map.length && map[playerY][playerX + 1] == 't')
					&& (playerX - 1 >= 0 && map[playerY][playerX - 1] == 't')
					&& (playerY + 1 < map.length && map[playerY + 1][playerX] == 't')) {
				map[playerY][playerX] = 't';
			} else {
				map[playerY][playerX] = ' ';
			}

			map[playerY - 1][playerX] = 'p';

		}
		if (instruction.equals("down")) {
			if ((playerX + 1 < map.length && map[playerY][playerX + 1] == 't')
					&& (playerX - 1 >= 0 && map[playerY][playerX - 1] == 't')
					&& (playerY - 1 >= 0 && map[playerY - 1][playerX] == 't')) {
				map[playerY][playerX] = 't';
			} else {
				map[playerY][playerX] = ' ';
			}
			map[playerY + 1][playerX] = 'p';

		}
		if (instruction.equals("left")) {
			if (true) {
				map[playerY][playerX] = 't';
			} else {
				map[playerY][playerX] = ' ';
			}
			map[playerY][playerX + 1] = 'p';

		}
		if (instruction.equals("right")) {
			if (true) {
				map[playerY][playerX] = 't';
			} else {
				map[playerY][playerX] = ' ';
			}
			map[playerY][playerX + 1] = 'p';

		}
		System.out.println(instruction+" hi");

		return map;
		// System.out.println(playerX + " " + playerY);
	}

	public static int longestSortedSequence(int[] x){
	    int t=1;
	    int longest=0;
	    for(int i=0; i<x.length; i++){
	        t=1;
	        while(i+t<x.length&&x[i+t-1]<=x[i+t]){
	        	
	            t++;
	        }
	        
	        
	        if(t>longest){
	        	
	            longest=t;
	            if(t==7) {
	        		System.out.print(x[i]+" "+x[i+1]+" "+x[i+2]+" "+x[i+3]+" "+x[i+4]);
	        	}
	            
	        }
	        
	    }
	    return longest;

	}
	
	public static void main(String[] args) {
		
		
		int[] x = {3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12};
		System.out.println(" \n"+longestSortedSequence(x));
		
		
		
		String nextStep = "";
		Scanner sc = new Scanner(System.in);

		char[][] forest = { 
				{ ' ', ' ', 'x', ' ' },
				{ 't', 't', ' ', ' ' },
				{ 't', 'p', 't', ' ' },
				{ ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ' } };
		while (!nextStep.equals("stop")) {
			for (char[] a : forest) {
				for (char c : a) {
					System.out.print(c);
				}
				System.out.println();
			}

			System.out.println("type stop to end, go to continue");
			nextStep = sc.nextLine();
			if (nextStep.equals("go")) {
				forest = pathfinder(forest);
				
			}
			//clearConsole();
			GUI gui = new GUI(0,0,500,500);
		}

	}

}

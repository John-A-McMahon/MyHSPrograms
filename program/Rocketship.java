package program;

import java.util.Scanner;

public class Rocketship {
	public static void draw(char[][] drawing) {
		for (char[] a : drawing) {
			for (char c : a) {
				System.out.print(c);
			}
			System.out.println();

		}
	}

	public static void triangle(int scale) {
		String base = "**";
		for (int i = 0; i < scale - 2 - (scale / 14); i++) {
			base = "/" + base + "\\";
			for (int s = 0; s < scale - i - 2 - (scale / 14); s++) {
				base = " " + base;
			}
			System.out.println(base);
			base = base.replace(" ", "");
		}
	}

	public static void border(int scale) {
		String spacing = multiplyStrings(" ", scale / 2 - 1);
		String base = "*=";
		for (int i = 0; i < (scale - 3) / 2; i += 1) {

			base = "" + base + "";
			if (base.substring(0, 1).equals("*")) {
				base = "=" + base + "*";
			} else if (base.substring(0, 1).equals("=")) {
				base = "*" + base + "=";
			}

		}

		System.out.println(spacing + "+" + base + "+");
		// System.out.println(base.length()+2);

	}

	public static String multiplyStrings(String str, int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + str;
		}
		return s;
	}

	public static void bodyTop(int scale) {
		String spacing = multiplyStrings(" ", scale / 2 - 1);
		scale = (scale) / 12;
		String up = multiplyStrings("/\\", scale);
		String dot = multiplyStrings(".", scale);
		// String base = "";
		for (int i = 0; i < scale; i++) {
			System.out.print(spacing+"|");
			for (int p = 0; p<1;p++) {
				System.out.print(multiplyStrings(dot,2));
				System.out.print(up);
				System.out.print(multiplyStrings(dot,4));
				System.out.print(up);
				System.out.print(multiplyStrings(dot,2));
			}
			System.out.print("|");
			System.out.println();
			
			
			
			System.out.print(spacing+"|"+dot);
			for (int p = 0; p<1;p++) {
				System.out.print(up);
				System.out.print(up);
				System.out.print(dot);
				System.out.print(dot);
				System.out.print(up);
				System.out.print(up);
			}
			System.out.print(dot+"|");
			System.out.println();
			
			System.out.print(spacing+"|");
			for (int p = 0; p<6;p++) {
				System.out.print(up);
			}
			System.out.print("|");
			System.out.println();
			
			//System.out.println(spacing + "|" + dot + dot + up + dot + dot + dot + dot + up + dot + dot + "|");
			//System.out.println(spacing + "|" + dot + up + up + dot + dot + up + up + dot + "|");
			//System.out.println(spacing + "|" + up + up + up + up + up + up + "|");
		}
		// System.out.println(("|"+dot+dot+up+dot+dot+dot+dot+up+dot+dot+"|").length());
		// System.out.println("../\\..../\\..");
	}

	public static void bodyBottom(int scale) {
		String spacing = multiplyStrings(" ", scale / 2 - 1);

		scale = (scale) / 12;
		String down = multiplyStrings("\\/", scale);
		String dot = multiplyStrings(".", scale);
		String base = "";
		for (int i = 0; i < scale; i++) {
			System.out.print(spacing+"|");
			for (int p = 0; p<6;p++) {
				System.out.print(down);
			}
			System.out.print("|");
			System.out.println();
			
			System.out.print(spacing+"|"+dot);
			for (int p = 0; p<1;p++) {
				System.out.print(down);
				System.out.print(down);
				System.out.print(dot);
				System.out.print(dot);
				System.out.print(down);
				System.out.print(down);
			}
			System.out.print(dot+"|");
			System.out.println();
			
			System.out.print(spacing+"|");
			for (int p = 0; p<1;p++) {
				System.out.print(multiplyStrings(dot,2));
				System.out.print(down);
				System.out.print(multiplyStrings(dot,4));
				System.out.print(down);
				System.out.print(multiplyStrings(dot,2));
			}
			System.out.print("|");
			System.out.println();
			//System.out.println(spacing + "|" + down + down + down + down + down + down + "|");
			//System.out.println(spacing + "|" + dot + down + down + dot + dot + down + down + dot + "|");
			//System.out.println(spacing + "|" + dot + dot + down + dot + dot + dot + dot + down + dot + dot + "|");
		}

		// System.out.println("../\\..../\\..");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("how big do you want the rocket?");
		//System.out.println("pick a number between 1 and 5 (1 smallest 5 biggest):");
		int size = sc.nextInt();
		int scale = 0;
		scale = 12*size+2;
		char[] rocket = { 
				't',
				'b',
				'u',
				'd',
				'b',
				'd',
				'u',
				'b',
				't' };
		for (int i = 0; i < rocket.length; i++) {
			if (rocket[i] == 't') {
				triangle(scale);
			}
			if (rocket[i] == 'b') {
				border(scale);
			}
			if (rocket[i] == 'u') {
				bodyTop(scale);
			}
			if (rocket[i] == 'd') {
				bodyBottom(scale);
			}

		}
		// System.out.println(border(scale).length());
		// +=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *=*=*
		// =*=*= *=*+
		// +=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *=*=* =*=*= *+

	}
}

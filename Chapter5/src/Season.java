import java.util.Scanner;

public class Season {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] months = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		System.out.println("What month? (respond as a number)");
		int month = sc.nextInt();
		System.out.println("What day?");
		int day = sc.nextInt();
		if ((day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
				|| (day > 29 && month == 2) || (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))
				|| month > 12||month<1||day<1) {
			System.out.println("You clearly dont know how a calendar works!");

		} else {
			System.out.print(months[month - 1] + ", " + day + "th "+"("+month+"/"+day+")"+  " is in the ");
			System.out.print(season(month, day));
			if (month == 2 && day == 29) {
				System.out.println(" (happy leap year btw)");
			}
		}
	}

	public static String season(int month, int day) {
		if (month < 3 || (month == 3 && day <= 15) || (month == 12 && day >= 16)) {
			return "winter";
		} else if (month < 6 || (month == 6 && day <= 15)) {
			return "spring";
		} else if (month < 9 || (month == 6 && day >= 16)) {
			return "summer";
		} else {
			return "fall";
		}
	}
}

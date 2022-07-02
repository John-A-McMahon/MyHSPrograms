package program;

public class WarmUp {
public static void main(String[] args) {
	System.out.print(power(2,3));
}
public static int power(int num, int p) {
	if (p==0) {
		return 1;
	}
	if (p==1) {
		return num;
	}
	else {
		return num*power(num,p-1);
	}
}
}

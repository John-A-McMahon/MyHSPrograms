import java.lang.Math;
public class ThinkLines {
public static void main(String[] args) {
	System.out.println(slope(0,0,0,2));
	System.out.println((double) 3/2);
}
public static boolean hasMidpoint(int a,int b,int c) {
	int min = Math.min(Math.min(a, b), c);
	int max = Math.max(Math.max(a, b), c);
	if (min==a&&max==c) {
		return (a+c)/2.0==b;
	}
	else if (min==b&&max==a) {
		return (b+a)/2.0==c;
	}
	else {
		return (c+b)/2.0==a;
	}
}
public static double slope(int x1, int y1, int x2,int y2) {
	if(x1-x2!=0) {
		return (double)(y1-y2)/(x1-x2);
	}
	else {
		return 0;
	}
}

}

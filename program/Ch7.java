package program;
import java.util.Scanner;
import java.lang.Math;
public class Ch7 {
public static void main(String[] args) {
	//System.out.println(squareRoot(9));
	//System.out.println(power(5,3));
	//System.out.println(factorial(4));
	//System.out.println(myexp(10,10));
	
	//check(1);
	//System.out.println(gauss(1,10));
	
}

public static double squareRootI(double num) {
	Scanner sc = new Scanner(System.in);
	System.out.println("What is your guess at the square root of 9?");
	double guess = sc.nextDouble();
	System.out.println("How percise?");
	int p = sc.nextInt();
	int i = 0;
	double x = 0;
	while (i<p) {
		x=(guess+num/guess)/2;
		i++;
	}
	return x;
}
public static double squareRoot(double num) {
	//.num.Scanner sc = new Scanner(System.in);
	//ystem.out.println("What is your guess at the square root of 9?");
	double guess = num/2;
	//System.out.println("How percise?");
	
	int i = 0;
	double x = guess;
	while (x-Math.sqrt(num)>0.001) {
		System.out.println(x);
		x=(guess+num/guess)/2;
		guess=x;
		//i++;
	}
	return x;
}

public static double power(double num, int exp) {
	if (exp==0) {
		return 1;
	}
	while (exp>1&&exp>0) {
		num=num*num;
		exp-=1;
	}
	return num;
}
public static double factorial(double num) {
	double n = num;
	while (n>1&&num>0) {
		n=n-1;
		num=num*(n);
		
	}
	return num;
}
public static double myexp(double x, double n) {
	int i =1;
	double nn = n;
	double e = 1;
	while (i<nn) {
		
		
		//e= e+power(x,i)/factorial(n);
		
		e=e+x/n;
		x=x*x;
		n=n*(nn-i);
		i++;
	}
	return e;
}
public static void check(double x) {
	System.out.println(x+" "+myexp(10,10)+" "+Math.exp(1));
}

public static double gauss(double x, double n) {
	int i = 0;
	double sum = 0;
	while (i<n) {
		if (i==0) {
			sum = sum +1;
		}
		if (i%2==0) {
			sum = sum -x*(x*x)/(n*(n-i));
		}
		else {
			sum = sum+ x*(x*x)/(n*(n-i));
		}
		
		i++;
	}
	return sum;
}

}

package program;
import java.lang.Object;
import java.math.BigInteger;
import java.util.function.Function;

public class Review implements Function{
public static void main(String[] args) {
	BigInteger num=BigInteger.valueOf(50);
	//System.out.println(factorial(num));
	
	//System.out.println(sumDigits("101"));
	
	String s;
	int scale=10000000;
	int x = 0;
	//diff(Math.sin(x^2),x,2);
	//System.out.println(Math.pow(1,10));
	
	//System.out.println((17-13)*(17-13));
	//System.out.println(sumDigits(factorial(BigInteger.valueOf(103)).toString()));
	
	
	for(int i=0; i<10000; i++) {
		
		if((i*i)%10==7) {
			System.out.println(i);
		}
		
	}
	
	
	
	boolean root = false;
	long lastTime=System.currentTimeMillis();
	for(int i=0; i<scale; i++) {
		root = false;
		if(!(i%10==3||i%10==7)&&i%2!=i/10%2&&((i*i)%10==1||(i*i)%10==9)) {
			for(int e=2; e<=(Math.log(i)/Math.log(2))*Math.log(i); e++) {
				//System.out.println(Math.pow(i, 1.0/e));
				if(Math.pow(i, 1.0/e)%1==0||i%e==0) {
					root = true;
					//System.out.println(i);
				}
			}
			if(!root) {
				//System.out.println(i+" "+isPrime(i));
			}
			
		}
	}
	
	long myTime=System.currentTimeMillis()-lastTime;
	System.out.println(myTime);
	//System.out.println(System.currentTimeMillis()-lastTime+"\n\n\n");
	
	
	
	lastTime=System.currentTimeMillis();
	for(int i=0; i<scale; i++) {
		if(isPrime(i)) {
			//System.out.println(i+" "+isPrime(i));
		}
	}
	long nTime=System.currentTimeMillis()-lastTime;
	
	
	
	System.out.println("My time "+myTime);
	System.out.println("Normal time "+nTime);
	
	//System.out.println(System.currentTimeMillis()-lastTime+"\n\n\n");
	
}

public static BigInteger factorial(BigInteger n) {
	if(n.equals(BigInteger.ONE)) {
		return BigInteger.ONE;
	}
	return n.multiply(factorial(n.subtract(BigInteger.ONE)));
}




public static int sumDigits(String num) {
	if(num.length()==1) {
		return Integer.valueOf(num);
	}
	return Integer.valueOf(num.substring(0,1))+sumDigits(num.substring(1));
}


public static boolean isPrime(int n) {
	for(int i=2; i<=Math.sqrt(n); i++) {
		if(n%i==0) {
			return false;
		}
	}
	return true;
}

@Override
public Object apply(Object t) {
	// TODO Auto-generated method stub
	return null;
}



}

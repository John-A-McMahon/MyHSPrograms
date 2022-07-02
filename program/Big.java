package program;
import java.math.BigInteger;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;
import java.math.BigDecimal;
//import javafx.stage.Stage;


public class Big{
	
	
	public static void sort(int[] a) {
		   int maxCompare = a.length - 1;
		   int savedIndex = 0;
		   int numSteps = 0;
		   int temp = 0;

		   for (int i = maxCompare; i > 0; i--) {
		      savedIndex = i;
		            for (int j = i-1; j >= 0; j--) {
		            	if (a [ j ] > a[savedIndex]) { savedIndex = j; }
		      }

		      temp = a[i];
		      a[i] = a[savedIndex];
		      a[savedIndex] = temp;
		      
		   }
		   
		   System.out.println(a[1]);
		}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BigInteger x = new BigInteger("2147483649");
//		//int[] y= {0,1,2};

//		a aa=new a();
		//ArrayList abb= (ArrayList) aa;
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.set(1, "c");
		list1.add(2, "d");
		list1.set(2, "e");
		list1.add("g");
		System.out.println(list1);

		int[] n= {0,1,2,3,4,5,6,7};
		
		ImprovedIntArray iA= new ImprovedIntArray(n);
		System.out.println(iA.get(1));
		BigInteger num = BigInteger.valueOf(4);
		System.out.println(num.pow(4).pow(4).pow(4).pow(4));
		
		
		BigDecimal PI= BigDecimal.valueOf(Math.PI);
		BigDecimal ONE= BigDecimal.valueOf(1);
		//System.out.println(ONE.divide(BigDecimal.valueOf(3)));
		System.out.println(PI.pow(3).pow(3).pow(3).pow(3));
		
		
		
		num=num.pow(4).pow(7);
		
		long longN= num.longValue();
		System.out.println(longN);
		
		long oldValue=0;
		for(int i=1; i<1000000; i+=1) {
			
			if(addFactors(i)==i) {
				System.out.println(i);
			}
			
				
				
			
		}
		
		Fraction f= new Fraction(4,8);
		System.out.println(f);
		
	}
	
	
	
	public static boolean isPrime(long n) {
		for(int i=2; i<n; i++) {
			
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public static int  addFactors(int n) {
		int sum=0;
		for(int i=1; i<n; i++) {
			
			if(n%i==0) {
				sum+=i;
			}
		}
		
		return sum;
	}




	

}

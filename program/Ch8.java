package program;
import java.lang.Math;
public class Ch8 {
public static void main(String[] args) {
	//powArray::
	double array[] = {0.0,1.0,2.0,3.0};
	double[] a = powArray(array,3);
	printDoubleElements(a);
	//0.0,1.0,16.0,81.0
	
	System.out.println("Histogram of 100 scores sequentialy:");
	
	int[] scores = new int[100];
	for (int i=0;i<100;i++) {
		scores[i]=(int) (100*Math.random()+1);
	}
	printIntElements(histogram(scores));
	
	
	System.out.println("\n\n\n");
	System.out.println("index of max:");
	
	
	
	
	int intArray[] = {1,4,3,7};
	System.out.println(indexOfMax(intArray));
	//3
	
	System.out.println("\n\n\n");
	System.out.println("sieve:");
	printBooleanElements(sieve(intArray));
	//t,f,t,t
	
	System.out.println("\n\n\n");
	System.out.println("Are factors:");
	int[] x = {12,18,30};
	int[] y = {11,18,30};
	
	System.out.println(areFactors(x,6));//true
	System.out.println(areFactors(y,6));//false
	
	System.out.println("\n\n\n");
	System.out.println("Are prime factors:");
	
	
	int[] primeArray= {1,2,3,5,7,11};
	System.out.println(arePrimeFactors(primeArray,2310));//true
	System.out.println(arePrimeFactors(primeArray,21));//false
	
	
	System.out.println("\n\n\n");
	System.out.println("Max in range:");
	System.out.println(maxInRange(0,3,primeArray));//3
	System.out.println(maxInRange(2,4,primeArray));//7
	
	
	System.out.println("\n\n\n");
	System.out.println("Max:");
	int[] Array= {1,2,3,5,7,11,33,44,2,34,23,11,99};
	System.out.println(max(Array));//99
	
	
}
public static double[] powArray(double[] a, int pow) {
	double[] d = a;
	for (int i = 0; i<a.length;i++) {
		for (int e = 0; e<pow-1;e++) {
			d[i] = d[i]*a[i];
		}
		
		
	}
	return d;
}

public static void printDoubleElements(double[] array) {
	for (int i = 0; i<array.length;i++) {
		System.out.println(array[i]);
	}
	


}

public static void printIntElements(int[] array) {
	for (int i = 0; i<array.length;i++) {
		System.out.println(array[i]);
	}
}
public static void printBooleanElements(boolean[] array) {
	for (int i = 0; i<array.length;i++) {
		System.out.println(array[i]);
	}

}

public static int[] histogram(int[] a) {
	int[] scores = new int[101];
	for(int i = 0; i<100; i++) {
		scores[a[i]]+=1;
	}
	return scores;
	
}



/*
//exercise 2
//returns the product of multiplying all the elements of the array
public static int banana(int[] a) {
    int kiwi = 1;//sets the product to 1
    int i = 0;//sets the first iteration to 0
    while (i < a.length) {
        kiwi = kiwi * a[i];
        i++;//increace the iteration counter 
    }
    return kiwi;//return the product
}


//checks for a particular int value in the array, a
public static int grapefruit(int[] a, int grape) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == grape) {//checks if the value at index at i equals grape (int)
            return i;//returns the index where grape is found
        }
    }
    return -1;//returns -1 if the value grape is not found
}

*/


public static int indexOfMax(int[] a) {
	int max = 0;
	for (int i = 0; i<a.length; i++) {
		if(a[i]>a[max]) {
			max = i;
		}
		//using an enhanced would be impossible on its own because it does not give you the index
	}
	return max;
	
	
}

public static boolean[] sieve(int[] nums) {
	boolean isPrime[] = new boolean[nums.length];
	for (int i = 0; i<nums.length;i++) {
		if(nums[i]==1||nums[i]==2) {
			isPrime[i]=true;
		}
		for (int e=2;e<nums[i]; e++) {
			isPrime[i] = !(Math.abs(nums[i])%e==0);
			if (isPrime[i]==false) {
				//isPrime[i]=true;
				break;
			}
		}
		
	}
	return isPrime;
}
public static boolean areFactors(int[] nums,int d) {
	boolean f = true;
	for(int n : nums) {
		f =n%d==0;
		if(f==false) {
			break;
		}
	}
	return f;
}
public static boolean arePrimeFactors(int[] nums,int n) {
	int product = 1;
	boolean[] prime = sieve(nums);
	for(boolean p : prime) {
		if(p==false) {
			return true;
		}
	}
	for(int i = 0; i<nums.length; i++) {
		product = product*nums[i];
	}
	return product == n;
	//return f;
}


public static int maxInRange(int start, int end,int[] nums) {
	int[] rangeA = new int[end+1-start];
	for(int i = start; i <=end;i++) {
		rangeA[i-start]=nums[i];
	}
	int max = rangeA[0];
	for(int n : rangeA) {
		if(max<n) {
			max=n;
		}
	}
	return max;
	
}

public static int max(int[] a) {
	return maxInRange(0,a.length-1,a);
}



}

package program;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MessingWithMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0;
		boolean positive = true;
		// int num = 3000;
		// long i;
//		for(int i = -num; i<num; i+=0.001) {
//			sum+=Math.pow(Math.E, -i*i);
//			
//			
//			
//		}
//		
//		System.out.println(sum*0.001);
//		System.out.println(Math.log(num));
//		
//		

		// BigInteger num = BigInteger.valueOf();
		BigInteger num = stringToNum("Hi");
		BigInteger x = BigInteger.ONE;

//		System.out.println(ln(100));
//		System.out.println(Math.log(100));
//		System.out.println(Math.log(1000)-ln(1000));
//		System.out.println(Math.exp(0.5*ln(10)));
//		System.out.println(exp(0.5*ln(10)));

		// System.out.println(exp(1));

//		for(int i=0; i<100000; i++) {
//			//System.out.println(Math.pow(64, 1/3.0));
//			if(Math.sqrt(i)%1==0&&Math.abs(Math.round(Math.pow(i, 1/3.0))-Math.pow(i, 1/3.0))<0.01) {
//				System.out.println(i);
//			}
//		}

		// Fraction f = new Fraction(1, 4);
		// Fraction f = new Fraction(2,10);
		// f.add(1);
		// f.simplify();
		// System.out.println(f.bigDecimal());

		// Integer nine = new Integer(9);

		int sumP = 0;
//		for(int i=1; i<501; i++) {
//			
//			
//			System.out.println(isPrime((int)Math.pow(2, i)-1)+" "+i);
//			//System.out.println((factorial(i)/(i+1)%10==0) ==isPrime(i));
//			
//		}

		// System.out.println(sumP);

		// prime race
//		int limit = 2000000;
//
//		long time = System.currentTimeMillis();
//		//System.out.println(primeSieve(limit).get(primeSieve(limit).size()-1));
//		System.out.println(primeSieve(limit).size());
//		//primeSieve(limit);
//		System.out.println("took " + (System.currentTimeMillis() - time) / 1000.0 + "seconds");
//
//		time = System.currentTimeMillis();
//		//System.out.println(primeList(limit).get(primeList(limit).size()-1));
//		System.out.println(primeList(limit).size());
//		//primeList(limit);
//		System.out.println("took " + (System.currentTimeMillis() - time) / 1000.0 + "seconds");
//
//		

//		 System.out.println(bigFactorial(new BigInteger("5000")));
//		 System.out.println(bigFactorial(new BigInteger("100000")).subtract(new
//		 BigInteger("16777216").pow(1000000)));
//		 System.out.println(ackerman(BigInteger.valueOf(3),BigInteger.valueOf(4)));

		// System.out.println(bigFactorial(new BigInteger("1000000")));
		// System.out.println(ackerman(new BigInteger("5000"),new BigInteger("100")));

//		Random r = new Random();
//		for(BigInteger i=BigInteger.ZERO; i.compareTo(new BigInteger("10000"))==-1; i=i.add(BigInteger.ONE)) {
//			BigInteger p = BigInteger.probablePrime(10, r);
//			if(!isPrime(p)) {
//				System.out.println(p);
//			}
//			
//			
//		}
		Math.log(10);
		BigInteger max = BigInteger.ONE;
		BigInteger two = new BigInteger("2");
		BigInteger zero = BigInteger.ZERO;
		Random r = new Random();
		BigInteger limit = new BigInteger("1000");

		double total = 0;
		// BigDecimal total=new BigDecimal("1");
//		for(BigDecimal i=BigDecimal.ZERO; i.compareTo(limit)==-1; i=i.add(BigDecimal.ONE)) {
//			
//		}
//		for(BigInteger i=BigInteger.ONE; i.compareTo(limit)==-1; i=i.add(BigInteger.ONE)) {
//			if(isPrime(fibonocci(i))) {
//				//System.out.println(fibonocci(i));
//				//total+=1.0/fibonocci(i).longValue();
//				//System.out.println(i);
//			}
//			
//			//System.out.println(fibonocci(i));
//		}
		// total/=d;
		// System.out.println(fibonocci(101));
		// System.out.println(myPrimeSieve(100));

		// System.out.println(ackermann(3,1));

		// System.out.println(myPrimeSieveW(100));
		// System.out.println(gamma(0.5));
		// System.out.println(StrictMath.floorDiv(0, 0));

		// ArrayList<BigInteger> nums= new ArrayList<>();
//		
//		for(int i=10; i<1000000; i++) {
//			nums.add(BigInteger.valueOf(i));
//		}
//		
//		for(int i=0; i<13; i++) {
//			collatzD(nums);
//		}

//		BigInteger a = new BigInteger("123123");
//		a=a.pow(5000);
//		System.out.println(myHash(a.toString()));
//		a=a.add(BigInteger.ONE);
//		System.out.println(myHash(a.toString()));
//		
//		
//		System.out.println((byte)0xAAAABBBB);
//		
//		
//		Complex n1 = new Complex(5,-3);
//		Complex n2 = new Complex(5,3);
//		//System.out.println(n1.pow(2));
//		System.out.println(n1.multiply(n2));
//		
//		

		// System.out.println(""+myAlg(1000000)[0]+" * "+myAlg(1000000)[1]+"^x +
		// "+myAlg(1000000)[2]);
		// System.out.println(gamma(5));
		// System.out.println(myAlg(3.14159265));

//		ArrayList<Integer> tree = new ArrayList<>();
//
//		tree.add(1);
//		tree.add(2);
//		tree.add(3);
//		tree.add(4);
//		tree.add(5);
//		tree.add(6);
//		tree.add(7);
//
//		System.out.println(tree);
//		invertBinaryTree(tree);
//		System.out.println(tree);
//
//		System.out.println(investmentCalc(11000, 4800, 0.07, 40));
//
//		String[] words = { "b", "c", "a", "cat", "dog", "apple" };
//		words = alphabetize(words);
//
//		System.out.println(logI(5000) - Math.log(5000));
//		

		Complex comp = new Complex(2, 2);
		System.out.println(comp.allRoots(2)[0]);
		System.out.println(comp.allRoots(2)[1]);

		System.out.println(sqrt(9));
		
		
		System.out.println(probPrime(10));
		
		//System.out.println(tetration(Math.pow(Math.E, -Math.E),10000000));
		//System.out.println(tetration(Math.pow(Math.E, -Math.E),10000005));

		
		
		String word = "hello world";
		//System.out.println(a);
		
		
		
		
		
		
		//System.out.println(xorBruteForce2("0:71-.9$	7::	\">3v\">?81%+","the"));
		BigDecimal dec = new BigDecimal(10);
		
		
		System.out.println(greedy(1000000000,0.577));
		
		
		
		

		
		
		
		
	}

	public static boolean isPrime(int x) {
		if (x == 1) {
			return false;
		}
		if (x == 2) {
			return true;
		}

		if ((x + 1) % 6 != 0 && (x - 1) % 6 != 0 && x != 3) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(x) + 1; i += 2) {

			if (x % i == 0) {
				return false;
			}
		}
		return true;

	}

	public static boolean isPrime(BigInteger x) {
		if (x.compareTo(BigInteger.ONE) == 0) {
			return false;
		}
		if (x.compareTo(new BigInteger("2")) == 0) {
			return true;
		}

		if (x.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0) {
			return false;
		}

		for (BigInteger i = new BigInteger("3"); i.compareTo(x) == -1; i = i.add(new BigInteger("2"))) {
			if (x.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;

	}

	public static ArrayList<Integer> primeSieve(int limit) {
		ArrayList<Integer> sieve = new ArrayList<>();
		boolean isPrime = true;
		for (int i = 2; i < limit; i++) {
			// isPrime = true;
			for (int num : sieve) {
				isPrime = (i % num != 0);

				if (!isPrime || num > Math.sqrt(i)) {
					break;
				}
			}
			if (isPrime) {
				sieve.add(i);
			}
		}
		return sieve;
	}

	public static ArrayList<Integer> myPrimeSieve(int limit) {
		ArrayList<Integer> sieve = new ArrayList<>();
		for (int i = 1; i < limit; i++) {
			sieve.add(i);
		}
		for (int i = 2; i < Math.sqrt(limit + 1); i++) {
			removeComposite(sieve, i);
		}
		return sieve;
	}

	public static void removeComposite(ArrayList<Integer> a, int num) {
		boolean firstFound = false;
		for (int i = 0; i < a.size(); i += 1) {
			if (!firstFound && a.get(i) % num == 0) {
				firstFound = true;
				continue;
			} else if (a.get(i) % num == 0) {
				a.remove(i);
				i--;
			}
		}
	}

	public static ArrayList<Integer> myPrimeSieveW(int limit) {
		ArrayList<Integer> sieve = new ArrayList<>();
		for (int i = 1; i < limit; i++) {
			sieve.add(i);
		}
		for (int i = 2; i < sieve.size(); i++) {
			if (!((sieve.get(i) == 2 || sieve.get(i) == 3)
					|| ((sieve.get(i) + 1) % 6 == 0 || (sieve.get(i) - 1) % 6 == 0))) {
				sieve.remove(i);
				i--;
			}
		}

		for (int i = 0; i < sieve.size(); i++) {
			if (isPrime(i)) {

			}
		}

		return sieve;
	}

	public static ArrayList<Integer> primeList(int limit) {
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i < limit; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static double derivitive(double x, double xx, double y, double yy) {
		return (y - yy) / (x - xx);
	}

	public static int addF(int n) {
		if (n == 1) {
			return 1;
		}
		return n + addF(n - 1);
	}

	public static String fastNumToString(long x) {
		ArrayList<Character> c = new ArrayList<>();
		while (x > 256) {

			c.add((char) (x % 256));
			// System.out.println((char) (x%256));
			x /= 256;
		}
		c.add((char) x);
		String r = "";
		for (char ch : c) {
			r = r + ch;
		}
		return r;

	}

	public static long fastStringToNum(String str) {
		long total = 0;
		long charValue;
		for (int i = 0; i < str.length(); i++) {
			charValue = str.charAt(i);
			total += (Math.pow(256, i) * charValue);
		}

		return total;

	}

	/*
	 * note this is a faster brute force calculator because it uses long's so the
	 * math opperations +-* / take a lot less time
	 */
	public static void fasterBruteForceCalculator(String password) {
		long x = 0;

		System.out.println("Estimated time:" + 0.00003 * (Math.pow(256, password.length())) + " seconds.");

		while (!fastNumToString(x).equals(password)) {
			x++;
		}

		System.out.println("Password found!, it is \"" + fastNumToString(x) + "\".");

	}

	// slow
	public static String numToString(BigInteger x) {
		ArrayList<Character> c = new ArrayList<>();
		BigInteger charMax = BigInteger.valueOf(256);
		while (x.compareTo(charMax) == 1) {

			c.add((char) (x.mod(charMax).intValue()));
			// System.out.println((char) (x%256));
			x = x.divide(charMax);
		}
		c.add((char) x.intValue());
		String r = "";
		for (char ch : c) {
			r = r + ch;
		}
		return r;

	}

	public static BigInteger stringToNum(String str) {
		BigInteger total = BigInteger.valueOf(0);
		BigInteger cLimit = BigInteger.valueOf(256);
		BigInteger charValue;
		for (int i = 0; i < str.length(); i++) {
			charValue = BigInteger.valueOf(str.charAt(i));
			total = total.add(cLimit.pow(i).multiply(charValue));
		}

		return total;

	}

	/*
	 * note this is a VERY slow brute force calculator because it uses BigIntegers
	 * so the math opperations +-* / take a lot more time
	 */
	public static void bruteForceCalculator(String password) {
		BigInteger x = BigInteger.ZERO;

		System.out.println("Estimated time:" + 0.00003 * (Math.pow(256, password.length())) + " seconds.");

		while (!numToString(x).equals(password)) {
			x = x.add(BigInteger.ONE);
		}

		System.out.println("Password found!, it is \"" + numToString(x) + "\".");

	}

//	public static String encryptString(String str) {
//		BigInteger x =stringToNum(str);
//		x.multiply(x);
//		return numToString(x);
//	}
//	public static String decryptString(String str) {
//		return numToString((long) sqrt(stringToNum(str)));
//	}

	public static double ln(double num) {
		double sum = 0;
		double inc = (1.0 / num) * (1.0 / num);
		for (double i = 1; i < num; i += inc) {
			sum += (1.0 / i);
		}

		return sum * inc;
	}

	public static double exp(double num) {
		double sum = 0;
		for (int n = 0; n < 10; n++) {
			sum += Math.pow(num, n) / factorial((long) n);
			// System.out.println(factorial((long)n));
		}

		return sum;
	}

	public static long factorial(long num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		long p = 1;
		for (long i = num; i > 1; i--) {

			p *= ((i));

		}

		return p;
	}

	public static BigInteger bigFactorial(BigInteger num) {
		if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		BigInteger p = BigInteger.ONE;
		for (BigInteger i = num; !i.equals(BigInteger.ONE); i = i.subtract(BigInteger.ONE)) {

			p = p.multiply(i);

		}

		return p;
	}

	public static String fastNumToStringOnlyLetters(long x) {
		ArrayList<Character> c = new ArrayList<>();
		while (x > 26) {

			c.add((char) (65 + x % 26));
			// System.out.println((char) (x%256));
			x /= 26;
		}
		c.add((char) (65 + x));
		String r = "";
		for (char ch : c) {
			r = r + ch;
		}
		return r;

	}

	public static ArrayList<Integer> sort(ArrayList<Integer> l) {
		int min = l.get(0);
		ArrayList<Integer> sortedList = new ArrayList<>();

		for (int i = 0; i < l.size(); i++) {
			min = l.get(0);
			for (int e = 0; e < l.size(); e++) {
				if (l.get(e) < min) {
					min = l.get(e);
				}
			}
			sortedList.add(min);
			l.remove(l.indexOf(min));
			i--;

		}
		return sortedList;

	}

	public static ArrayList<Integer> toArrayList(int[] x) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i = 0; i < x.length; i++) {
			l.add(x[i]);
		}
		return l;
	}

	public static int[] toArray(int[] x) {
		int[] l = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			l[i] = i;
		}
		return l;
	}

	public static BigInteger ackerman(BigInteger m, BigInteger n) {
		if (m.equals(BigInteger.ZERO)) {
			return n.add(BigInteger.ONE);
		} else if (n.equals(BigInteger.ZERO)) {
			return ackerman(m.subtract(BigInteger.ONE), BigInteger.ONE);
		} else {
			return ackerman(m.subtract(BigInteger.ONE), ackerman(m, n.subtract(BigInteger.ONE)));
		}

	}

	public static int myA(int a) {
		if (Math.sqrt(a) % 1 == 0) {

			return (int) Math.sqrt(a);
		}
		if (a % 2 == 0) {
			return 0 + myA(a / 2);
		}
		return 0 + myA(3 * a + 1);
	}

	public static int collatz(int n) {
		int steps = 0;
		while (Math.abs(n) != 1 && Math.abs(n) != 0) {
			if (n % 2 == 0) {
				n /= 2;
				steps++;
			} else {
				n *= 3;
				n += 1;
				steps++;
			}
		}
		return steps;
	}

	public static BigInteger collatz(BigInteger n) {
		BigInteger steps = BigInteger.ZERO;
		BigInteger zero = BigInteger.ZERO;
		BigInteger one = BigInteger.ONE;
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		while (!n.abs().equals(one) && !n.abs().equals(zero)) {

			if (n.mod(two).equals(zero)) {
				n = n.shiftRight(1);
				steps = steps.add(one);
			} else {
				n = n.multiply(three);
				n = n.add(one);

			}
		}
		return steps;
	}

	public static void collatzD(ArrayList<BigInteger> nums) {
		BigInteger three = new BigInteger("3");
		BigInteger two = new BigInteger("2");
		for (int i = 0; i < nums.size(); i++) {
			if (three.multiply(nums.get(i)).divide(two).mod(two).equals(BigInteger.ZERO)
					|| nums.get(i).mod(two).equals(BigInteger.ZERO)) {
				nums.remove(i);
				i--;
			} else {
				nums.set(i, three.multiply(nums.get(i)).divide(two));
			}
		}
	}

	public static BigInteger fibonocci(int n) {
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		BigInteger num3 = BigInteger.ONE;

		for (int i = 0; i < n; i++) {
			num3 = num1.add(num2);
			num1 = num2;
			num2 = num3;
		}
		return num3;
	}

	public static BigInteger fibonocci(BigInteger n) {
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;

		if (n.equals(BigInteger.ONE)) {
			return num1;
		}
		if (n.equals(new BigInteger("2"))) {
			return num2;
		}
		n = n.subtract(new BigInteger("2"));

		BigInteger num3 = BigInteger.ONE;

		for (BigInteger i = BigInteger.ZERO; i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
			num3 = num1.add(num2);
			num1 = num2;
			num2 = num3;
		}
		return num3;
	}

	public static int ackermann(int m, int n) {
		if (m == 0) {
			return n + 1;
		}
		if (n == 0) {
			return ackermann(m - 1, 1);
		}
		return ackermann(m - 1, ackermann(m, n - 1));

	}

	public static double gamma(double x) {
		double total = 0;
		double inc = 0.0001;
		x++;
		for (double i = 0; i < 1000; i += inc) {
			total += Math.pow(i, x - 1) * Math.exp(-i) * inc;
		}

		return total;
	}

	public static double logBase(double n, double base) {
		return Math.log(n) / Math.log(base);
	}

	public static double mySqrt(double n) {
		double x = n;
		double min = 0;
		double max = n;
		n = n / 2;
		double p = 0.0001;
		while (Math.abs(Math.abs(n * n) - x) > p) {
			if (n * n > x) {
				max = n;
				n = (n + min) / 2;
			} else if (n * n < x) {
				min = n;
				n = (n + max) / 2;
			}
		}
		return n;
	}

	public static double myRand() {

		double time = (double) Math.abs(System.nanoTime());
		time /= Math.PI;
		return time % 1.0;
	}

	public static String myHash(String data) {
		String str = "";
		String bits = "";
		int size = 256;
		while (data.length() < size) {
			data += data;
		}

		BigInteger hash = new BigInteger(data.getBytes());
		hash = hash.pow(2);
		hash = hash.shiftLeft(Math.max(size - hash.bitLength(), 0));
		int index = hash.toString(16).length() - 64;
		return hash.toString(16).substring(index);
	}

	public static String myHash2(String data, int base) {
		BigInteger output = new BigInteger(data.hashCode() + "");
		while (output.toString(base).length() < (256 * Math.log(2)) / Math.log(base)) {
			output = output.add(output);
			output = output.multiply(output);
			output = output.add(output);
			output = output.add(BigInteger.ONE);
		}
		String out = output.toString(base);
		while (out.length() < (256 * Math.log(2)) / Math.log(base)) {
			out = "0" + out;
		}
		while (out.length() > (256 * Math.log(2)) / Math.log(base)) {
			if (out.length() % 2 == 0) {
				out = out.substring(1);
			} else {
				out = out.substring(0, out.length() - 1);
			}

		}

		return out;
	}

	public static int superCollatz(int x) {
		if (collatz(x) == 1 || collatz(x) == x) {
			return 0;
		} else {
			return 1 + superCollatz(collatz(x));
		}
	}

	public static double myAlg(double num) {

		if (num > 1) {
			return num * myAlg(num - 1);
		} else if (num < 0) {
			return myAlg(num + 1) / (num + 1);
		}

		if (num == 1 || num == 0) {
			return 1;
		}
		return -0.0874 * Math.pow(num, 7) + 0.3857 * Math.pow(num, 6) - 0.7596 * Math.pow(num, 5)
				+ 0.9750 * Math.pow(num, 4) - 0.9329 * Math.pow(num, 3) + 0.9971 * Math.pow(num, 2) - 0.578 * num + 1;

	}

	public static int maxParDepth(String str) throws Exception {
		int numRight = 0;
		int numLeft = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				numLeft++;
			}
			if (str.charAt(i) == ')') {
				numRight++;
			}
		}
		if (numRight != numLeft) {
			throw new Exception("Invalid input");
		}

		int max = 0;
		int tempMax = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				tempMax++;
			} else if (str.charAt(i) == ')') {
				tempMax--;
			}

			if (tempMax > max) {
				max = tempMax;
			}
		}

		return max;

	}

	public static double averageFactor(int num) {
		ArrayList<Integer> factors = new ArrayList<>();
		for (int i = 1; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		double average = 0;
		for (int x : factors) {
			average += x;
		}
		average /= factors.size();

		return average;
	}

	public static ArrayList<Integer> invertBinaryTree(ArrayList<Integer> tree) {
		int level = 0;
		int index = 0;
		while (level < tree.size()) {

			System.out.println(" index " + index + " level " + level);
			for (int i = index; i < level - (i - index); i++) {
				int right = tree.get(level - (i - index));
				int left = tree.get(i);
				tree.set(level - (i - index), left);
				tree.set(i, right);
			}
			index = 2 * index + 1;
			level = 2 * level + 2;

		}
		return tree;
	}

	public static long sumOfFactors(int x) {
		int max = (int) x / 2 + 1;
		long sum = 0;
		for (int i = 1; i < max; i++) {
			if (x % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static double investmentCalc(double initial, double annualDeposit, double interestRate, int years) {
		double total = initial;
		for (int i = 0; i < years; i++) {
			total += annualDeposit;
			total *= (1 + interestRate);
		}

		return total;
	}

	public static String[] alphabetize(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (words[j].compareToIgnoreCase(words[i]) < 0) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
					i = 0;
					j = 0;
				}
			}
		}
		return words;
	}

	public static ArrayList<?> toArrayList(Object[] array) {
		ArrayList<Object> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	public static double logR(double n) {
		double accuracy = 0.01;
		if (n <= 1) {
			return -1 / n + 1;
		} else {
			return accuracy / n + logR(n - accuracy);
		}
	}

	public static double logI(double n) {
		double accuracy = 0.01;
		double answer = 0;

		if (n == 0) {
			return Double.NEGATIVE_INFINITY;
		}

		for (double i = n; i > 0; i -= accuracy) {
			answer += accuracy / i;
			if (i <= 1) {
				answer += -(1 / i) + 1;
				break;
			}
		}
		return answer;
	}

	public static double sqrt(double num) {
		if(num<0) {
			return Double.NaN;
		}
		if(num==0||num/2==0) {
			return 0;
		}
		
		
		double guess=num/2;
		double min = 0;
		double max = Math.max(num, 1.0/num);
		while(Math.abs(guess*guess-num)>0) {
			double x=guess*guess;
			if(x>num) {
				max=guess;
				guess=(guess+min)/2;
			}
			else if(x<num) {
				min=guess;
				guess=(guess+max)/2;
			}
		}
		return guess;
	}

	
	public static ArrayList<Double> probPrime(int size){
		ArrayList<Double> nums = new ArrayList<>();
		nums.add(0.5);
		for(int i=3; i<size; i++) {
			if(isPrime(i)) {
				nums.add(1.0/(i)*nums.get(nums.size()-1)+nums.get(nums.size()-1));
			}
		}
		return nums;
	}
	
	
	public static double tetration(double base, int size) {
		double num=base;
		for(int i=0; i<size; i++) {
			num=Math.pow(base, num);
		}
		return num;
	}
	
	
	public static ArrayList<Integer> pascal(int row){
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		
		int d=1;
		while(row>0) {
			int sum=0;
			for(int i=1; i<=row; i++) {
				sum+=nums.get(nums.size()-1);
			}
			sum/=d;
			nums.add(sum);
			d++;
			row--;
		}
		return nums;
	}
	
	
	
	public static int myFun(int x) {
		if(x==1) {
			return 1;
		}
		int sum=0;
		for(int i=0; i<x; i++) {
			sum+=1;
		}
		return sum+myFun(x-1);
	}
	
	
	public static ArrayList<Integer> greedy(long terms,double num){
		ArrayList<Integer> nums = new ArrayList<>();
		double sum = 0;
		for(int i=2; i<terms; i++) {
			if((sum+1.0/(i)+num)/2<num) {
				sum+=1.0/(i);
				nums.add(i);
			}
		}
		return nums;
	}
	
	
	
	public static String xorBruteForce(String ciphertext, String decryptedText) {
		String key = "";
		
		String plain=ciphertext;
		
		while(!plain.toUpperCase().contains(decryptedText.toUpperCase())) {
			
			while(key.length()<ciphertext.length()) {
				key=(char)0+key;
			}
			plain=ciphertext;
			for(int i=0; i<ciphertext.length(); i++) {
				plain=plain.substring(0,i)+
						(char)(plain.charAt(i)^
								key.charAt(i))
						+plain.substring(i+1,plain.length());
			}
			key=numToString(stringToNum(key).add(BigInteger.ONE));
		}
		return key;
	}
	
	
	public static String xorBruteForce2(String ciphertext, String decryptedText) {
		int key =0;
		String plain=ciphertext;
		while(!plain.toUpperCase().contains(decryptedText.toUpperCase())) {
			plain=ciphertext;
			key++;
			for(int i=0; i<plain.length(); i++) {
				plain=plain.substring(0,i)+(char)(plain.charAt(i)^key)+plain.substring(i+1);
			}
			//System.out.println(plain);
		}
		return plain;
	}
}

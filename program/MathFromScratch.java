package program;

public class MathFromScratch {

	final static double PI = 3.141592653589793238462643383279;
	final static double E = 2.7182818284590452353602874713527;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] a = { { Math.sqrt(2), 1}, { 1, 1} };
		double[][] b = { { 1, 0}, { 0, 1} };

		
//		for(int i=1; i<100; i++) {
//			System.out.println("("+i+", "+logBase(3,i/2.0)+")");
//		}
		
		System.out.println(exp(logBase(E,2)));
		System.out.println(logBase(E,exp(2)));
	}

	
	
	
	public static double[] getCol(double[][] matrix, int col) {
		double[] finalCol = new double[matrix.length];

		for (int i = 0; i < finalCol.length; i++) {
			finalCol[i] = matrix[i][col];
		}
		return finalCol;
	}

	public static double add(double num1, double num2) {
		return num1 + num2;
	}

	public static double[] add(double[] matrix1, double[] matrix2) {
		double[] sumMatrix = new double[matrix1.length];
		for (int i = 0; i < sumMatrix.length; i++) {
			sumMatrix[i] = add(matrix1[i], matrix2[i]);
		}
		return sumMatrix;
	}

	public static double[][] add(double[][] matrix1, double[][] matrix2) {
		double[][] sumMatrix = new double[matrix1.length][matrix1[0].length];
		for (int row = 0; row < sumMatrix.length; row++) {
			for (int col = 0; col < sumMatrix.length; col++) {
				sumMatrix[row][col] = add(matrix1[row][col], matrix2[row][col]);
			}
		}
		return sumMatrix;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double[] subtract(double[] matrix1, double[] matrix2) {
		double[] difMatrix = new double[matrix1.length];
		for (int i = 0; i < difMatrix.length; i++) {
			difMatrix[i] = subtract(matrix1[i], matrix2[i]);
		}
		return difMatrix;
	}

	public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
		double[][] difMatrix = new double[matrix1.length][matrix1[0].length];
		for (int row = 0; row < difMatrix.length; row++) {
			for (int col = 0; col < difMatrix.length; col++) {
				difMatrix[row][col] = subtract(matrix1[row][col], matrix2[row][col]);
			}
		}
		return difMatrix;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double sum(double[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = add(sum, nums[i]);
		}
		return sum;
	}

	public static double[] scale(double scalar, double[] nums) {
		double[] newArray = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			newArray[i] = multiply(scalar, nums[i]);
		}
		return newArray;
	}

	public static double[][] scale(double scalar, double[][] matrix) {
		double[][] newArray = new double[matrix.length][matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				newArray[row][col] = multiply(scalar, matrix[row][col]);
			}
		}
		return newArray;
	}

	public static double multiply(double[] arr1, double[] arr2) {
		double sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum = add(sum, multiply(arr1[i], arr2[i]));
		}
		return sum;
	}

	public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
		double[][] multMatrix = new double[matrix1[0].length][matrix2.length];

		for (int row = 0; row < multMatrix.length; row++) {
			for (int col = 0; col < multMatrix[0].length; col++) {
				multMatrix[row][col] = multiply(matrix1[row], getCol(matrix2, col));
			}
		}
		return multMatrix;
	}

	public static double divide(double dividend, double divisor) {
		return dividend / divisor;
	}

	public static double intPow(double base, int power) {
		double num = base;

		if (power > 0) {
			for (int i = 1; i < power; i++) {
				num = multiply(num, base);
			}
		} else if (power <= 0) {
			for (int i = 1; i < abs(power); i++) {
				num = divide(num, base);
			}
		}
		return num;

	}

	public static double abs(double num) {
		if (num < 0) {
			num = multiply(num, -1);
		}
		return num;
	}

	public static double sqrt(double num) {
		double max = num;
		double min = 0;

		double guess = add(divide(num, 2), 1);

		double square = intPow(guess, 2);
		while (abs(square - num) > 0.000000000000001) {

			if (square > num) {
				max = guess;
				guess = average(guess, min);
			} else if (square < num) {
				min = guess;
				guess = average(guess, max);
			}
			square = intPow(guess, 2);
		}
		return guess;
	}

	public static double average(double num1, double num2) {
		return divide(add(num1, num2), 2);
	}

	
	
	public static int factorial(int x) {
		int num=1;
		for(int i=1; i<=x; i++) {
			num*=i;
		}
		return num;
	}
	
	public static double exp(double x, int numTerms) {
		double sum=0;
		for(int i=0; i<numTerms; i++) {
			sum+=(double)intPow(x,i)/factorial(i);
		}
		return sum;
	}
	
	public static double log2(double x) {
		boolean neg = false;
		if(x<1) {
			neg=true;
			x=1/x;
		}
		
		
		double  total = 0;
		double guess = 1;
		double dx=2;
		double step=1;
		while(abs(guess-x)>0.0000000001) {
			if(guess<x) {
				if(guess*dx>x) {
					dx=sqrt(dx);
					step=divide(step,2);
				}
				else {
					guess=multiply(guess,dx);
					total=add(total,step);
				}
			}
			
			
		}
		if(neg) {
			return -total;
		}
		return total;
	}
	
	public static double logBase(double base, double x) {
		if(x==1) {
			return 0;
		}
		if(x<=0) {
			return 1/0;
		}
		boolean neg = false;
		if(base>x) {
			return 1/logBase(x,base);
		}
		if(x<1) {
			neg=true;
			x=1/x;
		}
		
		
		double  total = 0;
		double guess = 1;
		double dx=base;
		double step=1;
		while(abs(guess-x)>0.00000000000) {
			if(guess<x) {
				if(guess*dx>x) {
					dx=sqrt(dx);
					step=divide(step,2);
				}
				else {
					guess=multiply(guess,dx);
					total=add(total,step);
				}
				
				
				
				
				
			}
		}
		if(neg) {
			return -total;
		}
		return total;
	}

	
	public static double pow(double base, double exp) {
		boolean neg = false;
		if(exp<0) {
			exp=-exp;
			neg = true;
		}
		double guess = 1;
		double dx = base;
		double steps = 0;
		double step=1;
		while(abs(exp-steps)>0.000000000000) {
			if(steps<exp) {
				if(add(steps,step)>exp) {
					dx=sqrt(dx);
					step/=2;
					continue;
				}
				guess*=dx;
				steps=add(steps,step);
			}
		}
		
		if(neg) {
			return 1/guess;
		}
		return guess;
	}
	
	public static double exp(double pow) {
		return pow(E,pow);
	}
	
	
	
	
}

package program;

public class Complex {
	private double real;
	private double imaginary;

	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public String toString() {

		if (Math.abs(imaginary) == 1) {
			if (imaginary == 1) {
				return real + " + " + "i";
			} else if (imaginary == -1) {
				return real + " - " + "i";
			}
		}
		if (imaginary > 0) {
			return real + " + " + imaginary + "i";
		} else if (imaginary < 0) {
			return real + " - " + -1 * imaginary + "i";
		}
		return real + "";

	}

	public Complex clone() {
		return new Complex(real, imaginary);
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginary() {
		return imaginary;
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	public Complex multiply(double scale) {
		return new Complex(real * scale, imaginary * scale);
	}

	public Complex multiply(Complex num) {
		// a+bi

		double a1 = getReal() * num.getReal();
		double b1 = getReal() * num.getImaginary();

		double a2 = -1 * getImaginary() * num.getImaginary();
		double b2 = getImaginary() * num.getReal();

		return new Complex(a1 + a2, b1 + b2);

	}
	public Complex divide(double scale) {
		return new Complex(real/scale,imaginary/scale);
	}
	public Complex divide(Complex denominator) {
		Complex conj=new Complex(denominator.getReal(),-denominator.getImaginary());
		
		Complex numerator=clone();
		
		numerator=numerator.multiply(conj);
		denominator=denominator.multiply(conj);
		numerator=numerator.divide(denominator.getReal());
		return numerator;
	}

	
	public Complex add(Complex num) {
		return new Complex(real+num.getReal(),imaginary+num.getImaginary());
	}
	public Complex subtract(Complex num) {
		return new Complex(real-num.getReal(),imaginary-num.getImaginary());
	}
	
	public double abs() {
		return Math.sqrt(real*real+imaginary*imaginary);
	}
	
	public Complex exp() {
		double a =Math.exp(real);
		double b =Math.sin(imaginary);
		b*=a;
		a*=Math.cos(imaginary);
		return new Complex(a,b);
	}
	public Complex ln() {
		double r = abs();
		double theta = Math.atan(imaginary/real);
		return new Complex(Math.log(r),theta);
	}
	
	public Complex pow(double n) {
		return (ln().multiply(n)).exp();
	}
	
	public Complex[] allRoots(int n) {
		double r = Math.sqrt(real*real+imaginary*imaginary);
		double theta = Math.atan(imaginary/real);
		Complex[] roots = new Complex[n];
		for(int i=0; i<n; i++) {
			roots[i]=new Complex(Math.cos(theta/n+(i*(2*Math.PI)/n)),Math.sin(theta/n+(i*(2*Math.PI)/n))).multiply(Math.pow(r, 1.0/n));
		}
		return roots;
	}
	
}

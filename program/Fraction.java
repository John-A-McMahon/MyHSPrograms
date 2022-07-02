package program;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Fraction {
private int numerator;
private int denominator;

public Fraction(int n, int d) {
	this.numerator=n;
	this.denominator=d;
}


public int getNumerator() {
	return numerator;
}


public void setNumerator(int numerator) {
	this.numerator = numerator;
}


public int getDenominator() {
	return denominator;
}


public void setDenominator(int denominator) {
	this.denominator = denominator;
}

public void simplify() {
	ArrayList<Integer> nFactors= new ArrayList<>();
	ArrayList<Integer> dFactors= new ArrayList<>();
	
	for(int i=1; i<=numerator; i++) {
		if(numerator%i==0) {
			
			nFactors.add(i);
		}
	}
	
	for(int i=1; i<=denominator; i++) {
		if(denominator%i==0) {
			dFactors.add(i);
		}
	}
	
	int gcf=1;
	for(int i=0; i<nFactors.size(); i++) {
		
		if(dFactors.contains(nFactors.get(i))) {
			gcf=nFactors.get(i);
		}
	}
	
	
	
	//System.out.println(gcf);
	numerator/=gcf;
	denominator/=gcf;
	
	
	
	
	if(numerator<0&&denominator<0) {
		numerator=Math.abs(numerator);
		denominator=Math.abs(denominator);
	}
	if(numerator>0&&denominator<0) {
		numerator=-Math.abs(numerator);
		denominator=Math.abs(denominator);
	}
	
	
	
}

public void add(Fraction f) {
	if(denominator==f.getDenominator()) {
		numerator+=f.getNumerator();
	}
	else {
		numerator*=f.getDenominator();
		f.setNumerator(f.getNumerator()*denominator);
		int d = denominator*f.getDenominator();
		this.setDenominator(d);
		f.setDenominator(d);
		
		numerator+=f.getNumerator();
	}
	//this.simplify();
}

public void add(int n) {
	numerator+=n*denominator;
}


public void subtract(Fraction f) {
	if(denominator==f.getDenominator()) {
		numerator-=f.getNumerator();
	}
	else {
		numerator*=f.getDenominator();
		f.setNumerator(f.getNumerator()*denominator);
		int d = denominator*f.getDenominator();
		this.setDenominator(d);
		f.setDenominator(d);
		
		numerator-=f.getNumerator();
	}
}

public void subtract(int n) {
	numerator-=n*denominator;
}

public void multiply(Fraction f) {
	if(f==this) {
		numerator=1;
		denominator=1;
	}
	numerator*=f.getNumerator();
	denominator*=f.getDenominator();
}

public void multiply(int n) {
	numerator*=n;
}

public void divide(Fraction f) {
	f.inverse();
	
	this.multiply(f);
	
}

public void divide(int n) {
	denominator*=n;
}

public void pow(int p) {
	if(p==0) {
		numerator=1;
		denominator=1;
	}
	else if(p>1) {
		int n=numerator;
		int d=denominator;
		for(int i=1; i<p; i++) {
			numerator*=n;
			denominator*=d;
		}
	}
	
	
	if(p<0) {
		this.inverse();
		pow(Math.abs(p));
	}
	
}

public void sum(Fraction[] fArray) {
	for(int i=0; i<fArray.length; i++) {
		this.add(fArray[i]);
	}
}


public void inverse() {
	int n=numerator;
	int d=denominator;
	numerator=d;
	denominator=n;
}

public double decimal() {
	return (double)numerator/denominator;
}

public BigDecimal bigDecimal() {
	if(numerator!=denominator&&denominator%2!=0&&denominator%10!=0) {
		System.out.println("BigDecimal cant do that (non-terminating)");
		return BigDecimal.ZERO;
	}
	return BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator));
}

public String toString() {
	
	int whole = 0;
	int numerator=this.numerator;
	int denominator=this.denominator;
	
	this.simplify();
	
	while(numerator>=denominator) {
		whole+=1;
		numerator-=denominator;
	}
	this.simplify();
	
	
	if(denominator==0) {
		return "undefined";
	}
	if(whole==0) {
		return numerator+"/"+denominator;
	}
	return whole+" "+numerator+"/"+denominator;
}
}

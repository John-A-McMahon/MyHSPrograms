package program;

import java.util.ArrayList;

public class StatArray {

	private double[] array;

	public StatArray(double array[]) {
		this.array = array;
	}

	public StatArray(ArrayList<Double> list) {
		this.array = new double[list.size()];
		for (int i = 0; i < size(); i++) {
			this.array[i] = list.get(i);
		}
	}

	public StatArray(int length) {
		this.array = new double[length];
	}
	
	public void add(double num) {
		double[] newArray = new double[size()+1];
		for(int i=0; i<size(); i++) {
			newArray[i]=this.array[i];
		}
		newArray[size()]=num;
		this.array=newArray;
	}
	public void add(int index,double num) {
		double[] newArray = new double[size()+1];
		for(int i=0; i<size(); i++) {
			if(i==index) {
				newArray[i]=num;
			}
			if(i<index) {
				newArray[i]=this.array[i];
			}
			else {
				newArray[i+1]=this.array[i];
			}
			
		}
		this.array=newArray;
	}
	public void remove(int index) {
		double[] newArray = new double[size()-1];
		for(int i=0; i<size(); i++) {
			if(i==index) {
				continue;
			}
			if(i<index) {
				newArray[i]=this.array[i];
			}
			else {
				newArray[i-1]=this.array[i];
			}
			
		}
		this.array=newArray;
	}

	public StatArray(String type, int length) {
		this.array = new double[length];

		if (type.equalsIgnoreCase("random")) {
			for (int i = 0; i < length; i++) {
				this.array[i] = Math.random();
			}
		}
		if (type.equalsIgnoreCase("random")) {
			for (int i = 0; i < length; i++) {
				this.array[i] = Math.random();
			}
		}

	}

	public String toString() {
		String str = "{";
		for (int i = 0; i < size(); i++) {
			str += get(i) + ",";
		}
		str = str.substring(0, str.length() - 1) + "}";
		return str;
	}

	public double get(int index) {
		return array[index];
	}

	public void set(int index, double newValue) {
		array[index] = newValue;
	}

	public int size() {
		return array.length;
	}

	public ArrayList<Double> copyList() {
		ArrayList<Double> list = new ArrayList<>();
		int len = array.length;
		for (int i = 0; i < len; i++) {
			list.add(get(i));
		}
		return list;
	}

	public double[] copy() {
		double[] copy = new double[size()];
		int len = size();
		for (int i = 0; i < len; i++) {
			copy[i] = get(i);
		}
		return copy;
	}

	public double[] sort() {
		// ArrayList<ArrayList<double>> lists = new ArrayList<>();
		ArrayList<Double> copy = copyList();
		copy = mergeSort(copy);
		System.out.println(copy);
		double[] copyA = new double[size()];
		for (int i = 0; i < size(); i++) {
			copyA[i] = copy.get(i);
		}
		return copyA;
	}

	public static ArrayList<Double> mergeSort(ArrayList<Double> a) {
		if (a.size() == 1) {
			return a;
		}

		ArrayList<Double> left = new ArrayList<>();
		ArrayList<Double> right = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (i < a.size() / 2) {
				left.add(a.get(i));
			} else {
				right.add(a.get(i));
			}
		}

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);

	}

	public static ArrayList<Double> merge(ArrayList<Double> a, ArrayList<Double> b) {

		ArrayList<Double> sorted = new ArrayList<>();

		while (a.size() > 0 && b.size() > 0) {
			if (a.get(0) > b.get(0)) {
				sorted.add(b.remove(0));
			} else {
				sorted.add(a.remove(0));
			}
		}

		while (a.size() > 0) {
			sorted.add(a.remove(0));
		}
		while (b.size() > 0) {
			sorted.add(b.remove(0));
		}

		return sorted;
	}

//standard deviation population
	public double std() {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += (get(i) - mean()) * (get(i) - mean());
		}
		sum /= size();
		sum = Math.sqrt(sum);
		return sum;
	}

	public double var() {
		double std = std();
		return std * std;
	}

//standard deviation population
	public double stdSample() {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += (get(i) - mean()) * (get(i) - mean());
		}
		sum /= size() - 1;
		sum = Math.sqrt(sum);
		return sum;
	}

	public double varSample() {
		double std = stdSample();
		return std * std;
	}

	public double mean() {
		double sum = 0;
		int len = array.length;
		for (int i = 0; i < array.length; i++) {
			sum += (double) get(i);
		}
		return sum / len;
	}

	public double median() {
		double[] copy = sort();
		if (size() == 0) {
			return get(0);
		} else if (size() % 2 == 1) {
			return copy[copy.length / 2];
		} else {
			return (copy[copy.length / 2] + copy[copy.length / 2 - 1]) / 2.0;
		}
	}

	public double mode() {
		double mode = get(0);
		int count = 0;
		int maxCount = 0;
		double current;
		for (int i = 0; i < size(); i++) {
			count = 0;
			current = get(i);
			for (double element : array) {
				if (element == current) {
					count++;
				}
			}
			if (count > maxCount) {
				mode = current;
				count = maxCount;
			}

		}
		return mode;
	}

	private boolean medianInData() {
		if (size() == 0) {
			return false;
		} else if (size() % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	public double percentile(double num) {
		if (size() == 0) {
			return 0;
		}

		double sum = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i) < num) {
				sum++;
			} else if (get(i) == num) {
				sum += 0.5;
			}
		}
		return sum / size();
	}

	public double R2(double[] input, double slope, double intercept) {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += (get(i) - (input[i] * slope + intercept)) * (get(i) - (input[i] * slope + intercept));
		}
		//sum /= size() - 1;

		// return (varSample()-sum)/varSample();
		return 1 - sum / (var());
	}
	
	public double SSR(double[] input, double slope, double intercept) {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += (get(i) - (input[i] * slope + intercept)) * (get(i) - (input[i] * slope + intercept));
		}
		return sum;
	}

	public double R(double[] input, double slope, double intercept) {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += (get(i) - (input[i] * slope + intercept)) * (get(i) - (input[i] * slope + intercept));
		}
		sum /= size() - 1;

		return (slope / Math.abs(slope)) * Math.sqrt(1 - sum / (varSample()));
	}

	public double R2(double[] input, double[] weights) {
		double sum = 0;
		int terms = weights.length;
		

		// sum /= terms*(size()-1);

		// return (varSample()-sum)/varSample();
		return 1 - SSR(input,weights) / (var());
	}

	public double SSR(double[] input, double[] weights) {
		double sum = 0;
		int terms = weights.length;
		for (int i = 0; i < size(); i++) {
			double tempSum = 0;
			for (int w = 0; w < terms; w++) {
				tempSum += (weights[w] * Math.pow(input[i], w));
			}
			sum += (get(i) - tempSum) * (get(i) - tempSum);
			//sum += (get(i) - tempSum) * (get(i) - tempSum);
		}

		// sum /= terms*(size()-1);

		// return (varSample()-sum)/varSample();
		return sum;
	}
	
	public double MSE(double[] input, double[] weights) {
		double sum = 0;
		int terms = weights.length;
		for (int i = 0; i < size(); i++) {
			double tempSum = 0;
			for (int w = 0; w < terms; w++) {
				// sum += ((get(i) - (weights[w] * Math.pow(input[i],w) + biases[b])) * (get(i)
				// - (weights[w] * Math.pow(input[i],w) + biases[b])));
				// tempSum += ((get(i) - (weights[w] * Math.pow(input[i],w))) * (get(i) -
				// (weights[w] * Math.pow(input[i],w))));
				tempSum += (weights[w] * Math.pow(input[i], w));
				// sum += ((get(i) - (Math.pow(input[i] * weights[w] + biases[b],w))) * (get(i)
				// - (Math.pow(input[i] * weights[w] + biases[b],w))));
			}
			sum += (get(i) - tempSum) * (get(i) - tempSum);
		}

		// sum /= terms*(size()-1);

		// return (varSample()-sum)/varSample();
		return sum/input.length;
	}
	
	public double MSE(double[] input, double slope, double intercept) {
		return SSR(input,slope,intercept)/input.length;
	}
	
	
	public double polyReg(double[] input, int terms, int epoch,double learningRate) {
		terms++;
		double sum = 0;
		double step = 0.001;
		double[] weights = new double[terms];
		
		for (double weight : weights) {
			weight = 0;
			weights[0]=mean();
		}
		
		
		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = SSR(input, weights);
				weights[i] += step;
				double mutateW = SSR(input, weights);
				weights[i] -= step;

				
				
				double slope = ((orig-mutateW)/step);
				
				
				
				weights[i] += learningRate*slope;
				if(Math.abs(SSR(input, weights))>Math.abs(orig)) {
					//weights[i] -= learningRate*slope;
					//learningRate/=1.000001;
					//System.out.println("half"+learningRate);
				}
				
				
				
				
			}
			
			System.out.println(SSR(input,weights));
			
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);
		return max;
	}
	
	

	public double polyReg(double[] input, int terms, int epoch) {
		terms++;
		double sum = 0;
		double step = 0.001;
		double learningRate=0.001*Math.pow(10, -terms);
		double[] weights = new double[terms];
		
		for (double weight : weights) {
			weight = 0;
			weights[0]=mean();
		}
		
		
		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = SSR(input, weights);
				weights[i] += step;
				double mutateW = SSR(input, weights);
				weights[i] -= step;

				
				
				double slope = ((orig-mutateW)/step);
				
				
				
				weights[i] += learningRate*slope;
				if(Math.abs(SSR(input, weights))>Math.abs(orig)) {
					//weights[i] -= learningRate*slope;
					//learningRate/=1.000001;
					//System.out.println("half"+learningRate);
				}
				
				
				
				
			}
			
			System.out.println(SSR(input,weights));
			
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);
		return max;
	}

	
	public String polyRegStr(double[] input, int terms, int epoch,double learningRate) {
		terms++;
		double sum = 0;
		double step = 0.001;
		
		double[] weights = new double[terms];
		
		for (double weight : weights) {
			weight = 0;
			weights[0]=mean();
		}
		
		
		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = SSR(input, weights);
				weights[i] += step;
				double mutateW = SSR(input, weights);
				weights[i] -= step;

				
				
				double slope = ((orig-mutateW)/step);
				
				
				
				weights[i] += learningRate*slope;
				if(Math.abs(SSR(input, weights))>Math.abs(orig)) {
					//weights[i] -= learningRate*slope;
					//learningRate/=2;
					//System.out.println("half"+learningRate);
				}
				
				
				
				
			}
			
			System.out.println(SSR(input,weights));
			
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);

		// return (varSample()-sum)/varSample();
		String str = "";
		for (int i = terms-1; i >=0; i--) {
			str += "(" + weights[i] + "*x^" + (i) + "" + ")+";
		}
		str = str.replace("*x^0", "");
		str = str.replace("*x^1)", "x)");
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public String polyRegStr(double[] input, int terms, int epoch) {
		terms++;
		double sum = 0;
		double step = 0.001;
		double learningRate=0.001*Math.pow(10, -terms);
		double[] weights = new double[terms];
		
		for (double weight : weights) {
			weight = 0;
			weights[0]=mean();
		}
		
		
		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = SSR(input, weights);
				weights[i] += step;
				double mutateW = SSR(input, weights);
				weights[i] -= step;

				
				
				double slope = ((orig-mutateW)/step);
				
				
				
				weights[i] += learningRate*slope;
				if(Math.abs(SSR(input, weights))>Math.abs(orig)) {
					//weights[i] -= learningRate*slope;
					//learningRate/=2;
					//System.out.println("half"+learningRate);
				}
				
				
				
				
			}
			
			System.out.println(SSR(input,weights));
			
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);

		// return (varSample()-sum)/varSample();
		String str = "";
		for (int i = terms-1; i >=0; i--) {
			str += "(" + weights[i] + "*x^" + (i) + "" + ")+";
		}
		str = str.replace("*x^0", "");
		str = str.replace("*x^1)", "x)");
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public String polyRegStrRound(double[] input, int terms, int epoch, double decimal,double learningRate) {
		terms++;
		double sum = 0;
		double step = 0.001;
		double[] weights = new double[terms];
		double rounder = 0.5 * decimal;

		for (double weight : weights) {
			weight = Math.random();
		}

		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = R2(input, weights);
				weights[i] += step;
				double mutateW = R2(input, weights);
				weights[i] -= step;

				weights[i] -= learningRate * (orig - mutateW) / step;

				//System.out.println((orig - mutateW) / step);
			}
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);

		// return (varSample()-sum)/varSample();
		String str = "";
		for (int i = terms-1; i >=0; i--) {
			str += "(" + (int) (weights[i] + rounder) + "*x^" + (i) + "" + ")+";
		}
		str = str.replace("*x^0", "");
		str = str.replace("*x^1)", "x)");
		str = str.substring(0, str.length() - 1);
		return str;
	}

	
	public String polyRegStrRound(double[] input, int terms, int epoch, double decimal) {
		terms++;
		double sum = 0;
		double step = 0.001;
		double[] weights = new double[terms];
		double rounder = 0.5 * decimal;

		for (double weight : weights) {
			weight = Math.random();
		}

		for (int e = 0; e < epoch; e++) {
			for (int i = 0; i < terms; i++) {
				double orig = R2(input, weights);
				weights[i] += step;
				double mutateW = R2(input, weights);
				weights[i] -= step;

				weights[i] -= 0.01 * (orig - mutateW) / step;

				//System.out.println((orig - mutateW) / step);
			}
		}
		// return (varSample()-sum)/varSample();
		double[][] WB = new double[2][terms];
		for (int i = 0; i < terms; i++) {
			WB[0][i] = weights[i];
		}

		double max = R2(input, weights);

		// return (varSample()-sum)/varSample();
		String str = "";
		for (int i = terms-1; i >=0; i--) {
			str += "(" + (int) (weights[i] + rounder) + "*x^" + (i) + "" + ")+";
		}
		str = str.replace("*x^0", "");
		str = str.replace("*x^1)", "x)");
		str = str.substring(0, str.length() - 1);
		return str;
	}

//returns slope and intercept
	public double[] linReg(double[] input, int epoch) {
		double m = Math.random();
		double intercept = Math.random();
		double stepSize = 0.000001;
		double learningRate=1.0/epoch;
		for (int i = 0; i < epoch; i++) {
			System.out.println((MSE(input, m, intercept) - MSE(input, m + stepSize, intercept)) / stepSize);
			m += learningRate * (MSE(input, m, intercept) - MSE(input, m + stepSize, intercept)) / stepSize;
			intercept += learningRate * (MSE(input, m, intercept) - MSE(input, m, intercept + stepSize)) / stepSize;
//			if(MSE(input, m, intercept)>MSE(input, m+0.01, intercept)) {
//				m+=0.0001;
//			}
//			else {
//				m-=0.0001;
//			}
//			if(MSE(input, m, intercept)>MSE(input, m, intercept+0.1)) {
//				intercept+=0.000001;
//			}
//			else {
//				intercept-=0.000001;
//			}
			//System.out.println(R2(input, m, intercept));
		}
		System.out.println("y = "+m+"x + "+intercept);
		
		return new double[] { m, intercept };
	}

	public double median(int begin, int end) {
		double[] copy = copy();
		if ((begin + end) % 2 == 1) {
			return copy[((begin + end) / 2)];
		} else {
			return (get((begin + end) / 2) + get((begin + end) / 2 - 1)) / 2;
		}
	}

	public StatArray boxSummary() {
		double MIN = get(0);
		double Q1;
		double Q3;
		double MAX = get(size() - 1);
		int medIndex = size() / 2;

		Q1 = median(0, size() / 2);
		Q3 = median(size() / 2, size());

		double[] summary = { MIN, Q1, median(), Q3, MAX };
		return new StatArray(summary);
	}

	
	public double kMeans(int numClusters,int epoch) {
		if(numClusters<=0) {
			return Double.NaN;
		}
		
		
		double[] clusters= new double[numClusters];
		for(double num : clusters) {
			num=Math.random();
		}
		int[] grouping = new int[size()];
		for(int r=0; r<epoch; r++) {
			for(int i =0; i<size(); i++) {
				double dist=Double.MAX_VALUE;
				for(int clusterIndex=0;clusterIndex<numClusters; clusterIndex++) {
					dist=Math.abs(get(i)-clusters[clusterIndex]);
					if(Math.abs(get(i)-clusters[grouping[i]])>dist) {
						grouping[i]=clusterIndex;
					}
				}
			}
			for(int i =0; i<numClusters; i++) {
				double average=0;
				int total=0;
				for(int e=0; e<size(); e++) {
					if(grouping[e]==i) {
						average+=get(e);
						total++;
					}
				}
				if(total!=0) {
					average/=total;
					clusters[i]=average;
				}
			}
		}
		
		
		int total=0;
		double variance = 0;
		for(int i =0; i<numClusters; i++) {
			
			for(int e=0; e<size(); e++) {
				if(grouping[e]==i) {
					variance+=(clusters[grouping[e]]-get(i))*(clusters[grouping[e]]-get(i));
					total++;
				}
			}
			if(total!=0) {
				variance/=total;
			}
		}
		return variance;
		
	}
	
	
}

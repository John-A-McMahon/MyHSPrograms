package program;

import java.util.ArrayList;

public class Sorting {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int sortSize = 10000;

		ArrayList<Double> list = new ArrayList<>();
		randomize(list, sortSize);

		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < sortSize; i++) {
			intList.add((int) (Math.random() * 100));
		}
		// System.out.println(list);

		long timeStart = System.currentTimeMillis();

		// System.out.println(isSorted(bubble(list)));
		// bubble(list);
		System.out.println("bubble " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		// System.out.println(isSorted(insertion(list)));
		// insertion(list);
		System.out.println("insertion " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSortedInt(bucket(intList)));
		// bucket(intList);
		System.out.println("bucket " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(quick(list, 0, list.size() - 1)));
		// System.out.println(quick(list,0,list.size()-1));
		// mySort(list);
		System.out.println("quick " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(mergeSort(list)));
		// System.out.println(mergeSort(list));
		// mergeSort(list);
		System.out.println("merge (recursion) " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(mergeSortI(list)));
		// System.out.println(mergeSort(list));
		// mergeSort(list);
		System.out.println("merge (iteration) " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(heapSort(list)));
		// System.out.println(mergeSort(list));
		// mergeSort(list);
		System.out.println("heap " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

//		System.out.println(isSorted(bogoCombo(list)));
//		// System.out.println(mergeSort(list));
//		// mergeSort(list);
//		System.out.println("bogo " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(mySort(list)));
		// System.out.println(mySort(list));
		// mySort(list);
		System.out.println("mySort (recurision) " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(mySortI(list)));
		// System.out.println(mySort(list));
		// mySort(list);
		System.out.println("mySort (iteration) " + (System.currentTimeMillis() - timeStart));

		randomize(list, sortSize);
		timeStart = System.currentTimeMillis();

		System.out.println(isSorted(mySort2(list)));
		// System.out.println(mySort(list));
		// mySort(list);
		System.out.println("mySort 2 " + (System.currentTimeMillis() - timeStart));

	}

	public static ArrayList<Double> bubble(ArrayList<Double> list) {
		for (int e = 0; e < list.size(); e++) {
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) > list.get(i + 1)) {
					double x = list.get(i + 1);
					double y = list.get(i);
					list.set(i, x);
					list.set(i + 1, y);
				}
			}
		}
		return list;
	}

	public static ArrayList<Double> insertion(ArrayList<Double> list) {
		for (int e = 0; e < list.size(); e++) {
			for (int i = 0; i < e; i++) {
				if (list.get(i) > list.get(e)) {
					double x = list.get(e);
					double y = list.get(i);
					list.set(i, x);
					list.set(e, y);
				}
			}
		}
		return list;
	}

	public static ArrayList<Double> mySort(ArrayList<Double> list) {
		if (list.size() == 1) {
			return list;
		}
		double average = 0;
		for (int i = 0; i < list.size(); i++) {
			average += list.get(i);
		}
		average /= list.size();
		ArrayList<Double> smallNums = new ArrayList<>();
		ArrayList<Double> bigNums = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < average) {
				smallNums.add(list.get(i));
			} else {
				bigNums.add(list.get(i));
			}
		}
		list = mySort(smallNums);
		list.addAll(mySort(bigNums));

		// System.out.println(list.size());
		return list;

	}

	public static ArrayList<Double> mySortI(ArrayList<Double> a) {
		ArrayList<ArrayList<Double>> lists = new ArrayList<>();
		int l = a.size();
		int index = 0;
		while (lists.size() < l) {
			if (lists.size() > 0) {
				for (int i = 0; i < lists.size(); i++) {
					if (lists.get(i).size() > 1) {
						index = i;
						break;
					}
				}
				a = lists.get(index);
			}

			double average = 0;
			for (int i = 0; i < a.size(); i++) {
				average += a.get(i);
			}
			average /= a.size();
			ArrayList<Double> smallNums = new ArrayList<>();
			ArrayList<Double> bigNums = new ArrayList<>();
			for (int i = 0; i < a.size(); i += 0) {
				if (a.get(i) < average) {
					smallNums.add(a.remove(i));
				} else {
					bigNums.add(a.remove(i));
				}
			}
			lists.add(index, smallNums);
			lists.add(index + 1, bigNums);

		}

		ArrayList<Double> sorted = new ArrayList<>();
		for (ArrayList<Double> list : lists) {
			if (list.size() == 1) {
				sorted.add(list.get(0));
			}

		}
		return sorted;

	}

	public static ArrayList<Double> quick(ArrayList<Double> list, int low, int high) {
		if (low < high) {
			int pi = partition(list, low, high);

			quick(list, low, pi - 1);
			quick(list, pi + 1, high);
		}

		return list;

	}

	public static int partition(ArrayList<Double> list, int low, int high) {
		double pivot = list.get(high);
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (list.get(j) < pivot) {
				i++;
				swap(list, i, j);
			}
		}

		swap(list, i + 1, high);
		return i + 1;

	}

	public static ArrayList<Integer> bucket(ArrayList<Integer> list) {
		int max = list.get(0);
		int min = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		int[] posNums = new int[max + 1];
		int[] negNums = new int[Math.abs(Math.min(0, min))];

		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			if (temp >= 0) {
				posNums[temp]++;
			} else {
				negNums[-temp]++;
			}
		}

		ArrayList<Integer> sorted = new ArrayList<>();
		for (int i = 0; i < negNums.length; i++) {
			for (int e = 0; e < Math.abs(negNums[i]); e++) {
				if (negNums[i] != 0) {
					sorted.add(-i);
				}
			}
		}
		for (int i = 0; i < posNums.length; i++) {
			for (int e = 0; e < Math.abs(posNums[i]); e++) {
				if (posNums[i] != 0) {
					sorted.add(i);
				}
			}
		}

		return sorted;

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

	public static ArrayList<Double> mergeSortI(ArrayList<Double> a) {
		ArrayList<ArrayList<Double>> lists = new ArrayList<>();
		for (int i = 0; i < a.size(); i += 0) {
			ArrayList<Double> temp = new ArrayList<>();
			temp.add(a.remove(i));
			lists.add(temp);
		}
		for (int i = 0; i < lists.size() - 1; i += 0) {
			if (i + 1 < lists.size()) {
				merge(lists.get(i), lists.remove(i + 1));
			}
		}
		return lists.get(0);

	}

	public static ArrayList<Double> heapSort(ArrayList<Double> a) {
		ArrayList<Double> sorted = new ArrayList<>();
		buildMaxHeap(a);
		int i = 0;
		while (a.size() - i > 0) {

			swap(a, 0, i);
			heapify(a, a.size() - i - 1);
			// sorted.add(0,a.remove(0));
			i++;
			// System.out.println(i);

		}
		return sorted;
	}

	public static void buildMaxHeap(ArrayList<Double> a) {
		boolean r = false;
		for (int i = 0; i < a.size(); i++) {
			if (r) {
				i = 0;
				r = false;
			}
			if (2 * i + 1 < a.size()) {
				if (a.get(i) < a.get(2 * i + 1)) {
					swap(a, i, 2 * i + 1);
					r = true;

				}
				if (2 * i + 2 < a.size()) {
					if (a.get(i) < a.get(2 * i + 2)) {
						swap(a, i, 2 * i + 2);
						r = true;
					}
				}
			}
		}
		// System.out.println(a);
	}

	public static void heapify(ArrayList<Double> a, int end) {
		for (int i = 0; i < end; i += 0) {

			if ((2 * i + 1 < end && a.get(i) < a.get(2 * i + 1)) || (2 * i + 2 < end && a.get(i) < a.get(2 * i + 2))) {
				if (a.get(i) < a.get(2 * i + 1)) {
					swap(a, i, 2 * i + 1);
					i = 2 * i + 1;
				}
				if (2 * i + 2 < end) {
					if (a.get(i) < a.get(2 * i + 2)) {
						swap(a, i, 2 * i + 2);
						i = 2 * i + 2;
					}
				}
			} else {
				break;
			}
		}
		// System.out.println(a);
	}

	public static ArrayList<Double> bogoRandom(ArrayList<Double> a) {
		while (!isSorted(a)) {
			for (int i = 0; i < a.size(); i++) {
				swap(a, i, (int) (Math.random() * i));
			}
		}
		return a;
	}

	public static ArrayList<Double> bogoCombo(ArrayList<Double> a) {
		// double[][] combos=new double[a.size()][factorial(a.size())];
		ArrayList<ArrayList<Double>> lists = new ArrayList<>();

		int index = 1;
		ArrayList<Double> sorted = new ArrayList<>();
		while (a.size() > 0) {
			sorted.add(0, a.remove(0));
			for (int i = 0; i < sorted.size() - 1; i++) {
				if (isSorted(sorted)) {
					break;
				}
				swap(sorted, i, i + 1);
			}

		}
		System.out.println(a);
		return sorted;

	}

	public static void randomize(ArrayList<Double> list, int elements) {
		list.removeAll(list);
		for (int i = 0; i < elements; i++) {
			list.add(Math.random() * 100);
		}
	}

	public static ArrayList<Double> reverse(ArrayList<Double> a) {
		ArrayList<Double> b = new ArrayList<>();
		for (int i = a.size() - 1; i > 0; i--) {
			b.add(a.get(i));
		}
		return b;
	}

	public static boolean isSorted(ArrayList<Double> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSortedInt(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void swap(ArrayList<Double> list, int index1, int index2) {
		double temp = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}

	public static int factorial(int num) {
		if (num <= 1) {
			return 1;
		}
		return num * factorial(num - 1);
	}

	public static ArrayList<Double> mySort2(ArrayList<Double> list) {
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1)>list.get(i)) {
				swap(list,i,i-1);
				i=1;
			}
			System.out.println(i);
			
		}

		return list;
	}

}

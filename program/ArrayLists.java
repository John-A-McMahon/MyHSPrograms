package program;
import java.util.ArrayList;

public class ArrayLists {
public static void main(String[] args) {
	ArrayList<Integer> myArrayList = fillWithRandom(1,100,100);
	
	//System.out.println(myArrayList);
	
	//System.out.println(myArrayList.size());
	
	//System.out.println( removeEvens(myArrayList));
	///System.out.println(myArrayList.size());
	
	//System.out.println(everyOtherZero(myArrayList));
	System.out.println(moveMinToFront(myArrayList));
}

public static ArrayList<Integer> fillWithRandom(int lowRange, int highRange, int size){
	ArrayList<Integer> r= new ArrayList<>();
	for(int i = 0; i<size; i++) {
		r.add((int) (Math.random()*(highRange-lowRange+1)+lowRange));
	}
	return r;
}
public static ArrayList<Integer> removeEvens(ArrayList<Integer> a){
	int size = a.size();
	for(int i = 0; i<a.size(); i++) {
		if(a.get(i)%2==0) {
			 a.remove(i);
			 i--;
		}
		
		
	}
	
	return a;
}
public static ArrayList<Integer> everyOtherZero (ArrayList<Integer> a){
	for(int i = 0; i<a.size(); i+=2) {
		a.add(i,0);
	}
	return a;
}
public static ArrayList<Integer> moveMinToFront(ArrayList<Integer> a){
	int min = a.get(0);
	int minIndex = 0;
	for(int i = 0; i<a.size(); i++) {
		if(a.get(i)<min) {
			min = a.get(i);
			minIndex = i;
		}
	}
	a.add(0,min);
	a.remove(minIndex+1);
	return a;
	
}
}

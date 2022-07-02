package program;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java..Matrix;
public class Scan {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
//	System.out.println("X");
//	String x= sc.nextLine();
//	System.out.println("Y");
//	System.out.println("Y");
//	String y= sc.nextLine();
//	Random r = new Random();
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
//	System.out.println(r.nextInt(3));
	int[] a = {1,2,3};
	int[] b;
	double slope = 3.14159923243423;
	slope=Math.round((((int)(slope*10000))))/10000.0;
	//System.out.println(slope);
	//Matrix m = new Matrix();
	b=a;
	a[0]=0;
	String x = "hello";
	String y=x;
	x="hi";
	ArrayList<Integer> xx =new ArrayList<>();
	xx.add(100);
	//System.out.println(xx.toString().length());
	//System.out.println(b[0]);
	
	
	
	int[][] arr= {{0,1,2},
					{3,4,5},
					{6,7,7}
	};
	
	int[] col =getColumn(arr,0);
	for(int i=0; i<col.length; i++) {
		System.out.println(col[i]);
	}
	
	int[][] numbers = {
			{30, 4, 15, 6},
			{40, 35, 30, 25},
			{5, 8, 7, 3}
			};
	
//	for(int i=0; i<5; i++) {
//		mystery2d(numbers);
//	}
	//mystery2d(numbers);
	
	
	
	
}


//Im unsure if we are supposed to include this since it is above but here it is
public static int[] getColumn(int[][] arr2D, int c)
{

int[] colArr = new int[arr2D.length];
//only 1 for loop because the colum remains constant
for(int r=0; r<arr2D.length; r++){
colArr[r]=arr2D[r][c];
}

//return the filled in column array
return colArr;
}



public static void mystery2d(int[][] a) {
for (int r = 0; r < a.length; r++) {
for (int c = 0; c < a[0].length - 1; c++) {
if (a[r][c + 1] < a[r][c]) {
a[r][c] = a[r][c + 1];
}
System.out.println(a[r][c]);
}
System.out.println(a[r][a[r].length-1]);
}
}
}

package program;

public class ImprovedIntArray {
	String type;
	boolean[] booleanArray;
	byte[] byteArray;
	short[] shortArray;
	int[] intArray;
	long[] longArray;
	float[] floatArray;
	double[] doubleArray;
	
	public ImprovedIntArray(int[] nums) {
		//this.type="int";
		this.intArray=nums;
	}
	public ImprovedIntArray(String type) {
		this.type=type;
		
		if(this.type.equals("int")) {
			
		}
		this.intArray=new int[0];
		
	}
	
	
	public void add(int x) {
		int[] placeholder=new int[intArray.length+1];
		placeholder[placeholder.length-1]=x;
		for(int i=0; i<intArray.length; i++) {
			placeholder[i]=this.intArray[i];
		}
		this.intArray=placeholder;
	}
	
	public void add(int x,int index) {
		int[] placeholder=new int[intArray.length+1];
		placeholder[index]=x;
		for(int i=0; i<intArray.length; i++) {
			if(i<index) {
				placeholder[i]=this.intArray[i];
			}
			if(i>=index) {
				placeholder[i+1]=this.intArray[i];
			}
			
		}
		this.intArray=placeholder;
	}
	
	public int get(int index) {
		return intArray[index];
	}
	public void set(int index, int value) {
		intArray[index]=value;
	}
	public int remove(int index) {
		int[] placeholder=new int[intArray.length-1];
		int removedNumber=intArray[index];
		for(int i=0; i<intArray.length; i++) {
			if(i==index) {
				continue;
			}
			else if(i<index) {
				placeholder[i]=intArray[i];
			}
			
			else if(i>index){
				placeholder[i-1]=intArray[i];
			}
			
			
		}
		intArray=placeholder;
		
		return removedNumber;
	}
	
	public void removeAll(int num) {
		for(int i=0; i<intArray.length; i++) {
			if(intArray[i]==num) {
				remove(i);
				i--;
			}
		}
	}
	
	
	
	public boolean contains(int num) {
		
		for(int i=0; i<this.intArray.length; i++) {
			if(intArray[i]==num) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
}

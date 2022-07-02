package program;
import java.util.Scanner;

public class PunnettSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Father's gene:");
		String fatherGene=sc.nextLine();
		System.out.println("Mother's gene:");
		String motherGene=sc.nextLine();
		String placeholder;
		
		String topLeft=fatherGene.charAt(0)+""+motherGene.charAt(0);
		String topRight=fatherGene.charAt(0)+""+motherGene.charAt(1);
		String bottomLeft=fatherGene.charAt(1)+""+motherGene.charAt(0);
		String bottomRight=fatherGene.charAt(1)+""+motherGene.charAt(1);
		
		if(topLeft.charAt(0)>topLeft.charAt(1)) {
			placeholder=topLeft.charAt(0)+"";
			topLeft=topLeft.charAt(1)+""+placeholder;
			
		}
		if(topRight.charAt(0)>topRight.charAt(1)) {
			placeholder=topRight.charAt(0)+"";
			topRight=topRight.charAt(1)+""+placeholder;
			
		}
		
		if(bottomLeft.charAt(0)>bottomLeft.charAt(1)) {
			placeholder=bottomLeft.charAt(0)+"";
			bottomLeft=bottomLeft.charAt(1)+""+placeholder;
			
		}
		if(bottomRight.charAt(0)>bottomRight.charAt(1)) {
			placeholder=bottomRight.charAt(0)+"";
			bottomRight=bottomRight.charAt(1)+""+placeholder;
			
		}
		
		System.out.println("Possiblities:");
		System.out.print(topLeft+"|");
		System.out.println(topRight);
		System.out.print(bottomLeft+"|");
		System.out.println(bottomRight);
		
		

	}

}

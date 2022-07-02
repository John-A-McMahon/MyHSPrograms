package program;

import java.util.ArrayList;

public class Economy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sellers = 100;
		int buyers = 100;
		int lowestPrice = 0;
		int highestPrice = 0;
		int highestDemand = 0;
		double averagePrice = 0;
		double averageDemand = 0;
		double immigrationRate = 0.0;
		long pastTime = System.currentTimeMillis();
		ArrayList<Integer> prices = new ArrayList<>();
		for(int i = 0; i<sellers; i++) {
			prices.add( (int) (Math.random()*100+10));
		}
		ArrayList<Integer> willingToPay = new ArrayList<>();
		for(int i = 0; i<buyers; i++) {
			willingToPay.add( (int) (Math.random()*100+10));
		}
		
		
		
		while(true) {
			
			//to reduce lag
			if(sellers+buyers>2000) {
				immigrationRate=0;
			}
			else {
				immigrationRate=1;
			}
			
			if(System.currentTimeMillis()-pastTime>100) {
				lowestPrice = prices.get(0);
				highestPrice = prices.get(0);
				highestDemand = willingToPay.get(0);
				for(int i = 0; i<buyers; i++) {
					for(int e = 0; e<sellers; e++) {
						if(prices.get(e)<lowestPrice) {
							lowestPrice = prices.get(e);
							if(lowestPrice<10) {
								prices.remove(e);
								sellers--;
								continue;
								//prices.set(i,(int)(prices.get(i)*0.9));
							}
						}
						if(prices.get(e)>highestPrice) {
							highestPrice = prices.get(e);
							if(highestPrice>highestDemand+5) {
								prices.set(e,(int)(prices.get(e)*0.9));
								
							}
						}
					}
					
					if(lowestPrice>willingToPay.get(i)) {
						willingToPay.set(i,(int)(willingToPay.get(i)*0.9));
						if(willingToPay.get(i)<10) {
							//willingToPay.remove(i);
							//buyers--;
							willingToPay.set(i,(int)(willingToPay.get(i)*1.1));
						}else {
							
							//prices.set(prices.indexOf(lowestPrice), (int) (prices.get(prices.indexOf(lowestPrice))*1.1));
							
							
						}
					}
				}
				
				for(int i = 0;i<prices.size(); i++) {
					
					prices.set(i, (int)(prices.get(i)*1.1));
					averagePrice+=prices.get(i);
				}
				for(int i = 0;i<willingToPay.size(); i++) {
					willingToPay.set(i, (int)(willingToPay.get(i)*0.9));
					averageDemand+=willingToPay.get(i);
				}
				averagePrice/=prices.size();
				averageDemand/=willingToPay.size();
				
				if(averageDemand<averagePrice||sellers>buyers) {
					for(int i = 0;i<willingToPay.size(); i++) {
						//losing intrest
						if(willingToPay.get(i)<10) {
							willingToPay.remove(i);
							buyers--;
							//willingToPay.add( (int) (averageDemand*Math.random()*2+10));
							//buyers++;
						}
						
						if(Math.random()*Math.random()>1-immigrationRate) {
							willingToPay.add( (int) (averageDemand*Math.random()*2));
							buyers++;
						}
						
					}
					
					
					for(int i = 0;i<prices.size(); i++) {
						
						
						//going out of business
						if(prices.get(i)<10) {
							prices.remove(i);
							sellers--;
							//System.out.println("hello");
							continue;
							//willingToPay.add( (int) (averageDemand*Math.random()*2+10));
							//buyers++;
						}
						
						if(Math.random()>1-immigrationRate) {
							prices.add( (int) (averagePrice*Math.random()*2));
							sellers++;
						}
						
						//as demand lowers prices lower
						if(prices.get(i)>averageDemand/2||sellers>buyers) {
							prices.set(i, (int)(prices.get(i)*(1.0*buyers/sellers)));
						}
						
						
						
						
						
						
						//averagePrice+=prices.get(i);
					}
				}
				if(averageDemand>averagePrice||sellers<buyers) {
					for(int i = 0;i<prices.size(); i++) {
						
						prices.set(i, (int)(prices.get(i)*(1.0*buyers/sellers)));
						//averagePrice+=prices.get(i);
					}
				}
				
				
				
				
				if(Math.random()*Math.random()>1-immigrationRate) {
					willingToPay.add( (int) (averageDemand*Math.random()*2));
					buyers++;
					//prices.add( (int) (averagePrice*Math.random()*2));
					//sellers++;
				}
				
				System.out.println("buyers:"+buyers);
				System.out.println("sellers:"+sellers);
				System.out.println("average Price:"+averagePrice);
				System.out.println("average Demand:"+averageDemand);
				pastTime=System.currentTimeMillis();
				
				
			}
			
		}
		

	}

}

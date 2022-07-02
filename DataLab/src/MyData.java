import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.data.DataSource;

public class MyData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataSource ds = DataSource.connect("http://api.kivaws.org/v1/loans/newest.json").load();
		
		// DataSource ds
		// =DataSource.connectAs("xml","https://data.cdc.gov/api/views/xmrr-rw5u/rows.xml?accessType=DOWNLOAD"
		// );
		
		ds.printUsageString();

		ArrayList<String> names = ds.fetchStringList("loans/name");
		ArrayList<String> loanAmount = ds.fetchStringList("loans/loan_amount");
		ArrayList<String> sector = ds.fetchStringList("loans/sector");
		ArrayList<String> credit = ds.fetchStringList("loans/bonus_credit_eligibility");
		ArrayList<String> use = ds.fetchStringList("loans/use");
		
		//ArrayList<Loans> loans = ds.fetchStringList("loans");
		//System.out.println(use);
		while(true) {
		ds.load();
		int index = -1;
		System.out.println("What do you want to search for");
		Scanner sc = new Scanner(System.in);
		String search = sc.nextLine();

		if (search.equals("name")) {
			System.out.println("Who do you want to search for");
			String name = sc.nextLine();
			double m = Double.MIN_VALUE;
			double bestM = 0;
			String md = "";
			String tempName = name;
			String tempN = "";
			for (String n : names) {
				tempN = n.toLowerCase();
				tempName = name.toLowerCase();
				m = 0;

				if (tempN.length() < tempName.length()) {
					for (int i = 0; i < tempN.toCharArray().length; i++) {
						if (tempN.charAt(i) == tempName.charAt(i)) {
							m++;
						}
					}
				} else if (tempN.length() > tempName.length()) {
					for (int i = 0; i < tempName.toCharArray().length; i++) {
						if (tempN.charAt(i) == tempName.charAt(i)) {
							m++;
						}
					}
				} else {
					for (int i = 0; i < tempName.toCharArray().length; i++) {
						if (tempN.charAt(i) == tempName.charAt(i)) {
							m++;
						}
					}
				}

				if (m > bestM) {
					bestM = m;
					md = n;
					index=names.indexOf(n);
				}

			}

			System.out.println(md);
			System.out.println(names);
			System.out.println(bestM);
			System.out.println(names.get(index)+" sector: "+sector.get(index)+" amount: $"+loanAmount.get(index)+" use "+use.get(index));
			

		}
		
		
		if (search.equals("biggest loan")) {
			double biggest = Double.MIN_VALUE;
			for(int i=0; i<loanAmount.size(); i++) {
				if(Double.valueOf(loanAmount.get(i))>biggest) {
					index=i;
					biggest=Double.valueOf(loanAmount.get(i));
				}
			}
			System.out.println(names.get(index)+" sector: "+sector.get(index)+" amount: $"+loanAmount.get(index)+" use "+use.get(index));
		}
		
		
		if (search.equals("use")) {
			System.out.println("What keyword do you want to search for");
			String keyword=sc.nextLine();
			for(int i=0; i<use.size(); i++) {
				for(int e=0; e<use.get(i).length(); e++) {
					if(keyword.charAt(0)==use.get(i).charAt(e)&&e+keyword.length()<use.get(i).length()) {
						if(use.get(i).substring(e,e+keyword.length()).equals(keyword)) {
							
							index=i;
							System.out.println(names.get(index)+" sector: "+sector.get(index)+" amount: $"+loanAmount.get(index)+" use "+use.get(index));
							//i++;
						}
					}
				}
			}
			
		}
		
		if (search.equals("refresh")) {
			ds.clearENTIRECache();
		}
		
		}

		// String names=ds.fetchString("loans/");
//		//System.out.println(names);
		// ArrayList<Long> names = ds.fetchLongList("data/new_cases");
		// ds.fetchList("data/new_cases");
//		ArrayList<Double> loans = ds.fetchDoubleList("loans/loan_amount");
		// System.out.println();
//		System.out.println(loans);

		// ArrayList<String> states = ds.fetch("state");

		// String county = ds.fetchString("county").toString();
		// System.out.println(ds.fetch("location").getClass());
		// String location = ds.fetch("location");

		// ds.fetchString("Counties");
		// ds.load();
		// System.out.println(ds.getDescription());
		// ArrayList<Countries> countries = ds.fetchList("Countries");

	}

}

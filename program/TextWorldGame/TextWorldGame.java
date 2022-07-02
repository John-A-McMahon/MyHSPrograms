package program.TextWorldGame;

import java.util.Scanner;
import java.util.ArrayList;

public class TextWorldGame extends Territories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int turn = 0;
		double treasuary = 0;

		
		ArrayList<String> defeatedNations = new ArrayList<>();
		
		
		ArrayList<String> axis = new ArrayList<>();
		axis.add("Germany");
		axis.add("Italy");
		axis.add("Japan");
		ArrayList<String> allies = new ArrayList<>();
		allies.add("Great Britian");
		allies.add("France");
		ArrayList<String> neutral = new ArrayList<>();
		neutral.add("United States");
		neutral.add("USSR");

		String input = "";
		String mover = "";
		String destination = "";
		double train = 0;
		String building = "";
		int percent = 0;
		String attacker = "";
		String attackingNation = "";
		String defender = "";
		
		

		// stats
		double[][] stats = {
				// population, tfr,army size,economy,economic growth,tech level
				// united states
				{ 130, 2.5, 0.3, 200, 1.03,4 },
				// great britian
				{ 550, 3, 3, 70, 1.03,3 },
				// france
				{ 100, 2.5, 2, 70, 1.03,2 },
				// germany
				{ 80, 3, 4, 110, 1.04,6 },
				// Italy
				{ 55, 3.1, 3, 60, 1.03,3 },
				// japan
				{ 300, 2.5, 3, 60, 1.003,3 },
				// USSR
				{ 170, 2.5, 11, 60, 1.005,2 },

				//
		};
		
		

		Scanner sc = new Scanner(System.in);
		ArrayList<String> countries = new ArrayList<>();
		countries.add("United States");
		countries.add("Great Britian");
		countries.add("France");
		countries.add("Germany");
		countries.add("Italy");
		countries.add("Japan");
		countries.add("USSR");

		addUSA();
		addGreatBritian();
		addFrance();
		addGermany();
		addItaly();
		addJapan();
		addUSSR();
		// addTerritory("Berlin","Germany",1,0.5);

		String country = "";
		while (country.equals("")) {
			System.out.println("Choose your country! "+countries+"");
			country = sc.nextLine();
			if (countries.contains(country)) {
				System.out.println("You are " + country);
			} else {
				country = "";
			}

		}

		while (stats[countries.indexOf(country)][0] > 0&&allies.size()>0&&axis.size()>0) {
			for (String c : countries) {
				if (!territoryOwners.contains(c)&&!defeatedNations.contains(c)) {
					System.out.println(c + " has been defeated");
					//countries.remove(countries.indexOf(c));
					defeatedNations.add(c);
					if(allies.contains(c)) {
						allies.remove(allies.indexOf(c));
					}
					if(axis.contains(c)) {
						axis.remove(axis.indexOf(c));
					}
					continue;
				}
				if(defeatedNations.contains(c)) {
					continue;
				}
			}
			territoryArmyPercent = resetAllAttackPercents(territoryArmyPercent, territoryOwners);
			territoryPopulationPercent = resetAllPopulationPercents(territoryPopulationPercent, territoryOwners);
			for (int i = 0; i < countries.size(); i++) {
				//stats[i][3] = resetValues(territoryValue, territoryOwners, countries.get(i));
			}
			input = sc.nextLine();

			if (input.equalsIgnoreCase("commands")) {
				System.out.println("stats");
				System.out.println("my territory");
			}
			if (input.equalsIgnoreCase("end turn")) {

				// ai attack
				for (String c : countries) {
					if (c.equals(country)||defeatedNations.contains(c)) {
						continue;
					}
					attacker = c;
					defender = "";
					while (defender.equals("")) {
						defender = territoryNames.get((int) (Math.random() * territoryNames.size()));

						if (!territoryOwners.get(territoryNames.indexOf(defender)).equals(attacker)
								&& !(axis.contains(attacker) && axis.contains(defender))
								&& !(allies.contains(attacker) && allies.contains(defender))) {
							if (neutral.contains(attacker)) {

								if (neutralJoin(attacker, defender, axis, allies, neutral).equals("axis")) {
									axis.add(attacker);
									System.out.println(c + " joined the axis");
								} else {
									allies.add(attacker);
									System.out.println(c + " joined the allies");
								}
								neutral.remove(neutral.indexOf(c));
							}

							if ((axis.contains(attacker)
									&& allies.contains(territoryOwners.get(territoryNames.indexOf(defender))))
									|| (axis.contains(territoryOwners.get(territoryNames.indexOf(defender)))
											&& allies.contains(attacker))) {

								break;
							} else {
								// if(allies.size()==0) {}
								defender = "";
							}

						} else {
							defender = "";
						}

					}
					for (int i = 0; i < countries.size(); i++) {
						if (!countries.get(i).equals(attacker) && !countries.get(i).equals(country)) {
							System.out.println(attacker + " is attacking " + defender);
							attackingNation = attacker;

							attacker = territoryNames.get(i);
							while (System.currentTimeMillis() % 1000 != 0) {

							}

							// enSystem.out.println(stats[countries.indexOf(attackingNation)][2]);
							if (stats[countries.indexOf(attackingNation)][2]
									* territoryArmyPercent.get(territoryNames.indexOf(attacker)) > territoryArmyPercent
											.get(territoryNames.indexOf(defender))
											* stats[countries.indexOf(
													territoryOwners.get(territoryNames.indexOf(defender)))][2]) {
								
								//Casualties 
								stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(attacker)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(defender))*(Math.random()*2);
								territoryArmyPercent.set(i,territoryArmyPercent.get(i)*Math.random());
								stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(attacker));
								
								territoryOwners.set(territoryNames.indexOf(defender), attackingNation);
								territoryArmyPercent.set(territoryNames.indexOf(defender), 0.0);
								System.out.println(attackingNation + "\'s won");
							} else {
								
								//Casualties 
								stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(attacker)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(defender));
								stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(attacker))*(Math.random()*2);
								territoryArmyPercent.set(territoryNames.indexOf(defender),territoryArmyPercent.get(territoryNames.indexOf(defender))*Math.random());
								
								stats[countries.indexOf(attackingNation)][2] = stats[countries.indexOf(attackingNation)][2]
										- (stats[countries.indexOf(attackingNation)][2]
												* territoryArmyPercent.get(territoryNames.indexOf(attacker)));
								territoryArmyPercent.set(territoryNames.indexOf(attacker), 0.0);
								System.out.println(attackingNation + "\'s army was defeated");
							}
							// attacker = "";
							// defender = "";
							// attackingNation = "";
							break;

						}
					}

				}

				// stat updates
				for (int i = 0; i < countries.size(); i++) {
					
					//population growth
					stats[i][0] *= (stats[i][1] / 2.5);
					stats[i][1] = stats[i][1]+(2.5-stats[i][1])*0.5;
					
					//economic growth
					for(int e = 0; e<territoryNames.size(); e++) {
						if(countries.get(i).equals(territoryOwners.get(e))) {
							//System.out.println("hi");
							territoryValue.set(e,territoryValue.get(e)*stats[i][4]);
							stats[i][4]=stats[i][4]+(1-stats[i][4])*0.5;
						}
						
					}
					
					//stats[i][3] *= stats[i][4];
					
					
					//ai army training and movements
					if (!countries.get(i).equals(country) && stats[i][2]<stats[i][0]*0.4-stats[i][2]) {
						//System.out.println(!countries.get(i).equals(country));
						stats[i][2] += stats[i][0] * 0.5 * 0.9 * Math.random()*0.01;
						stats[i][0]-=stats[i][2];
						
						for(int e = 0; e<territoryNames.size(); e++) {
							if(Math.random()<0.1&&!territoryOwners.get(i).equals(country)) {
								territoryArmyPercent.set(i,Math.random());
							}
						}
						
					} else {
						System.out.println("taxes collected:" + (stats[i][3] - treasuary) * 0.2 + " B");
						treasuary += (stats[i][3]) * 0.2;
						//stats[i][3] = (stats[i][3] - treasuary);
						System.out.println("total" + treasuary);
						//stats[i][3] *= stats[i][4];

					}
				}

			}

			
			
			
			
			
			
			
			//stats
			if (input.equalsIgnoreCase("stats")) {
				checkStats(country, countries, stats);
				System.out.println("treasuary:"+treasuary+"B");

			}

			
			
			
			
			
			
			//alliances
			if (input.equalsIgnoreCase("alliances")) {
				System.out.println("Axis:" + axis);
				System.out.println("Allies:" + allies);
				System.out.println("Neutral:" + neutral);

			}

			
			
			
			
			
			
			//Game winner
			if (axis.size() == 0 || allies.size() == 0) {
				break;
			}

			
			
			
			
			
			
			
			
			// train troops
			if (input.equalsIgnoreCase("train")) {
				System.out.println("Treasuary, "+treasuary+"B");
				System.out.println("How many (in millions) ($1B = 1m troops)");
				train = sc.nextDouble();
				if (train > treasuary) {
					System.out.println("You do not have enough funds in your treasuary to train that number of troops");

				}
				else if (train > stats[countries.indexOf(country)][0]*0.5*0.4) {
					System.out.println("You do not have a big enough recrutable population train that number of troops");
					System.out.println("Grow your population to recruit more troops");

				}
				else {
					for (int i = 0; i < territoryOwners.size(); i++) {
						if (territoryOwners.get(i).equals(country)) {
							territoryArmyPercent.set(i,
									territoryArmyPercent.get(i) + (territoryPopulationPercent.get(i) * train));
						}
					}
					System.out.println("trained " + train + " million troops");
					stats[countries.indexOf(country)][2]+=train;
					territoryArmyPercent = resetAllAttackPercents(territoryArmyPercent, territoryOwners);
					treasuary-=train;
				}

			}
			
			
			//build
			if (input.equalsIgnoreCase("build")) {
				System.out.println("Treasuary, "+treasuary+"B");
				System.out.println("What?");
				System.out.println("Factory, 0.2B");
				System.out.println("Farm, 0.1B");
				System.out.println("lab, 0.2B");
				
				
				building = sc.nextLine();
				if (building.equalsIgnoreCase("factory")&&0.2 > treasuary) {
					System.out.println("You do not have enough funds in your treasuary to build that");

				}
				else if (building.equalsIgnoreCase("Farm")&&0.2 > treasuary) {
					System.out.println("You do not have enough funds in your treasuary to build that");

				}
				else if (building.equalsIgnoreCase("lab")&&0.2 > treasuary) {
					System.out.println("You do not have enough funds in your treasuary to build that");

				}
				else if(building.equalsIgnoreCase("factory")||building.equalsIgnoreCase("farm")||building.equalsIgnoreCase("lab")) {
					
					System.out.println("built " + building + " ");
					if (building.equalsIgnoreCase("factory")) {
						stats[countries.indexOf(country)][4]*=1.2;

					}
					if (building.equalsIgnoreCase("Farm")) {
						stats[countries.indexOf(country)][1]*=1.2;

					}
					if (building.equalsIgnoreCase("lab")) {
						System.out.println("You do not have enough funds in your treasuary to train that number of troups");

					}
					treasuary-=0.2;
					
				}
				else {
					System.out.println("Invalid building");
				}

			}

			
			// move troops
			if (input.equalsIgnoreCase("move")) {
				mover = "";
				destination="";
				percent = 0;
				System.out.println("Which territory?");
				while (!territoryNames.contains(mover) && territoryNames.indexOf(mover) == -1
						|| !territoryOwners.get(territoryNames.indexOf(mover)).equals(country)) {
					mover = stringInput(sc);
				}
				System.out.println("What %?");
				while (percent == 0 || percent > 100) {
					percent = sc.nextInt();
				}
				System.out.println("To?");
				while (!territoryNames.contains(destination) && territoryNames.indexOf(destination) == -1
						|| !territoryOwners.get(territoryNames.indexOf(destination)).equals(country)) {
					destination = stringInput(sc);
				}

				
				
				territoryArmyPercent.set(territoryNames.indexOf(destination),
						territoryArmyPercent.get(territoryNames.indexOf(destination))+ territoryArmyPercent.get(territoryNames.indexOf(mover)) *( ((double) percent / 100)));
				
				territoryArmyPercent.set(territoryNames.indexOf(mover),
						territoryArmyPercent.get(territoryNames.indexOf(mover)) *(1- ((double) percent / 100)));
				
				System.out.println("Troops moved from " + mover + " to " + destination);

			}
			
			if (input.equalsIgnoreCase("move to defend")) {
				for(int i = 0; i<territoryNames.size(); i++) {
					if(territoryOwners.get(i).equals(country)) {
						territoryArmyPercent.set(i,1.0);
					}
					
				}
				territoryArmyPercent = resetAllAttackPercents(territoryArmyPercent, territoryOwners);
				System.out.println("troops equally dispersed");

			}
			

			// my territory
			if (input.equalsIgnoreCase("my territory")) {
				for (int i = 0; i < territoryNames.size(); i++) {
					if (territoryOwners.get(i).equals(country)) {
						System.out.print(territoryNames.get(i));
						System.out.print("  Population "
								+ (double) ((int) (territoryPopulationPercent.get(i) * 1000)) / 10 + "%");
						System.out.print("  Percent of total army: " + (double)((int) (territoryArmyPercent.get(i) * 1000))/10 + "%");
						System.out.print("  Army in numbers:" + (territoryArmyPercent.get(i) * stats[countries.indexOf(territoryOwners.get(i))][2]) + " million troops");
						System.out.println("  Value " + territoryValue.get(i));
					}
				}

			}

			if (input.equalsIgnoreCase("spy")) {
				defender = "";
				System.out.println("On who?");
				while (!territoryOwners.contains(defender) && territoryNames.indexOf(defender) == -1
						&& !defender.equals(country)) {
					defender = stringInput(sc);
				}
				for (int i = 0; i < stats[countries.indexOf(defender)].length; i++) {
					if (i == 0) {
						System.out.print("total Population (in millions):");
					}
					if (i == 1) {
						System.out.print("TFR:");
					}
					if (i == 2) {
						System.out.print("Total Army Size (in millions):");

					}
					if (i == 3) {
						System.out.print("Econemy Size (GDP in billions):");
					}
					if (i == 4) {
						System.out.print("Economic Growth:");
						System.out.println((stats[countries.indexOf(defender)][i] - 1) * 100 + "%");
						
					}
					if (i == 5) {
						System.out.print("Tech level:");
					}
					
					if(i!=4) {
						System.out.println(stats[countries.indexOf(defender)][i]);
					}
					if (i == 5) {
						System.out.println();
					}

				}

				for (int i = 0; i < territoryNames.size(); i++) {
					if (territoryOwners.get(i).equals(defender)) {
						System.out.print(territoryNames.get(i));
						System.out.print("  Population "
								+ (double) ((int) (territoryPopulationPercent.get(i) * 1000)) / 10 + "%");
						System.out.print("  Army percent of total army stationed: "
								+ (int) (territoryArmyPercent.get(i) * 100) + "%");
						System.out.print("  Army in numbers "
								+ (territoryArmyPercent.get(i) * stats[countries.indexOf(territoryOwners.get(i))][2])
								+ "m troops");
						System.out.println("  Value " + territoryValue.get(i));
					}
				}
				defender = "";
			}

			// player attack
			if (input.equalsIgnoreCase("attack")) {
				defender = "";
				attacker = "";
				System.out.println("Providences:");
				for (int i = 0; i < territoryNames.size(); i++) {
					if (!territoryOwners.get(i).equals(country)&&(
							 (axis.contains(country) && !axis.contains(territoryOwners.get(i)))
							|| (allies.contains(country) && !allies.contains(territoryOwners.get(i)))
							||neutral.contains(country))) {
						System.out.print(territoryNames.get(i) + ",  ");
						System.out.println(territoryOwners.get(i));
					}

				}
				System.out.println("Attack who?");
				while (!territoryNames.contains(defender) && territoryNames.indexOf(defender) == -1
						|| territoryOwners.get(territoryNames.indexOf(defender)).equals(country)&&(
								 (axis.contains(country) && !axis.contains(territoryOwners.get(territoryNames.indexOf(defender))))
									&& (allies.contains(country) && !allies.contains(territoryOwners.get(territoryNames.indexOf(defender))))
									||neutral.contains(country))) {
					defender = stringInput(sc);
				}
				System.out.println("From?");
				while (!territoryNames.contains(attacker) && territoryNames.indexOf(attacker) == -1
						|| !territoryOwners.get(territoryNames.indexOf(attacker)).equals(country)) {
					attacker = stringInput(sc);
				}
				if (neutral.contains(country)) {
					if (axis.contains(territoryOwners.get(territoryNames.indexOf(defender)))) {
						allies.add(country);
						System.out.println("You joined the allies");
					}
					if (allies.contains(territoryOwners.get(territoryNames.indexOf(defender)))) {
						axis.add(country);
						System.out.println("You joined the axis");
					}
					neutral.remove(neutral.indexOf(country));
				}

				if (stats[countries.indexOf(country)][2] * territoryArmyPercent.get(
						territoryNames.indexOf(attacker)) > territoryArmyPercent.get(territoryNames.indexOf(defender))
								* stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]) {
					//Casualties 
					stats[countries.indexOf(country)][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(defender))*(Math.random()*2);
					stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(attacker));
					
					stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][0] -= territoryPopulationPercent.get(territoryNames.indexOf(defender))*stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][0];
					stats[countries.indexOf(country)][0] += territoryPopulationPercent.get(territoryNames.indexOf(defender))*
							stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][0];
					territoryOwners.set(territoryNames.indexOf(defender), country);
					territoryArmyPercent.set(territoryNames.indexOf(defender), 0.0);
					
					
					
					System.out.println("you win");
				} else {
					
					//Casualties 
					stats[countries.indexOf(country)][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(defender));
					stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]-=stats[countries.indexOf(territoryOwners.get(territoryNames.indexOf(defender)))][2]*territoryArmyPercent.get(territoryNames.indexOf(attacker))*(Math.random()*2);
					
					
					territoryArmyPercent.set(territoryNames.indexOf(attacker), 0.0);
					System.out.println("your army was defeated");
				}
				attacker = "";
				defender = "";

			}

		}
		if(axis.size()==0) {
			System.out.println("The allies have won!");
		}
		else if(allies.size()==0) {
			System.out.println("The axis have won!");
		}
		else {
			System.out.println("you were defeated!");
		}


	}

	public static void checkStats(String country, ArrayList<String> countries, double[][] stats) {
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				System.out.print("Population:");
			} else if (i == 1) {
				System.out.print("TFR:");
			} else if (i == 2) {
				System.out.print("Army size:");
			} else if (i == 3) {
				System.out.print("economic GDP:");
			} else if (i == 4) {
				System.out.print("economic Industry growth:");
			}
			else if (i == 5) {
				System.out.print("Tech level:");
			}
			System.out.print(stats[countries.indexOf(country)][i]);

			if (i == 0) {
				System.out.println("m");
			} else if (i == 1) {
				System.out.println("");
			} else if (i == 2) {
				System.out.println("m");
			} else if (i == 3) {
				System.out.println("B");
			} else if (i == 4) {
				System.out.println("");
			}
			else if (i == 5) {
				System.out.println("");
			}

		}
	}

	public static void addTerritory(String name, String owner, double value, double populationPercent) {
		territoryNames.add(name);
		territoryOwners.add(owner);
		territoryValue.add(value);
		territoryPopulationPercent.add(populationPercent);
		territoryArmyPercent.add(populationPercent);

	}

	public static String[] border(String t1, String t2, String t3) {
		String[] borderAreas = { t1, t2, t3 };
		return borderAreas;
	}

	public static void addUSA() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("Pacific coast", "United States", 1.0, 0.25);
		addTerritory("Midwest", "United States", 1.0, 0.1);
		addTerritory("East Coast", "United States", 1.0, 0.4);

		addTerritory("South", "United States", 1.0, 0.25);

	}

	public static void addGermany() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("North Germany", "Germany", 1.0, 0.25);
		addTerritory("West Germany", "Germany", 1.0, 0.25);
		addTerritory("South Germany", "Germany", 1.0, 0.25);
		addTerritory("East Germany", "Germany", 1.0, 0.25);

	}

	public static void addFrance() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("Brittany", "France", 1.0, 0.25);
		addTerritory("Normandy", "France", 1.0, 0.25);
		addTerritory("Paris", "France", 1.0, 0.25);
		addTerritory("South France", "France", 1.0, 0.25);

	}

	public static void addGreatBritian() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("Great Britian", "Great Britian", 1.0, 0.25);
		addTerritory("India", "Great Britian", 1.0, 0.25);
		addTerritory("Ireland", "Great Britian", 1.0, 0.25);
		addTerritory("Canada", "Great Britian", 1.0, 0.25);

	}

	public static void addItaly() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("Rome", "Italy", 1.0, 0.20);
		addTerritory("Northern Italy", "Italy", 1.0, 0.20);
		addTerritory("Southern Italy", "Italy", 1.0, 0.20);
		addTerritory("Sardengna", "Italy", 1.0, 0.20);
		addTerritory("Sicily", "Italy", 1.0, 0.20);

	}

	public static void addJapan() {
		// String[] borderAreas = {"Midwest","South",""};
		addTerritory("Kyushu", "Japan", 1.0, 0.25);
		addTerritory("Chugoku", "Japan", 1.0, 0.25);
		addTerritory("Shikoku", "Japan", 1.0, 0.25);
		addTerritory("Kinki", "Japan", 1.0, 0.25);
		addTerritory("Chubu", "Japan", 1.0, 0.25);
		addTerritory("Kanto", "Japan", 1.0, 0.25);
		addTerritory("Tohoku", "Japan", 1.0, 0.25);
		addTerritory("Hokkaido", "Japan", 1.0, 0.25);
		addTerritory("Korea", "Japan", 1.0, 0.25);
		addTerritory("Taiwan", "Japan", 1.0, 0.25);

	}

	public static void addUSSR() {

		addTerritory("Russia", "USSR", 0.9, 9);
		addTerritory("Estonia", "USSR", 0.01, 0.1);
		addTerritory("Latvia", "USSR", 0.01, 0.1);
		addTerritory("Lithuania", "USSR", 0.01, 0.1);
		addTerritory("Belurus", "USSR", 0.01, 0.1);
		addTerritory("Moldolva", "USSR", 0.01, 0.1);
		addTerritory("Ukraine", "USSR", 0.01, 0.1);
		addTerritory("Georgia", "USSR", 0.01, 0.1);
		addTerritory("Kazakh", "USSR", 0.01, 0.1);
		addTerritory("STAN nations", "USSR", 0.01, 0.1);
		addTerritory("Kirghiz", "USSR", 0.01, 0.1);

	}

	public static String stringInput(Scanner sc) {
		String input = sc.nextLine();
		return input;
	}

	public static ArrayList<Double> resetAttackPercents(ArrayList<Double> a, ArrayList<String> c, String country) {
		double sum = 0.1;
		for (int i = 0; i < a.size(); i++) {
			if (c.get(i).equals(country)) {
				if (a.get(i) < 0) {
					a.set(i, a.get(i) * -1);
				}
				sum += a.get(i);
			}
		}
		for (int i = 0; i < a.size(); i++) {
			if (c.get(i).equals(country)) {
				a.set(i, a.get(i) / sum);
			}

		}
		return a;
	}

	public static double resetValues(ArrayList<Double> v, ArrayList<String> owners, String country) {
		double sum = 0.1;
		for (int i = 0; i < v.size(); i++) {
			if (owners.get(i).equals(country)) {
				if (v.get(i) < 0) {
					v.set(i, v.get(i) * -1);
				}
				sum += v.get(i);
			}
		}
		for (int i = 0; i < v.size(); i++) {
			if (owners.get(i).equals(country)) {
				v.set(i, v.get(i) / sum);
			}

		}
		return sum;
	}

	public static ArrayList<Double> resetPopulationPercents(ArrayList<Double> a, ArrayList<String> c, String country) {
		double sum = 0;
		for (int i = 0; i < a.size(); i++) {
			if (c.get(i).equals(country)) {
				sum += a.get(i);
			}
		}
		for (int i = 0; i < a.size(); i++) {
			if (c.get(i).equals(country)) {
				a.set(i, a.get(i) / sum);
			}

		}
		return a;
	}

	public static ArrayList<Double> resetAllPopulationPercents(ArrayList<Double> a, ArrayList<String> countries) {
		ArrayList<Double> newPopulationValues = new ArrayList<>();
		for (String country : countries) {
			newPopulationValues = resetPopulationPercents(a, countries, country);

		}
		return newPopulationValues;
	}

	public static ArrayList<Double> resetAllAttackPercents(ArrayList<Double> a, ArrayList<String> countries) {
		ArrayList<Double> newAttackValues = new ArrayList<>();
		for (String country : countries) {
			newAttackValues = resetAttackPercents(a, countries, country);

		}
		return newAttackValues;
	}

	public static String neutralJoin(String attacker, String defender, ArrayList<String> axis, ArrayList<String> allies,
			ArrayList<String> neutral) {
		if (neutral.contains(attacker) && axis.contains(defender)) {
			return "allies";
		}
		if (neutral.contains(attacker) && allies.contains(defender)) {
			return "axis";
		} else {
			if (Math.random() >= 0.5) {
				return "allies";
			}
			return "axis";
		}
	}

	// public static boolean insideStringArray() {}

}

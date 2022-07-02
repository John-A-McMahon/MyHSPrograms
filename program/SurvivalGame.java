package program;

import java.util.ArrayList;
import java.util.Scanner;

public class SurvivalGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		
		boolean madeNoise = false;
		int noiseX = 0;
		int noiseY = 0;
		int noiseZ = 0;

		int inventorySpace = 1;
		ArrayList<String> inventory = new ArrayList<>();
		
		
		ArrayList<String> equipment = new ArrayList<>();
		
		ArrayList<String> lockedRooms = new ArrayList<>();
		
		
		
		ArrayList<String> merchantGoods = new ArrayList<>();
		merchantGoods.add("backpack");
		merchantGoods.add("gloves");
		merchantGoods.add("shoes");
		
		ArrayList<Integer> merchantPrices = new ArrayList<>();
		merchantPrices.add(100);
		merchantPrices.add(50);
		merchantPrices.add(200);
		
		

		ArrayList<String> normalMoves = new ArrayList<>();
		normalMoves.add("investagate");
		normalMoves.add("search");
		normalMoves.add("move");
		normalMoves.add("rest");
		normalMoves.add("take");
		normalMoves.add("drop");
		normalMoves.add("use");
		
		//merchant moves
		normalMoves.add("buy");
		normalMoves.add("sell");
		normalMoves.add("talk");

		ArrayList<String> directions = new ArrayList<>();
		directions.add("up");
		directions.add("down");
		directions.add("north");
		directions.add("south");
		directions.add("east");
		directions.add("west");
		directions.add("through");

		// ArrayList<String> roomsToEnter = new ArrayList<>();

		// ArrayList<ArrayList<ArrayList<String>>> House = new ArrayList<>();
		ArrayList<String> rooms = new ArrayList<>();
		ArrayList<ArrayList<String>> roomItems = new ArrayList<>();

		String[][][] house = {

				// atic
				{ { "room", "ladder1" }, { "hall1", "hall2" }, { "hall3", "hall4" }, { "hall5", "hall6" }, { "ladder2", "atic" } },

				// 2nd floor
				{ { "workshop1", "ladder3" }, { "hall7", "bathroom" }, { "fitness", "aquarium" }, { "hall8", "office1" }, { "second floor stairs", "ladder4" } },
				// first floor
				{ { "exit", "mudroom" }, { "hall9", "hall10" }, { "gameroom", "living room" }, { "dining room", "kitchen" }, { "first floor stairs", "closet" } },
				// basement
				{ { "bed1", "fireplace" }, { "freezer", "machine" }, { "scull", "hall11" }, { "hall12", "office2" }, { "basement stairs", "medicine room" } }

		};

		String[][][] entities = {

				// atic
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// 2nd floor
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// first floor
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "P" } },

				// basement
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } }

		};

		String[][][] enemy = {

				// atic
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// 2nd floor
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "E" } },

				// first floor
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// basement
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } }

		};

		String[][][] merchant = {

				// atic
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// 2nd floor
				{ { "", "" }, { "", "" }, { "", "M" }, { "", "" }, { "", "" } },

				// first floor
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } },

				// basement
				{ { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } }

		};

		for (int i = 0; i < 4; i++) {

			for (int e = 0; e < 5; e++) {
				for (int j = 0; j < 2; j++) {

					rooms.add(house[i][e][j]);
					roomItems.add(new ArrayList<String>());
					

				}
			}
		}

		
		
		
		
		
		
		//locked rooms and keys
		ArrayList<String> lockedKeyRooms= new ArrayList<>();
		ArrayList<String> keyRooms= new ArrayList<>();
		while(keyRooms.size()<10) {
			keyRooms.add(house[(int)(Math.random()*house.length)][(int)(Math.random()*house[0].length)][(int)(Math.random()*house[0][0].length)]);
		}
		
		while(lockedKeyRooms.size()<10) {
			lockedKeyRooms.add(house[(int)(Math.random()*house.length)][(int)(Math.random()*house[0].length)][(int)(Math.random()*house[0][0].length)]);
			if(keyRooms.contains(lockedKeyRooms.get(lockedKeyRooms.size()-1))) {
				lockedKeyRooms.remove(lockedKeyRooms.size()-1);
			}
		}
		
		int lockedRoomNumber=0;
		
		for (int i = 0; i < 4; i++) {

			for (int e = 0; e < 5; e++) {
				for (int j = 0; j < 2; j++) {

					if(keyRooms.contains(house[i][e][j])) {
						roomItems.get(rooms.indexOf(house[i][e][j])).add(lockedKeyRooms.get(lockedRoomNumber)+" key");
						lockedRoomNumber+=1;
						
					}
					

				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		//spawn items
		boolean portalGunCreated=false;
		boolean remoteCreated=false;
		boolean lockKitCreated=false;
		//boolean lock=false;
		roomItems.get(rooms.indexOf("room")).add("toilet paper");
		roomItems.get(rooms.indexOf("office1")).add("blueprint");
		roomItems.get(rooms.indexOf("kitchen")).add("knife");
		roomItems.get(rooms.indexOf("workshop1")).add("knife");
		roomItems.get(rooms.indexOf("mudroom")).add("knife");
		//spawn random items
		for(String room : rooms) {
			
			
			
			if(Math.random()<0.1&&!portalGunCreated) {
				portalGunCreated=true;
				roomItems.get(rooms.indexOf(room)).add("portal gun");
			}
			else if(Math.random()<0.1&&!remoteCreated) {
				remoteCreated=true;
				roomItems.get(rooms.indexOf(room)).add("radio remote");
			}
			else if(Math.random()<0.1&&!lockKitCreated) {
				lockKitCreated=true;
				roomItems.get(rooms.indexOf(room)).add("lock kit");
			}
			
			
			
			if(Math.random()<0.2) {
				roomItems.get(rooms.indexOf(room)).add("toilet paper");
			}
			else  if(Math.random()<0.01) {
				roomItems.get(rooms.indexOf(room)).add("jewelery");
			}
			else if(Math.random()<0.1) {
				roomItems.get(rooms.indexOf(room)).add("ring");
			}
			
		}
		
		
		System.out.println(roomItems);

		String input;
		String d;
		boolean alive = false;
		int money = 0;
		
		//initializes path to random location
		noiseX=(int)(Math.random()*house[0].length);
		noiseY=(int)(Math.random()*house.length);
		noiseZ=(int)(Math.random()*house[0][0].length);
		
		int oldPlayerX = 0;
		int oldPlayerY = 0;
		int oldPlayerZ = 0;
		
		int playerX = 0;
		int playerY = 0;
		int playerZ = 0;
		
		int currentPortal=1;
		boolean hasPortalGun=true;
		boolean radioOn=false;
		
		int portal1X = -1;
		int portal1Y = 0;
		int portal1Z = 0;
		
		int portal2X = -1;
		int portal2Y = 0;
		int portal2Z = 0;
		
		
		String difficulty = "";
		ArrayList<String> difficulties= new ArrayList<>();
		difficulties.add("easy");
		difficulties.add("normal");
		difficulties.add("hard");
		long turn = 0;
		int enemyMoveFrequency = 1;
		
		System.out.println("Welcome! in this game you have been kidnapped and must escape");
		System.out.println("Your kidnapper will look for you!");
		System.out.println("Every move you make will advance time so choose your moves wisely");
		System.out.println("When making a decision, a list of actions will appear []");
		System.out.println("Inventory: limited space for the items you can carry");
		System.out.println("Equipment: gives perment bonuses, and does not take up inventory space");
		
		
		
		System.out.println("To play, choose a difficulty!"+difficulties);
		d=decision(sc,difficulties);
		if(d.equals("easy")) {
			enemyMoveFrequency=3;
			difficulty="easy";
		}
		if(d.equals("normal")) {
			enemyMoveFrequency=2;
			difficulty="normal";
		}
		if(d.equals("hard")) {
			enemyMoveFrequency=1;
			difficulty="hard";
		}
		alive=true;
		

		
		boolean enemyDistracted=false;
		boolean enemyHurt=false;
		boolean escaped=false;
		
		while (alive&&!escaped) {
			turn++;
			for (int i = 0; i < 4; i++) {

				for (int e = 0; e < 5; e++) {
					for (int j = 0; j < 2; j++) {

						// System.out.println(entities[i][e][j]+" x:"+e+" y:"+i+" z:"+j);

						if (entities[i][e][j].equalsIgnoreCase("P")) {
							
							if (enemy[i][e][j].equals("E")) {
								if(inventory.contains("knife")) {
									System.out.println("You were caught!, You stabbed the enemy with your knife!");
									enemyHurt=true;
									//inventory.remove("knive");
								}
								else {
									System.out.println("You were caught! game over");
									alive = false;
								}
								
								
							}
							
							
							//System.out.println("x" + e + " y" + i + " z" + j);

							if (i < 3 && ((enemy[i + 1][e][j].equalsIgnoreCase("E")
									|| merchant[i + 1][e][j].equalsIgnoreCase("M")))) {
								System.out.println("You hear someone below you...");
								if (enemy[i + 1][e][j].equalsIgnoreCase("E")) {
									noiseY = i;
								}
							}
							if (i > 0 && ((enemy[i - 1][e][j].equalsIgnoreCase("E")
									|| merchant[i - 1][e][j].equalsIgnoreCase("M")))) {
								System.out.println("You hear someone above you...");
								if (enemy[i - 1][e][j].equalsIgnoreCase("E")) {
									noiseY = i;
								}
							}
							if (e < 4 && ((enemy[i][e + 1][j].equalsIgnoreCase("E")
									|| merchant[i][e + 1][j].equalsIgnoreCase("M")))) {
								System.out.println("You hear someone in the room north of you...");
								if (enemy[i][e + 1][j].equalsIgnoreCase("E")) {
									//noiseX = e;
								}
							}
							if (e > 0 && ((enemy[i][e - 1][j].equalsIgnoreCase("E")
									|| merchant[i][e - 1][j].equalsIgnoreCase("M")))) {
								System.out.println("You hear someone in the room south of you...");
								if (enemy[i][e - 1][j].equalsIgnoreCase("E")) {
									//noiseX = e;
								}
							}
						}

						if (entities[i][e][j].equalsIgnoreCase("P")) {
							madeNoise = false;
							input = "";
							d = "";
							oldPlayerX = e;
							oldPlayerY = i;
							oldPlayerZ = j;
							
							
							
							if(inventory.contains("blueprint")) {
								System.out.println("You are in the " + house[i][e][j]+" on the "+floorName(i)+" floor "+" on the "+floorName(j)+" wing");
							}
							else {
								System.out.println("You are in the " + house[i][e][j]+" on the "+wingName(j)+" wing");
							}
							
							System.out.println("inventory: "+inventory);
							System.out.println("equipment: "+equipment);
							System.out.println("Money: $"+money);
							//System.out.println(difficulty+roomItems.get(rooms.indexOf(house[i][e][j])).size() );
							if(difficulty.equals("easy")&&roomItems.get(rooms.indexOf(house[i][e][j])).size() > 0) {
								System.out.println("You scence somthing in this room...");
							}
							
							System.out.println("What will you do?");
							if (merchant[i][e][j].equalsIgnoreCase("M") && entities[i][e][j].equalsIgnoreCase("P")) {
								System.out.println("A merchant is in the room with you");
							}

							input = decision(sc, normalMoves);

							if (input.equals("take") && inventory.size() < inventorySpace
									&& roomItems.get(rooms.indexOf(house[i][e][j])).size() > 0) {
								System.out.println("Take what?" + roomItems.get(rooms.indexOf(house[i][e][j])));
								d = decision(sc, roomItems.get(rooms.indexOf(house[i][e][j])));
								inventory.add(d);
								//roomItems.get(rooms.indexOf(house[i][e][j])).remove(rooms.indexOf(house[i][e][j]));
								roomItems.get(rooms.indexOf(house[i][e][j])).remove(roomItems.get(rooms.indexOf(house[i][e][j])).indexOf(d));
								System.out.println(inventory);
								System.out.println("You took the " + d);

							} else if (input.equals("take") && inventory.size() >= inventorySpace) {
								System.out.println("your inventory is full");
							} else if (input.equals("take")&&roomItems.get(rooms.indexOf(house[i][e][j])).size() == 0) {
								System.out.println("There is nothing to take in this room");
							}

							if (input.equals("drop") && inventory.size() > 0) {
								System.out.println("Drop what? " + inventory);
								d = decision(sc, inventory);
								inventory.remove(inventory.indexOf(d));
								roomItems.get(rooms.indexOf(house[i][e][j])).add(d);
								System.out.println("You dropped the " + d);

							}
							
							
							
							
							if (input.equals("use")) {
								System.out.println("Use what "+inventory);
								d=decision(sc, inventory);
								if(d.equalsIgnoreCase("cancel")) {
									continue;
								}
								
								
								
								if(d.equals("lock kit")) {
									System.out.println("Room securily locked, noone can come in");
									lockedRooms.add(house[i][e][j]);
								}
								else if(d.equals("lock kit")&&lockedRooms.contains(house[i][e][j])) {
									System.out.println("Room unlocked! be careful out there!");
									lockedRooms.remove(0);
								}
								
								if(d.equals("radio remote")&&!radioOn) {
									System.out.println("You turned the radio on!");
									noiseX=0;
									noiseY=3;
									noiseZ=0;
									radioOn=true;
									enemyDistracted=true;
								}
								else if(d.equals("radio remote")&&radioOn) {
									System.out.println("The radio is already on!");
								}
								
								if(d.equals("portal gun")) {
									
									if(currentPortal==1) {
										portal1X = e;
										portal1Y = i;
										portal1Z = j;
										currentPortal=2;
									}
									else if(currentPortal==2) {
										portal2X = e;
										portal2Y = i;
										portal2Z = j;
										currentPortal=1;
									}
									System.out.println("Portal created");
								}
								
								if(d.contains(house[i][e][j])&&d.contains(" key")&&lockedKeyRooms.contains(house[i][e][j])) {
									lockedKeyRooms.remove(lockedKeyRooms.indexOf(house[i][e][j]));
									inventory.remove(inventory.indexOf(d));
									System.out.println("You used the key");
									if(lockedKeyRooms.size()==0||Math.random()<0.1) {
										inventory.add("exit key");
									}
								}
								else if(!d.contains(house[i][e][j])&&d.contains(" key")) {
									System.out.println("You can't use that here");
								}
								
								if(d.equals("exit key")&&house[i][e][j].equals("exit")) {
									System.out.println("Used the exit key and escaped!");
									escaped=true;
									
								}
								
								//use blueprint
								if(d.equals("blueprint")) {
									System.out.println("Using your blueprint you observe the following:");
									
									System.out.println("The layout is 4 floors (basement,first/ground floor, second floor and atic/third floor)");
									System.out.println("There are 2 wings, a east wing and a west wing");
									System.out.println("Layout:");
									for (int a = 0; a < 4; a++) {
										System.out.println("\n"+floorName(a)+" floor:");
										for (int b  = 0; b < 5; b++) {
											
											for (int c = 0; c < 2; c++) {
												if(c%2==0) {
													System.out.print(wingName(c)+" wing :"+house[a][b][c]+" ");
												}
												
											}
											System.out.println("");
											for (int c = 0; c < 2; c++) {
												if(c%2!=0) {
													System.out.print(""+wingName(c)+" wing :"+house[a][b][c]+" ");
												}
											}
											
										}
									}
									System.out.println("");
									
									System.out.println("Using your blueprint, you see that you are on the "+floorName(i)+" and on the "+wingName(j));
									
									
									
								}
							}
							
							if (input.equals("investagate")||input.equals("search")) {
								
								
								
								if(house[i][e][j].equals("bed1")) {
									System.out.println("A large radio is bolted to the wall");
								}
								
								if (roomItems.get(rooms.indexOf(house[i][e][j])).size() == 0) {
									System.out.println("There is nothing to take in this room");
								}
								else {
									
									System.out.println("You see "+roomItems.get(rooms.indexOf(house[i][e][j])));
								}
							}

							
							
							
							
							
							//merchant commands
							if (input.equals("talk")&&merchant[i][e][j].equalsIgnoreCase("M")){
								System.out.println("I am the merchant, you can buy and sell things with me in exchange for valuables");
								System.out.println("Don't worry, I will keep you a secret.");
							}
							if (input.equals("buy")&&merchant[i][e][j].equalsIgnoreCase("M")){
								System.out.println("Here is my inventory: ");
								for(int good =0; good<merchantGoods.size(); good++) {
									System.out.println(merchantGoods.get(good)+"  $"+merchantPrices.get(good));
								}
								System.out.println("Your money: $"+money);
								
								d=decision(sc,merchantGoods);
								if(d.equalsIgnoreCase("cancel")) {
									continue;
								}
								else if(money>=merchantPrices.get(merchantGoods.indexOf(d))) {
									System.out.println("You purchaced a "+d+" from the merchant for $"+merchantPrices.get(merchantGoods.indexOf(d)));
									equipment.add(d);
									money-=merchantPrices.get(merchantGoods.indexOf(d));
									merchantPrices.remove(merchantGoods.indexOf(d));
									merchantGoods.remove(merchantGoods.indexOf(d));
									
									
									//Increase inventory space
									if(equipment.contains("backpack")) {
										inventorySpace=3;
									}
								}
								else if(money<merchantPrices.get(merchantGoods.indexOf(d))) {
									System.out.println("Not enough money to buy that!");
								}
								
								
							}
							if (input.equals("sell")&&merchant[i][e][j].equalsIgnoreCase("M")){
								System.out.println("What do you got?");
								d=decision(sc,inventory);
								if(d.equalsIgnoreCase("cancel")) {
									continue;
								}
								
								
								if(d.equals("toilet paper")) {
									money+=2;
									System.out.println("The merchant bought the toilet paper for $2");
								}
								if(d.equals("jewelery")) {
									money+=20;
									System.out.println("The merchant bought the jewelery for $20");
								}
								
								
								
								if(d.equals("knife")) {
									System.out.println("Merchant: You can keep that, it will come in handy if you get caught...");
								}
								if(d.equals("Knife")) {
									System.out.println("Merchant: You can keep that, it will come in handy if you get caught");
								}
							}
							
							
							
							
							if (input.equals("move")&&!lockedRooms.contains(house[i][e][j])) {
								System.out.println("Which direction(north,south,east,west,up,down,through)?");
								d = decision(sc, directions);

								// up Stairs
								if (i > 0 && d.equals("up")
										&& (house[i][e][j].contains("stairs") || house[i][e][j].contains("ladder"))) {
									entities[i][e][j] = "";
									entities[i - 1][e][j] = "P";
									i--;
								} else if (i == 0 && d.equals("up")) {
									System.out.println("no more space to move in that direction");
								} else if (i > 0 && d.equals("up") && !house[i][e][j].contains("stairs")
										&& !house[i][e][j].contains("ladder")) {
									System.out.println("no stairs or ladder to do that");
								}

								// down Stairs
								if (i < 3 && d.equals("down")
										&& ((house[i][e][j].contains("stairs")&&i>0) || (house[i][e][j].contains("ladder")&&i==0))) {
									entities[i][e][j] = "";
									entities[i + 1][e][j] = "P";
									i++;
								} else if (i == 3 && d.equals("down")) {
									System.out.println("no more space to move in that direction");
								} else if (i < 3 && d.equals("down") && !house[i][e][j].contains("stairs")
										&& !house[i][e][j].contains("ladder")) {
									System.out.println("no stairs or ladder below you to do that");
								}

								// moving north
								if (e < 4 && d.equals("north")) {
									entities[i][e][j] = "";
									entities[i][e + 1][j] = "P";
									e++;
								} else if (e >= 4 && d.equals("north")) {
									System.out.println("no more space to move in that direction");
								}

								// moving south
								if (e > 0 && d.equals("south")) {
									entities[i][e][j] = "";
									entities[i][e - 1][j] = "P";
									e--;
								} else if (e == 0 && d.equals("south")) {
									System.out.println("no more space to move in that direction");
								}

								// moving east
								if (j == 0 && d.equals("east")) {
									entities[i][e][j] = "";
									entities[i][e][j + 1] = "P";
									j++;
								} else if (j == 1 && d.equals("east")) {
									System.out.println("no more space to move in that direction");
								}

								// moving west
								if (j == 1 && d.equals("west")) {
									entities[i][e][j] = "";
									entities[i][e][j - 1] = "P";
									j--;
								} else if (j == 0 && d.equals("west")) {
									System.out.println("no more space to move in that direction");
								}
								
								if (d.equals("through")&&((e==portal1X&&i==portal1Y&&j==portal1Z)||(e==portal2X&&i==portal2Y&&j==portal2Z))) {
									if((e==portal1X&&i==portal1Y&&j==portal1Z)||!hasPortalGun) {
										entities[i][e][j] = "";
										entities[portal2Y][portal2X][portal2Z] = "P";
										e=portal2X;
										i=portal2Y;
										j=portal2Z;
									}
									else if((e==portal2X&&i==portal2Y&&j==portal2Z)) {
										entities[i][e][j] = "";
										entities[portal1Y][portal1X][portal1Z] = "P";
										e=portal1X;
										i=portal1Y;
										j=portal1Z;
									}
									//System.out.println("portal1:"+portal1X);
									//System.out.println("portal2:"+portal2X);
									
									
									
									
									hasPortalGun=true;
									
									
									
								}
								else if(d.equals("through")&&portal1X!=-1) {
									System.out.println("No portal!");
								}
								
								
								
								
								//chance of making noise
								if(!house[i][e][j].contains("ladder")) {
									//walking
									madeNoise = Math.random()<0.1&&!equipment.contains("shoes")&&(d.equals("north")||d.equals("south")||d.equals("east")||d.equals("west")||((d.equals("up")||d.equals("down")&&house[i][e][j].contains("stairs"))));
									if(madeNoise) {
										System.out.println("You tripped!");
									}
								}
								else {
									//climbing
									madeNoise = Math.random()<0.1&&!equipment.contains("gloves")&&((d.equals("up")||d.equals("down")&&house[i][e][j].contains("ladder")));
									if(madeNoise) {
										System.out.println("You made noise on your way up the ladder");
									}
								}
								//System.out.println(madeNoise);
								
								
								if(lockedKeyRooms.contains((house[i][e][j]))) {
									System.out.println("There is a large box with a lock on it!");
								}
								

							}
							else if(input.equals("move")&&lockedRooms.contains(house[i][e][j])) {
								System.out.println("You can't leave this room because its locked");
							}
							playerX = e;
							playerY = i;
							playerZ = j;
							
							
							
							
							if(madeNoise) {
								noiseX=e;
								noiseY=i;
								noiseZ=j;
							}
							
							
							
						}

						if (merchant[i][e][j].equalsIgnoreCase("M")) {
							
						}

						

					}
				}
			}
			
			
			
			
			
			
			
			for (int i = 0; i < 4; i++) {

				for (int e = 0; e < 5; e++) {
					for (int j = 0; j < 2; j++) {

						if (enemy[i][e][j].equalsIgnoreCase("E")&&turn%enemyMoveFrequency==0) {
							if(enemyDistracted && radioOn) {
								noiseX=0;
								noiseY=3;
								noiseZ=0;
							}
							if(enemyHurt) {
								noiseX=0;
								noiseY=3;
								noiseZ=1;
							}
							
							
							
							
							if (i!=noiseY&&(house[i][e][j].contains("stairs") || house[i][e][j].contains("ladder"))) {
								if (i > noiseY) {
									enemy[i][e][j] = "";
									enemy[i - 1][e][j] = "E";
									i--;
								} else if (i < noiseY) {
									enemy[i][e][j] = "";
									enemy[i + 1][e][j] = "E";
									i++;
								}
							} else if (i != noiseY) {
								if (e == 4 && j == 1) {
									enemy[i][e][j] = "";
									enemy[i][e][0] = "E";
									j--;
								} else if (e < 4) {
									enemy[i][e][j] = "";
									enemy[i][e + 1][j] = "E";
									e++;
								}

							}

							else if (i == noiseY) {
								
								if(lockedRooms.contains(house[noiseY][noiseX][noiseZ])&&(e+1==noiseX||e-1==noiseX)) {
									noiseX=(int)(Math.random()*house[0].length);
									noiseY=(int)(Math.random()*house.length);
									noiseZ=(int)(Math.random()*house[0][0].length);
									System.out.println("Person outside: I can't open this door... wierd");
									
								}
								
								if (e > noiseX) {
									enemy[i][e][j] = "";
									enemy[i][e - 1][j] = "E";
									e--;
								} else if (e < noiseX) {
									enemy[i][e][j] = "";
									enemy[i][e + 1][j] = "E";
									e++;
								} else if (j < noiseZ) {
									enemy[i][e][j] = "";
									enemy[i][e][j + 1] = "E";
									j++;
								} else if (j > noiseZ) {
									enemy[i][e][j] = "";
									enemy[i][e][j - 1] = "E";
									j--;
								}
							}

							if (e == playerX && i == playerY && j == playerZ) {
								if(inventory.contains("knife")) {
									System.out.println("You were caught!, You stabbed the enemy with your knife! He stumbled to another room");
									enemyHurt=true;
									inventory.remove("knive");
								}
								else {
									alive = false;
									System.out.println("You were caught! game over");
								}
								
							}
							else if(e == noiseX && i == noiseY && j == noiseZ) {
								if(enemyHurt) {
									enemyHurt=false;
								}
								if(e==0&&i==3&&j==0&&radioOn) {
									System.out.println("Someone turned the radio off!");
									radioOn=false;
									enemyDistracted=false;
								}
								noiseX=(int)(Math.random()*house[0].length);
								noiseY=(int)(Math.random()*house.length);
								noiseZ=(int)(Math.random()*house[0][0].length);
							}
							//System.out.println("x" + playerX + " y" + playerY + " z" + playerZ);
							//System.out.println("x" + e + " y" + i + " z" + j);
							//System.out.println("noise:x" + noiseX + " y" + noiseY + " z" + noiseZ);
						}

					}
				}
			}
			
			
			
			
			
			

		}
		
		
		
		
		if(escaped) {
			System.out.println("Congratulations, you have escaped!");
		}
		if(!alive) {
			System.out.println("GAME OVER");
			
		}
	}

	public static String decision(Scanner sc, ArrayList<String> moves) {
		String input = "";
		//moves.add("cancel");
		while (input.equals("")||input.equals("cancel")) {
			input = sc.nextLine();
			if (moves.contains(input)) {
				return input;
			} else {

				input = "";
			}
		}
		return "";
	}

	public static String floorName(int floor) {
		if(floor==3) {
			return "basement";
		}
		if(floor==2) {
			return "first/ground floor";
		}
		if(floor==1) {
			return "second floor";
		}
		if(floor==0) {
			return "atic";
		}
		else {
			return "";
		}
	}
	
	public static String wingName(int wing) {
		if(wing==0) {
			return "west";
		}
		else {
			return "east";
		}
	}
}

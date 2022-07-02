package program;

import java.util.ArrayList;

public class AIBlackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean hitOnSoft17 = true;

		boolean mustDouble = false;

		int numDecks = 1;

		String decision = "";
		int newPlayerSum = 0;
		int oldPlayerSum = 0;
		int newDealerSum = 0;
		int oldDealerSum = 0;

		int oddSum = 0;
		int evenSum = 0;
		int duplicate1 = 0;
		int duplicate2 = 0;
		boolean canSplit = false;

		// ratio paid to player
		double payout = 1.0;

		long dealerWins = 0;
		long AIWins = 0;
		long surrenders = 0;
		int recentSurrenders = 0;
		long tieGames = 0;
		int dealerRecentWins = 0;
		int AIRecentWins = 0;
		int recentTieGames = 0;
		double learningIncrease = 0;

		// bigger=slower but more aucurate
		double learningRate = 1000;

		boolean doubled = false;

		/// if the AI is trying to maximise chips won:
		boolean usingBets = false;
		double bet = 100;
		int recentBets = 0;
		int recentGame = 0;
		long bets = 0;
		long game = 0;

		long busts = 0;
		long tooFar = 0;

		double update = 1.0;

		// show variables
		boolean willShowGame = true;
		boolean showScore = false;
		boolean showGame = false;
		long lastTime = System.currentTimeMillis();

		double[][] QTable = new double[21][11];

		for (int i = 0; i < 21; i++) {
			for (int e = 0; e < 11; e++) {
				QTable[i][e] = Math.random() + 0.01;
			}
		}

		double[][][] surrenderQTable = new double[14][14][14];

		for (int i = 0; i < 14; i++) {
			for (int e = 0; e < 14; e++) {
				for (int d = 0; d < 14; d++) {
					surrenderQTable[i][e][d] = Math.random() + 0.01;
				}

			}
		}

		double[][] splitQTable = new double[14][14];

		for (int i = 0; i < 14; i++) {
			for (int e = 0; e < 14; e++) {
				splitQTable[i][e] = (Math.random() + 0.01) * 1;
			}
		}

		double[][] doubleQTable = new double[22][14];

		for (int i = 0; i < 21; i++) {
			for (int e = 0; e < 14; e++) {
				doubleQTable[i][e] = Math.random() + 0.01;
			}
		}

		while (true) {

			// reset

			// hit/stand reset
			for (int i = 0; i < 21; i++) {
				for (int e = 0; e < 11; e++) {
					if (QTable[i][e] > 1) {
						QTable[i][e] = 1;
					}
					if (QTable[i][e] == 0) {
						QTable[i][e] = 1.0 / Double.MAX_VALUE;
					}
				}
			}

			// surrender reset
			for (int i = 0; i < 14; i++) {
				for (int e = 0; e < 14; e++) {
					for (int d = 0; d < 14; d++) {
						if (surrenderQTable[i][e][d] > 1) {
							surrenderQTable[i][e][d] = 1;
						}

					}

				}
			}

			// split reset
			for (int i = 0; i < 14; i++) {
				for (int e = 0; e < 14; e++) {
					if (splitQTable[i][e] > 1) {
						splitQTable[i][e] = 1;
					}

				}
			}

			// double reset
			for (int i = 0; i < 21; i++) {
				for (int e = 0; e < 14; e++) {
					if (doubleQTable[i][e] > 1) {
						doubleQTable[i][e] = 1;
					}
				}
			}

			bet = 100;
			game++;
			recentGame++;

			if (willShowGame && System.currentTimeMillis() - lastTime > 3000) {
				showGame = true;
				lastTime = System.currentTimeMillis();

			} else {
				showGame = false;
			}
			// surrenders count as 1/2 of a dealer win
			// dealerWins += recentSurrenders / 2;
			// AIWins += recentSurrenders / 2;
			// stats
			if (showScore && System.currentTimeMillis() - lastTime > 2000) {
				System.out.println("AI wins " + AIWins);
				System.out.println("Dealer wins " + dealerWins);
				System.out.println("AI loss reason " + 1.0 * busts / tooFar);

				System.out.println(
						"AI total win percent " + (1.0 * AIWins / (dealerWins + AIWins + tieGames)) * 100 + "%");
				System.out.println("Dealer total win percent "
						+ (1.0 * dealerWins / (dealerWins + AIWins + tieGames)) * 100 + "%");
				System.out.println(
						"tie games percent " + (1.0 * tieGames / (dealerWins + AIWins + tieGames)) * 100 + "%");
				System.out.println("recent tie games percent "
						+ (1.0 * recentTieGames / (dealerRecentWins + AIRecentWins + recentTieGames)) * 100 + "%");

				System.out.println("AI recent win percent "
						+ (1.0 * AIRecentWins / (dealerRecentWins + AIRecentWins + recentTieGames)) * 100 + "%");

				if (usingBets) {
					System.out.println("AI total average payout: " + (1.0 * bets) / (game * 100));
					System.out.println("AI recent average payout: " + (1.0 * recentBets) / (recentGame * 100));

					System.out.println((1.0 * recentBets) / (recentGame));

					if ((1.0 * recentBets) / (recentGame) < 1) {
						System.out.println(doubleQTable[5][5]);
					}
					recentBets = 0;
					recentGame = 0;

				}

				AIRecentWins = 0;
				dealerRecentWins = 0;
				recentTieGames = 0;
				recentSurrenders = 0;

				lastTime = System.currentTimeMillis();

			}

			if (showGame) {
				System.out.println("\nGAME# :" + game);
				System.out.println("Player bet:" + (int) bet + " chips");
			}
			ArrayList<Integer> cards = new ArrayList<>();
			for (int i = 1; i < 53 * numDecks; i++) {
				cards.add(i % 13 + 1);
			}

			ArrayList<Integer> dealerHand = new ArrayList<>();
			ArrayList<Integer> dealerHandFirstCard = new ArrayList<>();

			ArrayList<Integer> secondPlayerHand = new ArrayList<>();
			ArrayList<Integer> playerHand = new ArrayList<>();

			// dealers cards
			dealerHand.add(cards.get((int) (Math.random() * 51 + 1)));
			cards.remove(cards.indexOf(dealerHand.get(0)));
			dealerHand.add(cards.get((int) (Math.random() * 50 + 1)));
			cards.remove(cards.indexOf(dealerHand.get(1)));

			dealerHandFirstCard.add(dealerHand.get(0));

			// Player's cards
			playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
			cards.remove(cards.indexOf(playerHand.get(0)));

			playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
			cards.remove(cards.indexOf(playerHand.get(1)));

			if (showGame) {
				showHand(dealerHand, "one", "Dealer");
				showHand(playerHand, "all", "Player");
				System.out.println();
			}

			decision = "";

			// surrendering
			if (playerHand.size() == 2 && shouldSurrender((int) playerHand.get(0), (int) playerHand.get(1),
					(int) dealerHand.get(0), surrenderQTable)) {
				surrenderQTable[playerHand.get(0)][playerHand.get(1)][dealerHand
						.get(0)] *= (1.0 * handSum(dealerHand) + learningRate - 6)
								/ (handSum(playerHand) + learningRate + 1);
				bet = bet / 2.0;
				surrenders++;
				recentSurrenders++;
				//
				// tieGames++;
				// recentTieGames++;
				// System.out.println("hey");
				bets += bet;
				recentBets += bet;
				continue;
			}

			doubled = false;

			while (decision.equals("") || decision.equals("hit")) {
				decision = decide(handSum(playerHand), handSum(dealerHandFirstCard), QTable);

				// simulate splitting
				if (playerHand.size() == 2 && playerHand.get(0) == playerHand.get(1)
						&& shouldSplit(playerHand.get(0), playerHand.get(1), splitQTable)) {
					newPlayerSum = playerHand.get(0);

					if (showGame) {
						System.out.println("Player split");

					}
					game++;
					playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
					cards.remove(cards.indexOf(playerHand.get(playerHand.size() - 1)));

					playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
					cards.remove(cards.indexOf(playerHand.get(playerHand.size() - 1)));

					secondPlayerHand.add(playerHand.get(0));
					playerHand.remove(0);
					secondPlayerHand.add(playerHand.get(1));
					playerHand.remove(1);

					// splitQTable[playerHand.get(0)][secondPlayerHand.get(0)]
					// *=newPlayerSum/((handSum(playerHand)+handSum(secondPlayerHand)/2));
					splitQTable[playerHand.get(0)][secondPlayerHand
							.get(0)] *= ((handSum(playerHand) + handSum(secondPlayerHand) / 2)) / newPlayerSum;

					continue;
				}

				// double
				if (usingBets && playerHand.size() == 1
						&& shouldDouble(handSum(playerHand), dealerHand.get(0), doubleQTable)) {
					if (showGame) {
						System.out.println("Player double downed");
					}
					oldPlayerSum = handSum(playerHand);
					// oldDealerSum = handSum(dealerHandFirstCard);

					playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
					cards.remove(cards.indexOf(playerHand.get(playerHand.size() - 1)));

					newPlayerSum = handSum(playerHand);

					// player busted
					if (newPlayerSum > 21) {
						// System.out.println("Player busted");
						// bet = -100;
						update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
						doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update * update * update;
						//break;
					} else {
						update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
						doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update * update;
					}
					doubled = true;

					if (!mustDouble) {
						bet = (double) bet * (1 + Math.exp(doubleQTable[oldPlayerSum][dealerHand.get(0)])
								/ (Math.exp(doubleQTable[oldPlayerSum][dealerHand.get(0)] + 1)));
					} else {
						bet = bet * 2;
					}
					if (showGame) {
						System.out.println("new player bet:" + (int) bet + " chips");
					}
					//break;
				}

				// hit
				else if (decision.equals("hit")) {
					if (showGame) {
						System.out.println("Player hit");
					}
					oldPlayerSum = handSum(playerHand);
					oldDealerSum = handSum(dealerHandFirstCard);

					playerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
					cards.remove(cards.indexOf(playerHand.get(playerHand.size() - 1)));

					newPlayerSum = handSum(playerHand);

					// player busted
					if (newPlayerSum > 21) {
						// System.out.println("Player busted");
						update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
						QTable[oldPlayerSum][oldDealerSum] *= update;
						// doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update*update;

					} else {
						update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
						QTable[oldPlayerSum][oldDealerSum] *= update;
						// doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update;
					}

					if (newPlayerSum < 11) {
						// update = 1.0001;
						// QTable[oldPlayerSum][oldDealerSum] *= update;
					}

					if (newPlayerSum < 21) {
						// update = 0.99;
						// QTable[newPlayerSum-1][oldDealerSum] *= update;
					}

					if (showGame) {
						showHand(playerHand, "all", "Player");
					}

					continue;

				}

				if (decision.equals("stand")) {
					// oldPlayerSum =handSum(playerHand);
					// oldDealerSum =handSum(dealerHandFirstCard);

					if (showGame) {
						System.out.println("Player stand");
					}

					if (newPlayerSum < 15) {
						// update = 1.01;
						// QTable[oldPlayerSum][oldDealerSum] *= update;
					}

				}
			}

			if (showGame) {
				// System.out.println();
				showHand(dealerHand, "all", "Dealer");
				System.out.println();
				showHand(playerHand, "all", "Player");
				System.out.println();

			}

			// player busted
			if (handSum(playerHand) > 21) {
				if (showGame) {
					System.out.println("Player busted");
				}

				if (playerHand.get(0) == playerHand.get(1)) {

					splitQTable[playerHand.get(0)][playerHand.get(1)] *= 21.0 / handSum(playerHand);
				}

				update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
				QTable[oldPlayerSum][oldDealerSum] *= update;
				// splitQTable[oldPlayerSum][oldDealerSum] *= update;
				doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update * update;
				busts++;
				dealerWins++;
				dealerRecentWins++;

				if (doubled) {
					if (!mustDouble) {
						bet = -(double) bet * (1 + Math.exp(doubleQTable[oldPlayerSum][dealerHand.get(0)])
								/ (Math.exp(doubleQTable[oldPlayerSum][dealerHand.get(0)] + 1)));
					} else {
						bet = -100;
					}
				} else {
					bet = 0;
				}

				bets += bet;
				recentBets += bet;
				continue;

			}

			// dealer hitting
			while (handSum(dealerHand) < 17 || (hitOnSoft17 && handSum(dealerHand) == 17 && dealerHand.contains(1))) {
				if (showGame) {

					System.out.println("Dealer Hit");
				}

				dealerHand.add(cards.get((int) (Math.random() * cards.size()) + 0));
				cards.remove(cards.indexOf(dealerHand.get(dealerHand.size() - 1)));
				if (showGame) {

					showHand(dealerHand, "all", "Dealer");
				}

			}

			if (secondPlayerHand.size() == 2) {

				for (int i = 0; i < 1; i++) {

					if (handSum(dealerHand) > 21) {
						if (showGame) {
							System.out.println("Dealer busted");
						}

						AIWins++;
						AIRecentWins++;

						// bet = bet
						bets += bet + payout * bet;
						recentBets += bet + payout * bet;
						continue;

					}

					else if (Math.abs(handSum(secondPlayerHand) - 21) < Math.abs(handSum(dealerHand) - 21)) {
						if (showGame) {
							System.out.println("Player was closer to 21");
						}

						AIWins++;
						AIRecentWins++;

						// bet = bet + payout*bet;
						bets += bet + payout * bet;
						recentBets += bet + payout * bet;

						continue;
					} else if (Math.abs(handSum(secondPlayerHand) - 21) > Math.abs(handSum(dealerHand) - 21)) {
						if (showGame) {
							System.out.println("Dealer was closer to 21");
						}
						if (playerHand.size() == 2 && playerHand.get(0) == playerHand.get(1)) {
							splitQTable[playerHand.get(0)][playerHand.get(1)] *= 21.0 / handSum(playerHand);

						}
						// splitQTable[playerHand.get(0)][playerHand.get(1)] *=21.0/handSum(playerHand);
						// doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update*update;
						tooFar++;

						splitQTable[playerHand.get(0)][secondPlayerHand
								.get(0)] *= ((handSum(playerHand) + handSum(secondPlayerHand) / 2)) / newPlayerSum;
						dealerWins++;
						dealerRecentWins++;

						if (doubled) {
							bet = -bet / 2;
						} else {
							bet = 0;
						}
						bets += bet;
						recentBets += bet;

						continue;
					} else if (handSum(secondPlayerHand) - 21 == handSum(dealerHand) - 21) {

						if (((secondPlayerHand.get(0) == 1 && secondPlayerHand.get(1) >= 10)
								|| (secondPlayerHand.get(0) >= 10 && secondPlayerHand.get(1) == 1))
								&& !((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
										|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
							if (showGame) {
								System.out.println("BLACKJACK");
							}
							// System.out.println("JJHIOHFOIDSHJIOAHFDSOIHFDISOH");
							AIWins++;
							AIRecentWins++;
							bet = (bet * 3) / 2.0;
							bets += bet;
							recentBets += bet;

						} else if (!((secondPlayerHand.get(0) == 1 && secondPlayerHand.get(1) >= 10)
								|| (secondPlayerHand.get(0) >= 10 && secondPlayerHand.get(1) == 1))
								&& ((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
										|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {

							if (showGame) {
								System.out.println("BLACKJACK for dealer");
							}
							surrenderQTable[playerHand.get(0)][playerHand.get(1)][dealerHand.get(0)] *= 1.0
									* handSum(dealerHand) / handSum(playerHand);
							dealerWins++;
							dealerRecentWins++;
							bet = 0;
							bets += bet;
							recentBets += bet;
						} else {

							
							tieGames++;
							recentTieGames++;
							bet = 100;
							bets += bet;
							recentBets += bet;

							if (showGame) {
								System.out.println("PUSH");
							}
						}
						continue;
					}
				}
			}

			if (handSum(dealerHand) > 21) {
				if (showGame) {
					System.out.println("Dealer busted");
				}

				AIWins++;
				AIRecentWins++;

				// bet = bet + payout*bet;
				bets += bet + payout * bet;
				recentBets += bet + payout * bet;
				continue;

			}

			else if (Math.abs(handSum(playerHand) - 21) < Math.abs(handSum(dealerHand) - 21)) {
				if (showGame) {
					System.out.println("Player was closer to 21");
				}

				update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
				QTable[oldPlayerSum][oldDealerSum] *= update;

				AIWins++;
				AIRecentWins++;

				// bet = bet
				bets += bet + payout * bet;
				recentBets += bet + payout * bet;

				continue;
			} else if (Math.abs(handSum(playerHand) - 21) > Math.abs(handSum(dealerHand) - 21)) {
				if (showGame) {
					System.out.println("Dealer was closer to 21");
				}
				if (playerHand.size() == 2 && playerHand.get(0) == playerHand.get(1)) {
					splitQTable[playerHand.get(0)][playerHand.get(1)] *= 21.0 / handSum(playerHand);

				}
				update = (21.0 / newPlayerSum + learningRate) / (learningRate + 1);
				QTable[oldPlayerSum][oldDealerSum] *= update;
				// doubleQTable[oldPlayerSum][dealerHand.get(0)] *= update*update;
				tooFar++;

				// QTable[oldPlayerSum][oldDealerSum] *= update;
				// update = 1.0001;
				// QTable[oldPlayerSum][oldDealerSum] *= update;

				dealerWins++;
				dealerRecentWins++;
				bet = 0;
				bets += bet;
				recentBets += bet;

				continue;
			} else if (handSum(playerHand) - 21 == handSum(dealerHand) - 21) {

				if (((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
						|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
						&& !((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
								|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {
					if (showGame) {
						System.out.println("BLACKJACK");
					}
					// System.out.println("JJHIOHFOIDSHJIOAHFDSOIHFDISOH");
					AIWins++;
					AIRecentWins++;
					bet = ((bet * 3) / 2);
					bets += bet;
					recentBets += bet;

				} else if (!((playerHand.get(0) == 1 && playerHand.get(1) >= 10)
						|| (playerHand.get(0) >= 10 && playerHand.get(1) == 1))
						&& ((dealerHand.get(0) == 1 && dealerHand.get(1) >= 10)
								|| (dealerHand.get(0) >= 10 && dealerHand.get(1) == 1))) {

					if (showGame) {
						System.out.println("BLACKJACK for dealer");
					}
					surrenderQTable[playerHand.get(0)][playerHand.get(1)][dealerHand
							.get(0)] *= (1.0 * handSum(dealerHand) + learningRate)
									/ (handSum(playerHand) + learningRate + 1);
					dealerWins++;
					dealerRecentWins++;
					bet = 0;
					bets += bet;
					recentBets += bet;
				} else {

					tieGames++;
					recentTieGames++;
					bet = 100;
					bets += bet;
					recentBets += bet;
					if (showGame) {
						System.out.println("PUSH");
					}
				}

				continue;
			}

		}
	}

	public static void showHand(ArrayList<Integer> hand, String s, String name) {
		if (s.equals("one")) {
			if (hand.get(0) == 1) {
				System.out.println(name + "'s hand:A ?");
			} else if (hand.get(0) > 1 && hand.get(0) < 11) {
				System.out.println(name + "'s hand:" + hand.get(0) + " ?");
			} else if (hand.get(0) > 10) {
				if (hand.get(0) == 11) {
					System.out.println(name + "'s hand:J ?");
				}
				if (hand.get(0) == 12) {
					System.out.println(name + "'s hand:Q ?");
				}
				if (hand.get(0) == 13) {
					System.out.println(name + "'s hand:K ?");
				}

			}
		}

		if (s.equals("all")) {
			System.out.print(name + "'s hand:");
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i) == 1) {
					System.out.print("A ");
				} else if (hand.get(i) > 1 && hand.get(i) < 11) {
					System.out.print(hand.get(i) + " ");
				} else if (hand.get(i) > 10) {
					if (hand.get(i) == 11) {
						System.out.print("J ");
					}
					if (hand.get(i) == 12) {
						System.out.print("Q ");
					}
					if (hand.get(i) == 13) {
						System.out.print("K ");
					}

				}
			}

		}
	}

	public static int handSum(ArrayList<Integer> hand) {
		int sum = 0;
		if (!hand.contains(1)) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i) > 10) {
					sum += 10;
				} else {
					sum += hand.get(i);
				}

			}
			return sum;
		} else {
			int numAces=0;
			for(int i = 0; i<hand.size(); i++) {
				if(hand.get(i)>10) {
					sum+=10;
				}
				else if(hand.get(i)==1) {
					numAces++;
				}
				else {
					sum+=hand.get(i);
				}
			}
			for(int i=0; i<numAces; i++) {
				if(sum<11) {
					sum+=11;
					}
				else {
					sum+=1;
				}
				}
			}

		return sum;

	}

	public static String decide(int playerSum, int dealerSum, double[][] QTable) {
		try {
			if (Math.random() < QTable[playerSum][dealerSum]) {
				return "hit";
			}
		} catch (Exception e) {

		}

		{
			return "stand";
		}
	}

	public static boolean shouldSurrender(int card1, int card2, int card3, double[][][] QTable) {
		return Math.random() < QTable[card1][card2][card3];
	}

	public static boolean shouldSplit(int card1, int card2, double[][] QTable) {
		return Math.random() < QTable[card1][card2];
	}

	public static boolean shouldDouble(int card1, int card2, double[][] QTable) {
		return Math.random() < QTable[card1][card2];
	}
}

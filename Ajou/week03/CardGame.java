import java.util.Scanner;

public class CardTest01 {
	
	public static Card[] deck = new Card[52];
	
	// deck 생성
	public static void deckGenerator(Card[] deck) {
		for(int i=0 ; i<4; ++i) {
			for(int j=0; j<13; ++j) {
				switch(i) {
				case 0: deck[i*13 + j] = new Card("Spade", j+1); break;
				case 1: deck[i*13 + j] = new Card("Diamond", j+1); break;
				case 2: deck[i*13 + j] = new Card("Heart", j+1); break;
				case 3: deck[i*13 + j] = new Card("Club", j+1); break;
				}
			}
		}
	}
	
	// deck shuffle
	public static void deckShuffler(Card[] deck) {
		Card cTmp; int nTmp;
		for(int i=0 ;i<52; ++i) {
			nTmp = (int)(Math.random() * 52);
			cTmp = deck[nTmp];
			deck[nTmp] = deck[i];
			deck[i] = cTmp;
		}
	}
	
	// main method
	public static void main(String[] args) {
		
		boolean bFlag = true;
		String sFlag;
		int drawNum = 51;
		
		Scanner SC = new Scanner(System.in);
		deckGenerator(deck);
		deckShuffler(deck);
		
		System.out.println("Card Game!\n");
		while(bFlag) {
			
			Card c1 = new Card();
			String c1Rank;
			System.out.print("Player1's suit type (Spade / Diamond / Heart / Club) : "); c1.suit = SC.nextLine();
			System.out.print("Player1's rank type (Ace / 2 ~ 10 / Jack / Queen / King) : "); c1Rank = SC.nextLine();
			if(c1Rank.equals("Ace")) c1.rank = 1;
			else if(c1Rank.equals("Jack")) c1.rank = 11;
			else if(c1Rank.equals("Queen")) c1.rank = 12;
			else if(c1Rank.equals("King")) c1.rank = 13;
			else c1.rank = Integer.parseInt(c1Rank);
			
			Card c2 = deck[drawNum];
			
			// Card 정보 출력
			printCard(c1);
			printCard(c2);
			
			// Card 정보 비교 + winner 출력
			int result;
			result = compareCards(c1, c2);
			if(result > 0) {
				System.out.print("Player Win's : ");
				printCard(c1);
			}
			else if(result < 0) {
				System.out.print("Computer Win's : ");
				printCard(c2);
			}
			else {
				System.out.println("Tie");
			}
			
			// 만약에 deck에서 카드를 모두 draw 했다면
			if(--drawNum<0) {
				System.out.println("\nComputer player draw's every card from deck.");
				System.out.print("\nMore Game ? (y/n) : ");
				sFlag = SC.nextLine();
				if(sFlag.equalsIgnoreCase("y")) {
					deckShuffler(deck);
					drawNum = 51;
					bFlag = true;
				}
				else if(sFlag.equalsIgnoreCase("N")) bFlag = false;
				else {System.out.println("Wrong input.. terminate program."); bFlag = false;}
			}
			// retry 여부 질문 (잘못된 input의 경우에, 처리요구사항은 없지만 프로그램 종료하도록 구현했습니다.)
			else{
				System.out.print("\n More Game ? (y/n) : ");
				sFlag = SC.nextLine();
				if(sFlag.equalsIgnoreCase("y")) bFlag = true;
				else if(sFlag.equalsIgnoreCase("N")) bFlag = false;
				else {System.out.println("Wrong input.. terminate program."); bFlag = false;}
			}
			
		}
		
		System.out.println("Game end.");
	}
	
	// Card 정보 출력
	static void printCard(Card c) {
		if(c.rank == 1) {
			System.out.println("Ace of " + c.suit);
		}
		else if(c.rank == 11) {
			System.out.println("Jack of " + c.suit);
		}
		else if(c.rank == 12) {
			System.out.println("Queen of " + c.suit);
		}
		else if(c.rank == 13) {
			System.out.println("King of " + c.suit);
		}
		else {
			System.out.println(c.rank + " of " + c.suit);
		}
	}
	
	// Card 승자 결정
	// c1 > c2 : returns 1, c1 < c2 : returns -1, c1 == c2 : returns 0
	static int compareCards(Card c1, Card c2) {
		
		int c1SuitNum = 0, c2SuitNum = 0, c1RankNum = 0, c2RankNum = 0;
		
		if(c1.suit.equals("Spade")) c1SuitNum = 4;
		else if(c1.suit.equals("Diamond")) c1SuitNum = 3;
		else if(c1.suit.equals("Heart")) c1SuitNum = 2;
		else if(c1.suit.equals("Club")) c1SuitNum = 1;
		else {}
		
		if(c2.suit.equals("Spade")) c2SuitNum = 4;
		else if(c2.suit.equals("Diamond")) c2SuitNum = 3;
		else if(c2.suit.equals("Heart")) c2SuitNum = 2;
		else if(c2.suit.equals("Club")) c2SuitNum = 1;
		else {}
		
		if(c1.rank == 1) c1RankNum = c1.rank + 15; else c1RankNum = c1.rank;
		if(c2.rank == 1) c2RankNum = c2.rank + 15; else c2RankNum = c2.rank;
		
		if(c1SuitNum == 0) {
			System.out.println("player suit input error..");
			return 0;
		}
		
		if(c1RankNum > c2RankNum) return 1;
		else if(c1RankNum < c2RankNum) return -1;
		else {
			if(c1SuitNum > c2SuitNum) return 1;
			else if(c1SuitNum < c2SuitNum) return -1;
			else return 0;
		}
		
	}
	
}

class Card{
	
	public String suit;
	public int rank;
	
	Card(String suit, int rank){this.suit = suit; this.rank =rank;}
	Card() {}
	
}

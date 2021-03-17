import java.util.Scanner;

public class CardTest5 {
	public static void main(String[] args) {
		
		boolean flag = true;
		Scanner SC = new Scanner(System.in);
		
		while(flag) {
			
			Card c1 = new Card();
			String c1Rank;
			System.out.print("\nPlayer1's suit type (Spade / Diamond / Heart / Club) : "); c1.suit = SC.nextLine();
			System.out.print("Player1's rank type (Ace / 2 ~ 10 / Jack / Queen / King) : "); c1Rank = SC.nextLine();
			if(c1Rank.equals("Ace")) c1.rank = 1;
			else if(c1Rank.equals("Jack")) c1.rank = 11;
			else if(c1Rank.equals("Queen")) c1.rank = 12;
			else if(c1Rank.equals("King")) c1.rank = 13;
			else c1.rank = Integer.parseInt(c1Rank);
			
			Card c2 = new Card(); 
			int n;
			n = (int)(Math.random()*4 + 1);
			switch(n) {
			case 1: c2.suit = "Club"; break;
			case 2: c2.suit = "Heart"; break;
			case 3: c2.suit = "Diamond"; break;
			case 4: c2.suit = "Spade"; break;
			}
			c2.rank = (int)(Math.random()*13 + 1);
			
			printCard(c1);
			printCard(c2);
			
			int result;
			result = compareCards(c1, c2);
			if(result > 0) {
				System.out.print("Player Win's : ");
				printCard(c1);
				flag = false;
			}
			else if(result < 0) {
				System.out.print("Computer Win's : ");
				printCard(c2);
				flag = true;
			}
			else {
				System.out.println("Tie");
			}
		}
		
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
	String suit;
	int rank;
}


// 실제 실행 시에 프로젝트 내에 모듈 기술자(module-info.java) 파일을 src에 추가해 실행시켰습니다.
/*
module ajou_week2 {
	requires java.se;
}
*/


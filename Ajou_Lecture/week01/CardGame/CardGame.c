#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define TERMSG "\n\nTerminating Program..\n"

enum cardnum {
	ACE = 14, KING = 13, QUEEN = 12, JACK = 11
};

enum cardsuit {
	spade = 4, diamond = 3, heart = 2, club = 1
};

typedef struct _card {
	int num;
	int suit;
}CARD;

typedef struct _person {
	char name[20];
	int balance;
	CARD card;
}PLAYER;

CARD DECK[52] = {
	{2, diamond}, {3, diamond}, {4,diamond}, {5, diamond}, {6, diamond}, {7,diamond }, {8,diamond}, {9,diamond}, {10,diamond}, {JACK,diamond}, {KING, diamond}, {QUEEN, diamond}, {ACE, diamond},
	{2, spade}, {3, spade}, {4,spade}, {5, spade}, {6, spade}, {7,spade }, {8,spade}, {9,spade}, {10,spade}, {JACK,spade}, {KING, spade}, {QUEEN, spade}, {ACE, spade},
	{2, heart}, {3, heart}, {4,heart}, {5, heart}, {6, heart}, {7,heart }, {8,heart}, {9,heart}, {10,heart}, {JACK,heart}, {KING, heart}, {QUEEN, heart}, {ACE, heart},
	{2, club}, {3, club}, {4,club}, {5, club}, {6, club}, {7,club }, {8,club}, {9,club}, {10,club}, {JACK,club}, {KING, club}, {QUEEN, club}, {ACE, club},
};

char CARD_SUIT[4][10] = { "club", "heart", "diamond", "spade" };
char CARD_NUM[13][10] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE" };

void swap(CARD* card1, CARD* card2) {
	CARD tmp;
	tmp = *card1;
	*card1 = *card2;
	*card2 = tmp;
	return;
}

void ShuffleDeck(CARD deck[]) {
	srand((unsigned int)time(NULL));
	
	// deck을 섞는다.
	for (int i = 0; i < 52; ++i) {
		swap(&deck[i], &deck[rand() % 52]);
	}
}

int CardCompare(PLAYER *P1, PLAYER *P2, int bet) {

	if ((*P1).card.num > (*P2).card.num) {
		return CaseP1Win(P1, P2, bet);
	}
	else if ((*P1).card.num < (*P2).card.num) {
		return CaseP2Win(P1, P2, bet);
	}
	else {
		if ((*P1).card.num > (*P2).card.num) {
			return CaseP1Win(P1, P2, bet);
		}
		else {
			return CaseP2Win(P1, P2, bet);
		}
	}

}

int CaseP1Win(PLAYER* P1, PLAYER* P2, int bet) {

	printf("====================================\n");
	printf("\nP1's card : %s %s, P2's card : %s %s\n", CARD_SUIT[(*P1).card.suit - 1], CARD_NUM[(*P1).card.num - 2], CARD_SUIT[(*P2).card.suit - 1], CARD_NUM[(*P2).card.num - 2]);

	if ((*P2).balance - bet <= 0) {
		(*P1).balance += (*P2).balance; (*P2).balance = 0;
		printf("Game end!\n");
		printf("Player1's balance : %d / Player2's balance : %d", (*P1).balance, (*P2).balance);
		return -1;
	}

	(*P1).balance += bet; (*P2).balance -= bet;
	printf("Player1 wins!\n");
	printf("Player1's balance : %d / Player2's balance : %d\n\n", (*P1).balance, (*P2).balance);
	return 0;
}

int CaseP2Win(PLAYER* P1, PLAYER* P2, int bet) {

	printf("====================================\n");
	printf("P1's card : %s %s, P2's card : %s %s\n", CARD_SUIT[(*P1).card.suit - 1], CARD_NUM[(*P1).card.num - 2], CARD_SUIT[(*P2).card.suit - 1], CARD_NUM[(*P2).card.num - 2]);

	if ((*P1).balance - bet <= 0) {
		(*P2).balance += (*P1).balance; (*P1).balance = 0;
		printf("Game end!\n");
		printf("Player1's balance : %d / Player2's balance : %d\n\n", (*P1).balance, (*P2).balance);
		return -1;
	}

	(*P2).balance += bet; (*P1).balance -= bet;
	printf("Player2 wins!\n");
	printf("Player1's balance : %d / Player2's balance : %d\n\n", (*P1).balance, (*P2).balance);
	return 0;
}

int main(void) {

	PLAYER P1, P2;
	int loop_flag = 1; char ans;
	int deck_walker = 0;
	int BET = 0;

	printf("PLAYER1==\n");
	printf("enter your name : "); scanf_s("%s", P1.name, 20);
	printf("money you bet? : "); scanf_s("%d", &P1.balance);
	printf("\n");

	printf("PLAYER2==\n");
	printf("enter your name : "); scanf_s("%s", P2.name, 20);
	printf("money you bet? : "); scanf_s("%d", &P2.balance);
	printf("\n===================\n");

	ShuffleDeck(DECK);

	do
	{
		printf("\nHow much do you want to bet? : " );
		scanf_s("%d", &BET);
		getchar();

		if (deck_walker >= 52) {
			deck_walker = 0;
			ShuffleDeck(DECK);
		}

		P1.card = DECK[deck_walker]; P2.card = DECK[deck_walker + 1];
		
		if (CardCompare(&P1, &P2, BET) < 0)
			break;

		deck_walker += 2;

		printf("One More Time (Y/N) ? : "); scanf_s("%c", &ans, 1);
		switch(ans) {
			case 'Y':
				loop_flag = 1;
				break;
			case 'N':
				printf("Game end!\n");
				loop_flag = 0;
				break;
			default:
				break;
		}

	} while (loop_flag);

	printf(TERMSG);

	return 0;

}

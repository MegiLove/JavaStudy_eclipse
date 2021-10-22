package com.sist.game;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck {
	private ArrayList<Card> deck= new ArrayList<Card>();
	
	//�����ڿ��� CardDeck�� ��������� deck�� 52���� ī�带 ����� �㵵�� ����
	public CardDeck() {
		String []suit= {"Clubs","Diamonds","Hearts","Spades"};
		String []number= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	for(int i=0; i<suit.length; i++) {
		for(int j=0; j<number.length; j++) {
			deck.add(new Card(suit[i], number[j]));
		}
	}
		
		shuffle();
		Card c1= deal();			
		Card c2=deal();			
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card deal() {
		return deck.remove(0);
	}
}

package com.sist.game;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck {
	private ArrayList<Card> deck= new ArrayList<Card>();
	
	//생성자에서 CardDeck의 멤버변수인 deck에 52장의 카드를 만들어 담도록 하자
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

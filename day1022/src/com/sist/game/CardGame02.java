package com.sist.game;

public class CardGame02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck= new CardDeck();
		deck.shuffle();
		
		Player p1= new Player();
		Player p2= new Player();
		
		for(int i=1; i<=7; i++) {
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		}
		p1.showCard();
		p2.showCard();
		
		if(p1.isOnePair()!=0) {
			System.out.println("player1은 원페어이다 "+p1.isOnePair());
		}else {
			System.out.println("player1은 원페어가 아니다");
					
		}
		if(p2.isOnePair()!=0) {
			System.out.println("player2은 원페어이다 "+p2.isOnePair());
		}else {
			System.out.println("player2은 원페어가 아니다");
					
		}
		
	}

}

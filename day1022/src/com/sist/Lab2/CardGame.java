package com.sist.Lab2;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck= new CardDeck();
		deck.shuffle();
		Player p1= new Player();
		Player p2= new Player();
		for(int i=0; i<5; i++) {
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		}
		p1.showCards();
		p2.showCards();
		
		if(p1.isOnePair()!=0) {
			System.out.println("player1의 원페어입니다. 점수는"+p1.isOnePair()+"입니다");
		}else {
			System.out.println("player1은 원페어가 아닙니다");
		}
		
		if(p2.isOnePair()!=0) {
			System.out.println("player2의 원페어입니다. 점수는"+p2.isOnePair()+"입니다");
		}else {
			System.out.println("player2은 원페어가 아닙니다");
		}
		
		if(p1.isTwoPair()) {
			System.out.println("player1의 투페어입니다. 점수는"+p2.isTwoPair()+"입니다");
		}else {
			System.out.println("player1의 투페어가 아닙니다");
		}
		if(p2.isTwoPair()) {
			System.out.println("player2의 투페어입니다. 점수는"+p2.isTwoPair()+"입니다");
		}else {
			System.out.println("player2의 투페어가 아닙니다");
		}
		
	}

}

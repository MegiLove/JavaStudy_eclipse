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
			System.out.println("player1�� ������Դϴ�. ������"+p1.isOnePair()+"�Դϴ�");
		}else {
			System.out.println("player1�� ���� �ƴմϴ�");
		}
		
		if(p2.isOnePair()!=0) {
			System.out.println("player2�� ������Դϴ�. ������"+p2.isOnePair()+"�Դϴ�");
		}else {
			System.out.println("player2�� ���� �ƴմϴ�");
		}
		
		if(p1.isTwoPair()) {
			System.out.println("player1�� ������Դϴ�. ������"+p2.isTwoPair()+"�Դϴ�");
		}else {
			System.out.println("player1�� ���� �ƴմϴ�");
		}
		if(p2.isTwoPair()) {
			System.out.println("player2�� ������Դϴ�. ������"+p2.isTwoPair()+"�Դϴ�");
		}else {
			System.out.println("player2�� ���� �ƴմϴ�");
		}
		
	}

}

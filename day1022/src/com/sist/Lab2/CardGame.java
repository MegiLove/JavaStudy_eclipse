package com.sist.Lab2;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck= new CardDeck();
		deck.shuffle();
		Player p1= new Player();
		Player p2= new Player();
		for(int i=0; i<7; i++) {
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		}
		p1.showCards();
		p2.showCards();
		
		int n1= p1.pairProcess("�÷��̾�1");
		int n2= p2.pairProcess("�÷��̾�2");
		if(n1==n2) {
			System.out.println("�����ϴ�");
		}else if(n1>n2) {
			System.out.println("�÷��̾� 1�� �̰���ϴ�");
		}else {
			System.out.println("�÷��̾� 2�� �̰���ϴ�");
		}
		
		
		
	}

}

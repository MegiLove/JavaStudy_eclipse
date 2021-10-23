package com.sist.Lab2;
import java.util.*;
public class Card {

	String suit;
	String number;
	public Card(String suit, String number) {
		super();
		this.suit = suit;
		this.number = number;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "[" + suit + "," + number + "]";
	}
	
	
}

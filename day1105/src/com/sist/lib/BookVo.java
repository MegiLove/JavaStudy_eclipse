package com.sist.lib;

public class BookVo {

	private int no;
	private String name;
	private String comp;
	private int price;
	
	public BookVo(int no, String name, String comp, int price) {
		super();
		this.no = no;
		this.name = name;
		this.comp = comp;
		this.price = price;
	}
	
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}

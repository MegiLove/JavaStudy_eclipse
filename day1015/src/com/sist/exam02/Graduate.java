package com.sist.exam02;

public class Graduate extends Student {
    private String type;
    private double rate;
	public Graduate(String name, String number, String major, int grade, double credits, String type, double rate) {
		super(name, number, major, grade, credits);
		this.type = type;
		this.rate = rate;
	}
	public Graduate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Graduate [type=" + type + ", rate=" + rate + ", name=" + name + ", number=" + number + ", major="
				+ major + ", grade=" + grade + ", credits=" + credits + "]";
	}
    
    
}

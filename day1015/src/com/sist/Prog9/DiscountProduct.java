package com.sist.Prog9;

public class DiscountProduct extends Product {
double discount;

public DiscountProduct(String name, double price, double discount) {
	super(name, price);
	this.discount = discount;
}

public DiscountProduct() {
	super();
	// TODO Auto-generated constructor stub
}

public double getDiscount() {
	return discount;
}

public void setDiscount(double discount) {
	this.discount = discount;
}

public double getPrice() {
	return price*(1-discount/100);
}

@Override
public String toString() {
	return "DiscountProduct [name=" + name + ", price=" + this.getPrice() + "]";
}


}

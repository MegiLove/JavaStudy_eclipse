package com.sist.exam09;

public class ColorRect extends Rect {
private String color;

public ColorRect(double width, double height, String color) {
	super(width, height);
	this.color = color;
}
public void info() {
	   System.out.println("����: "+width+",����: "+height+",����: "+color+",����: "+area);
}
}

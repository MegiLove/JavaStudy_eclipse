package com.sist.exam09;

public class ColorRect extends Rect {
private String color;

public ColorRect(double width, double height, String color) {
	super(width, height);
	this.color = color;
}
public void info() {
	   System.out.println("가로: "+width+",세로: "+height+",색상: "+color+",면적: "+area);
}
}

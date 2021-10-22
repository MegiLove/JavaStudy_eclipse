package com.sist.HW1021;

public class HW3 {
private String word;
private String explain;
public HW3(String word, String explain) {
	super();
	this.word = word;
	this.explain = explain;
}
public HW3() {
	super();
	// TODO Auto-generated constructor stub
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public String getExplain() {
	return explain;
}
public void setExplain(String explain) {
	this.explain = explain;
}
@Override
public String toString() {
	return "HW3 [단어=" + word + ", 설명=" + explain + "]";
}

}

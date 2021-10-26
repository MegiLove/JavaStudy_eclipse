package com.sist.exam08;

import java.util.Date;
public class Hello extends Thread {

	public void run(){
		while(true) {
			Date d=new Date();
			System.out.println(d);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
	


}

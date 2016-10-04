package com.prodcons;

import java.util.ArrayList;

public class Container {
	static int size = 0;
	static double obj = -1 ;
	
	public Container() {
		
	}
	public synchronized void put() throws InterruptedException{
		while(size != 0){
			this.wait();
		}
		
		Thread.sleep(1000);
		obj = (int) (Math.random()*1000);
		System.out.println("PUT:"+obj);
		
		size = 1;
		
		this.notifyAll();
	}
	
	public synchronized void get() throws InterruptedException{
		while(size != 1){
			this.wait();
		}
		
		Thread.sleep(1000);
		
		size = 0;
		System.out.println("GET:"+obj);
		obj = -1;
		
		this.notifyAll();
	}
}

package com.prodcons;

public class Entry {
	public static void main(String[] args) {
		int capacity = 20;
		Container container1 = new Container(); 
		
		new Producer(capacity, container1).start();
		new Consumer(capacity, container1).start();
		
		/*while(true){
			try {
				p.produce();
				c.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}*/
		
	}
}

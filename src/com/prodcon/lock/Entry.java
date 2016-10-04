package com.prodcon.lock;

public class Entry {
	public static void main(String[] args) {
		Container container1 = new Container(); 
		
		new Producer("Producer 1", container1).start();
		new Consumer("Consumer 1", container1).start();
		new Consumer("Consumer 2", container1).start();
		new Producer("Producer 2", container1).start();
		new Consumer("Consumer 3", container1).start();
		
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

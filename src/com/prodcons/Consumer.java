package com.prodcons;

public class Consumer extends Thread{
	int capacity = 100;
	Container myContainer = null;

	public Consumer(int capacity, Container myContainer) {
		this.capacity = capacity;
		this.myContainer = myContainer ;
	}
	
	public Consumer(Container myContainer) {
		this.myContainer = myContainer ;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				myContainer.get();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}

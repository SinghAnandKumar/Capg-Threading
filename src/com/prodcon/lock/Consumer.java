package com.prodcon.lock;

public class Consumer extends Thread{
	int capacity = 100;
	Container myContainer = null;
	String name;
	
	public Consumer(String name , Container myContainer) {
		this.name = name;
		this.myContainer = myContainer ;
	}
	
	
	@Override
	public void run() {
		try{
			while(true){
				myContainer.get(name);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}

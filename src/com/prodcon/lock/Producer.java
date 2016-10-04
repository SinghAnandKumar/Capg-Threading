package com.prodcon.lock;

public class Producer extends Thread {
	int capacity = 100;
	Container myContainer = null;
	String name;

	public Producer(String name, Container myContainer) {
		this.name = name;
		this.myContainer = myContainer;
	}

	@Override
	public void run() {

		try {
			while(true){
				myContainer.put(name);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

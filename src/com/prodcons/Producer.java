package com.prodcons;

public class Producer extends Thread {
	int capacity = 100;
	Container myContainer = null;

	public Producer(int capacity, Container myContainer) {
		this.capacity = capacity;
		this.myContainer = myContainer;
	}

	public Producer(Container myContainer) {
		this.myContainer = myContainer;
	}

	@Override
	public void run() {

		try {
			while(true){
				myContainer.put();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

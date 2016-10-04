package com.prodcon.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
	static int size = 0;
	static double obj = -1;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public Container() {

	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	// synchronised
	public void put(String name) throws InterruptedException {
		lock.lock();
		while (size != 0) {
			cond.await();
		}

		Thread.sleep(1000);
		obj = (int) (Math.random() * 1000);
		System.out.println(name+" :PUT: " + obj);

		size = 1;
		cond.signalAll();
		// this.notifyAll();
		lock.unlock();
	}

	// synchronised
	public void get(String name) throws InterruptedException {
		lock.lock();
		while (size != 1) {
			cond.await();
		}

		Thread.sleep(1000);

		size = 0;
		System.out.println(name+" :GET: " + obj);
		obj = -1;

		cond.signalAll();
		//this.notifyAll();
		lock.unlock();
	}
}

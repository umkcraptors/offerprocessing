package com.bizintelli.offerprocessing.services;

import org.apache.log4j.Logger;

import com.bizintelli.offerprocessing.rest.conroller.MarketerController;

public class MarketerWorkerThread implements Runnable {
	Logger  LOG = Logger.getLogger(MarketerWorkerThread.class.getName());
 private String workerName;
 
	public String getWorkerName() {
	return workerName;
}

public void setWorkerName(String workerName) {
	this.workerName = workerName;
}

	public MarketerWorkerThread() {
	super();
	
}

	public MarketerWorkerThread(String workerName) {
		super();
		this.workerName = workerName;
	}

	@Override
	public void run() {
		System.out.println("Worker name is" +workerName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}

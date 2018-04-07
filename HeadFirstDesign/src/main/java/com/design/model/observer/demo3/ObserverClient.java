package com.design.model.observer.demo3;

import com.design.model.observer.demo1weather.DisplayElement;

public class ObserverClient implements DisplayElement, Client {

	private String info;
	private Server server;
	
	public ObserverClient(Server server){
		this.server =server;
		server.addClient(this);
	}
	
	@Override
	public void setInfo(String info) {
		this.info = info;
		display();

	}

	@Override
	public void display() {
		System.out.println("ObserverClient : "+info);

	}

}

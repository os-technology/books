package com.design.model.observer.demo3;

public interface Server {
	
	public void addClient(Client client);
	public void removeClient(Client client);
	public void notifyClients();

}

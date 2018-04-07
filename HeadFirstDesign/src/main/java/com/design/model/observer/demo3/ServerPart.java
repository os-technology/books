package com.design.model.observer.demo3;

import java.util.ArrayList;
import java.util.List;

public class ServerPart implements Server {

	private List clientList;
	private String message;

	public ServerPart() {
		clientList = new ArrayList();
	}

	@Override
	public void addClient(Client client) {
		clientList.add(client);

	}

	@Override
	public void removeClient(Client client) {
		int i = clientList.indexOf(client);
		if (i >= 0) {
			clientList.remove(i);
		}

	}

	/**
	 * 负责通知所有接入的客户端
	 */
	@Override
	public void notifyClients() {

		for (int i = 0; i < clientList.size(); i++) {
			Client client = (Client) clientList.get(i);
			client.setInfo(message + " 数字编号为：" + i);
		}
	}

	/**
	 * 准备向客户端传送的信息
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
		notifyClients();
	}

}

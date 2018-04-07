package com.design.model.observer.demo3;

public class ClientExecute {

	public static void main(String[] args) {
		ServerPart sp = new ServerPart();
		ObserverClient oc = new ObserverClient(sp);
		ObserverClient2 oc2 = new ObserverClient2(sp);
		
		sp.setMessage("开始工作");
		

	}

}

package com.design.model.observer.demo2;

public class ClientUser implements User {
	
	private PaperSubject paper;
	public ClientUser(PaperSubject ps){
		this.paper = ps;
		ps.addUser(this);
	}
	

	@Override
	public void getPaper(String paper) {
		System.out.println("ClientUser has gotten "+paper);

	}

}

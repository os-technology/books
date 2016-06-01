package com.design.model.observer.demo2;

public class CompanyUser implements User {
	private PaperSubject ps;
	
	public CompanyUser(PaperSubject ps){
		this.ps  = ps;
		ps.addUser(this);
	}
	

	@Override
	public void getPaper(String paper) {
		System.out.println("CompanyUser has gotten "+paper);

	}

}

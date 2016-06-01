package com.design.model.observer.demo2;

public class PaperJob {

	public static void main(String[] args) {
		PaperOffice ps = new PaperOffice();
		
		ClientUser cu = new ClientUser(ps);	
		CompanyUser comU = new CompanyUser(ps);
		
		ps.setPaper("今日早报");
	}

}

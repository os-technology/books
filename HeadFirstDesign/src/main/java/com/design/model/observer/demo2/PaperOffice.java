package com.design.model.observer.demo2;

import java.util.ArrayList;
import java.util.List;

public class PaperOffice implements PaperSubject {

	private List userList;
	private String paper;

	public PaperOffice() {
		userList = new ArrayList();
	}

	@Override
	public void addUser(User u) {
		userList.add(u);

	}

	@Override
	public void removeUser(User u) {
		int i = userList.indexOf(u);
		if (i >= 0)
			userList.remove(i);

	}

	@Override
	public void notifyUsers() {
		for(int i=0;i<userList.size();i++){
			User user = (User)userList.get(i);
			user.getPaper(paper);
		}
	}

	public void setPaper(String paper){
		this.paper = paper;
		notifyUsers();
	}
	
}

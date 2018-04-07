package com.design.model.observer.demo2;

/**
 * 报社接口
 * @author shui
 *
 */
public interface PaperSubject {
	
	public void addUser(User u);
	public void removeUser(User u);
	public void notifyUsers();

}

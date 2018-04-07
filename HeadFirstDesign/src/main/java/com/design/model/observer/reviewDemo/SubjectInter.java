package com.design.model.observer.reviewDemo;

public interface SubjectInter {
	
	void register(ObserverInter o);
	void remove(ObserverInter o);
	void notifyData();

}

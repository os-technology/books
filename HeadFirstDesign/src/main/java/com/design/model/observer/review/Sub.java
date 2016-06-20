package com.design.model.observer.review;

/**
 * 主题接口
 * 
 * @author gao
 *
 */
public interface Sub {
	void register(ObInter inter);

	void notifyData();

	void remove(ObInter in);
}

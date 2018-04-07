package org.chapter.databasic.interview.aop;

import org.apache.log4j.Logger;

public class BussinessServiceImpl implements BussinessService {

	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@Override
	public String login(String username, String password) {
		return "login success";
	}

	@Override
	public String find() {
		return "find success";
	}

}

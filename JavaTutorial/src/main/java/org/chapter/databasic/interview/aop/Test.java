package org.chapter.databasic.interview.aop;

import org.apache.log4j.Logger;

public class Test {
	public static Logger logger = Logger.getLogger(Test.class.getSimpleName());

	public static void main(String[] args) {
		BussinessService bs = LogInvoHandler.getProxyInstance(BussinessServiceImpl.class);

		bs.login("zhangsan", "123456");
		bs.find();
		logger.info("-------------------------");
		WorkService ws = LogInvoHandler.getProxyInstance(WorkServiceImpl.class);
		ws.work();
		ws.sleep();

		logger.info("-------------------------");

		BussinessService bss = LogInvoHandler.getProxyInstance(BussinessServiceImpl.class);
		bss.login("lisi", "654321");
		bss.find();

	}

}

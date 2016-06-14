package org.chapter.databasic.interview.aop;

public interface Aspect {
	/**
	 * 事先执行
	 */
	public void doBefore();

	/**
	 * 事后执行
	 */
	public void doAfter();
}

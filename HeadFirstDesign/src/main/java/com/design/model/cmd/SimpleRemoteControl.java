package com.design.model.cmd;

/**
 * 遥控器类
 * 
 * @author Yujinshui
 *
 */
public class SimpleRemoteControl {
	Command slot;

	public SimpleRemoteControl() {

	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}

package com.design.model.cmd.remote;

import com.design.model.cmd.Command;

/**
 * 遥控器
 * 
 * @author Yujinshui
 *
 */
public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	/**
	 * 记录开关数组中对应的插槽位置。
	 * 
	 * @param slot
	 *            插槽位置
	 * @param onCommand
	 *            开命令
	 * @param offCommand
	 *            关命令
	 * @author Yujinshui
	 * @time 2016年3月30日 上午8:04:32
	 */
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	/**
	 * 开
	 * 
	 * @param slot
	 * @author Yujinshui
	 * @time 2016年3月30日 上午8:05:50
	 */
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}

	/**
	 * 关
	 * 
	 * @param slot
	 * @author Yujinshui
	 * @time 2016年3月30日 上午8:05:59
	 */
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------Remote Control ------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "]" + onCommands[i].getClass().getName() + "     "
					+ offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();

	}
}

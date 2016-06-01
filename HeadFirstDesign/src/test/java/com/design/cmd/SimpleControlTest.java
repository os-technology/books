package com.design.cmd;

import com.design.model.cmd.Light;
import com.design.model.cmd.LightOnCommand;
import com.design.model.cmd.SimpleRemoteControl;
import com.design.model.cmd.demo2.GarageDoor;
import com.design.model.cmd.demo2.GarageDoorOpenCommand;
import com.design.model.cmd.demo3.Mobile;
import com.design.model.cmd.demo3.Phone;

/**
 * 命令模式测试类（相当于客户）
 * 
 * @author Yujinshui
 *
 */
public class SimpleControlTest {

	public static void main(String[] args) {
		
		

		SimpleRemoteControl src = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightControl = new LightOnCommand(light);
		src.setCommand(lightControl);
		src.buttonWasPressed();

		/***************************/
		GarageDoor gd = new GarageDoor();
		GarageDoorOpenCommand oc = new GarageDoorOpenCommand(gd);
		src.setCommand(oc);
		src.buttonWasPressed();
		/***************************/
		Phone phone = new Phone();
		Mobile mob = new Mobile(phone);
		src.setCommand(mob);
		src.buttonWasPressed();
	}

}

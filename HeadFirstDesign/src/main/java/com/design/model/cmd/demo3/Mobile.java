package com.design.model.cmd.demo3;

import com.design.model.cmd.Command;

public class Mobile implements Command {
	Phone phone;

	public Mobile(Phone phone) {
		this.phone = phone;
	}

	@Override
	public void execute() {
		phone.closeScreen();

	}

}

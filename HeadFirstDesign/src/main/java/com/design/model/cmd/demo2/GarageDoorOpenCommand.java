package com.design.model.cmd.demo2;

import com.design.model.cmd.Command;

public class GarageDoorOpenCommand implements Command {
	GarageDoor door;

	public GarageDoorOpenCommand(GarageDoor gd) {
		this.door = gd;
	}

	@Override
	public void execute() {
		door.up();
	}

}

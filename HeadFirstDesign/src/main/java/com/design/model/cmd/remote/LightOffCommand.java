package com.design.model.cmd.remote;

import com.design.model.cmd.Command;
import com.design.model.cmd.Light;

public class LightOffCommand implements Command {
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}


}

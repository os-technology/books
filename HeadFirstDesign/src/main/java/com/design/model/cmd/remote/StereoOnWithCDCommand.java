package com.design.model.cmd.remote;

import com.design.model.cmd.Command;

/**
 * 音响CD命令
 * 
 * @author Yujinshui
 *
 */
public class StereoOnWithCDCommand implements Command {

	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}

}

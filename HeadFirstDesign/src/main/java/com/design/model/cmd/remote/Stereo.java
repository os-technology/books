package com.design.model.cmd.remote;

public class Stereo {
	void on() {
		System.out.println("Stereo（音响）is open.");
	}

	void setCD() {
		System.out.println("设置音响CD");
	}

	void setVolume(int sound) {
		System.out.println("设置Stereo音量为：" + sound);
	}
}

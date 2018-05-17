package com.wisely.highlight_spring4.ch3.c4_conditional;

public class WindowsListService implements ListService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}

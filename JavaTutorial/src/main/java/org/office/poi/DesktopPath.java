package org.office.poi;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class DesktopPath {

	public static String getDesktopPath() {
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		System.out.println(desktopDir.getPath());
		System.out.println(desktopDir);
		System.out.println(desktopDir);
		System.out.println(desktopDir);
		System.out.println(desktopDir);
		
		return desktopDir.getAbsolutePath();
	}

	public static void main(String[] args) {
		System.out.println(getDesktopPath());

	}

}

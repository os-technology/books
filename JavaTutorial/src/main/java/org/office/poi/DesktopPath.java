package org.office.poi;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class DesktopPath {
	/**
	 * 获取桌面名称
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月2日 下午3:13:01
	 */
	public static String getDesktopPath() {
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		System.out.println(desktopDir);
		
		return desktopDir.getAbsolutePath();
	}

	public static void main(String[] args) {
		System.out.println(getDesktopPath());

	}

}

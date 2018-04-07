package org.office.poi;

import java.io.File;

public class Extension {
	/**
	 * 
	 * 得到文件扩展名
	 * 
	 * @param file
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月17日 下午1:56:01
	 * @since 0.3.0.0 {初始版本号}
	 */
	public static String getExtension(File file) {
		String info = file.getName().substring(
				file.getName().lastIndexOf(".") + 1);
		info = info.toLowerCase();
		return info;
	}

}

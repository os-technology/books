package org.webservice.weather.client;

/**
 * 各种状态记录
 * 
 * @author admin
 * 
 */
public class WeatherBasic {
	public static String[] cityException = { "城市信息输出异常" };
	public static String[] cityWeatherException = { "城市天气预报输出异常" };

	public static String[] regionCountryException = { "获得国外国家名称和与之对应的ID失败" };
	public static String[] regionProvinceException = { "获得中国省份、直辖市、地区和与之对应的ID" };
	public static String[] supportCityException = { "获得支持的城市/地区名称和与之对应的ID失败" };

	public static String[] weatherException = { "获得天气预报数据异常" };

	public static String regionDatasetException = "获得中国省份、直辖市、地区；国家名称（国外）和与之对应的ID的xml文件失败";

	/**
	 * 返回城市编号数组
	 * 
	 * @param info
	 * @return
	 */
	public static String[] getCityCode(String[] info) {
		String[] cityCodes = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			cityCodes[i] = getCode(info[i]);
		}
		return cityCodes;
	}

	/**
	 * 返回编号
	 * 
	 * @param input
	 * @return
	 */
	public static String getCode(String input) {
		String cityCode = null;
		if ("(".equals(input)) {
			cityCode = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
		} else {
			cityCode = input.substring(input.indexOf(",") + 1);
		}
		return cityCode;
	}

	/**
	 * 获取城市名称
	 * 
	 * @param info
	 * @return
	 */
	public static String[] getCityName(String[] info) {
		String[] cityName = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			cityName[i] = getName(info[i]);
		}
		return cityName;
	}

	/**
	 * 获取名称
	 * 
	 * @param name
	 * @return
	 */
	public static String getName(String name) {
		String getName = null;
		if ("(".equals(name)) {
			getName = name.substring(0, name.indexOf("("));
		} else {
			getName = name.substring(0, name.indexOf(","));
		}
		return getName;
	}

	/**
	 * 打印String[]结果
	 * 
	 * @param re
	 */
	public static void printArrayResult(String[] re) {
		for (int i = 0; i < re.length; i++) {
			System.out.println(i + "****:" + re[i]);
		}

	}

	/**
	 * 获取所属省份（直辖市，自治区）
	 * 
	 * @param info
	 * @return
	 */
	public static String getPro(String[] info) {
		return info[0];
	}

}
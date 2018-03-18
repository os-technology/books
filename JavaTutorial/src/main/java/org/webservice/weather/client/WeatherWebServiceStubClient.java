package org.webservice.weather.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.webservice.weather.beans.WeatherWebServiceBean;
import org.webservice.weather.stub.WeatherWebServiceStub;
import org.webservice.weather.stub.WeatherWebServiceStub.ArrayOfString;
import org.webservice.weather.stub.WeatherWebServiceStub.GetSupportCity;
import org.webservice.weather.stub.WeatherWebServiceStub.GetSupportCityResponse;
import org.webservice.weather.stub.WeatherWebServiceStub.GetWeatherbyCityName;
import org.webservice.weather.stub.WeatherWebServiceStub.GetWeatherbyCityNameResponse;

/**
 * 天气预报wsdl调用 WeatherWebServiceStub
 * <p>
 * http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl
 * <p>
 * 包括 340 多个中国主要城市和 60 多个国外主要城市三日内的天气预报数据。
 * 
 * @author admin
 * 
 */
public class WeatherWebServiceStubClient extends WeatherBasic {

	private WeatherWebServiceStub getStub() {
		WeatherWebServiceStub stub = null;
		try {
			for (int i = 0; i < 5 && stub == null; i++)
				stub = new WeatherWebServiceStub();
			return stub;
		} catch (AxisFault e) {

			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 由省份获取所需的城市
	 * 
	 * @param province
	 * @return
	 */
	public String[] getSupportCityByProvince(String province) {

		try {

			/*******************/
			GetSupportCity getSupportCity = new GetSupportCity();
			// 设置省的名称
			getSupportCity.setByProvinceName(province);
			// 得到市的对象
			/**
			 * <br />
			 * <h3>查询本天气预报Web Services支持的国内外城市或地区信息</h3>
			 * <p>
			 * 输入参数：byProvinceName = 指定的洲或国内的省份，若为ALL或空则表示返回全部城市；返回数据：一个一维字符串数组
			 * String()，结构为：城市名称(城市代码)。
			 * </p>
			 * <br />
			 */
			GetSupportCityResponse cities = getStub().getSupportCity(getSupportCity);
			ArrayOfString result = cities.getGetSupportCityResult();
			// 得到省份中的市名
			String[] re = result.getString();
			printArrayResult(re);// TODO
			return re;
			/*******************/
			/*******************/

		} catch (RemoteException e) {

			e.printStackTrace();
			return cityException;
		}

	}

	/**
	 * 通过城市获得该地区的天气状况
	 * 
	 * @param cityName
	 * @return
	 */
	public String[] getWeatherInfoByCityName(String cityName) {
		/*******************/
		try {
			GetWeatherbyCityName getCityName = new GetWeatherbyCityName();
			// 获取城市名
			getCityName.setTheCityName(cityName);
			/**
			 * <br>
			 * <h3>根据城市或地区名称查询获得未来三天内天气情况、现在的天气实况、天气和生活指数</h3>
			 * <p>
			 * 调用方法如下：输入参数：theCityName = 城市中文名称(国外城市可用英文)或城市代码(不输入默认为上海市)，如：上海 或
			 * 58367，如有城市名称重复请使用城市代码查询(可通过 getSupportCity 或 getSupportDataSet
			 * 获得)；返回数据： 一个一维数组 String(22)，共有23个元素。<br />
			 * String(0) 到 String(4)：省份，城市，城市代码，城市图片名称，最后更新时间。String(5) 到
			 * String(11)：当天的
			 * 气温，概况，风向和风力，天气趋势开始图片名称(以下称：图标一)，天气趋势结束图片名称(以下称：图标二)
			 * ，现在的天气实况，天气和生活指数。String(12) 到 String(16)：第二天的
			 * 气温，概况，风向和风力，图标一，图标二。String(17) 到 String(21)：第三天的
			 * 气温，概况，风向和风力，图标一，图标二。String(22) 被查询的城市或地区的介绍 <br />
			 * <a href="http://www.webxml.com.cn/images/weather.zip">下载天气图标
			 * <img src="http://www.webxml.com.cn/images/download_w.gif" border=
			 * "0" align="absbottom" /></a>(包含大、中、小尺寸)
			 * <a href="http://www.webxml.com.cn/zh_cn/weather_icon.aspx" target
			 * ="_blank">天气图例说明</a>
			 * <a href="http://www.webxml.com.cn/files/weather_eg.zip">
			 * 调用此天气预报Web Services实例下载</a> (VB ASP.net 2.0)
			 * </p>
			 * <br />
			 */
			GetWeatherbyCityNameResponse weatherReport = getStub().getWeatherbyCityName(getCityName);

			ArrayOfString thisCityWeather = weatherReport.getGetWeatherbyCityNameResult();
			String[] cityReport = thisCityWeather.getString();

			return cityReport;
		} catch (RemoteException e) {

			e.printStackTrace();
			return cityWeatherException;
		}
		/*******************/
	}

}

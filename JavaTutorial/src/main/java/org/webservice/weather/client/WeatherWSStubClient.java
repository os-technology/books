package org.webservice.weather.client;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;

import org.webservice.weather.stub.WeatherWSStub;
import org.webservice.weather.stub.WeatherWSStub.ArrayOfString;
import org.webservice.weather.stub.WeatherWSStub.GetRegionCountry;
import org.webservice.weather.stub.WeatherWSStub.GetRegionCountryResponse;
import org.webservice.weather.stub.WeatherWSStub.GetRegionDataset;
import org.webservice.weather.stub.WeatherWSStub.GetRegionDatasetResponse;
import org.webservice.weather.stub.WeatherWSStub.GetRegionDatasetResult_type0;
import org.webservice.weather.stub.WeatherWSStub.GetRegionProvince;
import org.webservice.weather.stub.WeatherWSStub.GetRegionProvinceResponse;
import org.webservice.weather.stub.WeatherWSStub.GetSupportCityString;
import org.webservice.weather.stub.WeatherWSStub.GetSupportCityStringResponse;
import org.webservice.weather.stub.WeatherWSStub.GetWeather;
import org.webservice.weather.stub.WeatherWSStub.GetWeatherResponse;

/**
 * WeatherWSStub
 * <p>
 * http://www.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl
 * <p>
 * 包含2300个以上中国城市和100个以上国外城市天气预报数据。数据每2.5小时左右自动更新一次，准确可靠。
 * 
 */
public class WeatherWSStubClient extends WeatherBasic {

	/**
	 * 初始化客户端
	 * 
	 * @return
	 */
	private WeatherWSStub getStub() {
		WeatherWSStub stub = null;
		try {
			for (int i = 0; i < 5 && stub == null; i++)
				stub = new WeatherWSStub();
		} catch (AxisFault e) {
			System.out.println("初始化客户端失败，请检查类是否存在");
			e.printStackTrace();

		}
		return stub;
	}

	/**
	 * <br />
	 * <h3>获得天气预报数据</h3>
	 * <p>
	 * 输入参数：城市/地区ID或名称，返回数据：一维字符串数组。
	 * </p>
	 * <br />
	 * 
	 * @param cityName
	 * @return
	 */
	public String[] getWeatherInfoByCityName(String cityName) {

		try {
			GetWeather getWeather = new GetWeather();
			getWeather.setTheCityCode(cityName);
			// getWeather.setTheUserID("54511");
			GetWeatherResponse response = getStub().getWeather(getWeather);

			ArrayOfString res = response.getGetWeatherResult();

			String[] result = res.getString();
			return result;
		} catch (RemoteException e) {

			e.printStackTrace();
			return cityWeatherException;
		}

	}

	/**
	 * <br />
	 * <h3>获得国外国家名称和与之对应的ID</h3>
	 * <p>
	 * 输入参数：无，返回数据：一维字符串数组。
	 * </p>
	 * <br />
	 * 
	 * @return
	 */
	public String[] getRegionCountries() {

		// getRegionCountry.
		try {
			GetRegionCountry getRegionCountry = new GetRegionCountry();
			GetRegionCountryResponse response = getStub().getRegionCountry(getRegionCountry);
			ArrayOfString res = response.getGetRegionCountryResult();
			String[] result = res.getString();
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return regionCountryException;
		}

	}

	/**
	 * <br />
	 * <h3>获得中国省份、直辖市、地区；国家名称（国外）和与之对应的ID</h3>
	 * <p>
	 * 输入参数：无，返回数据：DataSet。
	 * </p>
	 * <br />
	 * 
	 * @return
	 */
	public String getAllRegionDataset() {

		try {
			GetRegionDataset getRegionDataset = new GetRegionDataset();

			GetRegionDatasetResponse dataSet = getStub().getRegionDataset(getRegionDataset);
			GetRegionDatasetResult_type0 res = dataSet.getGetRegionDatasetResult();

			OMElement result = res.getExtraElement();
			/************* 测试使用 ****************/
			System.out.println("test");
			/*****************************/
			String item = null;
			try {
				/**
				 * 得到所需信息的xml文件,需要解析xml文件
				 */
				item = result.toStringWithConsume();

			} catch (XMLStreamException e) {

				e.printStackTrace();
			}
			return item;
		} catch (RemoteException e) {

			e.printStackTrace();
			return regionDatasetException;
		}

	}

	/**
	 * <br />
	 * <h3>获得中国省份、直辖市、地区和与之对应的ID</h3>
	 * <p>
	 * 输入参数：无，返回数据：一维字符串数组。
	 * </p>
	 * <br />
	 * 
	 * @return
	 */
	public String[] getAllProvinces() {

		try {
			GetRegionProvince getRegionProvince = new GetRegionProvince();
			GetRegionProvinceResponse provinces = getStub().getRegionProvince(getRegionProvince);
			ArrayOfString allPro = provinces.getGetRegionProvinceResult();
			String[] result = allPro.getString();
			return result;
		} catch (RemoteException e) {

			e.printStackTrace();
			return regionProvinceException;
		}

	}

	/**
	 * <br />
	 * <h3>根据省市获得支持的城市/地区名称和与之对应的ID</h3>
	 * <p>
	 * 输入参数：theRegionCode = 省市、国家ID或名称，返回数据：一维字符串数组。
	 * </p>
	 * <br />
	 * 
	 * 
	 * @param nameOrId
	 * 
	 * @return
	 */
	public String[] getSupportCity(String nameOrId) {

		try {
			GetSupportCityString supportCityString = new GetSupportCityString();
			supportCityString.setTheRegionCode(nameOrId);
			GetSupportCityStringResponse response = getStub().getSupportCityString(supportCityString);
			ArrayOfString res = response.getGetSupportCityStringResult();
			String[] result = res.getString();

			return result;
		} catch (Exception e) {

			e.printStackTrace();
			return supportCityException;
		}
	}

	/**
	 * <br />
	 * <h3>获得天气预报数据</h3>
	 * <p>
	 * 默认上海预报
	 * <p>
	 * 输入参数：城市/地区ID或名称，返回数据：一维字符串数组。
	 * </p>
	 * <br />
	 * 
	 * @param cityCode
	 * @return
	 */
	public String[] getWeatherInfo(String city) {
		GetWeather weather = new GetWeather();
		weather.setTheCityCode(city);
		try {
			GetWeatherResponse weatherInfo = getStub().getWeather(weather);

			ArrayOfString res = weatherInfo.getGetWeatherResult();
			String[] result = res.getString();

			return result;
		} catch (RemoteException e) {

			System.out.println(e.toString());// org.apache.axis2.AxisFault:
												// 服务器无法处理请求。 ---> 值不能为空。
			return weatherException;
		}
	}

}

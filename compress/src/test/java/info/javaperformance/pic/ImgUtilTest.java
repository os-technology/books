package info.javaperformance.pic;

import org.junit.Test;

import info.javaperformance.util.Base64Util;
import info.javaperformance.zip.BZip2Utils;

public class ImgUtilTest {
	@Test
	public void testBzip2() throws Exception {
		String input = "/Users/yujinshui/Desktop/shui_1.jpg";
		String picBase64 = Base64Util.getImgBase64Str(input);
		byte[] compressPic = BZip2Utils.compress(picBase64.getBytes());
		System.out.println("图片base64长度："+picBase64.getBytes().length);
		System.out.println("图片base64-压缩后 1 长度："+compressPic.length);
		byte[] compressPic2 = BZip2Utils.compress(compressPic);
		System.out.println("图片base64-压缩后 2 长度："+compressPic2.length);
		byte[] dcom2 = BZip2Utils.decompress(compressPic2);
		System.out.println("图片解压2 长度："+dcom2.length);
		byte[] dcom1 = BZip2Utils.decompress(dcom2);
		System.out.println("图片解压1 长度："+dcom1.length);
		
		
//		String output = "/Users/yujinshui/Desktop/result_03.jpg";
//		ImgUtil.reduceImg(input, output, 0.3);
//		System.out.println("输出完成");
	}

}

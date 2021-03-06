package info.javaperformance.pic;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("restriction")
public class ImgUtil {
	/**
	 * 
	 * 
	 * @param imgsrc
	 *            图片路径
	 * @param imgdist
	 *            输出路径
	 * @param rate
	 *            压缩比
	 * @Author yujinshui
	 * @createTime 2016年8月14日 下午7:58:57
	 */
	public static void reduceImg(String imgsrc, String imgdist, double rate) {
		try {
			File srcfile = new File(imgsrc);
			if (!srcfile.exists()) {
				return;
			}
			Image src = javax.imageio.ImageIO.read(srcfile);
			int iwidth = src.getWidth(null);
			int iheight = src.getHeight(null);
			System.out.println(iwidth + "  " + iheight);
			int width = (int) (iwidth * rate);
			int height = (int) (iheight * rate);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
			// tag.getGraphics().drawImage(src.getScaledInstance(widthdist,
			// heightdist, Image.SCALE_AREA_AVERAGING), 0, 0, null);

			FileOutputStream out = new FileOutputStream(imgdist);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
			out.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String name = "wangxiaoyue";
		String input = "/Users/yujinshui/Desktop/piccheck/"+name+"_1.jpg";
		String output = "/Users/yujinshui/Desktop/piccheck/"+name+"_2.jpg";
		reduceImg(input, output, 0.3);
		System.out.println("输出完成");
	}

}

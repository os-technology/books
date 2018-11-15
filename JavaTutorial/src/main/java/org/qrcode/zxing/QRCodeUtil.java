package org.qrcode.zxing;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang.StringUtils;

public class QRCodeUtil {

    public QRCodeUtil() {
    }

    public QRCodeUtil(int qr_size, int logo_width, int logo_height) {
        this.WIDTH = logo_width;
        this.HEIGHT = logo_height;
        this.QRCODE_SIZE = qr_size;
    }

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static int QRCODE_SIZE = 300;
    // LOGO宽度
    private static int WIDTH = 60;
    // LOGO高度
    private static int HEIGHT = 60;

    /**
     * 二维码创建
     *
     * @param content
     * @param imgPath
     * @param needCompress
     * @return
     * @throws Exception
     */
    private static BufferedImage createImageForQrCode(String content, String imgPath, boolean needCompress) throws Exception {
        return createImage(content, imgPath, needCompress, BarcodeFormat.QR_CODE);
    }

    /**
     * 条码创建
     *
     * @param content
     * @param imgPath
     * @return
     * @throws Exception
     */
    private static BufferedImage createImageForBarCode(String content, String imgPath) throws Exception {
        return createImage(content, imgPath, false, BarcodeFormat.CODE_128);
    }

    /**
     * 创建指定类型的条码
     *
     * @param content
     * @param imgPath
     * @param needCompress
     * @param barcodeFormat
     * @return
     * @throws Exception
     */
    private static BufferedImage createImage(String content, String imgPath, boolean needCompress, BarcodeFormat barcodeFormat) throws Exception {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, barcodeFormat, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (StringUtils.isBlank(imgPath)) {
            return image;
        }
        // 插入图片
        insertImage(image, imgPath, needCompress);
        return image;
    }

    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * @param content      内容
     * @param imgPath      logo路径,为空则不添加logo
     * @param destPath     输出路径
     * @param needCompress 是否需要压缩二维码logo尺寸
     * @param picName      指定图片名称
     * @throws Exception
     * @Author yujinshui
     * @createTime 2016年11月12日 下午9:55:06
     */
    public static void encodeForQrCode(String content, String imgPath, String destPath, boolean needCompress, String picName)
            throws Exception {
        BufferedImage image = QRCodeUtil.createImageForQrCode(content, imgPath, needCompress);
        mkdirs(destPath);

        ImageIO.write(image, FORMAT_NAME, new File(destPath + File.separator + picName));
    }

    /**
     * 条码创建
     *
     * @param content  内容
     * @param imgPath  logo路径,为空则不添加logo
     * @param destPath 输出路径
     * @param picName  图片名称
     * @throws Exception
     */
    public static void encodeForBarCode(String content, String imgPath, String destPath, String picName)
            throws Exception {
        BufferedImage image = QRCodeUtil.createImageForBarCode(content, imgPath);
        mkdirs(destPath);

        ImageIO.write(image, FORMAT_NAME, new File(destPath + File.separator + picName));
    }

    private static void mkdirs(String destPath) {
        File file = new File(destPath);
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 二维码创建
     *
     * @param content  内容
     * @param imgPath  logo路径
     * @param destPath 输出路径
     * @throws Exception
     */
    public static void encodeForQrCode(String content, String imgPath, String destPath) throws Exception {
        String file = new Random().nextInt(99999999) + ".jpg";
        QRCodeUtil.encodeForQrCode(content, imgPath, destPath, false, file);
    }

    /**
     * 二维码创建
     *
     * @param content  内容
     * @param destPath 图片输出路径
     * @throws Exception
     */
    public static void encodeForQrCode(String content, String destPath) throws Exception {
        String file = new Random().nextInt(99999999) + ".jpg";
        QRCodeUtil.encodeForQrCode(content, null, destPath, false, file);
    }

    public static void encodeForQrCode(String content, String imgPath, OutputStream output, boolean needCompress)
            throws Exception {
        BufferedImage image = QRCodeUtil.createImageForQrCode(content, imgPath, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    public static void encodeForQrCode(String content, OutputStream output) throws Exception {
        QRCodeUtil.encodeForQrCode(content, null, output, false);
    }

    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    public static String decode(String path) throws Exception {
        return QRCodeUtil.decode(new File(path));
    }

}
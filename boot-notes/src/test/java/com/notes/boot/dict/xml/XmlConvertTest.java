package com.notes.boot.dict.xml;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

/**
 * @author code
 * @Title: XmlConvertTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/51:32 PM
 */
public class XmlConvertTest {

    @Test
    public void xmlconvert() {

        String xml = getXml();
        XmlBean bean = xmlToObject(XmlBean.class, xml);
        System.out.println(JSON.toJSONString(bean));

        xml = marshall(bean);
        System.out.println(xml);
    }

    private String getXml() {
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "<appid><![CDATA[wx0a6dc862d037ca98]]></appid>\n" +
                "<mch_id><![CDATA[1395246202]]></mch_id>\n" +
                "<nonce_str><![CDATA[oE21SB0AO67L2I5Y]]></nonce_str>\n" +
                "<sign><![CDATA[25D5054F429EED89EF3E4DF2A3E2FAAA]]></sign>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<out_trade_no><![CDATA[channel_1559097017006]]></out_trade_no>\n" +
                "<attach><![CDATA[]]></attach>\n" +
                "<trade_state><![CDATA[CLOSED]]></trade_state>\n" +
                "<trade_state_desc><![CDATA[订单已关闭]]></trade_state_desc>\n" +
                "</xml>";
    }

    /**
     * jdk转换xml字符串为bean对象操作
     *
     * @param clazz
     * @param content
     * @param <T>
     * @return
     */
    public static <T> T xmlToObject(Class<T> clazz, String content) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
            return (T) unmarshaller.unmarshal(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转换为xml字符串
     *
     * @param bean
     * @return
     */
    public static String marshall(Object bean) {
        try {
            JAXBContext context = JAXBContext.newInstance(bean.getClass());
            Marshaller marshaller = context.createMarshaller();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            marshaller.marshal(bean, out);
            return new String(out.toByteArray(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object xmlToObjectSafe(Class<?> klass, String xml) throws Exception {
        // 将外部实体、参数实体和内联DTD 都设置为false，从而避免XXE漏洞
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
        spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        // Do unmarshall operation
        Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));

        JAXBContext context = JAXBContext.newInstance(klass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(xmlSource);
    }
}

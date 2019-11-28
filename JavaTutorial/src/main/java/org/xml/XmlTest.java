package org.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * 用的是jdk自带的javax.xml.bind.JAXBContext将对象和xml字符串进行相互转换。
 *        如果对要生成的 xml 格式有点些许的限制，就会对生成xml的对象就需要进行些许控制，控制对象的一个最可行的办法就是用注解。
 *        （jdk 1.6 api：http://www.cs.uic.edu/~mcpc/Java_Docs/api/index.html?javax/xml/bind/JAXBContext.html）
 *  
 *        比较常用的几个：
 *        @XmlRootElement：根节点
 *        @XmlAttribute：该属性作为xml的attribute
 *        @XmlElement：该属性作为xml的element，且可以增加属性(name="NewElementName")，那么生成的xml串的elment的标签是NewElementName
 *
 * @author code
 * @Title: XmlTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/10/2810:08 AM
 */
public class XmlTest {

    public static void main(String[] args) {
        RootClass rc = new RootClass();
        EleClassA a = new EleClassA();
        EleClassB b = new EleClassB();

        a.setAttrC("attrc");
        a.setEleA("eleA");
        a.setEleB("eleB");

        b.setAttrPassword("attrPassword");
        b.setAttrUserName("attrUsrName");
        b.setEleCode("eleCode");

        rc.setA(a);
        rc.setB(b);
        rc.setRoot("root");
        rc.setRootA("rootA");


        JAXBContext context;
        try {
            context = JAXBContext.newInstance(RootClass.class);
            Marshaller mar = context.createMarshaller();
            //xml格式化
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            //去掉默认的xml报文头
            mar.setProperty(Marshaller.JAXB_FRAGMENT, true);


            StringWriter writer = new StringWriter();

            writer.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");


            mar.marshal(rc, writer);

            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}

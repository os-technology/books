package org.xml;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author code
 * @Title: RootClass
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/10/2810:05 AM
 */

@XmlRootElement(name="rootclass")
public class RootClass {

    private EleClassA a;
    private EleClassB b;
    private String root;
    private String rootA;

    @XmlElement(name="eleClassA")
    public EleClassA getA() {
        return a;
    }
    public void setA(EleClassA a) {
        this.a = a;
    }
    @XmlElement(name="EleclassA")
    public EleClassB getB() {
        return b;
    }
    public void setB(EleClassB b) {
        this.b = b;
    }
    public String getRoot() {
        return root;
    }
    public void setRoot(String root) {
        this.root = root;
    }
    public String getRootA() {
        return rootA;
    }
    public void setRootA(String rootA) {
        this.rootA = rootA;
    }

}

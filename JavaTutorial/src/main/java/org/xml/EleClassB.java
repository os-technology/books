package org.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author code
 * @Title: EleClassB
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/10/2810:07 AM
 */
public class EleClassB {

    private String attrUserName;
    private String attrPassword;

    private String eleCode;

    @XmlAttribute
    public String getAttrUserName() {
        return attrUserName;
    }

    public void setAttrUserName(String attrUserName) {
        this.attrUserName = attrUserName;
    }

    @XmlAttribute(name = "password")
    public String getAttrPassword() {
        return attrPassword;
    }

    public void setAttrPassword(String attrPassword) {
        this.attrPassword = attrPassword;
    }

    @XmlElement
    public String getEleCode() {
        return eleCode;
    }

    public void setEleCode(String eleCode) {
        this.eleCode = eleCode;
    }
}
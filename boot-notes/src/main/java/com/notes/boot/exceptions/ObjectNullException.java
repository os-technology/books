package com.notes.boot.exceptions;

/**
 * @author code
 * @Title: ObjectNullException
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/6下午8:56
 */
public class ObjectNullException extends BasicException {

    public ObjectNullException() {
        super();
    }

    public ObjectNullException(String msg) {
        super(msg);
    }

    public ObjectNullException(String msg, Throwable th) {
        super(msg, th);
    }
}

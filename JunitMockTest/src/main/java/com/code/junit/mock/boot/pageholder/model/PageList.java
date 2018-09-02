package com.code.junit.mock.boot.pageholder.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * PageList类是继承于ArrayList的，这样Dao中就不用为了专门分页再多写一个方法
 *
 * @author code
 * @Title: PageList
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2上午10:11
 */
public class PageList<E> extends ArrayList<E> {

    private static final long serialVersionUID = -732001183616436546L;

    private Paginator paginator;

    public PageList() {
    }

    public PageList(Collection<? extends E> c) {
        super(c);
    }

    public PageList(Collection<? extends E> c, Paginator p) {
        super(c);
        this.paginator = p;
    }

    public PageList(Paginator p) {
        this.paginator = p;
    }

    /**
     * 得到分页器，通过Paginator可以得到总页数等值
     *
     * @return
     */
    public Paginator getPaginator() {
        return paginator;
    }

}

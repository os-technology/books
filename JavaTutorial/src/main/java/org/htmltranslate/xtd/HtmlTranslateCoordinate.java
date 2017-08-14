package org.htmltranslate.xtd;

/**
 * 数据解析坐标参数配置
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HtmlTranslateCoordinate
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30上午10:44
 */

public class HtmlTranslateCoordinate {
    /**
     * 数据获取开始位置坐标
     */
    private int htmlStart;
    /**
     * 数据获取结束位置坐标
     */
    private int htmlEnd;

    /**
     * 解析开始位置坐标-动态变化
     */
    private int start;
    /**
     * 解析结束位置坐标-动态变化
     */
    private int end = 0;

    public int getHtmlStart() {
        return htmlStart;
    }

    public HtmlTranslateCoordinate setHtmlStart(int htmlStart) {
        this.htmlStart = htmlStart;
        return this;
    }

    public int getHtmlEnd() {
        return htmlEnd;
    }

    public HtmlTranslateCoordinate setHtmlEnd(int htmlEnd) {
        this.htmlEnd = htmlEnd;
        return this;
    }

    public int getStart() {
        return start;
    }

    public HtmlTranslateCoordinate setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public HtmlTranslateCoordinate setEnd(int end) {
        this.end = end;
        return this;
    }
}

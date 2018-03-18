package org.htmltranslate.htmlplan;

import com.alibaba.fastjson.JSON;
import org.htmltranslate.util.HtmlUtil;
import org.junit.Test;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TranslateHtmlPlanTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/14上午7:54
 */

public class TranslateHtmlPlanTest {

    @Test
    public void testGetHtmlPlan() {
        String webUrl = "http://www.7879123.com/json/cqssc_json_A.js";
        String js = HtmlUtil.getHtmlByUrl(webUrl);

        TranslatePlan newPlan = JSON.parseObject(js, TranslatePlan.class);

        String waitData = newPlan.getNewGame().getWaitGame();

        String[] dataArray = waitData.split(" ");

        String output = HtmlUtil.getSubResultFromString(dataArray[1], "【", "】");

        System.out.println("计划期数："+dataArray[0]+"\n计划内容：" + output);
    }

}

class TranslatePlan {
    private GameData NewGame;

    public GameData getNewGame() {
        return NewGame;
    }

    public TranslatePlan setNewGame(GameData newGame) {
        NewGame = newGame;
        return this;
    }
}
class GameData{
    private String waitGame;

    public String getWaitGame() {
        return waitGame;
    }

    public GameData setWaitGame(String waitGame) {
        this.waitGame = waitGame;
        return this;
    }
}
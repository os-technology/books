package org.htmltranslate.xtd;

import org.htmltranslate.xtd.params.PrintDataBean;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ThreeStarZhiXuanRuleTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/28下午2:14
 */

public class ThreeStarZhiXuanRuleTest {

    private String getThreeDaDiString(){
        return "005　007　015　016　017　018　025　027　035　037" +
             "　038　045　047　050　051　052　053　054　055　056" +
             "　057　058　061　065　067　070　071　072　073　074" +
                "　075　076　077　078　081　083　085　087　105　106" +
                "　107　108　116　118　126　128　129　136　138　145" +
                "　146　148　149　150　154　156　158　160　161　162" +
                "　163　164　165　166　167　168　169　170　176　178" +
                "　180　181　182　183　184　185　186　187　188　189" +
                "　192　194　196　198　205　207　216　218　219　229" +
                "　236　238　239　245　247　249　250　254　256　259" +
                "　261　263　265　267　269　270　274　276　278　279" +
                "　281　283　287　289　291　292　293　294　295　296" +
                "　297　298　299　305　307　308　316　318　326　328" +
                "　329　338　346　347　348　349　350　356　358　361" +
                "　362　364　365　367　368　370　374　376　378　380" +
                "　381　382　383　384　385　386　387　388　389　392" +
                "　394　398　405　407　415　416　418　419　425　427" +
                "　429　436　437　438　439　450　451　452　457　458" +
                "　459　461　463　467　470　472　473　475　476　478" +
                "　479　481　483　485　487　491　492　493　495　497" +
                "　500　501　502　503　504　505　506　507　508　510" +
                "　514　516　518　520　524　526　529　530　536　538" +
                "　540　541　542　547　548　549　550　560　561　562" +
                "　563　570　574　580　581　583　584　592　594　601" +
                "　605　607　610　611　612　613　614　615　616　617" +
                "　618　619　621　623　625　627　629　631　632　634" +
                "　635　637　638　641　643　647　650　651　652　653" +
                "　661　670　671　672　673　674　681　683　691　692" +
                "　700　701　702　703　704　705　706　707　708　710" +
                "　716　718　720　724　726　728　729　730　734　736" +
                "　738　740　742　743　745　746　748　749　750　754" +
                "　760　761　762　763　764　770　780　781　782　783" +
                "　784　792　794　801　803　805　807　810　811　812" +
                "　813　814　815　816　817　818　819　821　823　827" +
                "　829　830　831　832　833　834　835　836　837　838" +
                "　839　841　843　845　847　850　851　853　854　861" +
                "　863　870　871　872　873　874　881　883　891　892" +
                "　893　912　914　916　918　921　922　923　924　925" +
                "　926　927　928　929　932　934　938　941　942　943" +
                "　945　947　952　954　961　962　972　974　981　982" +
                "　983　992";
    }




    @Test
    public void test_HouerZhiXuanFenFenCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        compareStrategy(mats, "111", 3,new BigDecimal(0.01));
    }

    @Test
    public void test_HouerZhiXuanShiShiCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        compareStrategy(mats, "101", 3,new BigDecimal(0.001));
    }

    /**
     * 台湾五分彩
     */
    @Test
    public void test_TaiWanWuFenCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getTaiWanWufenMatArray();
        compareStrategy(mats, "182", 5,new BigDecimal(0.01));
    }

    /**
     * 北京五分彩
     */
    @Test
    public void test_BeiJingWuFenCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getBeijingWufenMatArray();
        compareStrategy(mats, "181", 3,new BigDecimal(0.01));
    }





    private void compareStrategy(String[] mats, String caipiaoCode, int location,BigDecimal moneyModel) {
        if (location == 3) {
            compare_HouerZhiXuan_NumResult(mats, caipiaoCode, moneyModel, location, "40");
        } else if (location == 4) {
            compare_HouerZhiXuan_NumResult(mats, caipiaoCode, moneyModel, location, "30");
        }else if (location == 5) {
            compare_HouerZhiXuan_NumResult(mats, caipiaoCode, moneyModel, location, "20");
        }
    }

    /**
     * 后二单式直选大底数据比对结果
     *
     * @param mats
     * @param caiPiaoCode  彩票编码
     * @param moneyPattern 金额模式，1，0.1，0.01，0.001
     * @param location     位置，5 4 3 2 1
     */
    private void compare_HouerZhiXuan_NumResult(String[] mats, String caiPiaoCode, BigDecimal moneyPattern, int location, String playTypeCode) {

        StringBuilder dataBuilder = new StringBuilder();
        StringBuilder printResult = new StringBuilder();


        int multiple[] = NumberTools.getMultipleType(10);//倍投倍数值
        String[] numArray = XTDHtmlStringTranslateUtil.getSelectedArray(getThreeDaDiString());
        BigDecimal initMoney = new BigDecimal(2).multiply(moneyPattern).multiply(new BigDecimal(numArray.length));
        ;//初始投入金额
        BigDecimal winMoney = new BigDecimal(19.4).multiply(moneyPattern).multiply(new BigDecimal(100));//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//最终净利润金额
        BigDecimal tmpAllWinMoney = new BigDecimal(0);//临时盈利总金额
        BigDecimal tmpAllLoseMoney = new BigDecimal(0);//临时输掉总金额


        int time = 0;//倍投下标
        double maxMoney = 0;//最大投入金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数
        for (int m = 0; m < mats.length - 1; m++) {
            if (multiple.length <= time) {
                System.out.println("超出最大倍投，不适合投注");
                break;
            }
            BigDecimal tmpWinMoney = null;
            BigDecimal tmpLoseMoney = null;
            String tmpData = "";
            String nums = NumberTools.getSubNum(mats[m], location, 3);
            if (getThreeDaDiString().contains(nums)) {//赢


                if (time > 0) {
                    double inputMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                    maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;


                    tmpWinMoney = winMoney.multiply(new BigDecimal(multiple[time]));
                    tmpLoseMoney = initMoney.multiply(new BigDecimal(multiple[time]));

                    //本次净收益金额
                    BigDecimal tmpIncomeMoney = (winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time]));


                    tmpData = mats[m] + "  赢 1  " + inputMoney + "  "
                            + NumberTools.getMoneyString(tmpIncomeMoney);

//                    //盈利计算
//                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                } else {
                    tmpWinMoney = winMoney;
                    tmpLoseMoney = initMoney;

                    tmpData = mats[m] + "  赢 1  " + NumberTools.getMoneyString(initMoney) + "  " + NumberTools.getMoneyString(winMoney.subtract(initMoney));
                }
                //临时赢取总金额
                tmpAllWinMoney = tmpAllWinMoney.add(tmpWinMoney);

                //后续标识操作

                tmpLoseTime = 0;

                time = 0;
                tmpWinTime++;
                allWinTime++;
                //统计最大连赢次数
                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
            } else {//输
                double thisLoseMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                tmpData = mats[m] + "  输 0  " + thisLoseMoney;


                tmpLoseMoney = new BigDecimal(thisLoseMoney);

                //数值处理

                tmpWinTime = 0;
                time++;
                tmpLoseTime++;
                allLoseTime++;
                //统计最大连挂次数
                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
            }
            tmpAllLoseMoney= tmpAllLoseMoney.add(tmpLoseMoney);
            dataBuilder.append(tmpData).append("\n");
        }

        incomeMoney = tmpAllWinMoney.subtract(tmpAllLoseMoney);

        PrintDataBean bean = new PrintDataBean();
        bean.setCaiPiaoCode(caiPiaoCode)
                .setInitMoney(initMoney)
                .setWinMoney(winMoney)
                .setAllLoseTime(allLoseTime)
                .setAllWinTime(allWinTime)
                .setIncomeMoney(incomeMoney)
                .setMaxLoseTime(maxLoseTime)
                .setMaxWinTime(maxWinTime)
                .setMaxMoney(new BigDecimal(maxMoney))
                .setMultipleModel(multiple)
                .setStageNum(mats.length);

        printResult.append("投注模式：" + NumberTools.getPlaySelectType(playTypeCode) + "：" + getThreeDaDiString()).append("\n").append("\n");
        printResult.append("注数：" + XTDHtmlStringTranslateUtil.getSelectedArray(getThreeDaDiString()).length).append("\n").append("\n");

        NumberTools.print(printResult, bean);
        System.out.println(dataBuilder);
        System.out.println(printResult);
    }
}

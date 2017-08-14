package org.htmltranslate.xtd;

import org.apache.commons.lang.time.DateFormatUtils;
import org.htmltranslate.xtd.params.PrintDataBean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩票公共工具类
 *
 * @author yuijnshui@lxfintech.com
 * @Title: NumberTools
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午10:25
 */

public class NumberTools {


//    String str ="2342asfghgyu56asdasda";
//    Map<String,Integer> maps = new HashMap<String,Integer>();
//       for(int i=0;i<str.length();i++){
//        String key = String.valueOf((str.charAt(i)));
//        if(!maps.containsKey(key))
//            maps.put(key, 1);
//        else{
//            int val =maps.get(key);
//            maps.put(key, val+1);
//        }
//
//    }
//
//       for(Map.Entry i : maps.entrySet()){
//        System.out.println(i.getKey()+ "=="+i.getValue());
//    }


    public static int[] getFiveStarSixtyModel() {
        int[] store = {1, 2, 4, 8, 17, 36, 76, 160};
        return store;

    }

    /**
     * 倍数求和
     *
     * @param in    投注次数(0为第一次)
     * @param model 倍投模式
     * @return
     */
    public static BigDecimal multiplePlus(int in, int[] model) {
        int output = 0;
        for (int i = in; i >= 0; i--) {
            output += model[i];
        }
        return new BigDecimal(output);
    }


    /**
     * 玩法类型
     *
     * @param playTypeCode
     * @return
     */
    public static String getPlaySelectType(String playTypeCode) {
        Map<String, String> map = new HashMap<>();
        map.put("00", "前二单式");
        map.put("01", "前二复式");

        map.put("10", "后二单式");
        map.put("11", "后二复式");

        map.put("20", "前三单式");
        map.put("21", "前三复式");

        map.put("30", "中三单式");
        map.put("31", "中三复式");

        map.put("40", "后三单式");
        map.put("41", "后三复式");

        map.put("100", "五星组选60，只有一个数字重复");
//        map.put("41", "后三复式");
//        map.put("07","");
//        map.put("07","");


        return map.get(playTypeCode);
    }

    /**
     * 根据玩法类型编号获取对应位置名称
     *
     * @param typeCode
     * @return
     */
    public static String getPlayCase(int typeCode) {

        String locationList = "";
        if (typeCode >= 0 && typeCode < 10) {
            locationList = "54";
        } else if (typeCode > 9 && typeCode < 20) {
            locationList = "21";
        }
        char[] numList = locationList.toCharArray();
        String out = "";
        for (char ch : numList) {
            out += getNumLocation(Integer.parseInt(ch + ""));
        }

        return out;

    }

    /**
     * (?s) 开启单行模式 DOTALL 让. 号匹配任意字符
     * <p>
     * (.) 任意字符 并捕获在第一组
     * <p>
     * (?=.*\1) 这是断言, 表示后面内容将是 任意个字符加上第一组所捕获的内容
     * <p>
     * 这样,如果这整个式子匹配到,表示,第一个捕获组内容在字符串中,至少出现两次，替换为 "" 空串.
     * <p>
     * 进行 全局替换后， 整个字符串所出现的字符将不重复。
     *
     * @param inputNum
     * @return
     */
    public static String checkNumCount(String inputNum) {

        inputNum = inputNum.replaceAll("(?s)(.)(?=.*\\1)", "");

        return inputNum;
    }

    /**
     * 返回长度5
     *
     * @param inputNum
     * @return
     */
    public static boolean getLengthFive(String inputNum) {
        return checkNumCount(inputNum).length() == 5;
    }

    /**
     * 返回长度4
     *
     * @param inputNum
     * @return
     */
    public static boolean getLengthFour(String inputNum) {
        return checkNumCount(inputNum).length() == 4;
    }

    /**
     * 返回长度3
     *
     * @param inputNum
     * @return
     */
    public static boolean getLengthThree(String inputNum) {
        return checkNumCount(inputNum).length() == 3;
    }

    /**
     * 返回长度2
     *
     * @param inputNum
     * @return
     */
    public static boolean getLengthTwo(String inputNum) {
        return checkNumCount(inputNum).length() == 2;
    }

    /**
     * 返回长度1
     *
     * @param inputNum
     * @return
     */
    public static boolean getLengthOne(String inputNum) {
        return checkNumCount(inputNum).length() == 1;
    }

    /**
     * 获取彩票名称
     *
     * @param typeName
     * @return
     */
    public static String caiPiaoName(String typeName) {
        Map<String, String> typeList = new HashMap<>();
        typeList.put("111", "天地分分彩");
        typeList.put("113", "天地三分彩");
        typeList.put("115", "天地五分彩");
        typeList.put("110", "天地半分彩");
        typeList.put("119", "天地1.5分彩");
        typeList.put("100", "天地秒秒彩");
        typeList.put("101", "重庆时时彩");
        typeList.put("103", "天津时时彩");
        typeList.put("104", "新疆时时彩");
        typeList.put("181", "北京5分彩");
        typeList.put("182", "台湾5分彩");
        typeList.put("331", "江苏快3");
        typeList.put("332", "安徽快3");
        typeList.put("333", "吉林快3");
        typeList.put("1001", "北京赛车PK拾");
        typeList.put("555", "天地十一选五");
        typeList.put("501", "广东十一选五");
        typeList.put("502", "山东十一选五");
        typeList.put("504", "江西十一选五");
        typeList.put("505", "上海十一选五");
        typeList.put("506", "安徽十一选五");
        typeList.put("803", "重庆快乐十分彩");
        typeList.put("801", "广东快乐十分彩");
        typeList.put("802", "天津快乐十分彩");
        typeList.put("303", "上海时时乐");
        typeList.put("301", "福彩3D");
        typeList.put("302", "排列3");
        typeList.put("362", "台湾5分3D");

        return typeList.get(typeName);
    }


    /**
     * 倍投金额计算
     *
     * @param init     首次投入金额
     * @param multiple 倍数
     * @return
     */
    public static double getCalResult(BigDecimal init, int multiple) {
        BigDecimal result = init.multiply(new BigDecimal(multiple));
        return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param printResult
     * @param bean        数据输出bean
     */
    public static void print(StringBuilder printResult, PrintDataBean bean) {
        if (printResult == null || bean == null) {
            System.out.println("请求参数为null，请检查");
            return;
        }
        printResult.append("彩票类型：" + NumberTools.caiPiaoName(bean.getCaiPiaoCode())).append("\n");

        printResult.append("本次统计期数：" + bean.getStageNum() + "期").append("\n");
        if (bean.getMaxMoney() != null && bean.getMaxMoney().intValue() != 0) {
            printResult.append("最大倍投金额(仅针对两个号码不同的情况得出的结果)：" + getMoneyString(bean.getMaxMoney())).append("\n");
            printResult.append("最大投入总额：" +
                    getMoneyString(
                            bean.getMaxMoney()
                                    .add(
                                            bean.getInitMoney()
                                                    .multiply(NumberTools.multiplePlus(bean.getMaxLoseTime()-1, bean.getMultipleModel()))
                            )
                    )
            ).append("\n");
            ;
        }
        if (bean.getMaxWinTime() != null && bean.getMaxWinTime() != 0) {
            printResult.append("最大连赢次数：" + bean.getMaxWinTime()).append("\n");
        }
        printResult.append("最大连挂次数：" + bean.getMaxLoseTime()).append("\n");
        printResult.append("总赢次数：" + bean.getAllWinTime()).append("\n");
        printResult.append("总输次数：" + bean.getAllLoseTime()).append("\n");
        printResult.append("初始投入金额：" + getMoneyString(bean.getInitMoney())).append("\n");
        printResult.append("初始盈利金额：" + getMoneyString(bean.getWinMoney())).append("\n");
        if (bean.getIncomeMoney() != null && bean.getIncomeMoney().intValue() != 0) {
            printResult.append("总收益：" + getMoneyString(bean.getIncomeMoney())).append("\n");
        }
        printResult.append("统计时间：" + getTodayDateTime());
    }

    public static String getTodayDateTime() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 两个数字以上的比对操作
     * 不相同，true，相同，false
     *
     * @param init    比对数字
     * @param compare 待比对数字
     * @return
     */
    public static boolean compareArrayNumberIsTrue(String init, String compare) {
        char[] charValue = init.toCharArray();
        boolean bool = false;
        for (char ch : charValue) {
            if (compare.contains(ch + "")) {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        return bool;
    }

    public static String selectSort(String inputNum) {
        String[] numList = getStringArray(inputNum);
        //选择排序的优化
        for (int i = 0; i < numList.length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < numList.length; j++) {// 选最小的记录
                if (Integer.valueOf(numList[j]) < Integer.valueOf(numList[k])) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                String temp = numList[i];
                numList[i] = numList[k];
                numList[k] = temp;
            }
        }

        String out = "";
        for (String num : numList) {
            out += " " + num;
        }

        return out;
    }

    public static String[] getStringArray(String inputNum) {
        return inputNum.split(",| ");
    }


    /**
     * 倍投组合类型
     *
     * @param t
     * @return
     */
    public static int[] getMultipleType(int t) {
        return getMultipleType(t, true);
    }

    /**
     * 倍投组合类型
     * 单倍计算的输赢算法还有问题，需要处理
     *
     * @param t
     * @param multiple
     * @return
     */
    public static int[] getMultipleType(int t, boolean multiple) {
        if (multiple) {
            return getMultiple(t);
        } else {
            return getSingle(t);
        }
    }

    /**
     * 单倍投注结果
     */
    public static int[] getSingle(int t) {
        int[] multi = new int[t];
        for (int i = 0; i < t; i++) {
            multi[i] = 1;
        }
        return multi;
    }

    /**
     * {1,2,6,18,54,162,486}
     *
     * @param t 倍投次数
     * @return
     */
    public static int[] getMultiple(int t) {
        int[] multi = new int[t];
        for (int i = 0; i < t; i++) {
            if (i == 0) {
                multi[i] = 1;
            } else if (i == 1) {
                multi[i] = 2;
            } else {
                multi[i] = multi[i - 1] * 3;
            }
        }
        return multi;
    }

    /**
     * 金额转换为double类型
     *
     * @param inputMoney
     * @return
     */
    public static double getMoneyString(BigDecimal inputMoney) {
        if (inputMoney == null) {
            System.out.println("请求参数为空，返回0");
            return 0;
        }
        return inputMoney.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 选位
     *
     * @param in 1 2 3 4 5 个 十 百 千 万
     * @return
     */
    public static String getNumLocation(int in) {
        String[] numArray = {"个位", "十位", "百位", "千位", "万位"};
        return numArray[in - 1];
    }

    /**
     * @param mats        出号内容
     * @param collectType 收集类型，后二等，或者个位十位等
     * @param count       (位数)从起始位置开始，收集个数如后二,两位
     * @return
     */
    public static String collectNumList(String[] mats, String collectType, int location, int count) {
        String numlist = "";

        System.out.println("收集类型：从 " + NumberTools.getNumLocation(Integer.valueOf(location)) + " 开始，收集 " + count + "个位置的号码");
        for (String mat : mats) {
            String nums = NumberTools.getSubNum(mat, location, count);
            if (numlist.contains(nums)) {
                continue;
            }
            if ("".equals(numlist)) {
                numlist = nums;
            } else {
                numlist += " " + nums;
            }
        }

        return numlist;
    }

    /**
     * 截取结果值个数
     *
     * @param inputValue 输入值
     * @param startNum   截取开始位置(万，千，百，十，个 5 4 3 2 1)
     * @param count      截取个数(1 2 3 4 5)
     * @return
     */
    public static String getSubNum(String inputValue, int startNum, int count) {

        String value = inputValue.substring(inputValue.length() - startNum, inputValue.length() - (startNum - count));
        return value;
    }
}

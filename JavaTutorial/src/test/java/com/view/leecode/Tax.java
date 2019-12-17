package com.view.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 亚博科技
 *
 * @author code
 * @Title: Tax
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/16 7:42 PM
 */
public class Tax {


    @Test
    public void testCase() {


        Assert.assertEquals(0, taxValue(new BigDecimal(9999)).intValue());
        Assert.assertEquals(0, taxValue(new BigDecimal(10000)).intValue());
        Assert.assertEquals(1, taxValue(new BigDecimal(10010)).intValue());
        Assert.assertEquals(200, taxValue(new BigDecimal(12000)).intValue());
        Assert.assertEquals(8697, taxValue(new BigDecimal(56789)).intValue());
        Assert.assertEquals(473326, taxValue(new BigDecimal(1234567)).intValue());

    }

    /**
     * tax文件 读取税表计算税额
     */
    @Test
    public void taxCaseFile() {

        System.setProperty("fileName","/tax.txt");
        Assert.assertEquals(0, fileTax(new BigDecimal(9999)).intValue());
        Assert.assertEquals(0, fileTax(new BigDecimal(10000)).intValue());
        Assert.assertEquals(1, fileTax(new BigDecimal(10010)).intValue());
        Assert.assertEquals(200, fileTax(new BigDecimal(12000)).intValue());
        Assert.assertEquals(8697, fileTax(new BigDecimal(56789)).intValue());
        Assert.assertEquals(473326, fileTax(new BigDecimal(1234567)).intValue());

    }
    /**
     * tax1文件 读取税表计算税额
     */
    @Test
    public void taxCaseFile1() {
        System.setProperty("fileName","/tax1.txt");
        Assert.assertEquals(0, fileTax(new BigDecimal(9999)).intValue());
        Assert.assertEquals(0, fileTax(new BigDecimal(10000)).intValue());
        Assert.assertEquals(1, fileTax(new BigDecimal(10010)).intValue());
        Assert.assertEquals(200, fileTax(new BigDecimal(12000)).intValue());
        Assert.assertEquals(7697, fileTax(new BigDecimal(56789)).intValue());
        Assert.assertEquals(472326, fileTax(new BigDecimal(1234567)).intValue());

    }

    /**
     * income cap 收入上限      marginal tax rate 边际税率  缴税金额
     * ¤10,000           0.00 (0%)       0
     * ¤30,000           0.10 (10%)     2000
     * ¤100,000          0.25 (25%)     17500
     * --              0.40 (40%)      -
     *
     * @param money
     * @return
     */

    public BigDecimal taxValue(BigDecimal money) {
        if (money.compareTo(new BigDecimal(100000)) > 0) {
            return invokeTax(money, new BigDecimal(100000), new BigDecimal(30000), new BigDecimal(0.4));
        } else if (money.compareTo(new BigDecimal(30000)) > 0) {
            return invokeTax(money, new BigDecimal(30000), new BigDecimal(10000), new BigDecimal(0.25));
        } else if (money.compareTo(new BigDecimal(10000)) > 0) {
            return invokeTax(money, new BigDecimal(10000), new BigDecimal(0), new BigDecimal(0.1));
        } else return new BigDecimal(0);
    }

    public BigDecimal invokeTax(BigDecimal money, BigDecimal startRange, BigDecimal endRange, BigDecimal rate) {

        if (money.compareTo(new BigDecimal(100000)) > 0) {
            //(1234567-10w)*0.4+(10w-3w)*0.25+(3w-1w)*0.1=473326
            return money.subtract(startRange).multiply(rate)
                    .add(invokeTax(startRange, endRange, new BigDecimal(10000), new BigDecimal(0.25)))
                    .setScale(0, BigDecimal.ROUND_DOWN);
        } else if (money.compareTo(new BigDecimal(30000)) > 0) {
            return money.subtract(startRange).multiply(rate)
                    .add(invokeTax(startRange, endRange, new BigDecimal(0), new BigDecimal(0.1)))
                    .setScale(0, BigDecimal.ROUND_DOWN);
        } else if (money.compareTo(new BigDecimal(10000)) > 0) {
            return money.subtract(startRange).multiply(rate)
                    .setScale(0, BigDecimal.ROUND_DOWN);
        } else
            return new BigDecimal(0);


    }

    /**
     * 税额计算
     *
     * @param money
     * @param startRange
     * @param rate
     * @return
     */
    public BigDecimal taxAmt(BigDecimal money, BigDecimal startRange, BigDecimal rate) {
        return money.subtract(startRange).multiply(rate);
    }


    public BigDecimal fileTax(BigDecimal money) {
        String fileName = System.getProperty("fileName");
        List<String[]> list = txt2String(fileName);
//        List<String[]> list = txt2String("/tax1.txt");
        int level = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            String[] taxGrade = list.get(i);
            if (money.compareTo(new BigDecimal(taxGrade[0])) > 0) {
//                拿到缴税等级
                if (i == list.size() - 1) {
                    level = i;
                } else
                    level = i + 1;
                break;
            } else {
                continue;
            }
        }
        BigDecimal taxMoney = new BigDecimal(0);
        for (int i = 0; i <= level; i++) {
            switch (level) {
                case 0:
                    taxMoney = taxMoney.add(taxAmt(money, new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i)[1])));
                    break;
                case 1:
                    if (i == 0) {
                        taxMoney = taxMoney.add(taxAmt(new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i)[1])));
                    } else {
                        taxMoney = taxMoney.add(taxAmt(money, new BigDecimal(list.get(i - 1)[0]), new BigDecimal(list.get(i)[1])));
                    }
                    break;
                default:
                    if (i == 0) {
                        taxMoney = taxMoney.add(taxAmt(new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i)[1])));
                    } else if (i > 0 && i < level) {
                        taxMoney = taxMoney.add(taxAmt(new BigDecimal(list.get(i)[0]), new BigDecimal(list.get(i - 1)[0]), new BigDecimal(list.get(i)[1])));
                    } else {
                        BigDecimal tmp = taxAmt(money, new BigDecimal(list.get(i - 1)[0]), new BigDecimal(list.get(i)[1]));
                        taxMoney = taxMoney.add(tmp);
                    }

            }

        }
        return taxMoney.setScale(0, BigDecimal.ROUND_DOWN);
    }

    public List txt2String(String fileName) {
        List<String[]> list = new ArrayList<>();
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));//构造一个BufferedReader类来读取文件
            String s;
            while ((s = br.readLine()) != null) {

                list.add(s.split("-"));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

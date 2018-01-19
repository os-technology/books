package org.sql;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: GenerateSql
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/9/27下午5:04
 */

public class GenerateSql {


    @Test
    public void getDate(){
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(System.nanoTime());
    }

    /**
     *
     * @param compareDate 待比对时间
     * @param referenceDate 参考时间
     * @return
     */
    private int compareDate(Date compareDate,Date referenceDate){
        long dayTime = 1000*24*60*60;
        return (int)((compareDate.getTime()-referenceDate.getTime())/dayTime);
    }

    @Test
    public void testBool(){
        String startTime="1546185600000";
        String endTime="1546185600000";
        Date start=longStringToDate(startTime);
        Date end=longStringToDate(endTime);
        Date minDate=getDayBeforeMonth(3);
        Date maxDate=getDayBeforeDay(1);
        System.out.println("输出结果："+checkTimeByEnvType(startTime,endTime,start,end,minDate,maxDate));
    }

    public static Date longStringToDate(String time) {
        Date date = new Date();
        date.setTime(Long.parseLong(time));
        return date;
    }
    private boolean checkTimeByEnvType( String startTime,String endTime, Date start, Date end, Date minDate, Date maxDate) {
//        if (StringUtils.isNotBlank(noTimeLimit)){
//            return !startTime.equals(endTime);
//        }
        return !startTime.equals(endTime) //只能选择一天
                || compareDate(end,maxDate)>0 //最多只能选择到昨天
                || compareDate(start,minDate)<0;
    }
    public static Date getDayBeforeMonth(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, -i);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date getDayBeforeDay(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.DAY_OF_YEAR, -i);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }


    @Test
    public void create(){
        String merchantId = "13746";
        String startDate = "1201";
        String endDate = "1231";
        String bossId="888057160120009";

        System.out.println(getYear());
        System.out.println("\n微信公众号C2B支付、微信公众号的支付和退款\n");
        getWechat_C2B_Sql(merchantId,startDate,endDate);

        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付交易\n");
        pc_lakala_sql(merchantId,startDate,endDate);

        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付退款数据\n");
        pc_lakala_refund_sql(merchantId,startDate,endDate);

        System.out.println("\n实时代收对账单\n");
        charge_real_time_sql(merchantId,startDate,endDate,bossId);

        System.out.println("\n实时代收回盘文件\n");
        charge_real_time_return_sql(merchantId,startDate,endDate,bossId);

        System.out.println("\n修改Paymax系统中的支付联系人、邮箱、注册手机、登陆手机号信息\n");
        String merchantRealName = "安琦";
        String email = "zhangsan@126.com";
        String mobileNo = "13261502634";

        update_merchant_data(merchantId,merchantRealName,email,mobileNo);

        System.out.println("\n注销Paymax系统中的商户信息\n");
        logout_merchant(merchantId);

    }

    /**
     * 注销商户信息
     * @param merchantId
     */
    private void logout_merchant(String merchantId) {
        System.out.println("注销策略：将商户手机号首位改为2。\n" +
                "需要检查merchant.t_app和merchant.t_merchant_company是否有数据信息。如果有，需要商户重新更换手机号进行注册，我们不做任何处理。");
        String sql = "update merchant.t_member set phone = '23758116469' where merchant_id = "+merchantId+";";
        String sql2 = "update merchant.t_merchant_contacts set phone = '23758116469' where merchant_id = "+merchantId+";";
        System.out.println(sql+"\n"+sql2);
    }

    /**
     * 修改Paymax系统中的支付联系人、邮箱、注册手机、登陆手机号信息
     * @param merchantId
     * @param merchantRealName
     * @param email
     * @param mobileNo
     */
    private void update_merchant_data(String merchantId, String merchantRealName, String email, String mobileNo) {
        String member_sql = "update merchant.t_member set phone = '"+mobileNo+"',email='"+email+"' where merchant_id = "+merchantId+";";

        String concact_sql = "update merchant.t_merchant_contacts set phone = '"+mobileNo+"',real_name='"+merchantRealName+"' where merchant_id = "+merchantId+";";
        System.out.println(member_sql+"\n"+concact_sql);
    }


    private void charge_real_time_return_sql(String merchantId, String startDate, String endDate,String bossId) {
        if (StringUtils.isBlank(bossId)){
            bossId = merchantId;
        }
        String sql = "mysql -hrr-2ze10444nlw3kt70h.mysql.rds.aliyuncs.com -upayright_read -phiXgDu86gER -e \"SELECT merchant_order_no AS '商户订单号', channel_order_no AS '支付渠道订单号', trade_time AS '交易日期', amount AS '交易金额', fee AS '手续费金额', settlement_amount AS '实际结算金额', remark1 AS '预留1', remark2 AS '预留2', remark3 AS '预留3', status AS '交易状态'" +
                " FROM statement.t_lakala_real_time_trade_statement_records" +
                " WHERE merchant_id = " +merchantId+
                " AND statement_type = 'CHARGE_RETURN'" +
                " AND statement_date" +
                " BETWEEN " +getYear()+startDate+
                " AND  "+getYear()+endDate+";\" >" +
                " /tmp/"+bossId+"_real_time_charge_return_"+startDate+"_"+endDate+".csv";
        System.out.println(sql);
        System.out.println("\n实时代收回盘文件  数据条数查询\n");
        String count_sql = "select count(*) " +
                " FROM statement.t_lakala_real_time_trade_statement_records" +
                " WHERE merchant_id = " +merchantId+
                " AND statement_type = 'CHARGE_RETURN'" +
                " AND statement_date" +
                " BETWEEN " +getYear()+startDate+
                " AND  "+getYear()+endDate+";";
        System.out.println(count_sql);
    }

    /**
     * 实时代收对账单
     * @param merchantId
     * @param startDate
     * @param endDate
     */
    private void charge_real_time_sql(String merchantId, String startDate, String endDate,String bossId) {
        if (StringUtils.isBlank(bossId)){
            bossId = merchantId;
        }
        String sql = "mysql -hrr-2ze10444nlw3kt70h.mysql.rds.aliyuncs.com -upayright_read -phiXgDu86gER -e \"SELECT merchant_order_no AS '商户订单号', channel_order_no AS '支付渠道订单号', trade_time AS '交易日期', amount AS '交易金额', fee AS '手续费金额', settlement_amount AS '实际结算金额', remark1 AS '预留1', remark2 AS '预留2', remark3 AS '预留3'" +
                " FROM statement.t_lakala_real_time_trade_statement_records" +
                " WHERE merchant_id = "+merchantId +
                " AND statement_type = 'CHARGE_BILL'" +
                " AND statement_date" +
                " BETWEEN " +getYear()+startDate+
                " AND " +getYear()+endDate+";\" > " +
                "/tmp/"+bossId+"_real_time_charge_bill_"+startDate+"_"+endDate+".csv";
        System.out.println(sql);
        System.out.println("\n实时代收对账单  数据条数查询\n");
        String count_sql = "select count(*) FROM statement.t_lakala_real_time_trade_statement_records" +
                " WHERE merchant_id = "+merchantId +
                " AND statement_type = 'CHARGE_BILL'" +
                " AND statement_date" +
                " BETWEEN " +getYear()+startDate+
                " AND " +getYear()+endDate+";";
        System.out.println(count_sql);
    }

    public static void main(String[] args) {
        GenerateSql cs = new GenerateSql();
        String merchantId = "1818";
        String startDate = "1027";
        String endDate = "1029";
        String bossId ="";

//        System.out.println(getYear());
        System.out.println("\n微信公众号C2B支付、微信公众号的支付和退款\n");
        cs.getWechat_C2B_Sql(merchantId,startDate,endDate);
        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付交易\n");
        cs.pc_lakala_sql(merchantId,startDate,endDate);
        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付退款数据\n");
        cs.pc_lakala_refund_sql(merchantId,startDate,endDate);
        System.out.println("\n实时代收对账单\n");
        cs.charge_real_time_sql(merchantId,startDate,endDate,bossId);

        System.out.println("\n实时代收回盘文件\n");
        cs.charge_real_time_return_sql(merchantId,startDate,endDate,bossId);

        System.out.println("\n修改Paymax系统中的支付联系人、邮箱、注册手机、登陆手机号信息\n");
        String merchantRealName = "张三";
        String email = "zhangsan@126.com";
        String mobileNo = "13888888888";

        cs.update_merchant_data(merchantId,merchantRealName,email,mobileNo);

        System.out.println("\n注销Paymax系统中的商户信息\n");
        cs.logout_merchant(merchantId);

    }


    private String getYear(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        return DateFormatUtils.format(c.getTime(),"yy");

    }
//    微信公众号C2B支付、微信公众号的支付和退款
    private void getWechat_C2B_Sql(String merchantId,String startDate,String endDate){

        String sql = "mysql -hrr-2ze10444nlw3kt70h.mysql.rds.aliyuncs.com -upayright_read -phiXgDu86gER -e \"select comp_org_code '机构号',req_log_no '机构请求流水号',lkl_merchant_id '商户号',terminal_id '终端号',lkl_trade_type '交易类型',lkl_no '流水号',concat('''',paymax_merchant_order_no) '商户订单号',order_no ' Paymax 订单号',refund_order_no ' Paymax 退款单号',round(amount/100,2) '交易金额',status '交易状态',round(fee/100,2) '手续费',lkl_trade_date '交易日期',lkl_trade_time '交易时间' " +
                "from statement.t_wechat_csb_statement_records where " +
                "merchant_id = " +merchantId+
                " and statement_date >=" +getYear()+startDate+
                " and statement_date <=" +getYear()+endDate+
                " and status='00';\" > " +
                "/tmp/"+merchantId+"_bmcp_"+startDate+"_"+endDate+".csv";
        System.out.println(sql);
        System.out.println("\n微信公众号C2B支付、微信公众号的支付和退款  数据条数查询\n");
        String count_sql = "select count(*) " +
        "from statement.t_wechat_csb_statement_records where " +
                "merchant_id = " +merchantId+
                " and statement_date >=" +getYear()+startDate+
                " and statement_date <=" +getYear()+endDate+
                " and status='00';";
        System.out.println(count_sql);
    }
//PC快捷、PC网关、拉卡拉移动网页支付交易
    private void pc_lakala_sql(String merchantId,String startDate,String endDate){
        String sql="mysql -hrr-2ze10444nlw3kt70h.mysql.rds.aliyuncs.com -upayright_read -phiXgDu86gER -e \"select order_date '订单时间',CONCAT(order_date,order_time) '支付时间',concat('''',paymax_merchant_order_no) '商户订单号',merchant_no ' Paymax 订单号',case when pay_way='A' then '借记卡快捷支付'  when pay_way='1' then '账户支付'   when pay_way='2' then '快捷支付'   when pay_way='3' then '银行卡支付' when pay_way='9' then '信用卡快捷支付'  when pay_way='4' then '网关支付' end '支付方式',round(amount/100,2) '交易总价',round(server_fee/100,2) '手续费',case when order_status='BD' then '交易成功'  when order_status='3' then '退款成功'  when order_status='RF' then '全部退款成功'  when order_status='RP' then '部分退款成功' end '订单状态' from  statement.t_lakala_statement_records where" +
                " merchant_id = " +merchantId +
                " AND trade_type='SUCCESS'" +
                " and statement_date >= " +getYear()+startDate +
                " and statement_date <= " +getYear()+endDate+";\" >" +
                " /tmp/"+merchantId+"_lakala_charge_"+startDate+"_"+endDate+".csv";
        System.out.println(sql);
        String count_sql="select count(*) from  statement.t_lakala_statement_records where" +
                " merchant_id = " +merchantId +
                " AND trade_type='SUCCESS'" +
                " and statement_date >= " +getYear()+startDate +
                " and statement_date <= " +getYear()+endDate+";";
        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付交易  数据条数查询\r\n");
        System.out.println(count_sql);
    }
//    PC快捷、PC网关、拉卡拉移动网页支付退款数据
    private void pc_lakala_refund_sql(String merchantId,String startDate,String endDate){
        String sql="mysql -hrr-2ze10444nlw3kt70h.mysql.rds.aliyuncs.com -upayright_read -phiXgDu86gER -e \"select refund_date '订单时间',CONCAT(refund_date,refund_time) '支付时间',concat('''',paymax_merchant_order_no) '商户订单号',merchant_no ' Paymax 订单号',round(amount/100,2) ' 交易总价',case when refund_status='BD' then '交易成功'  when refund_status='3' then '退款成功'  when refund_status='RF' then '全部退款成功'  when refund_status='RP' then '部分退款成功' end '订单状态' from  statement.t_lakala_statement_records" +
                " where merchant_id =" +merchantId+
                " AND trade_type='REFUND'" +
                " and statement_date >= " +getYear()+startDate +
                " and statement_date <= " +getYear()+endDate +
                ";\" > /tmp/"+merchantId+"_lakala_refund_"+startDate+"_"+endDate+".csv";
        System.out.println(sql);
        String count_sql = "select count(*) from  statement.t_lakala_statement_records" +
        " where merchant_id =" +merchantId+
                " AND trade_type='REFUND'" +
                " and statement_date >= " +getYear()+startDate +
                " and statement_date <= " +getYear()+endDate +";";

        System.out.println("\nPC快捷、PC网关、拉卡拉移动网页支付退款数据  数据条数查询\n");
        System.out.println(count_sql);
    }


}

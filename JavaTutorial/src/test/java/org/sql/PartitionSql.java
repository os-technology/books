package org.sql;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: PartitionSql
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/22下午3:57
 */

public class PartitionSql {

    @Test
    public void testCreatePartitionSql(){

        String[] range={"0401","0701","1001","0101"};
        testCreatePartitionSql(range);
    }


    public void testCreatePartitionSql(String[] range){
//        String year = DateUtils.dateToString(new Date(), "yyyy");
        int year = Integer.valueOf(DateFormatUtils.format(new Date(),"yyyy"))+1;
        for (int i=1;i<5;i++){
            if(i==4){
                System.out.println(createSql(year+"0"+i,(year+1)+range[i-1]));
            }else {
                System.out.println(createSql(year+"0"+i,year+range[i-1]));
            }
        }
    }


    /**
     * 20170401
     * 20170701
     * 20171001
     * 20180101
     * @param partitionName **_201801_20180401
     * @param date
     * @return
     */
    private String createSql(String partitionName,String date){
        return "alter table orders.t_charge_order add partition(\n" +
                "partition order_partition_"+partitionName+"_"+date+" values less than ("+date+") ENGINE = InnoDB\n" +
                ");";
    }
}

package org.sql;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @Title: PartitionSql
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/22下午3:57
 */

public class PartitionSql {
    @Test
    public void testCreatePartitionSql() {

        String[] rangeOrder = {"0401", "0701", "1001", "0101"};
        String[] rangeEvent = {"-04-01", "-07-01", "-10-01", "-01-01"};

        createRangeArray(rangeOrder, null);
        createRangeArray(rangeEvent, "UNIX_TIMESTAMP");

        testCreatePartitionSql("orders.t_charge_order", "chargeOrder_partition_", rangeOrder);
        testCreatePartitionSql("orders.t_event", "event_partition_", rangeEvent);
    }

    private void createRangeArray(String[] range, String funcName) {
        int year = Integer.valueOf(DateFormatUtils.format(new Date(), "yyyy")) + 1;
        if (StringUtils.isNotBlank(funcName)) {
            for (int i = 0; i < range.length; i++) {
                if (i == 3) {
                    range[i] = funcName + "('" + (year + 1) + range[i] + "')";
                } else {
                    range[i] = funcName + "('" + year + range[i] + "')";
                }
            }
        } else {
            for (int i = 0; i < range.length; i++) {
                if (i == 3) {
                    range[i] = (year + 1) + range[i];
                } else {
                    range[i] = year + range[i];
                }
            }
        }
    }


    public void testCreatePartitionSql(String tableName, String frontName, String[] range) {
        int year = Integer.valueOf(DateFormatUtils.format(new Date(), "yyyy")) + 1;
        String partitionSql = "alter table " + tableName + " add partition(\n";
        for (int i = 1; i < 5; i++) {
            partitionSql += createSql(frontName + year + "0" + i, range[i - 1]) + (i == 4 ? "\n" : ",\n");
        }
        partitionSql += ");";
        System.out.println(partitionSql);
    }

    /**
     * @param partitionName **_201801
     * @param date
     * @return
     */
    private String createSql(String partitionName, String date) {
        return "partition " + partitionName + " values less than (" + date + ") ENGINE = InnoDB";
    }
}

package com.boot.group.dict.service.impl;

import com.alibaba.fastjson.JSON;
import com.boot.group.dict.dao.BlessRecordDAO;
import com.boot.group.dict.entity.BlessRecord;
import com.boot.group.dict.service.BlessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author code
 * @Title: BlessRecordServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/30下午2:07
 */
@Service("blessRecordService")
public class BlessRecordServiceImpl implements BlessRecordService {

    String[] info = {"捧一卷书册，看人生起落；闻一股花香，感受生活美妙；泡一壶清茶，尝一刻休闲；发一条短信，送一句祝福。于津水衷心祝%s和您的家人和和美美，新年快乐！"
            , "2019，祝福%s新年快乐"
            , "猪年将至献上一份猪福】期盼：每一天，幸福之神都陪伴着你；每一刻，快乐之神都保佑着你。祝%s新年快乐，猪事顺利！"
            , "值此春回大地、万象更新之良辰，祝福%s福、禄、寿三星高照，阖府康乐，如意吉祥！新年快乐！"
            , "新年快乐！在这里于津水祝%s及家人猪年大吉大利！万事如意！身体健康！阖家幸福！"
    };

    @Autowired
    BlessRecordDAO blessRecordDAO;

    @Async
    @Override
    public void asyncMethod(Object obj) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("@Async 注解方法执行" + JSON.toJSONString(obj));
    }

    @Override
    public String save(String name) {
        name = StringUtils.isEmpty(name) ? "您" : name;
        Random random = new SecureRandom();


        BlessRecord blessRecord = new BlessRecord();
        blessRecord.setUsername(name)
                .setContent(String.format(info[random.nextInt(info.length)], name));
        blessRecordDAO.save(blessRecord);
        return blessRecord.getContent();
    }

    /**
     * 此处为了测试jpa的删除插入问题，验证通过，问题复现，jpa事务的确存在问题
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delAndSave() {
        BlessRecord blessRecord = new BlessRecord();
        blessRecord.setUsername("啊啊啊")
                .setContent("hello11");
        blessRecordDAO.deleteById(56L);
        blessRecordDAO.save(blessRecord);
    }
}

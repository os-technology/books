package com.boot.group.dict.service.impl;

import com.boot.group.dict.dao.BlessRecordDAO;
import com.boot.group.dict.entity.BlessRecord;
import com.boot.group.dict.service.BlessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    ,"2019，祝福%s新年快乐"
    };

    @Autowired
    BlessRecordDAO blessRecordDAO;

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
}

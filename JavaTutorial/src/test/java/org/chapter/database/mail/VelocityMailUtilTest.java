package org.chapter.database.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chapter.databasic.mail.EmailConfig;
import org.chapter.databasic.mail.VelocityMailUtil;
import org.junit.Test;

public class VelocityMailUtilTest {
	@Test
    public void testTableEmail() throws Exception {
        EmailConfig config = new EmailConfig();

        config.setTo(new String[]{"yujinshui@lxfintech.com"});

        config.setTemplateName("mail_table.vm");
        config.setSubject("Junit test");
        config.setModel(getContentTableMap1(config));

        VelocityMailUtil.sendHtmlMail(config);
    }

    public Map<String, Object> getContentTableMap1(EmailConfig config) {
        Map<String, Object> map = new HashMap<String, Object>();
        List list = new ArrayList();
        list.add("列1");
        list.add("列2");
        list.add("列3");
        list.add("列4");
        list.add("列5");
        list.add("列6");
        list.add("列7");

        List content = new ArrayList();
        EmailConfig conTitle = new EmailConfig();
        String data = "1,2,3,4,5,6,7";
        content.add(data.split(","));

//        String con  =JSON.toJSONString(config);
//        content.add(JSONArray.parse(con));
        map.put("header","table之前的内容");
        map.put("tableName","table名称");
        map.put("title", list);
        map.put("text", content);
        return map;
    }
}

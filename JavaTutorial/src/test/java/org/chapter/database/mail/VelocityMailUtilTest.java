package org.chapter.database.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chapter.databasic.mail.EmailConfig;
import org.chapter.databasic.mail.VelocityMailUtil;
import org.junit.Test;

import javax.mail.MessagingException;

public class VelocityMailUtilTest {
	@Test
    public void testTableEmail() throws Exception {
        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            sendEmail();
        }
    }

    private void sendEmail() throws MessagingException {
        EmailConfig config = new EmailConfig();

        config.setTo(new String[]{"435468827@qq.com"});

        config.setTemplateName("mail_table.vm");
        config.setSubject("柴小溪，你好~");
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
        map.put("header","柴小溪，你好~");
//        map.put("tableName","table名称");
//        map.put("title", list);
//        map.put("text", content);
        return map;
    }
}

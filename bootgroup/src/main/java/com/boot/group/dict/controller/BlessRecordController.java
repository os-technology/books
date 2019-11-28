package com.boot.group.dict.controller;

import com.boot.group.dict.service.BlessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author code
 * @Title: BlessRecordController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/30下午2:18
 */
@RestController
public class BlessRecordController {

    @Autowired
    BlessRecordService blessRecordService;

    @RequestMapping("/happy")
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");
        String info = blessRecordService.save(name);


        return format(info);
    }
    @RequestMapping("/ds")
    public String delAndSave(HttpServletRequest request) {

        blessRecordService.delAndSave();


        return format("");
    }

    private String format(String info){
        String data = "<br><br><br><br><br><br>" +
                "<table style=\"font-size: 30px;\" align=\"center\">\n" +
                "        <tr>\n" +
                "            <td align=\"center\"><h1>"+info+"</h1></td>\n" +
                "        </tr>\n" +
                "\n" +
                "    </table>";


        return data;
    }
}

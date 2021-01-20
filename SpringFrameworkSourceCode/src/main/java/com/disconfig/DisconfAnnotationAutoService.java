package com.disconfig;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 注解配置暂时不可用
 * @author code
 * @Title: DisconfAutoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/8/1下午2:33
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "annotationconfig.properties")
@DisconfUpdateService(classes = DisconfAnnotationAutoService.class)
public class DisconfAnnotationAutoService {
    private String auto;
    private String content;

    @DisconfFileItem(name = "auto")
    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }
    @DisconfFileItem(name = "dis.content",associateField = "content")
    public String getContent() {
        return content;
    }

    public DisconfAnnotationAutoService setContent(String content) {
        this.content = content;
        return this;
    }
}
/**
 *
 * 为这个类定义 @DisconfFile 注解，指定文件名为 code.properties 。
 * 定义域codeError，并使用Eclipse为其自动生成 get&set 方法。
 * 为该域的get方法上添加注解 @DisconfFileItem 。添加标记 name, 表示配置文件中的KEY名，这是必填的。标记associateField是可选的，它表示此get方法相关连的域的名字，如果此标记未填，则系统会自动 分析get方法，猜测其相对应于域名。强烈建议添加associateField标记，这样就可以避免Eclipse生成的Get/Set方法不符合 Java规范的问题。
 * 标记它为Spring托管的类 （使用@Service），且 "scope" 都必须是singleton的。
 */
package com.wisely.highlight_spring4.ch3.c4_conditional;

import org.springframework.context.annotation.Conditional;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: WindowsListService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午3:53
 */

public class WindowsListService implements ListService {

    @Override
    @Conditional(WindowCondition.class)
    public String showListCmd() {
        return "dir";
    }
}

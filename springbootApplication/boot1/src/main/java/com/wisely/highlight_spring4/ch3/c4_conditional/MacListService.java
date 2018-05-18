package com.wisely.highlight_spring4.ch3.c4_conditional;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: MacListService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午3:23
 */

public class MacListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}

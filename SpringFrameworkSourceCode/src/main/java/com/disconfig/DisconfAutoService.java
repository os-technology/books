package com.disconfig;

/**
 * @author code
 * @Title: DisconfAutoService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/8/1下午2:33
 */
public class DisconfAutoService {
    private String auto;
    private String disconf;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getDisconf() {
        return disconf;
    }

    public DisconfAutoService setDisconf(String disconf) {
        this.disconf = disconf;
        return this;
    }
}

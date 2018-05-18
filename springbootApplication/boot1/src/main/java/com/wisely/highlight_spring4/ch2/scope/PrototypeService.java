package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: PropertyService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午8:27
 */
@Service
@Scope("prototype")
public class PrototypeService {

}

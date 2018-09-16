package com.code.junit.mock.boot.dict.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author code
 * @Title: Company
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/16下午5:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {


    private Long id;
    private String companyName;

    private String address;

    private Date createTime;


}

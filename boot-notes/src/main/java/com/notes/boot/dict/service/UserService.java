package com.notes.boot.dict.service;


import com.notes.boot.dict.beans.UserData;

import java.util.List;

/**
 * @author code
 * @Title: UserService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/19下午2:23
 */
public interface UserService {
    List<UserData> getUserDataList();
}

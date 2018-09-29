package com.boot.group.dict.dao;

import com.boot.group.dict.entity.StudentInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author code
 * @Title: StudentInfoDAO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29下午3:14
 */
public interface StudentInfoDAO extends CrudRepository<StudentInfo, Long> {

    @Query
    StudentInfo findById(long id);
}

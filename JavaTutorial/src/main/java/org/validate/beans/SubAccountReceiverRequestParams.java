package org.validate.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

/**
 * 添加/删除分账接收人请求bean
 *
 * @author code
 * @Title: SubAccountReceiverRequestParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/12/13下午4:01
 */
public class SubAccountReceiverRequestParams extends PrimaryRequestParams {
    /**
     * 必填。分账接收人list
     */
    @Valid
    private List<ReceiverParams> receivers;
    /**
     * 必填。项目名称标识
     */

    @NotEmpty
    private String projectName;


    public List<ReceiverParams> getReceivers() {
        return receivers;
    }

    public SubAccountReceiverRequestParams setReceivers(List<ReceiverParams> receivers) {
        this.receivers = receivers;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public SubAccountReceiverRequestParams setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }
}

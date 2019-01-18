package org.validate;

import org.junit.Test;
import org.validate.beans.ReceiverParams;
import org.validate.beans.SubAccountReceiverRequestParams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code
 * @Title: ValidateTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/18下午2:56
 */
public class ValidateTest {

    @Test
    public void validateBean(){
        SubAccountReceiverRequestParams params = getSubAccountReceiverRequestParams();
        ValidationUtils.validate(params);
    }

    private SubAccountReceiverRequestParams getSubAccountReceiverRequestParams() {
        SubAccountReceiverRequestParams params = new SubAccountReceiverRequestParams();
        params.setReceivers(getReceivers())
                .setProjectName("hello");

        return params;
    }

    private List<ReceiverParams> getReceivers() {

        List<ReceiverParams> list = new ArrayList<>();

        ReceiverParams receiverParams = new ReceiverParams();

        receiverParams.setAccount("account")
//                .setType("personal")
        ;

        return list;
    }
}

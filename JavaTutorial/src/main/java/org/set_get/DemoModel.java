package org.set_get;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Data;

/**
 * 包含传参校验的lombok-build方式
 * @author code
 * @Title: DemoModel
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/12下午5:51
 */
@Data
@Builder
public class DemoModel {

    private String name;

    private int age;

    private int start;

    private int end;

    private void valid(){
        Preconditions.checkNotNull(name,"name should not be null");
        Preconditions.checkArgument(age > 0);
        Preconditions.checkArgument(start < end);
    }

    public static class InternalBuilder extends DemoModelBuilder {
        InternalBuilder() {
            super();
        }
        @Override
        public DemoModel build() {
            DemoModel model = super.build();
            model.valid();
            return model;
        }
    }

    public static DemoModelBuilder builder() {
        return new InternalBuilder();
    }

    public static void main(String[] args) {
        DemoModel demoModel = DemoModel.builder().age(1).start(5).end(3).build();
    }
}

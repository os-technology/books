package org.test.tmp;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import groovy.lang.GString;
import groovy.lang.GroovyShell;
import org.apache.commons.httpclient.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: GroovyShellListString
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/8下午3:49
 */

public class GroovyShellListString {

//    private String inlineExpression = "orders.t_charge_order_${0..1}";
    private String inlineExpression = "orders.t_charge_order_${"+express()+"}";

    private String express(){
        String year = DateUtil.formatDate(new Date(), "yyyy");
        return year+"01.."+year+"12";
    }

    @Test
    public void subDate(){
        System.out.println(columnFilter(20180306l));
    }

    private int columnFilter(Long value){
        String val = String.valueOf(value);
        int v = val.lastIndexOf(2);
//        String out = val.substring(val.length()-4,val.length()-2);
        String out = val.substring(0,6);
        return Integer.valueOf(out);
    }
    @Test
    public void list(){
        List<String> result = evaluate();
        Assert.assertNotNull(result);
    }

    public List<String> evaluate() {
        return null == this.inlineExpression?new ArrayList<String>() :this.flatten(this.evaluate(split()));
    }
    private List<String> flatten(List<Object> segments) {
        ArrayList result = new ArrayList();
        Iterator i$ = segments.iterator();

        while(i$.hasNext()) {
            Object each = i$.next();
            if(each instanceof GString) {
                result.addAll(this.assemblyCartesianSegments((GString)each));
            } else {
                result.add(each.toString());
            }
        }

        return result;
    }
    private List<String> assemblyCartesianSegments(GString segment) {
        Set cartesianValues = this.getCartesianValues(segment);
        ArrayList result = new ArrayList(cartesianValues.size());
        Iterator i$ = cartesianValues.iterator();

        while(i$.hasNext()) {
            List each = (List)i$.next();
            result.add(this.assemblySegment(each, segment));
        }

        return result;
    }

    private Set<List<String>> getCartesianValues(GString segment) {
        ArrayList result = new ArrayList(segment.getValues().length);
        Object[] arr$ = segment.getValues();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object each = arr$[i$];
            if(null != each) {
                if(each instanceof Collection) {
                    result.add(Sets.newLinkedHashSet(Collections2.transform((Collection)each, new Function() {
                        public String apply(Object input) {
                            return input.toString();
                        }
                    })));
                } else {
                    result.add(Sets.newHashSet(new String[]{each.toString()}));
                }
            }
        }

        return Sets.cartesianProduct(result);
    }

    private String assemblySegment(List<String> cartesianValue, GString segment) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < segment.getStrings().length; ++i) {
            result.append(segment.getStrings()[i]);
            if(i < cartesianValue.size()) {
                result.append((String)cartesianValue.get(i));
            }
        }

        return result.toString();
    }

    private List<Object> evaluate(List<String> inlineExpressions) {
        ArrayList result = new ArrayList(inlineExpressions.size());
        GroovyShell shell = new GroovyShell();

        StringBuilder expression;
        for(Iterator i$ = inlineExpressions.iterator(); i$.hasNext(); result.add(shell.evaluate(expression.toString()))) {
            String each = (String)i$.next();
            expression = new StringBuilder(each);
            if(!each.startsWith("\"")) {
                expression.insert(0, "\"");
            }

            if(!each.endsWith("\"")) {
                expression.append("\"");
            }
        }

        return result;
    }


    private List<String> split() {
        ArrayList result = new ArrayList();
        StringBuilder segment = new StringBuilder();
        int bracketsDepth = 0;

        for(int i = 0; i < this.inlineExpression.length(); ++i) {
            char each = this.inlineExpression.charAt(i);
            switch(each) {
                case '$':
                    if(123 == this.inlineExpression.charAt(i + 1)) {
                        ++bracketsDepth;
                    }

                    segment.append(each);
                    break;
                case ',':
                    if(bracketsDepth > 0) {
                        segment.append(each);
                    } else {
                        result.add(segment.toString().trim());
                        segment.setLength(0);
                    }
                    break;
                case '}':
                    if(bracketsDepth > 0) {
                        --bracketsDepth;
                    }

                    segment.append(each);
                    break;
                default:
                    segment.append(each);
            }
        }

        if(segment.length() > 0) {
            result.add(segment.toString().trim());
        }

        return result;
    }
}

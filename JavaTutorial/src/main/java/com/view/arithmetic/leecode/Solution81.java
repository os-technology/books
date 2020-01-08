package com.view.arithmetic.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 便利蜂面试题
 * 给你一个由 '(' 、')' 和小写字母组成的字符串。
 * 你需要从字符串中删除少量的'(' 或')'，（可以删除任意位置的括号），使得剩下的 括号字符串 有效。
 * 请返回任意一个合法的字符串。
 *
 * 有效字符串应当符合以下任意一条要求：
 * 空字符串或只包含小写字母的字符串
 * 可以被写作AB(A连接B)的字符串，其中A和B都是有效的「括号字符串」
 * 可以被写作A的字符串，其中A是一个有效的「括号字符串」
 *
 * 示例1
 * s = "lee(t(c)o)de)"
 * 输出 "lee(t(c)o)de"
 * 解释："lee(t(c)o)de)" "lee(t(c)ode)"都是一个可行答案
 *
 * 示例2
 * s = "a)b(c)d"
 * 输出："ab(c)d"
 *
 * 示例3
 * s = "))(("
 * 输出：""
 * 解释：空串也是有效的
 *
 * @author code
 * @Title: Solution81
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/1610:55 AM
 */
public class Solution81 {

char left = '(';
    char right = ')';
    public String minRemovedToMakeValid(String s){
        Stack<Node> stack = new Stack<>();
        List<Integer> removeIndex = new ArrayList<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==left){
                stack.push(new Node(i,left));
            }else if (s.charAt(i)==right){
                if (!stack.isEmpty()&&stack.peek().value==left){
                    stack.pop();
                }else {
                    stack.push(new Node(i,right));
                }
            }
        }

        while (stack.isEmpty()){
            return s;
        }

        while (!stack.isEmpty()){
            removeIndex.add(stack.pop().index);
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (!removeIndex.contains(i)){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();




    }



}

class Node{
    int index;
    Character value;

    public Node(int index, Character value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public Node setIndex(int index) {
        this.index = index;
        return this;
    }

    public Character getValue() {
        return value;
    }

    public Node setValue(Character value) {
        this.value = value;
        return this;
    }
}

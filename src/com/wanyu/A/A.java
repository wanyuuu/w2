package com.wanyu.A;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 * JDK自带stack
 */
public class A {
    @Test
    public void Stack(){
        Stack s=new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
//        Enumeration e=s.elements();//枚举
//        while(e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }
        System.out.println(s.pop());//弹栈 然后删除
        System.out.println(s.peek());//弹出栈顶 不删除
    }
}

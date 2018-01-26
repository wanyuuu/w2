package com.wanyu.B;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/24.
 */
public class A {
    @Test
    public void myStack(){
        Stack<Object> s=new Stack<Object>();
        s.push("A");
        s.push("B");
        s.push("C");
        for (Object t:s) {
            System.out.println(t);
        }
        System.out.println("OK");
    }
}

package com.wanyu.C;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2018/1/15.
 */
public class Stack1 {
    @Test
    public void myStack(){
        Stack<Object> stack=new Stack<Object>();
        stack.push("wanyu");
        stack.push("james");
        stack.push("kobe");//后进先出
//        for (Object o:stack) {
//            System.out.println(o);  遍历
//        }
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        System.out.print(stack.peek());//栈顶元素
        System.out.println(stack.search("kobe"));//查找栈的位置 栈顶为1
    }
}

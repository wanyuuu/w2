package com.wanyu.C;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2018/1/16.
 * 双栈实现队列
 */
public class StackQueue {
    private Stack stackPush=new Stack();//压入栈
    private Stack stackPop=new Stack();//弹出栈
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        push();
        pop();
    }
    public void add(String data){
        stackPush.push(data);
    }
    public void push(){
        while(!stackPush.empty()){
            stackPop.push(stackPush.pop());
        }
    }
    public void pop(){
        while(!stackPop.empty()){
            System.out.println(stackPop.pop());
        }
    }
}

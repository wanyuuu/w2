package com.wanyu.C;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2018/1/17.
 */
public class StackQueue1 {
    private Stack pushStack=new Stack();
    private Stack popStack=new Stack();
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        push();
        pop();
    }
    public void add(String data){
        pushStack.push(data);
    }
    public void push(){
        while(!pushStack.empty()){
            popStack.push(pushStack.pop());
        }
    }
    public void pop(){
        while(!popStack.empty()){
            System.out.println(popStack.pop());
        }
    }
}

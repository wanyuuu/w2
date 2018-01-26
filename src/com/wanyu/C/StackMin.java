package com.wanyu.C;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2018/1/15.
 * 最小栈
 */
public class StackMin {
    Stack<Integer> stackData=new Stack();
    Stack<Integer> stackMin=new Stack();
    @Test
    public void test(){
        push(15);
        push(3);
        push(2);
        push(8);
        System.out.println(peek());
    }
    public void push(Integer data){
        if(stackMin.isEmpty()){
            stackMin.push(data);
        }else {
            if(data<peek()){
                stackMin.push(data);
            }
        }
        stackData.push(data);
    }
    public Integer peek(){
        return stackMin.peek();
    }
}

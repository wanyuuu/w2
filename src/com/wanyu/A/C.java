package com.wanyu.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 */
public class C {
    private Stack<Integer> stackMin=new Stack<Integer>();
//    private Stack1<Integer> stackData=new Stack1<Integer>();
   @Test
    public void Test(){
       push(5);
       push(3);
       push(34);
       push(22);
       push(10);
       System.out.println(stackMin.peek());
    }
    public void push(Integer data){
        if(stackMin.isEmpty()){
            stackMin.push(data);
        }else {
            if(data<getMin()){
                stackMin.push(data);
            }
        }
//        stackData.push(data);
    }
    public Integer getMin(){
        return stackMin.peek();
    }
}

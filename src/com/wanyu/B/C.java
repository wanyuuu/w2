package com.wanyu.B;

import org.junit.Test;

import java.awt.*;
import java.util.Stack;

/**
 * Created by samsung on 2017/9/24.
 */
public class C {
    @Test
    public void test(){
        push(4);
        push(22);
        push(1);
        push(3);
        System.out.println(getMinstack());
    }
    private Stack<Integer> minStack=new Stack<Integer>();
    public void push(Integer data){
        if(minStack.isEmpty()){
            minStack.push(data);
        }else {
            if(data<getMinstack()){
                minStack.push(data);
            }
        }
    }
    public Integer getMinstack(){
        return minStack.peek();
    }
}

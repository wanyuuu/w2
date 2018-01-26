package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/15.
 * 手写栈
 */
public class Stack2 {
    private Object os[]=new Object[4];
    private int size=0;
    @Test
     public void myStack(){
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(pop());
        System.out.println(peek());
    }
    public void push(Object o){
        if(size>=os.length){
            reverse();
        }
        os[size++]=o;
    }
    public Object pop(){
        Object o=os[size-1];//从0开始 比长度少1
        os[--size]=null;
        return o;
    }
    public void reverse(){//增加栈的容量
        Object tmp[]=new Object[os.length*2];//增加一倍
        for(int i=0;i<size;i++){
            tmp[i]=os[i];
            os[i]=null;
        }
        os=tmp;
    }
    public Object peek(){//返回栈顶 不删除
        Object o=os[size-1];
        return o;
    }
}

package com.wanyu.B;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/24.
 */
public class B1 {
    @Test
    public void test(){
        push("A");
        push("B");
        push("C");
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
    }
    private String s[]=new String[3];
    private int size=0;
    public void push(String data){
        if(size>=s.length){
            revise();
        }
        s[size++]=data;
    }
    public String pop(){
        String ss=s[size-1];
        s[--size]=null;
        return ss;
    }
    public void revise(){
        String tmp[]=new String[s.length*3];
        for(int i=0;i<s.length;i++){
            tmp[i]=s[i];
            s[i]=null;
        }
        s=tmp;
    }
    public String peek(){
        String top=s[size-1];
        return top;
    }
}

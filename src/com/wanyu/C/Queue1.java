package com.wanyu.C;

import com.wanyu.A.D;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2018/1/16.
 */
public class Queue1 {
    private int DEFAULT_SIZE=5;
    private int capacity;
    private String []elementData;
    private int front=0;
    private int rear=0;//进队列
    @Test
    public void Test(){
        add("1");
        add("3");
        add("4");
        add("5");
         System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    @Before
    public void init(){
        elementData=new String[DEFAULT_SIZE];
        capacity=elementData.length-1;
    }
    public void add(String data){
        if(rear>capacity){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        elementData[rear++]=data;
    }
    public String remove(){
        if(Empty()){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String str=elementData[front++];
        elementData[front-1]=null;
        return str;
    }
    public boolean Empty(){
        return front>=rear;
    }
}

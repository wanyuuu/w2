package com.wanyu.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * 顺序队列  FIFO
 */
public class E {
    private int DEFAULT_SIZE=10;//默认长度
    private int capacity;//保存数组的长度
    private String[] elementData;//定义一个数组用于保存顺序队列的元素
    private int front=0;//出
    private int rear=0;//进

    @Before
    public void init(){
        elementData=new String [10];
        capacity=elementData.length-1;
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){ //进
        if(rear>capacity){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[rear++]=data;
    }
    public String remove(){  //出
        String s=elementData[front];
        elementData[front++]=null;// 元素出队列 游标向后移 0 1 2
        return s;
    }
}

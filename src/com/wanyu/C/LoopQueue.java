package com.wanyu.C;

import com.wanyu.A.E;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2018/1/16.
 * 循环队列 队列满了 从0覆盖元素
 */
public class LoopQueue {
    private int DEFAULE_SIZE=4;
    private int rear=0;
    private int front=0;
    private int capacity;
    private String[] elementData;
    @Before
    public void init(){
        elementData=new String[DEFAULE_SIZE];
        capacity=elementData.length;
    }
    @Test
    public void test(){
        add("a");
        add("b");
        add("c");
        add("d");
        add("e");
        add("f");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        elementData[rear++]=data;
        rear=rear==capacity?0:rear;//队列已满 从头开始
    }
    public String remove(){
        if(isEmpty()){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String data=elementData[front++];
        return data;
    }
    public boolean isEmpty(){
        return front==capacity; //队列进满的情况 越界
    }
}

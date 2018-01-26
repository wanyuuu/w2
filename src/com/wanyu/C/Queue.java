package com.wanyu.C;

import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

/**
 * Created by samsung on 2018/1/15.
 */
public class Queue {
    private int DEFAULT_SIZE = 5; //队列长度
    private int capacity; //用来保存数组长度
    private String elementData[];
    private int front; //出队列
    private int rear; //进队列

    @Before //所有测试方法之前都要执行此方法
    public void init() {
        elementData = new String[DEFAULT_SIZE];
        capacity = elementData.length - 1;
    }

    @Test
    public void test() {
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }

    public void add(String data) {
        if (rear > capacity) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[rear++] = data;
    }

    public String remove() {
        if(Empty()){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       String element= elementData[front++];
        return element;
    }
    public boolean Empty(){
        return front==elementData.length;
    }
}
package com.wanyu.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * 循环队列  允许覆盖
 */
public class F {
    private int DEFAULT_SIZE=10;
    private String elementData[];
    private int capacity;
    private int front=0;
    private int rear=0;
    @Before
    public void init(){
        elementData=new String[3];//长度为3 3个元素
        capacity=elementData.length;
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        add("D");//D进去把A覆盖
        add("E");//
        add("F");
        System.out.println(remove());
        System.out.println(remove());
       System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
//        if((front==rear)&&(elementData[front]!=null)){
//            throw new IndexOutOfBoundsException();
//        }   不用判断越界  元素覆盖
        elementData[rear++]=data;
        rear=rear==capacity?0:rear;//若相等 说明队列已满 从头开始
    }
    public String remove(){
        String s=elementData[front];
        elementData[front++]=null;
        front=front==capacity?0:front;//若没这句 当元素都删除后 数组越界
        return s;
    }
}

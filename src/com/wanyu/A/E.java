package com.wanyu.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * ˳�����  FIFO
 */
public class E {
    private int DEFAULT_SIZE=10;//Ĭ�ϳ���
    private int capacity;//��������ĳ���
    private String[] elementData;//����һ���������ڱ���˳����е�Ԫ��
    private int front=0;//��
    private int rear=0;//��

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
    public void add(String data){ //��
        if(rear>capacity){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[rear++]=data;
    }
    public String remove(){  //��
        String s=elementData[front];
        elementData[front++]=null;// Ԫ�س����� �α������ 0 1 2
        return s;
    }
}

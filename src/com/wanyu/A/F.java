package com.wanyu.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * ѭ������  ������
 */
public class F {
    private int DEFAULT_SIZE=10;
    private String elementData[];
    private int capacity;
    private int front=0;
    private int rear=0;
    @Before
    public void init(){
        elementData=new String[3];//����Ϊ3 3��Ԫ��
        capacity=elementData.length;
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        add("D");//D��ȥ��A����
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
//        }   �����ж�Խ��  Ԫ�ظ���
        elementData[rear++]=data;
        rear=rear==capacity?0:rear;//����� ˵���������� ��ͷ��ʼ
    }
    public String remove(){
        String s=elementData[front];
        elementData[front++]=null;
        front=front==capacity?0:front;//��û��� ��Ԫ�ض�ɾ���� ����Խ��
        return s;
    }
}

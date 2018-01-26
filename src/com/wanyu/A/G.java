package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * 单链表
 */
public class G {
    private class Node{
        private String data;//保存节点的数据
        private Node next;//指向下个节点的引用
        //初始化全部属性的构造器
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node front;//保存该链队列的头结点
    private Node rear;//保存尾结点
    private int size;//保存该链队列中的节点数
//    public G(String data){//初始化首个节点
//        front=new Node(data,null);
//        rear=front;
//        size++;
//    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        if(front==null){
            front=new Node(data,null);
            rear=front;
        }else {
            Node newNode=new Node(data,null);//新节点
            rear.next=newNode;//让尾结点的next指向新节点
            rear=newNode;
        }
        size++;
    }
    public String remove(){//删除节点 从front开始删
        Node oldNode=front;
        front=front.next; //新节点的地址就是front
        oldNode.next=null;//删除老节点
        size--;
        return oldNode.data;
    }
}

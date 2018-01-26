package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/16.
 */
public class ListQueue2 {
    public class Node{
        private String data;
        private Node next;//保存下一节点
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node front;
    private Node rear;
    private int size=0;
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        add("D");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        if(front==null){
            front=new Node(data,null);
            rear=front;
        }else{
            Node newNode=new Node(data,null);
            rear.next=newNode; //添加到当前尾结点的下一个节点
            rear=newNode; //赋给当前尾结点
        }
        size++;
    }
    public String remove(){
        Node oldNode=front;
        front=front.next;
        oldNode.next=null;
        size--;
        return oldNode.data;
    }
}

package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/16.
 * 队列的链式存储结构
 */
public class ListQueue1 {
    private class Node{
        private String data;
        private Node next;
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node front;//头结点
    private Node rear;//尾结点
    private int size=0;
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
        if (front == null) {
            front=new Node(data,null);
            rear=front;
        }else{
            Node newNode=new Node(data,null);
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }
    public String remove(){
        Node oldNode=front;//front.data=A front.next=B
        front=front.next;//front.data=B front.next.data=C 把头结点向下移
        oldNode.next=null;
        size--;
        return oldNode.data;
    }
}

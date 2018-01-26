package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/16.
 * 队列的链式存储结构
 */
public class ListQueue {
    private class Node{
        private String data;//保存节点数据
        private Node next;//指向下个节点的引用 next保存下一个节点
        public Node(String data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node front;//头结点
    private Node rear;//尾结点
    private int size;//保存节点的个数
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        if(front==null){
            front=new Node(data,null);
            rear=front;//一个节点头尾相等
        }else {
            Node newNode=new Node(data,null);
            rear.next=newNode;//尾结点指向新节点
            rear=newNode;//新节点保存为尾结点
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

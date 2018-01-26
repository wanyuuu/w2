package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/17.
 * 链式双向队列
 */
public class Deque {
    public class Node{
        private Node previous;//前一个引用
        private Node next;
        private String data;
        public Node(String data){
            this.data=data;
        }
    }
    private int size=0;
    private Node front;//头结点
    private Node rear;//尾结点
    @Test
    public void test(){
        addFirst("a");
        addFirst("B");
        addFirst("c");
        addLast("e");
        addLast("F");
        System.out.println(removeFirst());
        System.out.println(removeLast());
        System.out.println(removeLast());
        System.out.println(removeLast());
    }
    public void addFirst(String data){
        Node newNode=new Node(data);//新节点
        if(isEmpty()){
            front=newNode;//新节点给头结点
            rear=front;//头尾相等
        }else {
                front.previous=newNode;//原头结点previous保存新节点
                newNode.next=front;//新节点next保存原头结点
                front=newNode;//把新节点赋给当前头结点
        }
        size++;
    }
    public void addLast(String data){
        Node newNode=new Node(data);
        if(isEmpty()){
            rear=newNode;
            front=rear;
        }else {
            rear.next=newNode;//把新节点存在原尾结点的next
            newNode.previous=rear;//新节点previous 保存原尾结点
            rear=newNode;//
        }
    }
    public String removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node node=front;//用来暂时保存当前头结点
        front=node.next;//使下一个为头结点
        if(front!=null){
            front.previous=null;
        }else {
            rear=null;
        }
        size--;
        return node.data;
    }
    public String removeLast(){
        if(isEmpty()){
            return null;
        }
        Node node=rear;//当前尾结点
        rear=node.previous;//删除后新尾结点
            if(rear!=null){
                rear.next=null;
            }else {
                front=null;
            }

        return node.data;
    }
    public boolean isEmpty(){
        return front==null;
    }
}

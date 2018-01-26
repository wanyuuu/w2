package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/17.
 */
public class Deque1 {
    public class Node{
        private String data;
        private Node previous;
        private Node next;
        public Node(String data){
            this.data=data;
        }
    }
    private Node front;
    private Node rear;
    private int size=0;
    @Test
    public void test(){
        addFirst("a");
        addFirst("b");
        addFirst("c");
        addLast("e");
        System.out.println(removeLast());
        System.out.println(getSize());
        System.out.println(removeFirst());
    }
    public void addFirst(String data){
        Node newNode=new Node(data);
        if(isEmpty()){
            front=newNode;
            rear=front;
        } else {
            front.previous=newNode;
            newNode.next=front;
            front=newNode;
        }
        size++;
    }
    public void addLast(String data){
        Node newNode=new Node(data);
        if(isEmpty()){
            rear=newNode;
            front=rear;
        }else {
            rear.next=newNode;
            newNode.previous=rear;
            rear=newNode;
        }
        size++;
    }
    public String removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node node=front;
        front=node.next;//用于下次是否为空的判断
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
        Node node=rear;
        rear=node.previous;
        if(rear!=null){
            rear.next=null;
        }else {
            front=null;
        }
        size--;
        return node.data;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public int getSize(){
        return size;
    }
}

package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 */
public class G2 {
    private class Node{
        private String data;
        private Node next;
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    @Test
    public void test(){
        add("A");
        add("b");
        add("c");
        System.out.println(remove());
        System.out.println(remove());
    }
    private Node head;
    private Node end;
    private int size;
    public void add(String data){
        if(head==null){
            head=new Node(data,null);
            end=head;
        }else {
            Node newNode=new Node(data,null);
            end.next=newNode;
            end=newNode;
        }
        size++;
    }
    public String remove(){
        Node oldNode=head;
        head=head.next; //指向下一个头节点
        oldNode.next=null;
        size--;
        return oldNode.data;
    }
}

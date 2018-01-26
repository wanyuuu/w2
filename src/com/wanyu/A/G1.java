package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 */
public class G1 {
    private class Node{
        private Node next;//对下个节点的引用
        private String data;//保存节点的数据
        public Node(String data,Node next){//节点
            this.data=data;
            this.next=next;
        }
    }
    private Node front;//头结点
    private Node rear;//尾结点
    private int size;
    @Test
    public void test(){
        add("1");
        add("2");
        add("3");
        add("4");
        System.out.println(leng());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        if(front==null){ //如果没有头结点 添加对象为头结点
            front=new Node(data,null);
            rear=front;
        }else {//如果有头节点，则添加新节点作为头节点
            Node newNode=new Node(data,null);
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }
    public int leng(){
        return size;
    }
    public String remove(){
        Node oldNode=front;
        front=front.next;
        oldNode.next=null;
        size--;
        return oldNode.data;
    }
}

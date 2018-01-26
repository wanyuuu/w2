package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/19.
 * 双向链表
 */
public class DLinkList {
    public class Node{
        private String data;
        private Node prev;
        private Node next;
        public Node(String data,Node prev,Node next){
            this.data=data;
            this.prev=prev;
            this.next=next;
        }
    }
    private Node header;
    private Node tail;
    private int size;
    @Test
    public void test(){
        this.addFirst("a");
        this.addFirst("b");
        this.addFirst("c");
        this.addLast("d");
        this.addLast("e");
        this.insertElement(2,"f");
        this.deleteElement(3);
        System.out.println(this);
        this.insertElement(4,"aa");//若要在最后插入 可直接addLast()
        System.out.println(this);
    }
    public void addFirst(String data){
        header=new Node(data,null,header);
        if(tail==null){
           // header=newNode;
            tail=header;
        }
        size++;
    }
    public void addLast(String data){
        Node newNode=new Node(data,tail,null);//新节点prev存了原尾结点
        if(tail==null){
            tail=newNode;
            header=tail;
        }else {
            tail.next=newNode;//原尾结点指向新节点
            tail=newNode;//改变当前尾结点
        }
        size++;
    }
    public Node findElement(int index){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        if(header==null){
            return null;
        }else {
            Node currentNode=header;
            for(int i=0;i<size;i++){
                if(i==index){
                    return currentNode;
                }
                currentNode=currentNode.next;
            }
        }
        return null;
    }
    public String deleteElement(int index){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        Node del=null;
        if(index==0){

        }else {
            Node node=findElement(index-1);//要删除元素的前一节点
            del=node.next;//获得要删除的节点current
            node.next=del.next;
            del.next.prev=node;//=del.prev
        }
        del.next=null;
        del.prev=null;
        size--;
        return del.data;
    }
    public void insertElement(int index,String data){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        if(header==null){
            addFirst(data);
        }else {
            if(index==0){
                addFirst(data);
            }else {
                Node prevNode=findElement(index-1);//获得前一个节点
               //下面将新节点和前后节点连接起来
                Node currentNode=new Node(data,prevNode,prevNode.next);
                prevNode.next=currentNode;
                prevNode.next.prev=currentNode;
            }
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(Node node=header;node!=null;node=node.next){
            sb.append(node.data+" ");
        }
        return sb.toString();
    }
}

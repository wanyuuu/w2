package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/18.
 */
public class LinkList2 {
    public class Node{
        private String data;
        private Node next;
        public Node(String data,Node next){
            this.data=data;
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
        this.addFirst("1");
        this.addLast("c");
        this.addLast("d");
        this.insertElement(2,"haha");
        this.deleteElement(4);
        System.out.println(this);
        System.out.println(this.findElement(3).data);
        System.out.println(this.findIndex("c"));
    }
    public void addFirst(String data){
        header=new Node(data,header);//原头结点给新节点的next
        if(tail==null){
            tail=header; //保留了最初的头结点
        }
        size++;
    }
    public void addLast(String data){
        if(header==null){
            tail=new Node(data,null);
            header=tail;
        }else{
            Node newNode=new Node(data,null);
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public Node findElement(int index){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        } else {
            Node currentNode=header;
            if(currentNode==null){
                return null;
            }
            for(int i=0;i<size;i++){
                if(i==index){
                    return currentNode;
                }
                currentNode=currentNode.next;
            }
        }
        return null;
    }
    public void deleteElement(int index){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        Node del=null;
        if(index==0){
            del=header;
            header=del.next;
        }
        else {
            Node prev=findElement(index-1);//找到要删除元素的前一个
            del=prev.next;//当前要删除的元素
            prev.next=del.next;
        }
        size--;
    }
    public void insertElement(int index,String data){
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        if(header==null){
            addFirst(data);
        } else {
            if(index==0){
                addFirst(data);
            }else {
                Node prev=findElement(index-1);
                prev.next=new Node(data,prev.next);
//                prev.next=newNode;   与上句等价
//                newNode.next=prev.next;
                size++;
            }
        }
    }
    public int findIndex(String data){
        Node currentNode=header;
        for(int i=0;i<size;i++){
            if(currentNode.data==data){
                return i;
            }
            currentNode=currentNode.next;
        }
        return -1;//没找到
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

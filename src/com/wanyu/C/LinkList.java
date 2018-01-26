package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/18.
 * 链表 链式顺序表
 */
public class LinkList {
    public class Node{
        private String data;
        private Node next;
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node header;//头结点
    private Node tail;//尾结点
    private int size=0;
    @Test
    public void test(){
        this.addHeader("a");
        this.addHeader("b");
        this.addHeader("c");
        this.addTail("E");
        this.insertElement(3,"f");
        System.out.println(findElement(2));
        System.out.println(this.deleteElement(0));
        System.out.println(this.deleteElement(3));
        System.out.println(this);
    }
    public void addHeader(String data){ //从头插入
        if(header==null){
            header=new Node(data,null);
            tail=header;
        }else {
            Node newNode=new Node(data,header);
            // newNode.next=header;在上句构造器中
            header=newNode;
        }
        size++;
    }
    public void addTail(String data){//从尾插入
        if(tail==null){
            tail=new Node(data,null);
            header=tail;
        }else {
            Node newNode=new Node(data,null);
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public Node findElement(int index){//根据索引找元素
        if(index<0||index>size-1){ //元素索引比个数少1
            System.out.println("索引越界");
        }
        Node currentNode=header;//从头结点开始
        for(int i=0;i<size;i++){
            if(currentNode==null){
                break; //如果头结点为空 跳出循环 返回空
            }
            if(i==index){
                return currentNode;
            }
            currentNode=currentNode.next;//继续寻找
        }
        return null;
    }
    public int findIndex(String elementData){//查找元素的索引
        Node node=header;
        if(node!=null){
            for(int i=0;i<size;i++){
                if(elementData==node.data){
                    return i;
                }
                //若没找到 继续下一个元素
                node=node.next;
            }
        }
        return -1;//没找到
    }
    public String deleteElement(int index){//根据索引删除元素
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        Node del=null;//初始化删除节点
        if(index==0){ //删除的是头结点
            del=header;
            header=del.next;
        }else {
            Node prev=findElement(index-1);//获得要删除节点的前一个节点
            del=prev.next;//获取要被删除的节点
            prev.next=del.next;//让被删除节点的前一节点指向它的下一节点
            del.next=null;
        }
        size--;
        return del.data;
    }
    public void insertElement(int index,String data){//指定插入元素
        if(index<0||index>size-1){
            System.out.println("索引越界");
        }
        if(header==null){
            addTail(data);
        }else {
            if(index==0){
                addHeader(data);
            }else {
                //获得前一个节点
                Node prev=findElement(index-1);
                //前一个节点指向新节点 新节点指向前一个节点的指向
                prev.next=new Node(data,prev.next);
                size++;
            }
        }
    }

    @Override
    public String toString() { //重写该方法 输出对象内容 而不是对象的hash码
        StringBuffer sb=new StringBuffer();
        for(Node node=header;node!=null;node=node.next){
            sb.append(node.data+" ");
        }
        return sb.toString();
    }
}

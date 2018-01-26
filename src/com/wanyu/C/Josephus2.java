package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/19.
 */
public class Josephus2 {
    public class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }
    @Test
    public void init(){
        Node first=new Node(0);
        first.next=first;
        Node last=first;
        int n=5;
        int m=2;
        for(int i=1;i<n;i++){
            last.next=new Node(i);
            last=last.next;
        }
        last.next=first;//最后一个节点指向头结点
        System.out.println("出圈顺序：");
        while(last!=last.next){
            for(int i=1;i<m;i++){
                last=last.next;//取得要删除节点的前一个节点
            }
            System.out.println("出圈的元素位置："+last.next.data);
            last.next=last.next.next;
        }
        System.out.println("幸存元素:"+last.data);
    }

}

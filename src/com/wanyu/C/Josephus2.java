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
        last.next=first;//���һ���ڵ�ָ��ͷ���
        System.out.println("��Ȧ˳��");
        while(last!=last.next){
            for(int i=1;i<m;i++){
                last=last.next;//ȡ��Ҫɾ���ڵ��ǰһ���ڵ�
            }
            System.out.println("��Ȧ��Ԫ��λ�ã�"+last.next.data);
            last.next=last.next.next;
        }
        System.out.println("�Ҵ�Ԫ��:"+last.data);
    }

}

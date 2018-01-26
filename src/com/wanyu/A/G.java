package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * ������
 */
public class G {
    private class Node{
        private String data;//����ڵ������
        private Node next;//ָ���¸��ڵ������
        //��ʼ��ȫ�����ԵĹ�����
        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node front;//����������е�ͷ���
    private Node rear;//����β���
    private int size;//������������еĽڵ���
//    public G(String data){//��ʼ���׸��ڵ�
//        front=new Node(data,null);
//        rear=front;
//        size++;
//    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
    }
    public void add(String data){
        if(front==null){
            front=new Node(data,null);
            rear=front;
        }else {
            Node newNode=new Node(data,null);//�½ڵ�
            rear.next=newNode;//��β����nextָ���½ڵ�
            rear=newNode;
        }
        size++;
    }
    public String remove(){//ɾ���ڵ� ��front��ʼɾ
        Node oldNode=front;
        front=front.next; //�½ڵ�ĵ�ַ����front
        oldNode.next=null;//ɾ���Ͻڵ�
        size--;
        return oldNode.data;
    }
}

package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 */
public class G1 {
    private class Node{
        private Node next;//���¸��ڵ������
        private String data;//����ڵ������
        public Node(String data,Node next){//�ڵ�
            this.data=data;
            this.next=next;
        }
    }
    private Node front;//ͷ���
    private Node rear;//β���
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
        if(front==null){ //���û��ͷ��� ��Ӷ���Ϊͷ���
            front=new Node(data,null);
            rear=front;
        }else {//�����ͷ�ڵ㣬������½ڵ���Ϊͷ�ڵ�
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

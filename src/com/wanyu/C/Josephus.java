package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/19.
 * ��ʽԼɪ��
 */
public class Josephus {
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
        first.next=first;  //һ��Ԫ�� ��β���
        Node last=first;
        int n=5;//����
        int m=3;//��Ȧλ��
        for(int i=1;i<n;i++){
            last.next=new Node(i);//�ӵڶ����˿�ʼ
            last=last.next;//�Ƶ���һ���ڵ�
        }
        last.next=first;//��β������Ȧ
        System.out.println("��Ȧ˳��");
        //��ʱlast�����һ���ڵ�
        while(last!=last.next){//��ʣһ����ʱ ��35�еĸ�ֵ ��� ���Խ���
            for(int i=1;i<m;i++){//����¼����
                last=last.next; //����lastΪ��Ȧ���ǰһ�� 0 1
            }
            System.out.println("��Ȧ�����֣�"+last.next.data);//2
            last.next=last.next.next;//�ӳ�Ȧ����һ������
        }
        System.out.println("�������ǣ�"+last.data);
    }
}

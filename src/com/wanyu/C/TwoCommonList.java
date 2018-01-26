package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/19.
 * 两个链表的公共部分
 */
public class TwoCommonList {
    public class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }
    @Test
    public void test(){
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=new Node(4);
        Node nodel2=new Node(2);
        nodel2.next=new Node(3);
        nodel2.next.next=new Node(4);
        nodel2.next.next.next=new Node(5);
        printCommom(node1,nodel2);
    }
    public void printCommom(Node head1,Node head2){
        while(head1!=null&&head2!=null){
            if(head1.data<head2.data){
                head1=head1.next;
            }else if(head1.data>head2.data){
                head2=head2.next;
            }else {
                System.out.println(head1.data+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }
    }
}

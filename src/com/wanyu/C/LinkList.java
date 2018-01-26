package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/18.
 * ���� ��ʽ˳���
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
    private Node header;//ͷ���
    private Node tail;//β���
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
    public void addHeader(String data){ //��ͷ����
        if(header==null){
            header=new Node(data,null);
            tail=header;
        }else {
            Node newNode=new Node(data,header);
            // newNode.next=header;���Ͼ乹������
            header=newNode;
        }
        size++;
    }
    public void addTail(String data){//��β����
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
    public Node findElement(int index){//����������Ԫ��
        if(index<0||index>size-1){ //Ԫ�������ȸ�����1
            System.out.println("����Խ��");
        }
        Node currentNode=header;//��ͷ��㿪ʼ
        for(int i=0;i<size;i++){
            if(currentNode==null){
                break; //���ͷ���Ϊ�� ����ѭ�� ���ؿ�
            }
            if(i==index){
                return currentNode;
            }
            currentNode=currentNode.next;//����Ѱ��
        }
        return null;
    }
    public int findIndex(String elementData){//����Ԫ�ص�����
        Node node=header;
        if(node!=null){
            for(int i=0;i<size;i++){
                if(elementData==node.data){
                    return i;
                }
                //��û�ҵ� ������һ��Ԫ��
                node=node.next;
            }
        }
        return -1;//û�ҵ�
    }
    public String deleteElement(int index){//��������ɾ��Ԫ��
        if(index<0||index>size-1){
            System.out.println("����Խ��");
        }
        Node del=null;//��ʼ��ɾ���ڵ�
        if(index==0){ //ɾ������ͷ���
            del=header;
            header=del.next;
        }else {
            Node prev=findElement(index-1);//���Ҫɾ���ڵ��ǰһ���ڵ�
            del=prev.next;//��ȡҪ��ɾ���Ľڵ�
            prev.next=del.next;//�ñ�ɾ���ڵ��ǰһ�ڵ�ָ��������һ�ڵ�
            del.next=null;
        }
        size--;
        return del.data;
    }
    public void insertElement(int index,String data){//ָ������Ԫ��
        if(index<0||index>size-1){
            System.out.println("����Խ��");
        }
        if(header==null){
            addTail(data);
        }else {
            if(index==0){
                addHeader(data);
            }else {
                //���ǰһ���ڵ�
                Node prev=findElement(index-1);
                //ǰһ���ڵ�ָ���½ڵ� �½ڵ�ָ��ǰһ���ڵ��ָ��
                prev.next=new Node(data,prev.next);
                size++;
            }
        }
    }

    @Override
    public String toString() { //��д�÷��� ����������� �����Ƕ����hash��
        StringBuffer sb=new StringBuffer();
        for(Node node=header;node!=null;node=node.next){
            sb.append(node.data+" ");
        }
        return sb.toString();
    }
}

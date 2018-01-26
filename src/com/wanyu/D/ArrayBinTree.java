package com.wanyu.D;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/20.
 */
public class ArrayBinTree {
    private String [] datas;//��¼���нڵ�
    private int DEFAULT_SIZE=3;
    private int deep;
    private int arraySize;
    public class BinTree{
        private String data;
    }
    @Test
    public void test(){
        this.initTree("A");
        this.addNode(0,"B",true);
        this.addNode(0,"C",false);
        this.addNode(1,"D",true);
        this.addNode(1,"E",false);
        this.addNode(2,"OK",true);
        this.addNode(2,"sb",false);
        System.out.println(getLeft(0));
        System.out.println(getLeft(1));
        System.out.println(getRight(1));
        System.out.println(getLeft(2));
        System.out.println(getRight(3));
    }
    public void initTree(String data){ //���ĳ�ʼ��
        deep=DEFAULT_SIZE;
        arraySize=(int) Math.pow(2,deep)-1;//�������ܽ��ĸ���
        datas=new String[arraySize];
        datas[0]=data;
    }
    /**
     *
     * @param index ��ӵ����ڵ������
     * @param data  ���ӽڵ������
     * @param left  �Ƿ�Ϊ��ڵ�
     */
    public void addNode(int index,String data,boolean left){
        if(datas[index]==null){
            throw new RuntimeException("���ڵ�Ϊ�գ��޷����");
        }
        if((2*index+1)>=arraySize){
            throw new RuntimeException("���ײ�����������Խ��");
        }
        if(left){//������ӽڵ�
            datas[2*index+1]=data;
        }else{
            datas[2*index+2]=data;
        }
    }
    public String getLeft(int index){
        if(2*index+1>=arraySize){
            throw new RuntimeException("�ýڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
        }
        return datas[2*index+1];
    }
    public String getRight(int index){
        if(2*index+2>=arraySize){
            throw new RuntimeException("�ýڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
        }
        return datas[2*index+2];
    }
}

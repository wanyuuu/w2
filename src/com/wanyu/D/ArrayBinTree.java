package com.wanyu.D;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/20.
 */
public class ArrayBinTree {
    private String [] datas;//记录所有节点
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
    public void initTree(String data){ //树的初始化
        deep=DEFAULT_SIZE;
        arraySize=(int) Math.pow(2,deep)-1;//二叉树总结点的个数
        datas=new String[arraySize];
        datas[0]=data;
    }
    /**
     *
     * @param index 添加到父节点的索引
     * @param data  新子节点的数据
     * @param left  是否为左节点
     */
    public void addNode(int index,String data,boolean left){
        if(datas[index]==null){
            throw new RuntimeException("父节点为空，无法添加");
        }
        if((2*index+1)>=arraySize){
            throw new RuntimeException("树底层已满，数组越界");
        }
        if(left){//添加左子节点
            datas[2*index+1]=data;
        }else{
            datas[2*index+2]=data;
        }
    }
    public String getLeft(int index){
        if(2*index+1>=arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return datas[2*index+1];
    }
    public String getRight(int index){
        if(2*index+2>=arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return datas[2*index+2];
    }
}

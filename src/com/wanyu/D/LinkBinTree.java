package com.wanyu.D;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/21.
 * 链式存储二叉树
 */
public class LinkBinTree {
    public class LinkTree{
        private String data;
        private LinkTree left;
        private LinkTree right;
        public LinkTree(String data){
            this.data=data;
        }
        public LinkTree(String data,LinkTree left,LinkTree right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    private LinkTree firstNode;//根节点
    public LinkTree initTree(String data){
        firstNode=new LinkTree(data);
        return firstNode;
    }
    @Test
    public void test(){
        LinkTree root=this.initTree("root");
       LinkTree a=this.addNode("A",root,true);
        LinkTree b=this.addNode("B",root,false);
        LinkTree c=this.addNode("C",a,true);
        LinkTree d=this.addNode("D",a,false);
        System.out.println(getLeft(root));
        System.out.println(getRight(root));
        System.out.println(getLeft(a));
        System.out.println(getRight(a));
        System.out.println(getDeep(root));
    }
    public LinkTree addNode(String data,LinkTree parent,boolean left){
        if(parent==null){
            System.out.println("父节点为空，无法添加！");
            return null;
        }
        if(left&&parent.left!=null){
            System.out.println("左节点已存在，无法添加！");
            return null;
        }
        if(!left&&parent.right!=null){
            System.out.println("右节点已存在，无法添加!");
            return null;
        }
        LinkTree node=new LinkTree(data);//新节点
        if(left){//左节点
            parent.left=node;
        }else {
            parent.right=node;
        }
        return node;
    }
    public String getLeft(LinkTree parent){//指定父节点的左节点
        if(parent==null){
            return null;
        }
        if(parent.left!=null){ //左节点存在
            return parent.left.data;
        }
        return null; //左节点不存在
    }
    public String getRight(LinkTree parent){
        if(parent==null){
            return null;
        }
        if(parent.right!=null){ //右节点存在
            return parent.right.data;
        }
        return null; //右节点不存在
    }
    public int getDeep(LinkTree parent){
        if(parent==null){
            return 0;
        }
        if(parent.left==null&&parent.right==null){
            return 1;
        }else {
            int leftDeep=getDeep(parent.left);
            int rightDeep=getDeep(parent.right);
            int max=leftDeep>rightDeep?leftDeep:rightDeep;
            return max+1;//加的是指定节点本身
        }
    }
}

package com.wanyu.D;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/21.
 */
public class LinkBinTree2 {
    public class Node{
        private String data;
        private Node leftNode;
        private Node rightNode;
        public Node(String data){
            this.data=data;
        }
        public Node(String data,Node leftNode,Node rightNode){
            this.data=data;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }
    }
    @Test
    public void test(){
        Node root=this.initTree("ROOT");
        Node a=this.addNode("A",root,true);
        Node b=this.addNode("B",root,false);
        Node c=this.addNode("C",a,true);
        Node d=this.addNode("D",a,false);
        System.out.println(getLeft(root));
        System.out.println(getRight(root));
        System.out.println(getLeft(a));
        System.out.println(getRight(a));
        System.out.println(getDeep(a));
    }
    public Node initTree(String data){
        Node firstNode=new Node(data);
        return firstNode;
    }
    public Node addNode(String data,Node parent,boolean left){
        if(parent==null){
            System.out.println("该节点为空，无法添加子节点");
            return null;
        }
        if(left&&parent.leftNode!=null){
            System.out.println("左节点已存在，无法添加");
            return null;
        }
        if(!left&&parent.rightNode!=null){
            System.out.println("右节点已存在，无法添加");
            return null;
        }
        Node node=new Node(data);
        if(left){
            parent.leftNode=node;
        }else {
            parent.rightNode=node;
        }
        return node ;
    }
    public String getLeft(Node parent){
        if(parent==null){
            System.out.println("该节点不存在");
            return null;
        }
        if(parent.leftNode==null){
            return null;
        }else {
            return parent.leftNode.data;
        }
    }
    public String getRight(Node parent){
        if(parent==null){
            System.out.println("该节点不存在");
            return null;
        }
        if(parent.rightNode==null){
            return null;
        }else {
            return parent.rightNode.data;
        }
    }
    public int getDeep(Node parent){
        if(parent==null){
            return 0;
        }
        if(parent.leftNode==null&&parent.rightNode==null){
            return 1;
        }else {
            int leftDeep=getDeep(parent.leftNode);
            int rightDeep=getDeep(parent.rightNode);
            int max=leftDeep>rightDeep?leftDeep:rightDeep;
            return max+1;
        }
    }
}

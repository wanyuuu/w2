package com.wanyu.D;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.wanyu.A.E;
import org.junit.Test;
import sun.font.StrikeCache;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by samsung on 2018/1/21.
 * 遍历二叉树 DLR LRD LDR
 */
public class BinaryTree {
    public class Node{
        private String data;
        private Node leftNode;
        private Node rightNode;
        public Node(String data,Node leftNode,Node rightNode){
            this.data=data;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }
    }
    @Test
    public void test(){
        Node F=new Node("F",null,null);
        Node G=new Node("G",null,null);
        Node H=new Node("H",null,null);
        Node M=new Node("M",null,null);
        Node N=new Node("N",null,null);
        Node D=new Node("D",F,G);
        Node E=new Node("E",null,H);
        Node B=new Node("B",D,E);
        Node C=new Node("C",M,N);
        Node A=new Node("A",B,C);
        this.root=A;
//        getL(A);
//        System.out.println();
//        getR(A);
//        System.out.println();
//        getD(A);
       // deepBin2();
        levelTree();
        /*
            A
          /  \
         B   C
       / \  / \
      D  E M  N
     / \  \
    F  G  H
         */
    }
    private Node root;
    public void deepBin(){ //深度遍历二叉树
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);
        while(stack.isEmpty()==false){//不为空
            Node node=stack.pop();
            System.out.println(node.data);
            if(node.rightNode!=null){
                stack.push(node.rightNode);
            }
            if(node.leftNode!=null){
                stack.push(node.leftNode);
            }
        }
    }
    public void deepBin2(){
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);
        while(stack.isEmpty()!=true){
            Node node=stack.pop();
            System.out.println(node.data);
            if(node.rightNode!=null){
                stack.push(node.rightNode);
            }
            if(node.leftNode!=null){
                stack.push(node.leftNode);
            }
        }
    }
    public void levelBin(){//广度遍历 一层一层
        ArrayDeque<Node> deque=new ArrayDeque<Node>();
        if(this.root==null){
            System.out.println("没有根节点");
            return ;
        }
        deque.add(this.root);
        while(!deque.isEmpty()){
            Node node=deque.remove();
            System.out.println(node.data);
            if(node.leftNode!=null){
                deque.add(node.leftNode);
            }
            if(node.rightNode!=null){
                deque.add(node.rightNode);
            }
        }
    }
    public void levelTree(){
        ArrayDeque<Node> deque=new ArrayDeque<Node>();
        if(this.root==null){
            System.out.println("根节点不存在！");
            return ;
        }
        deque.add(this.root);
        while(!deque.isEmpty()){
            Node node =deque.remove();
            System.out.println(node.data);
            if(node.leftNode!=null){
                deque.add(node.leftNode);
            }
            if(node.rightNode!=null){
                deque.add(node.rightNode);
            }
        }
    }
    public void getL(Node node){ //先序遍历
        System.out.print(node.data+" ");
        if(node.leftNode!=null){
            getL(node.leftNode);
        }
        if(node.rightNode!=null){
            getL(node.rightNode);
        }
    }
    public void getR(Node node){//后序遍历
        if(node.leftNode!=null){
            getR(node.leftNode);
        }
        if(node.rightNode!=null){
            getR(node.rightNode);
        }
        System.out.print(node.data+" ");
    }
    public void getD(Node node){
        if(node.leftNode!=null){
            getD(node.leftNode);
        }
        System.out.print(node.data+" ");
        if(node.rightNode!=null){
            getD(node.rightNode);
        }
    }
}

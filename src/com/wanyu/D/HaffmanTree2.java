package com.wanyu.D;

import org.junit.Test;

import java.util.*;

/**
 * Created by samsung on 2018/1/24.
 */
public class HaffmanTree2 {
    public Node2 createTree(List<Node2> list){
        Collections.sort(list);
        while(list.size()>1){
            Node2 left=list.get(list.size()-1);
            Node2 right=list.get(list.size()-2);
            Node2 parent=new Node2(null,left.getWeight()+right.getWeight());
            list.remove(left);
            list.remove(right);
            parent.setLeftNode(left);
            parent.setRightNode(right);
            list.add(parent);
            GuangBin();
        }
        return list.get(0);
    }
    static Node2 root;
    public void GuangBin(){
        ArrayDeque<Node2> deque=new ArrayDeque<Node2>();
        if(root!=null){
            deque.add(root);
        }
        while(!deque.isEmpty()){
            Node2 node =deque.remove();
            System.out.println(node);
            if(node.getLeftNode()!=null){
                deque.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                deque.add(node.getRightNode());
            }
        }
    }
    @Test
    public void test(){
        List<Node2> list=new ArrayList<Node2>();
        list.add(new Node2("a",2));
        list.add(new Node2("b",4));
        list.add(new Node2("c",5));
        list.add(new Node2("d",9));
        list.add(new Node2("e",11));
        list.add(new Node2("f",13));
        Node2 node=createTree(list);
        this.root=node;
        System.out.println(node);
        GuangBin();
    }
}
class Node2 implements Comparable<Node2>{
    private String data;
    private double weight;
    private Node2 leftNode;
    private Node2 rightNode;
    public Node2(String data,double weight){
        this.data=data;
        this.weight=weight;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node2 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node2 leftNode) {
        this.leftNode = leftNode;
    }

    public Node2 getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node2 rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "weight:"+getWeight();
    }

    @Override
    public int compareTo(Node2 node) {
        if(node.getWeight()>this.getWeight()){
            return 1;
        }
        if(node.getWeight()<this.getWeight()){
            return -1;
        }
        return 0;
    }
}

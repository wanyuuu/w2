package com.wanyu.D;

import org.junit.Test;

import java.util.*;

/**
 * Created by samsung on 2018/1/23.
 */
public class HuffmanTree {
    public Node createTree(List<Node> nodes){
        Collections.sort(nodes); //倒序 7542  下面那个compareTo方法 从大到小排
        while(nodes.size()>1){ //有两个以上的节点时
            Node left=nodes.get(nodes.size()-1);//倒数第一个
            Node right=nodes.get(nodes.size()-2);//倒数第二个
            //新节点权值为两个子节点权值之和
            Node parent=new Node(null,left.getWeight()+right.getWeight());
            parent.setLeftNode(left);
            parent.setRightNode(right);
            //删除权值最小的两个节点
            nodes.remove(left);
            nodes.remove(right);
            //将新生成的节点添加到集合中去
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    public void GuangBin(){//广度遍历
        ArrayDeque<Node> deque=new ArrayDeque<Node>();
        if(root!=null){
            deque.add(root);
        }
        while(!deque.isEmpty()){
            Node node =deque.remove();
            System.out.println(node.getWeight());
            if(node.getLeftNode()!=null){
                deque.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                deque.add(node.getRightNode());
            }
        }
    }
    static Node root;
    @Test
    public void test(){
        List<Node> list=new ArrayList<Node>();
        list.add(new Node("a",7));
        list.add(new Node("b",5));
        list.add(new Node("c",4));
        list.add(new Node("d",2));
//        list.add(new Node("e",2));
//        list.add(new Node("f",2));
        Node node= createTree(list);
        System.out.println(node);
        this.root=node;
        GuangBin();
       // System.out.println(list);
    }
}
class Node implements Comparable<Node>{
    private String data;
    private double weight;//权重
    private Node leftNode;
    private Node rightNode;
    public Node(String data,double weight){
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

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString(){
        return "data:"+this.data+";weight:"+this.weight;
    }
    @Override
    public int compareTo(Node node) {
        if(node.weight>this.weight){
            return 1;
        }
        if(node.weight<this.weight){
            return -1;
        }
        return 0;
    }
}

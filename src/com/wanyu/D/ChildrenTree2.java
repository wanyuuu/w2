package com.wanyu.D;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2018/1/20.
 */
public class ChildrenTree2 {
    public class sonNode{
        private int pos;
        private sonNode next;
        public sonNode(int pos,sonNode next){
            this.pos=pos;
            this.next=next;
        }
    }
    public class Node{
        private String data;
        private sonNode first;//存每个节点
        public Node(String data){
            this.data=data;
            this.first=null;
        }
    }
    private int treeSize=100;
    private Node[] nodes=new Node[treeSize];
    private int nodeNum;
    @Test
    public void test(){
        Node a=this.treeInit("A");
        Node b=this.addNode("B",a);
        Node c=this.addNode("C",a);
        Node d=this.addNode("D",a);
        Node e=this.addNode("E",b);
        List<Node> list=this.childrenNode(b);
        for (Node n:list){
            System.out.println(n.data);
        }
        System.out.println(deep(a));
    }
    public Node treeInit(String data){
        nodes[0]=new Node(data); //根节点
        nodeNum++;
        return nodes[0];
    }
    public Node addNode(String data,Node parent){
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==null){
                nodes[i]=new Node(data);//生成新节点 但还未加到父节点上
            if(parent.first==null){ //如果没有子节点 直接加到父节点上
                parent.first=new sonNode(i,null);
            }else {
                sonNode nextNode=parent.first;
                while(nextNode.next!=null){
                    nextNode=nextNode.next;
                }
                nextNode.next=new sonNode(i,null); //放到最后一个空节点上
              }
                nodeNum++;
                return nodes[i];
            }
        }
        return null;
    }
    public List<Node> childrenNode(Node parent){//指定父节点下的子节点
        List<Node> list=new ArrayList<Node>();
        sonNode node=parent.first;//获得第一个子节点
        while(node!=null){
            list.add(nodes[node.pos]);
            node=node.next;
        }
        return list;
    }
    public int deep(Node parent){
        if(parent.first==null){
            return 1;
        }else {
            int max=0;
            sonNode node =parent.first;
            while(node.next!=null) {
                int tmp = deep(nodes[node.pos]);
                if (tmp > max) {
                    max = tmp;
                }
                node=node.next;
            }
            return max+1;
        }
    }
}

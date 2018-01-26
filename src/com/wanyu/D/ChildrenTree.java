package com.wanyu.D;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2018/1/20.
 * 子节点链 表示法
 */
public class ChildrenTree {
    public class sonNode{//子节点
        private int pos;//节点位置
        private sonNode next;//下一节点
        public sonNode(int pos,sonNode next){
            this.pos=pos;
            this.next=next;
        }
    }
    public class Node{//同一层次的节点构成一条链
        String data;
        sonNode first;//    记录第一个子节点
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
        Node c=this.addNode("C",b);
        Node d=this.addNode("D",a);
        System.out.println(deep(a));
        List<Node> list=this.childrenTree(a);
        for (Node n:list){
            System.out.println(n.data);
        }
    }
    public Node treeInit(String data){ //树的根节点
        nodes[0]=new Node(data);
        nodeNum++;
        return nodes[0];
    }
    public Node addNode(String data,Node parent){//给指定父节点添加子节点
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==null){
                nodes[i]=new Node(data);//形成新节点 并保存
                if(parent.first==null){//如果父节点没有子节点
                    parent.first=new sonNode(i,null);// 则将子节点保存在父节点下
                }else {
                    sonNode nextNode=parent.first;//找到父节点下一层次的第一个子节点
                    while(nextNode.next!=null){//找到最后一个子节点
                        nextNode=nextNode.next;
                    }
                    nextNode.next=new sonNode(i,null);//把新的子节点添加到最后
                }
                nodeNum++;
                return nodes[i];
            }
        }
        return null;
    }
    public List<Node> childrenTree(Node parent){
        List<Node> list=new ArrayList<Node>();
        sonNode nextNode=parent.first;//父节点的第一个子节点
        while(nextNode!=null){
            list.add(nodes[nextNode.pos]);
            nextNode=nextNode.next; //下一个子节点
        }
        return list;
    }
    public int deep(Node node){//每棵子树的深度为其所有子树的最大深度 +1
        if(node.first==null){
            return 1; //没有子树 深度为本身
        }else{
            int max=0;
            sonNode nextNode=node.first; //第一个子节点
            while(nextNode!=null){
                //获取以其子节点为根的子树的深度
                int tmp=deep(nodes[nextNode.pos]);
                if(tmp>max){
                    max=tmp;
                }
                nextNode=nextNode.next;//该棵树的下一子节点
            }
            return max+1;
        }
    }
    public int deep(){//返回该树的深度
        return deep(nodes[0]);
    }
}

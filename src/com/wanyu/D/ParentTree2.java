package com.wanyu.D;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2018/1/19.
 */
public class ParentTree2 {
    public class Node{
        private String data;
        private int parent;//用来保存该节点的父节点
        public Node(String data,int parent){
            this.data=data;
            this.parent=parent;
        }
    }
    private int size=100;
    private Node[] nodes=new Node[size];
    private int numberNode;
    @Test
    public void test(){
        Node a=initTree("A");
        Node b=this.addNode("B",a);
        Node c=this.addNode("C",a);
        Node d=this.addNode("D",b);
        List<Node> list=this.childNode(a);
        for(Node n:list){
            System.out.println(n.data);
        }
        System.out.println(this.deep());
    }
    public Node initTree(String data){//树的初始化
        nodes[0]=new Node(data,-1);
        numberNode++;
        return nodes[0];
    }
    public int pos(Node parent){
        for(int i=0;i<size;i++){
            if(nodes[i]==parent){
                return i;  //返回子节点的父节点的索引
            }
        }
        return -1;
    }
    public Node addNode(String data,Node parent){
        for(int i=0;i<size;i++){
            if(nodes[i]==null){
                nodes[i]=new Node(data,pos(parent));
                numberNode++;
                return nodes[i];
            }
        }
        return null;
    }
    public List<Node> childNode(Node parent){//指定父节点下的子节点
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<size;i++){
            if(nodes[i]!=null&&nodes[i].parent==pos(parent)){
                list.add(nodes[i]);//添加的是子节点
            }
        }
        return list;
    }
    public int deep(){//树的深度
        int max=0;
        for(int i=0;i<size;i++){
            int dep=1;
            if(nodes[i]!=null){
                int m=nodes[i].parent;
                while(m!=-1&&nodes[m]!=null){
                    m=nodes[m].parent;
                    dep++;
                }
            }
            if(dep>max){
                max=dep;
            }
        }
        return max;
    }
}

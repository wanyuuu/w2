package com.wanyu.D;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * Created by samsung on 2018/1/19.
 */
public class ParentTree {
    public class Node{
        private String data;//节点数据
        private int parent;//记录父节点的位置
        public Node(String data,int parent){
            this.data=data;
            this.parent=parent;
        }
    }
    private int treeSize=100;//最大节点数量
    private Node [] nodes=new Node[treeSize];//使用数组来保存所有节点
    private int nodeNums;//用来记录节点的数量
    public Node ParentTree(String data){ //树的初始化
        nodes[0]=new Node(data,-1);//根节点
        nodeNums++;
        return nodes[0];
    }
    @Test
    public void test(){
        Node a=this.ParentTree("A");
        Node b=this.addNode("B",a);
        Node c=this.addNode("C",b);
        Node d=this.addNode("D",b);
        Node e=this.addNode("E",d);
        List<Node> list=this.getChildren(b);
        for (Node n:list) {
            System.out.println(n.data);
        }
        System.out.println(deep());
    }
    public int pos(Node node){//返回包含指定值的节点的索引
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==node){
                return i; //找到父节点的数组索引 保存在新节点的parent中
            }
        }
        return -1;
    }
    //给指定父节点添加子节点
    public Node addNode(String data,Node parent){
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==null){//找到第一个空数组 保存新子节点
                nodes[i]=new Node(data,pos(parent));
                nodeNums++;
                return nodes[i];
            }
        }
        return null;
    }
    public Node root(){//返回根节点
        return nodes[0];
    }
    //返回指定节点的所有子节点
    public List<Node> getChildren(Node parent){
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<treeSize;i++){
            if(nodes[i]!=null&&nodes[i].parent==pos(parent)){
                list.add(nodes[i]);
            }
        }
        return list;
    }
    //返回树的深度
    public int deep(){
        int max=0;
        for(int i=0;i<treeSize&&nodes[i]!=null;i++){
            int deep=1;//根节点深度
            int m=nodes[i].parent;//
            while(m!=-1&&nodes[m]!=null){//排除的是根节点 从根节点往下开始找
                m=nodes[m].parent;
                deep++;
            }
            if(deep>max){
                max=deep;
            }
        }
        return max;
    }
}

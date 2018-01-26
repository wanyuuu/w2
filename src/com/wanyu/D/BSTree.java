package com.wanyu.D;

/**
 * Created by samsung on 2018/1/24.
 * 二叉排序树
 */
public class BSTree {
    public class Node{
        String key; //键值
         Node leftNode;
         Node rightNode;
         Node parent;//父节点
        public Node(String key,Node leftNode,Node rightNode,Node parent){
            this.key=key;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
            this.parent=parent;
        }
    }
    public void insert(BSTree tree,Node node){

    }
    public void insert(String key){
        Node node =new Node(key,null,null,null); //头一个节点
        if(node!=null){
            insert(this,node);
        }
    }
    /*
        查找前驱结点 即查找二叉树中数据值小于该节点的最大节点
     */
    public Node preNode(Node node){ //查找该节点的前驱结点
        //存在左子树 则node的前驱结点为以左子树为根的子树的最大节点
        if(node.leftNode!=null){
            return maxNode(node.leftNode);
        }
        Node y=node.parent;//取出该节点父亲 判断是左孩子还是右孩子
        while(y!=null&&y.leftNode==node){//是左孩子
            node=y;
            y=node.parent;//向上继续找
        }
        return y;//不是左孩子 则父节点为前驱结点
    }

    private Node maxNode(Node node) {
        return node;
    }
}

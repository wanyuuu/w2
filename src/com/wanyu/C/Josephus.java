package com.wanyu.C;

import org.junit.Test;

/**
 * Created by samsung on 2018/1/19.
 * 链式约瑟夫环
 */
public class Josephus {
    public class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }
    @Test
    public void init(){
        Node first=new Node(0);
        first.next=first;  //一个元素 首尾相等
        Node last=first;
        int n=5;//人数
        int m=3;//出圈位置
        for(int i=1;i<n;i++){
            last.next=new Node(i);//从第二个人开始
            last=last.next;//移到下一个节点
        }
        last.next=first;//首尾相连成圈
        System.out.println("出圈顺序：");
        //此时last是最后一个节点
        while(last!=last.next){//若剩一个点时 由35行的赋值 相等 所以结束
            for(int i=1;i<m;i++){//仅记录个数
                last=last.next; //最后的last为出圈点的前一个 0 1
            }
            System.out.println("出圈的数字："+last.next.data);//2
            last.next=last.next.next;//从出圈点下一个继续
        }
        System.out.println("幸运者是："+last.data);
    }
}

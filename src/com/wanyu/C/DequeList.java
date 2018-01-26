package com.wanyu.C;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by samsung on 2018/1/16.
 * 链式双向队列
 */
public class DequeList {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<String>();
        list.add("wanyu");
        list.add("lbj");
        list.add("kobe");
        list.push("111");
        list.addFirst("666");//头部插入
        list.addLast("777");//尾部插入
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

package com.wanyu.A;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 * JDK�Դ�stack
 */
public class A {
    @Test
    public void Stack(){
        Stack s=new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
//        Enumeration e=s.elements();//ö��
//        while(e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }
        System.out.println(s.pop());//��ջ Ȼ��ɾ��
        System.out.println(s.peek());//����ջ�� ��ɾ��
    }
}

package com.wanyu.B;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/24.
 */
public class B {
    @Test
    public void myStack(){
        push(1);
        push(2);
        push(3);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
    private Object os[]=new Object[4];
    private int size=0;
    public void push(Object data){//��ջ
        if(size>=os.length){
            resize();
        }
        os[size++]=data;
    }
    public Object pop(){//��ջ
        Object o=os[size-1];//��Ϊ���һ��Ԫ����ջ�� size+1
        os[--size]=null;
        return o;
    }
    public void resize(){//�������
        Object oj[]=new Object[os.length*2];
        for(int i=0;i<os.length;i++){
            oj[i]=os[i];
            os[i]=null;
        }
        os=oj;
    }
    public Object peek(){
        Object o=os[size-1];
        return o;
    }
}

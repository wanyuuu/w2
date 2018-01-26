package com.wanyu.A;

import org.junit.Test;

/**
 * Created by samsung on 2017/9/22.
 * ??Object???? ??§ÕStack
 */
public class B {
    @Test
    public void test(){
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
    }
    private Object os[]=new Object[2];
    private int size=0;

    public void push(Object data){
        if(size>=os.length){
            resize();
        }
        os[size++]=data;
    }
    public Object pop(){
        Object o=os[size-1];
        os[--size]=null;//?????????
        return o;
    }
    public Object peek(){
        Object o=os[size-1];//?????0??? ????????????????1
        return o;
    }
    public void resize(){
        Object tmp[]=new Object[os.length*3];
        for(int i=0;i<os.length;i++){
            tmp[i]=os[i];
            os[i]=null;//os?????????
        }
        os=tmp;//??tmp??????os os????????? ??????????
    }
}

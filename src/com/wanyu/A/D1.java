package com.wanyu.A;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 * �Ͻ�˹����˫ջ�㷨 ������ʽ
 */
public class D1 {
    public static void main(String[] args) {
        D1 d=new D1();
        System.out.println(d.myStack("(((5-2)*(2+1))+((4/2)*1))"));
    }
    public Integer myStack(String data){
        Stack<Integer> vals=new Stack<Integer>();
        Stack<Character> op=new Stack<Character>();
        Integer v=null;
        char c;
        char cs[]=data.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='+'){
                op.push(cs[i]);
            }else if(cs[i]=='-'){
                op.push(cs[i]);
            }else if(cs[i]=='*'){
                op.push(cs[i]);
            }else if(cs[i]=='/'){
                op.push(cs[i]);
            }else if(cs[i]=='('){

            }else if(cs[i]==')'){
                 c=op.pop();//��������ջ
                 v=vals.pop();//��������ջ
                if(c=='+'){
                    v=vals.pop()+v;
                }else if(c=='-'){
                    v=vals.pop()-v;
                }else if(c=='*'){
                    v=vals.pop()*v;
                }else if(c=='/'){
                    v=vals.pop()/v;
                }
                vals.push(v);//ÿ����һ�κ�����ջ
            }
            else {
                vals.push(Integer.parseInt(cs[i]+""));//û�����κβ����� ��������ջ
            }
        }
        return v;
    }
}

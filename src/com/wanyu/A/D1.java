package com.wanyu.A;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 * 迪杰斯特拉双栈算法 计算表达式
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
                 c=op.pop();//操作符弹栈
                 v=vals.pop();//运算数弹栈
                if(c=='+'){
                    v=vals.pop()+v;
                }else if(c=='-'){
                    v=vals.pop()-v;
                }else if(c=='*'){
                    v=vals.pop()*v;
                }else if(c=='/'){
                    v=vals.pop()/v;
                }
                vals.push(v);//每运算一次后结果入栈
            }
            else {
                vals.push(Integer.parseInt(cs[i]+""));//没遇到任何操作符 运算数入栈
            }
        }
        return v;
    }
}

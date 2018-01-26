package com.wanyu.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 */
public class D {
    @Test
    public void Test(){
        Stack<Integer> vals=new Stack<Integer>();//运算数
        Stack<Character> op=new Stack<Character>();//操作符
        String s="(((2+3)+(2*4))+(3+1))";
        char cs[]=s.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='+'){
                op.push(cs[i]);
            }else if (cs[i]=='-'){
                op.push(cs[i]);
            }else if (cs[i]=='*'){
                op.push(cs[i]);
            }else if(cs[i]=='/'){
                op.push(cs[i]);
            }else if(cs[i]=='('){ //没有操作

            }else if(cs[i]==')'){
                Integer v=vals.pop();//运算数弹出
                char c=op.pop();//操作符弹出
                if(c=='+'){
                    v=v+vals.pop();
                }else if(c=='-'){
                    v=vals.pop()-v;
                }else if(c=='*'){
                    v=vals.pop()*v;
                }else if(c=='/'){
                    v=vals.pop()/v;
                }
                vals.push(v);//每运算完一次再压入栈中
            }else {
                vals.push(Integer.parseInt(cs[i]+""));//运算数压入栈中
            }
        }
        System.out.println(vals.pop());
    }
}

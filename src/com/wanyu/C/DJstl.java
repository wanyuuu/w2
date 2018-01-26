package com.wanyu.C;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2018/1/15.
 * 迪杰斯特拉算法
 */
public class DJstl {
    Stack<Integer> vals=new Stack<Integer>();
    Stack<Character> op=new Stack<Character>();
    String str="((5-(2+1))+(2*3))";
    @Test
    public void test(){
        System.out.println(djstl(str));
    }
    public int djstl(String str){
        char a[]=str.toCharArray();
        for(int i=0;i<a.length;i++){
            if(a[i]=='+'){
                op.push(a[i]);
            }else if(a[i]=='-'){
                op.push(a[i]);
            }else if(a[i]=='*'){
                op.push(a[i]);
            }else if(a[i]=='/'){
                op.push(a[i]);
            }else if(a[i]=='('){
                //没有操作
            }else if(a[i]==')'){
                int val=vals.pop();
                char o=op.pop();
                if(o=='+'){
                    val=vals.pop()+val;
                }else if(o=='-'){
                    val=vals.pop()-val;
                }else if(o=='*'){
                    val=vals.pop()*val;
                }else if(o=='/'){
                    val=vals.pop()/val;
                }
                vals.push(val);//每次运算完结果压入栈中
            }else {
                vals.push(Integer.parseInt(a[i]+""));//运算数压入栈中
            }
        }
        return vals.pop();
    }
}

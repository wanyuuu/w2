package com.wanyu.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by samsung on 2017/9/22.
 */
public class D {
    @Test
    public void Test(){
        Stack<Integer> vals=new Stack<Integer>();//������
        Stack<Character> op=new Stack<Character>();//������
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
            }else if(cs[i]=='('){ //û�в���

            }else if(cs[i]==')'){
                Integer v=vals.pop();//����������
                char c=op.pop();//����������
                if(c=='+'){
                    v=v+vals.pop();
                }else if(c=='-'){
                    v=vals.pop()-v;
                }else if(c=='*'){
                    v=vals.pop()*v;
                }else if(c=='/'){
                    v=vals.pop()/v;
                }
                vals.push(v);//ÿ������һ����ѹ��ջ��
            }else {
                vals.push(Integer.parseInt(cs[i]+""));//������ѹ��ջ��
            }
        }
        System.out.println(vals.pop());
    }
}

package Algos.String;

import java.util.*;

class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<Character>();
        char[] charArr = s.toCharArray();
        for (int i=0; i<charArr.length; i++){
            if(charArr[i]=='(' || charArr[i]=='{' || charArr[i]=='[') stk.push(charArr[i]);
            else if(charArr[i]==')' && (stk.isEmpty() || stk.pop()!='(')) return false;
            else if(charArr[i]=='}' && (stk.isEmpty() || stk.pop()!='{')) return false;
            else if(charArr[i]==']' && (stk.isEmpty() || stk.pop()!='[')) return false;
        }
        return stk.size() ==0;
    }


    public static void main(String[] args){

    }
}
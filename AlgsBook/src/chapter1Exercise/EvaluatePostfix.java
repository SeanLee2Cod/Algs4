package chapter1Exercise;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class EvaluatePostfix {

    public static void main(String[] args) {
      Stack<Integer>stack=new Stack<Integer>();
      @SuppressWarnings("resource")
    Scanner scn=new Scanner(System.in);
      String str=null;
      int a=0;
      int b=0;
      while(scn.hasNext()){
        str=scn.next();
        if(str.equals("+")){
            if(!stack.isEmpty())
            stack.push(stack.pop()+stack.pop());
        }
        else if(str.equals("-")){
            if(!stack.isEmpty()){
             a=stack.pop();
             b=stack.pop(); 
             stack.push(b-a);
           }
        }
        else if(str.equals("*")){
            if(!stack.isEmpty())
            stack.push(stack.pop()*stack.pop());
        }
        else if(str.equals("/")){
            if(!stack.isEmpty()){
              a=stack.pop();
              b=stack.pop();
              stack.push(b/a);
            }
        }
       else{
           stack.push(Integer.parseInt(str));
       }
     }
      if(!stack.isEmpty())
      System.out.println(stack.pop());
   }
}

package chapter1Exercise;



import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;


public class InfixToPostfix {
    
    public static void main(String[] args) {
      Stack<String>stack =new Stack<String>();
      String str=null;
      while(!StdIn.isEmpty()){
         str=StdIn.readString();
        if(str.equals("(")){
            stack.push(str);
        }
        else if(str.equals("+")){
            while(!stack.isEmpty()&&stack.peek()!="("&&higherPriority(str,stack.peek())){
             System.out.print(stack.pop()+" ");  
            }
          stack.push(str);
        }
        else if(str.equals("-")){
            while(!stack.isEmpty()&&stack.peek()!="("&&higherPriority(str,stack.peek())){
                System.out.print(stack.pop()+" ");  
               }
             stack.push(str); 
        }
        else if(str.equals("*")){
            while(!stack.isEmpty()&&stack.peek()!="("&&higherPriority(str,stack.peek())){
                System.out.print(stack.pop()+" ");  
               }
             stack.push(str); 
        }
        else if(str.equals("/")){
            while(!stack.isEmpty()&&stack.peek()!="("&&higherPriority(str,stack.peek())){
                System.out.print(stack.pop()+" ");  
               }
             stack.push(str); 
        }
        else if(str.equals(")")){
          while(!stack.isEmpty()&&!stack.peek().equals("(")){
              System.out.print(stack.pop()+" ");
          } 
         if(!stack.isEmpty())
           stack.pop();
        }
        else{
            System.out.print(str+" ");
        }
      }
    }
    //to determine priority
    public static boolean higherPriority(String str, String peek) {
        int a=change(str); 
        int b=change(peek);
        if(a<=b)
        return true;
        else
        return false;
    }
    //Giving different operator different value which means priority 
    public static int change(String str) {
        if(str.equals("+")){
          return 1;
        }
        if(str.equals("-")){
          return 1;
        }
        if(str.equals("*")){
          return 2;
        }
        if(str.equals("/")){
           return 2;
        }
        return 0;
}
}

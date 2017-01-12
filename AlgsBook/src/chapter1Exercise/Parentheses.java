package chapter1Exercise;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
    private static final char Left_Bracket='(';
    private static final char Left_Paren='[';
    private static final char Left_Brace='{';
    private static final char Right_Braket=')';
    private static final char Right_Paren=']';
    private static final char Right_Brace='}';
    
    public static boolean ToJudge(String str) {
        char[]s=str.toCharArray();
        Stack<Character> st=new Stack<Character>();
        for (int i = 0; i < s.length; i++) {
           switch(s[i]){
           case(Left_Bracket):st.push(s[i]); break;
           case(Left_Paren):st.push(s[i]); break;
           case(Left_Brace):st.push(s[i]);break;
           case(Right_Braket):
               if(st.isEmpty())
                   return false;
               if(st.pop()!=Left_Bracket) 
                   return false;
                   break;
           case(Right_Paren):
               if(st.isEmpty())
                   return false;
               if(st.pop()!=Left_Paren) 
                   return false;
                   break;
           case(Right_Brace):
               if(st.isEmpty())
                   return false;
               if(st.pop()!=Left_Brace) 
                   return false;
                   break;
           default:
               return false;
           
           }
        }
        return st.isEmpty();
    } 
    public static void main(String[] args) {
      @SuppressWarnings("resource")
    Scanner scn =new Scanner(System.in);
      String str=scn.nextLine();
      boolean result=ToJudge(str);
      System.out.println(result);
    }

   

}

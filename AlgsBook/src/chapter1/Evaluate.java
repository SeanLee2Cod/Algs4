package chapter1;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
	//haha
     public static void main(String[]args){
    	 Stack<String>ops=new Stack<String>();
    	 Stack<Double>vals=new Stack<Double>();
    	 StdOut.println("Please input the calculation circled with brace and with a space between them: ");
    	 while(!StdIn.isEmpty()){
    		 String s=StdIn.readString();
    		 if(s.equals("(")) ;
    		 else if(s.equals("+"))  ops.push(s);
    		 else if(s.equals("-"))  ops.push(s);
    		 else if(s.equals("*"))  ops.push(s);
    		 else if(s.equals("/"))  ops.push(s);
    		 else if(s.equals("sqrt"))  ops.push(s);
    		 else if(s.equals(")")){
    		   String s1=ops.pop();
    		   double v=vals.pop();
    		   if(s1.equals("+")) v=vals.pop()+v;
    		   else if(s1.equals("-")) v=vals.pop()+v;
    		   else if(s1.equals("*")) v=vals.pop()*v;
    		   else if(s1.equals("/")) v=vals.pop()/v;
    		   else if(s1.equals("sqrt")) v=Math.sqrt(v);
               vals.push(v);    			 
    		 }
    		 else vals.push(Double.parseDouble(s));
    	 }
    	 StdOut.println(vals.pop());
     }
}

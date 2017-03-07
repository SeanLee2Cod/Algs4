package chapter1Exercise;

import java.util.Scanner;

public class ReverseLinkList {
    private static class Node{
        int number;
        Node next;
    }
    
    public static void main(String[] args) {
      Node first=null;
      Node last = null;
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=0;i<n;i++){
       //使用链表存储数据
        Node c=new Node();
        c.number=scn.nextInt();
        if(first==null){
           first=c;
        }else{
           last.next=c;
        }
        last=c;
     }
      //非空表的最后一个节点的指针域为null
      if(last!=null){
          last.next=null;
       }
      scn.close();
      //输出原链表的顺序输出值
      for(Node node=first;node!=null;node=node.next){
          System.out.print(node.number+" ");
      }
      System.out.println();
      //调用函数倒序
      Node reverseList=reverse(first);
      //倒序输出
      for(Node node=reverseList;node!=null;node=node.next){
          System.out.print(node.number+" ");
      }
    }

    public static Node reverse(Node first) {
      Node p=first;
      Node reverse=null;
      while(p!=null){
          Node second=p.next;
          p.next=reverse;
          reverse=p;
          p=second;
      }
      return reverse;
   }
}




package chapter1Exercise;

import java.util.Scanner;

public class DoubleNode {
    private static class Node{
        int number;
        Node prior;
        Node next;
    }
    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      //初始化带头结点的链表
      Node first=new Node(); 
      first.prior=null;//对于非循环的双向链表而言，头指针的前驱为空
      first.next=null;
      Node last=first;
      //采用头插法插入元素
      for (int i = 0; i < n; i++) {
         Node c=new Node();
         c.number=scn.nextInt();
         last.next=c;
         c.prior=last;
         last=c;
      }
      scn.close();
      //尾指针的后继为空
     last.next=null;
    System.out.println("未插入删除前：");
    for (Node node=first.next;node!=null;node=node.next) {
        System.out.print(node.number+" ");
    }
    System.out.println();
    //在表头插入节点
    Node list1=insertList(first,1,8);
    System.out.println("在表头插入后：");
    for (Node node=list1.next;node!=null;node=node.next) {
        System.out.print(node.number+" ");
    }
    System.out.println();
    //在指定位置插入节点
    Node list2=insertList(first,2,8);
    System.out.println("在指定位置插入后：");
    for (Node node=list2.next;node!=null;node=node.next) {
        System.out.print(node.number+" ");
    }
    System.out.println();
    //删除指定位置节点
    Node list3=listDelete(first,2);
    System.out.println("在指定位置删除后：");
    for (Node node=list3.next;node!=null;node=node.next) {
        System.out.print(node.number+" ");
    }
 }
    
    public static Node listDelete(Node first, int i) {
       Node p=first;
       //找到被删除的第i个节点的前一个节点
       int j=0;
       while(p.next!=null&&j<i-1){
           p=p.next;
           j++;
       }
       if(p.next==null){
           return null;
       }
       p.next=p.next.next;
       p.next.prior=p;
       return first;
    }

    public static Node insertList(Node first, int i, int e) {
        Node p=first;
        int j=0;
        //要想在第i个节点前插入，就必须找到第i-1个节点
        while(p.next!=null&&j<i-1){
            p=p.next;
            j=j+1;
        }
        if(p.next==null){
            return null;
        }  
        Node s=new Node();
        s.number=e;
        s.next=p.next;
        p.next=s;
        s.next.prior=s;
        s.prior=p;
        return first;
    }

}

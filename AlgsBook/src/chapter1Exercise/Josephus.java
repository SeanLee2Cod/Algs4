package chapter1Exercise;

import java.util.Scanner;

import chapter1.Queue;

public class Josephus {
    //使用队列可以使约瑟夫环问题变得异常简单
    public static void main(String[] args) {
      Queue<Integer> queue=new Queue<Integer>();      
      Scanner scn=new Scanner(System.in);
      
      int n=scn.nextInt();
      int m=scn.nextInt();
      scn.close();
      for (int i = 0; i < n; i++) {
        queue.enQueue(i); 
      }
      
      while(queue.size()!=0){
          for (int i = 0; i < m-1; i++) {
             queue.enQueue(queue.deQueue());
          }
          System.out.print(queue.deQueue()+" ");
      }
      
    }

}

package chapter1Exercise;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

    public static void main(String[] args) {
      Bag<Double>numbers=new Bag<Double>();
      while(!StdIn.isEmpty()){
          numbers.add(StdIn.readDouble());
      }
      int N=numbers.size();
      double sum=0.0;
      for(double x:numbers){
          sum=sum+x;
      }
      double mean=sum/N;
      
      sum=0.0;
      for (double double1 : numbers) {
        sum=sum+(double1-mean)*(double1-mean);
    }   
    double stddev=Math.sqrt(sum/(N-1));
    StdOut.printf("Mean:%.2f\n",mean);
    StdOut.printf("Stddev:%.2f\n", stddev);
    }
}

package chapter1Exercise;

import java.util.Scanner;

public class AccumulatorDemo {
    private int N;
    private double m;
    private double s;
    //Accumulating to get s and m
    public void addDataValue(double x){
        N++;
        s=s+1.0*(N-1)/N*(x-m)*(x-m);
        m=m+(x-m)/N;
    }
    //To get mean
    public double mean(){
        return m;
    }
    //To get variance
    public double var(){
        return s/(N-1);
    }
    //To get standard deviation
    public double stddev(){
        return Math.sqrt(var());
    }
    
    public static void main(String[] args) {
      AccumulatorDemo  ald=new AccumulatorDemo();
      double[]a=new double[10];
      Scanner scn=new Scanner(System.in);
      //rotation input 
      for (int i = 0; i < a.length; i++) {
        a[i]=scn.nextDouble();
        ald.addDataValue(a[i]);
      }
      scn.close();
      System.out.println("The mean:"+ald.mean());
      System.out.println("The variance:"+ald.var());
      System.out.println("The standard deviation:"+ald.stddev());
    }

}

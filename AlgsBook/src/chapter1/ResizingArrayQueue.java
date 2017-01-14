package chapter1;

import java.util.Iterator;
//the construction of queue
public class ResizingArrayQueue<Item>implements Iterable<Item> {
    private Item[] a;
	private int N=0;
	private int head=0;
	private int tail=0;
	//initializing an Array as data structure
	public ResizingArrayQueue(){
      a=(Item[])new Object[1];//special initializing method for generics for Java 		
	}
	//Queue Api:isEmpty()
	public boolean isEmpty(){
	  return N==0;
	}
    //Queue Api:size()
	public int size(){
    	return N;
    }	
	//enqueue operation,Moving tail back and Adding N
    public void enqueue(Item item){
	  if(N==a.length) reSize(2*N);
	  if(tail==a.length) tail=0;
	  a[tail++]=item;
	  N++;
	}
	//resize array's scale
	private void reSize(int i) {
      @SuppressWarnings("unchecked")
	Item[] temp=(Item[])new Object[i];
      for (int j = 0; j < N; j++) {
		temp[j]=a[(head+j)%a.length];
	  }
      a=temp;
      head=0;
      tail=N;
	}
    //dequeue operation,Moving head back and substracting N
	public Item dequeue(){
	  Item t=a[head];
	  a[head]=null;
	  if(N==a.length/4) reSize(a.length/2);
	  head++;
	  N--;
	  return t; 
	}
	//implement Iterable's iterator() to get iterator
	public Iterator<Item> iterator() {
		return new ReisizingQueueIterator();
	}
   //completing a inner class to visit main class straightly
class ReisizingQueueIterator implements Iterator<Item>{
    //Just use it,don't need to change N or head in ResizingArrayQueue
	int i=N;
    int j=head;
	public boolean hasNext() {
		return i>0;
	}
	public Item next() {
		return a[j++];
	}
 }
}

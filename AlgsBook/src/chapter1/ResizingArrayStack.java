package chapter1;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;
    public ResizingArrayStack(){
    	a=(Item[])new Object[1];
    }
    public boolean isEmpty(){ return N==0;}
    
    public int size(){ return N; }

    public void push(Item item){
      if(N==a.length) reSize(2*N);
      a[N++]=item;  
    }
    
    public Item pop(){
      Item temp=a[--N];
      a[N]=null;
      if(N>0&&N==a.length/4) reSize(a.length/2);
      return temp;
    }
    
	private void reSize(int i) {
      @SuppressWarnings("unchecked")
    Item[]temp=(Item[])new Object[i];
      for (int j = 0; j < a.length; j++) {
		temp[j]=a[j];
	  }
      a=temp;
	}
	public Iterator<Item> iterator() {
		return new ResizingArrayIterator();
	}
 class ResizingArrayIterator implements Iterator<Item>{
    int i=N;
	public boolean hasNext() {
         
		 return i>0;
	}

	public Item next() {
		return a[--i];
	}
  }   
 }

package chapter1;

import java.util.Iterator;
/**
 * @author a1477
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
    private class Node{
      Item item;
      Node next;
    }
    private Node first;
    private Node last;
    private int N;
    
    /**
     * To judge whether Linkedlist is empty or not
     * @return 
     */
    public boolean isEmpty(){ return first==null;}
    
    /**
     * @return length of Linkedlist
     */
    public int size(){ return N;}
    /**
     *this enQueue method is special for if...else
     * @param item
     */
    public void enQueue(Item item){
      Node oldlast=last;
      last=new Node();
      last.item=item;
      last.next=null;
      if(isEmpty()){ 
    	first=last;
      }
      else{
    	oldlast.next=last;
      }
      N++;
    }
    
    public Item deQueue(){
      Item item=first.item;
      first=first.next;
      if(isEmpty()){
    	last=null;//To avoid object loitering
      }
      N--;
      return item;
    }
	//implement method
    public Iterator<Item> iterator() {
		return new ListLiterator();
	}
	
  //Inner class for easy visit Queue's private members
class ListLiterator implements Iterator<Item>{
    Node temp=first;
    //implement method
	public boolean hasNext() {
		return temp!=null;
	}
	//implement method
	public Item next() {
	  Item item=temp.item;
	  temp=temp.next;
      return item;
	}
}
}

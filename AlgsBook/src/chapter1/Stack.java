package chapter1;

import java.util.Iterator;

public class Stack<Item>implements Iterable<Item> {
   //the sign of linkedlist
	private class Node{
      Item item;
      Node next;
    }
    private Node first;//the first element of the linkedlist
    private int N;
   
    public boolean isEmpty(){
      return first==null;
    }
	
    public int size(){
      return N;		
	}
   	
	public void push(Item item){
	  Node oldfirst=first;
	  first=new Node();
	  first.item=item;
	  first.next=oldfirst;
	  N++;	
	}
   
	public Item pop(){
	  Item temp=first.item;
	  first=first.next;
	  N--;
	  return temp;
	}
	public Item peep(){
	  return first.item;
	}
	public Iterator<Item> iterator() {
		return new ListLterator();
	}
    
class ListLterator implements Iterator<Item>{
    Node temp=first;
	public boolean hasNext() {
		return temp!=null;
	}

	public Item next() {
      Item item=temp.item;
      temp=temp.next;
      return item;		
	}
  }
}

package chapter1;

import java.util.Iterator;

/**
 * @author a1477
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
  private class Node{
	Item item;
	Node next;
  }
  private int N;
  private Node first;
  
  public boolean isEmpty(){
	  return N==0;
  }
  
  public int size(){
	return N;
  }
//To add new object to bag.
  public void add(Item item){
	  Node oldfirst=first;
	  first=new Node();
	  first.next=oldfirst;
	  N++;
  }  
  //implement method
  public Iterator<Item> iterator() {  
	  return new ListLiterator();
 }
//Inner class for easy visit Bag's private members
class ListLiterator implements Iterator<Item>{
    Node current=first;
	//implement method
    public boolean hasNext() {
		return current!=null;
	}
    //implement method
	public Item next() {
    Item temp=current.item;
    current=current.next;
    return temp;
	}}
  
 
}

package chapter1;

public class FixedCapacityStack<Item> {
  private Item[]a;
  private int N;
  @SuppressWarnings("unchecked")
public FixedCapacityStack(){
    a=(Item[])new Object[1];	  
  }
  public boolean isEmpty(){
	return N==0;
  }
  public int size(){
	  return N;
  }
  public void push(Item item){
	a[N++]=item;
	if(N==a.length){
		reSize(2*N);
	}
  }
  private void reSize(int i) {
  @SuppressWarnings("unchecked")
Item[] temp=((Item[])new Object[i]);
  for (int j = 0; j < a.length; j++) {
	temp[j]=a[j];
  }
  a=temp;
}
  public Item pop(){
    Item item=a[--N];
    a[N]=null;//±ÜÃâ¶ÔÏóÓÎÀë
    if(N>0&&N==a.length/4){
	  reSize(a.length/2);
    }
    return item;
}  
  
  
  
}

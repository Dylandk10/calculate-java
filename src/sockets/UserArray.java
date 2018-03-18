package sockets;

public class UserArray<T> {
	protected int sp; // empty stack
	protected T[] head; // array
	private int size;

	@SuppressWarnings("unchecked")
	 public UserArray() {
		sp = -1;
	    size = 24; // sets the default size of the stack
	    head = (T[]) new Object[size];
	 }

	 public boolean isFull() {
		 return sp == this.size -1;
	 }

	 public boolean isEmpty() {
	    return sp == -1;
	 }

	 public void push(T t) {
		 if(!isFull())
	       head[++sp] = t;
		 System.out.println(t + " Created");
	 }

	 public T pop() {
		if (isEmpty()) {
			return null;
	     } else
	       return head[sp--]; // LINE 30
	 }
	 public int size() {
		 return head.length;
	 }
	 public T getHead(int i) {
		 return head[i];
	 }
	 public T[] returnUsers() {
		 return head;
	 }
}

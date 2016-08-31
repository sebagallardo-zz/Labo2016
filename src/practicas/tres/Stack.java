package practicas.tres;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack {

	private ArrayList<Object> items;
	
	public Stack() {
		super();
		items = new ArrayList<Object>();
	}

	public void push(Object item){
		items.add(item);
	}
	
	public Object pop(){
		return items.remove(0);
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public void finalize(){
		
	}
	
	public StackIterator getIterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Object>{
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return items.size() > index;
		}

		@Override
		public Object next() {
			return items.get(index++);
		}
		
	}
	
	public static void main(String[] args) {
		Stack pila = new Stack();
		pila.push("1");
		pila.push("2");
		pila.push("3");
		pila.push("4");
		
		Iterator<Object> iterator = pila.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		iterator = pila.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

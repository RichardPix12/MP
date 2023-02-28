package uo.mp.collections.impl;

import uo.mp.collections.List;

public class ArrayList implements List {
	
	private final static int INITIAL_CAPACITY = 20;
	private Object[] elements;
	private int numberOfElements;

	@Override
	public int size() {
		return numberOfElements; 
	}

	@Override
	public boolean isEmpty() {
		for(int i=0; i<elements.length;i++) {
			if(i==0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		for(int i=0; i<elements.length;i++) {
			if(i!=0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Object element) {
		if (size() >= elements.length)
			moreMemory(size()+1);
		elements[size()] = element;
		numberOfElements++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		 int index=indexOf(o);
	        if(index==-1) {
	            return false;
	        }
	        remove(index);
	        return true;
	}

	@Override
	public void clear() {
		if(isEmpty()) {
			return;
		}
		 for(int i=0; i<size(); i = 0) {
	            remove(i);
	        }
		

	}

	@Override
	public Object get(int index) {
		return elements[index];

	}

	@Override
	public Object set(int index, Object element) {
		return elements[index]=element;
	}

	@Override
	public void add(int index, Object element) {
		if (size() >= elements.length)
			moreMemory(size()+1);
			for(int i=size(); i>index; i--)
			elements[i] = elements[i-1];
			elements[index] = element;
			numberOfElements++;


	}

	@Override
	public Object remove(int index) {
		Object value = elements[index];
		for(int j=index; j<size()-1; j++)
		elements[j] = elements[j+1];
		numberOfElements--;
		return value;
	}

	@Override
	public int indexOf(Object o) {
		for(int i=0;i<size();i++)
			if(o.equals(elements[i]))
				return i;
		return -1;
	}
	
	private void moreMemory(int numElem) {
		if (numElem > elements.length) {
		Object[] aux = new Object[Math.max( numElem,
		2*elements.length)];
		System.arraycopy(elements, 0, aux, 0,
		elements.length);
		elements=aux;
		}
		}
}

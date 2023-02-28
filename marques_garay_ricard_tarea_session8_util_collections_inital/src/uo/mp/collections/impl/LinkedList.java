package uo.mp.collections.impl;

import uo.mp.collections.List;

public class LinkedList implements List {
	private Node head;
	private int numberOfElements;


	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object element) {
		if (isEmpty()) {
			addFirst(element);
		}
		else {
			Node last = getNode(size()-1);
			last.next = new Node(element, null);
			numberOfElements++;
			}
		return true;
	}

	private void addFirst(Object element) {
		head = new Node(element, head);
		numberOfElements++;
		
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
		head=null;
		numberOfElements=0;

	}

	@Override
	public Object get(int index) {
		return getNode(index).element;
	}

	@Override
	public Object set(int index, Object element) {
		Object previousValue=getNode(index).element;
		getNode(index).element = element;
		return previousValue;

	}

	@Override
	public void add(int index, Object element) {
		if (isEmpty()) {
			addFirst(element);
		}
		else {
			Node last = getNode(size()-index);
			last.next = new Node(element, null);
			numberOfElements++;
		}
		

	}

	@Override
	public Object remove(int index) {
		if (isEmpty())
			return null;
		Object value;
		if (index == 0) {
			value = head.element;
			head = head.next;
		} 
		else {
			Node previous = getNode(index - 1);
			value = previous.next.element;
			previous.next = previous.next.next;
		}
		numberOfElements--;
		return value; 
	}

	@Override
	public int indexOf(Object o) {
		Node temp=head;
		for(int i=0;i<size();i++) {
			if(o.equals(temp))
				return i;
			temp=temp.next;
		}
		return -1;
	}
	private class Node{
		Object element;
		Node next;
		Node(Object element, Node next){
			this.element = element;
			this.next = next;
			
		}
	}
	private Node getNode(int index) {
		int position = 0;
		Node node = head;
		while (position < index) {
		node = node.next;
		position++;
		}
		return node;
		}

}

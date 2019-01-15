package com.zuehlke.testing.testdoubles.examples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListStub<E> implements List<E> {

	@Override
	public int size() {
		return 10;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean add(E arg0) {
		return true;
	}

	@Override
	public void add(int arg0, E arg1) {
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		return true;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object arg0) {
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return true;
	}

	@Override
	public E get(int arg0) {
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		return true;
	}

	@Override
	public E remove(int arg0) {
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return true;
	}

	@Override
	public E set(int arg0, E arg1) {
		return arg1;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return null;
	}

}
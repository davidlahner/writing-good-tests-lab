package com.zuehlke.testing.testdoubles.examples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DummyList<E> implements List<E> {

	@Override
	public int size() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean add(E arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public void add(int arg0, E arg1) {
		throw new UnsupportedOperationException("not implemented!");

	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public E get(int arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public int indexOf(Object arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public int lastIndexOf(Object arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public E remove(int arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public E set(int arg0, E arg1) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("not implemented!");
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("not implemented!");
	}

}
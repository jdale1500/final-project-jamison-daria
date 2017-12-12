package edu.luc.cs271.myhashmap;
// small

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements IStack<E> {

  /** The topmost node of this stack. The stack gets pushed down from here. */
  private Node<E> top;

  private int size = 0;

  // Done why don't we need an explicit constructor? Linked list has already been implemented

  @Override // done
  public E push(final E obj) {
    Node<E> temps = top;
    top = new Node<>(obj);
    top.next = temps;
    return obj;
  }

  @Override
  public E peek() {
    // Done
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      return top.data;
    }
  }

  @Override
  public E pop() {
    // Done
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      E done = top.data;
      top = top.next;
      size = size - 1;
      return done;
    }
  }

  @Override
  public boolean isEmpty() {
    if (top != null) {
      return false;
    }
    return true;
  }

  @Override
  public List<E> asList() {
    // Done implement using an ArrayList preallocated with the right size
    // Done add any instance variable(s) required to support this
    Node<E> done = top;
    final ArrayList<E> more = new ArrayList<>(size);
    while (done != null) {
      more.add(done.data);
      done = done.next;
    }
    return more;
  }
}

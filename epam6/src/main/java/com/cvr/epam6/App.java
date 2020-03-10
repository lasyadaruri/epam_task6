package com.cvr.epam6;

import java.util.Arrays;

public class App<E> 
{
 int size = 0;
 int DEFAULT_CAPACITY = 10;
 Object elements[];
 public App() {
  elements = new Object[DEFAULT_CAPACITY];
 }
 public void add(E e) {
  if (size == elements.length) {
   ensureCapacity();
  }
  elements[size++] = e;
 }
 @SuppressWarnings("unchecked")
public E get(int i) {
  if (i >= size || i < 0) {
   throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
  }
  return (E) elements[i];
 }
 @SuppressWarnings("unchecked")
 public E remove(int i) {
  if (i >= size || i < 0) {
   throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
  }
  Object item = elements[i];
  int numElts = elements.length - ( i + 1 ) ;
  System.arraycopy( elements, i + 1, elements, i, numElts ) ;
  size--;
  return (E) item;
 }
 public int size() {
  return size;
 }
 @Override
 public String toString() 
 {
   StringBuilder sb = new StringBuilder();
   sb.append('[');
   for(int i = 0; i < size ;i++) {
    sb.append(elements[i].toString());
    if(i<size-1){
     sb.append(",");
    }
   }
   sb.append(']');
   return sb.toString();
 }
 
 public void ensureCapacity() {
  int newSize = elements.length * 2;
  elements = Arrays.copyOf(elements, newSize);
 }
//Main class
 public static void main(String[] args) 
 {
  App<Integer> l = new App<>();
  l.add(10);
  l.add(20);
  l.add(30);
  System.out.println(l);
  l.remove(2);
  System.out.println(l);
  System.out.println(l.get(1));
  System.out.println(l.get(2));
  System.out.println(l.size());
 }
}

package com.example.module_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    private int size;

    private static class Node<T> {
        T value;
        MyLinkedList.Node<T> next;
        MyLinkedList.Node<T> prev;

        Node(MyLinkedList.Node<T> prev, T value, MyLinkedList.Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList(){
    }

    public void add(T t){
        addLast(t);
    }

    public void add(int index, T t){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(t);
        else if (index == size) addLast(t);
        else {
            Node<T> node = node(index);
            Node<T> newNode = new Node<>(node.prev, t, node);
            node.prev = newNode;
        }
    }

    private void addFirst(T t){
        Node<T> f = first;
        Node<T> node = new Node<>(null, t, f);
        first = node;
        if (f == null)
            last = node;
        else
            f.prev = node;
        size++;
    }

    private void addLast(T t){
        Node<T> l = last;
        Node<T> node = new Node<>(l, t, null);
        last = node;
        if (l == null)
            first = node;
        else
            l.next = node;
        size++;
    }

    public Node<T> node(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index < size/2){
            Node<T> node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        } else{
            Node<T> node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
            return node;
        }
    }

    public T get(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index < size/2){
            Node<T> node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node.value;
        } else{
            Node<T> node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
            return node.value;
        }
    }

    public T remove(){
        return removeFirst();
    }

    public T remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<T> node = node(index);
            final Node<T> prev = node.prev;
            final T value = node.value;
            final Node<T> next = node.next;
            node.prev = null;
            node.value = null;
            node.next = null;
            prev.next = next;
            next.prev = prev;
            size--;
            return value;
        }

    }

    private T removeFirst(){
        Node<T> node = first;
        if (node == null)
            throw new NoSuchElementException();
        final T value = node.value;
        final Node<T> next = node.next;
        node.value = null;
        node.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return value;
    }

    private T removeLast(){
        Node<T> node = last;
        if (node == null)
            throw new NoSuchElementException();
        final T value = node.value;
        final Node<T> prev = node.prev;
        node.value = null;
        node.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return value;
    }

    public void addAll(){

    }
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<T> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") T e = (T) o;
            Node<T> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        return true;
    }
}

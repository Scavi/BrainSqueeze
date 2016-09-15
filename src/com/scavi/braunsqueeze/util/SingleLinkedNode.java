package com.scavi.braunsqueeze.util;

/**
 * Created by Scavenger on 15/09/16.
 */
public class SingleLinkedNode<T> {

    private final T _value;
    private SingleLinkedNode<T> _next;


    public SingleLinkedNode(final T value) {
        this(value, null);
    }


    public SingleLinkedNode(final T value, final SingleLinkedNode<T> next) {
        _value = value;
        _next = next;
    }


    public T getValue() {
        return _value;
    }


    public void setNext(final SingleLinkedNode<T> next) {
        _next = next;
    }


    public SingleLinkedNode<T> getNext() {
        return _next;
    }
}

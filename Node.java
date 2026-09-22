package com.mycompany.riyadhmetromanagmentsystem;
public class Node<E> {
private E element;        // Data stored in the node
private Node<E> next;     // Reference to the next node
private Node<E> prev;     // Reference to the previous node

public Node(E element) {
    this(element, null, null);
}

public Node(E element, Node<E> prev, Node<E> next) {
    this.element = element;
    this.prev = prev;
    this.next = next;
}

public E getElement() {
    return element;
}

public Node<E> getNext() {
    return next;
}

public Node<E> getPrev() {
    return prev;
}

public void setElement(E element) {
    this.element = element;
}

public void setNext(Node<E> next) {
    this.next = next;
}

public void setPrev(Node<E> prev) {
    this.prev = prev;
}
}

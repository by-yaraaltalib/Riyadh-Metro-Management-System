package com.mycompany.riyadhmetromanagmentsystem;

public class ArrayQueue<E> {
    private E[] data;
    private int f = 0;
    private int sz = 0;
    private static final int CAPACITY = 1000;

    public ArrayQueue() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
       data = (E[]) new Object[capacity];
    }

    public int size() {
       return sz;
    }

    public boolean isEmpty() {
       return sz == 0;
    }

    public void enqueue(E e) {
       if (sz == data.length) {
           throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public E first() {
        if (isEmpty()) return null;
    return data[f];
}

    public E dequeue() {
        if (isEmpty()) return null;
            E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
       return answer;
    }

    public void display() {
        if (isEmpty()) {
           System.out.println("Queue is empty");
          return;
        }
        int index = f;
        for (int i = 0; i < sz; i++) {
           System.out.print(data[index] + " ");
           index = (index + 1) % data.length;
        }
       System.out.println();
    }   
}

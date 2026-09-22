package com.mycompany.riyadhmetromanagmentsystem;

class BST<Key extends Comparable<? super Key>, T> {

    private BSTNode<Key, T> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key k, T e) {
        root = inserthelp(root, k, e);
        size++;
    }

    private BSTNode<Key, T> inserthelp(BSTNode<Key, T> rt, Key k, T e) {
        if (rt == null) return new BSTNode<>(k, e);
        if (k.compareTo(rt.getKey()) < 0)
            rt.setLeft(inserthelp(rt.getLeft(), k, e));
        else if (k.compareTo(rt.getKey()) > 0)
            rt.setRight(inserthelp(rt.getRight(), k, e));
        else
            rt.setData(e);
        return rt;
    }

    public T find(Key k) {
        BSTNode<Key, T> curr = root;
        while (curr != null) {
            int cmp = k.compareTo(curr.getKey());
            if (cmp == 0) return curr.getData();
            else if (cmp < 0) curr = curr.getLeft();
            else curr = curr.getRight();
        }
        return null;
    }

    public boolean contains(Key k) {
        return find(k) != null;
    }

    public T remove(Key k) {
        T found = find(k);
        if (found != null) {
            root = removehelp(root, k);
            size--;
        }
        return found;
    }

    private BSTNode<Key, T> removehelp(BSTNode<Key, T> rt, Key k) {
        if (rt == null) return null;
        int cmp = k.compareTo(rt.getKey());
        if (cmp < 0) rt.setLeft(removehelp(rt.getLeft(), k));
        else if (cmp > 0) rt.setRight(removehelp(rt.getRight(), k));
        else {
            if (rt.getLeft() == null) return rt.getRight();
            if (rt.getRight() == null) return rt.getLeft();
            BSTNode<Key, T> min = getmin(rt.getRight());
            rt.setKey(min.getKey());
            rt.setData(min.getData());
            rt.setRight(deletemin(rt.getRight()));
        }
        return rt;
    }

    private BSTNode<Key, T> getmin(BSTNode<Key, T> rt) {
        while (rt.getLeft() != null) rt = rt.getLeft();
        return rt;
    }

    private BSTNode<Key, T> deletemin(BSTNode<Key, T> rt) {
        if (rt.getLeft() == null) return rt.getRight();
        rt.setLeft(deletemin(rt.getLeft()));
        return rt;
    }
}
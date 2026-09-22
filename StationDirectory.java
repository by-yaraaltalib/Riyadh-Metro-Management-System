package com.mycompany.riyadhmetromanagmentsystem;

/*
StationDirectory
- يخزن كل المحطات باستخدام BST
- المفتاح هو Station ID
- البحث سريع O(log n)
*/

public class StationDirectory {

    // الشجرة، المفتاح = ID ، القيمة = Station
    private BST<Integer, Station> tree;

    public StationDirectory() {
        tree = new BST<>();
    }

    // ------------------------------------------------
    // Add new station
    // ------------------------------------------------
    public void addStation(Station s) {
        if (s == null) return;
        tree.insert(s.getId(), s);
    }

    // ------------------------------------------------
    // Search station by ID
    // ------------------------------------------------
    public Station searchById(int id) {
        return tree.find(id);
    }

    // ------------------------------------------------
    // Check if station exists
    // ------------------------------------------------
    public boolean exists(int id) {
        return tree.contains(id);
    }

    // ------------------------------------------------
    // Remove station
    // ------------------------------------------------
    public boolean removeStation(int id) {
        return tree.remove(id) != null;
    }

    // ------------------------------------------------
    // Update station info
    // نفس الـ ID، نغير البيانات فقط
    // ------------------------------------------------
    public boolean updateStation(Station updated) {
        if (!exists(updated.getId())) return false;
        tree.remove(updated.getId());
        tree.insert(updated.getId(), updated);
        return true;
    }

    // ------------------------------------------------
    // Display all stations sorted by ID
    // In-order traversal
    // ------------------------------------------------
    public void displayAll() {
        displayInOrder(treeRoot());
    }

    private void displayInOrder(BSTNode<Integer, Station> node) {
        if (node == null) return;
        displayInOrder(node.getLeft());
        System.out.println(node.getData());
        displayInOrder(node.getRight());
    }

    // ------------------------------------------------
    // Find min ID station
    // ------------------------------------------------
    public Station findMin() {
        BSTNode<Integer, Station> curr = treeRoot();
        if (curr == null) return null;
        while (curr.getLeft() != null)
            curr = curr.getLeft();
        return curr.getData();
    }

    // ------------------------------------------------
    // Find max ID station
    // ------------------------------------------------
    public Station findMax() {
        BSTNode<Integer, Station> curr = treeRoot();
        if (curr == null) return null;
        while (curr.getRight() != null)
            curr = curr.getRight();
        return curr.getData();
    }

    // ------------------------------------------------
    // Range search [from , to]
    // ------------------------------------------------
    public void findInRange(int from, int to) {
        rangeHelper(treeRoot(), from, to);
    }

    private void rangeHelper(BSTNode<Integer, Station> node, int from, int to) {
        if (node == null) return;

        if (node.getKey() > from)
            rangeHelper(node.getLeft(), from, to);

        if (node.getKey() >= from && node.getKey() <= to)
            System.out.println(node.getData());

        if (node.getKey() < to)
            rangeHelper(node.getRight(), from, to);
    }

    // ------------------------------------------------
    // Helper to access root safely
    // ------------------------------------------------
    private BSTNode<Integer, Station> treeRoot() {
        try {
            java.lang.reflect.Field f = tree.getClass().getDeclaredField("root");
            f.setAccessible(true);
            return (BSTNode<Integer, Station>) f.get(tree);
        } catch (Exception e) {
            return null;
        }
    }
}
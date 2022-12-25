package com.example;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int initialCapacity;

    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }

    }

    public LRUCache(int initialCapacity) {
        this.head = null;
        this.tail = null;
        map = new HashMap<>();
        this.initialCapacity = initialCapacity;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addNode(Node node) {
        // Add Node in head
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        Node headNode = this.head;
        headNode.previous = node;
        node.next = headNode;
        this.head = node;
    }

    public void removeNode(Node node) {
        Node previousNode = node.previous;
        Node nextNode = node.next;
        if (nextNode != null) {
            nextNode.previous = previousNode;
        }
        if (previousNode != null) {
            previousNode.next = nextNode;
        }
    }

    // O(1) time
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    // O(1) time
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            addNode(node);
        } else {
            if (map.size() == this.initialCapacity) {
                // Remove the least used node i.e. the tail node
                removeNode(this.tail);
                map.remove(this.tail.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int key = 1;
        System.out.println("Get Value of : " + key + " is: " + cache.get(key));
        cache.put(3, 3);
        key = 2;
        System.out.println("Get Value of : " + key + " is: " + cache.get(key));
        cache.put(4, 4);
        key = 1;
        System.out.println("Get Value of : " + key + " is: " + cache.get(key));
        key = 3;
        System.out.println("Get Value of : " + key + " is: " + cache.get(key));
        key = 4;
        System.out.println("Get Value of : " + key + " is: " + cache.get(key));
    }
}

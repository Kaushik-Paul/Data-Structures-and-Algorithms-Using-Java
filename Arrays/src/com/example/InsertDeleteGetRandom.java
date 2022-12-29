package com.example;

import java.util.*;

public class InsertDeleteGetRandom {
    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;

    // O(n) space
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    // O(1) time
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size() - 1);
        list.add(val);
        return true;
    }

    // O(1) time
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastValue = list.pop();
            list.add(lastValue, index);
            map.put(lastValue, index);
            map.remove(val);
            return true;
        }
        return false;
    }

    // O(1) time
    public int getRandom() {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom ll = new InsertDeleteGetRandom();
        System.out.println("After adding 1 : " + ll.insert(1));
        System.out.println("After removing 2 : " + ll.remove(2));
        System.out.println("After adding 2 : " + ll.insert(2));
        System.out.println("After random : " + ll.getRandom());
        System.out.println("After removing 1 : " + ll.remove(1));
        System.out.println("After adding 2 : " + ll.insert(2));
        System.out.println("After random : " + ll.getRandom());
    }
}

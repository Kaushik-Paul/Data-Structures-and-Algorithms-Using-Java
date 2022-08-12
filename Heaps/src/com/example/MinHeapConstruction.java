package com.example;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    private List<Integer> heap;

    public MinHeapConstruction() {
        heap = new ArrayList<>();
    }

    private void swap(int indexOne, int indexTwo) {
        int tempOne = heap.get(indexOne);
        int tempTwo = heap.get(indexTwo);
        heap.set(indexOne, tempTwo);
        heap.set(indexTwo, tempOne);
    }

    private void shiftUp(int currentIdx) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0) {
            if (heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }
    }

    private void shiftDown(int currentIdx, int endIdx) {
        int childOne = (currentIdx * 2) + 1;
        while (childOne <= endIdx) {
            int valueToSwap = childOne;
            int childTwo = (currentIdx * 2) + 2;
            if (childTwo <= endIdx && heap.get(childTwo) < heap.get(childOne)) {
                valueToSwap = childTwo;
            }
            if (heap.get(currentIdx) > heap.get(valueToSwap)) {
                swap(currentIdx, valueToSwap);
            } else {
                break;
            }
            currentIdx = valueToSwap;
            childOne = (currentIdx * 2) + 1;
        }
    }

    public void insertion(int newValue) {
        heap.add(newValue);
        shiftUp(heap.size() - 1);
    }

    public int deletion() {
        swap(0, heap.size() - 1);
        int valueRemoved = heap.remove(heap.size() - 1);
        shiftDown(0, heap.size() - 1);
        return valueRemoved;
    }

    public void buildHeap(int[] array) {
        for (int num : array) {
            heap.add(num);
        }
        for (int parentIdx = (heap.size() - 2) / 2; parentIdx >= 0; parentIdx--) {
            shiftDown(parentIdx, heap.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{30, 102, 23, 17, 18, 9, 44, 12, 31};
        MinHeapConstruction minHeapConstruction = new MinHeapConstruction();
        minHeapConstruction.buildHeap(array);
        System.out.println(minHeapConstruction.heap);
        minHeapConstruction.insertion(8);
        minHeapConstruction.insertion(2);
        System.out.println(minHeapConstruction.heap);
        System.out.println(minHeapConstruction.deletion());
        System.out.println(minHeapConstruction.deletion());
        System.out.println(minHeapConstruction.heap);
    }
}

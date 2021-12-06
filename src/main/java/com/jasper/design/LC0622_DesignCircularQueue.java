package com.jasper.design;

class MyCircularQueue {

    int head;
    int tail;
    int size;

    int[] data;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        tail = (tail + 1) % data.length;
        data[tail] = value;

//        if head is set to -1, uncomment the following code
//        if (head == -1) {
//            head++;
//        }

        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % data.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}

public class LC0622_DesignCircularQueue {
    /**
     * ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
     * [[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(2);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        myCircularQueue.deQueue();
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        myCircularQueue.deQueue();
    }
}

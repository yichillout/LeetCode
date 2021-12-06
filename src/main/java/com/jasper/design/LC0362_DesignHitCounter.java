package com.jasper.design;

import java.util.*;

class HitCounter {

    Queue<Integer> q;

    public HitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}

public class LC0362_DesignHitCounter {

    public static void main(String[] args) {

        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));

    }
}

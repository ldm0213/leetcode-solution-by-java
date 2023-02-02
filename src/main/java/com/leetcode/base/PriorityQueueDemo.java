package com.leetcode.base;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lidongmeng
 * Created on 2023-01-29
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        defaultPriorityQueue();
        customComparatorPriorityQueue();
    }

    public static void defaultPriorityQueue() {
        // 默认是小顶堆，每次取得的是排序最小的元素
        // add/offer: 添加元素到队列中，null不能添加，会报nullPointer
        // poll: 从队首拿取元素，并从队列中剔除掉
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.offer(100);
        queue.add(1);
        queue.add(90);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void customComparatorPriorityQueue() {
        // lambda新建比较器
        Queue<User> queue = new PriorityQueue<>((u1, u2) -> {
            if (u1.number.charAt(0) == u2.number.charAt(0)) {
                return u1.number.compareTo(u2.number);
            }
            if (u1.number.charAt(0) == 'V') {
                return -1;
            } else {
                return 1;
            }
        });
        queue.offer(new User("Bob", "A1"));
        queue.offer(new User("Alice", "A2"));
        queue.offer(new User("Boss", "V1"));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static class User {
        public final String name;
        public final String number;

        public User(String name, String number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return name + "/" + number;
        }
    }
}

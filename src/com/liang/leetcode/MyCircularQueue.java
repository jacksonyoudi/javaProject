package com.liang.leetcode;

/**
 * https://leetcode-cn.com/problems/design-circular-queue/
 * <p>
 * 可以考虑泛型， 然后阅读源码 deque源码
 * <p>
 * head tail 有三种情况
 * 1. tail > tail 正常情况，还没满
 * 2. tail = head, 满或空的情况
 * 3. head > tail
 */
class MyCircularQueue {

    private int[] content;
    private int head;
    private int tail;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        length = k + 1;
        content = new int[k + 1];
        head = 0;
        tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if ((tail + 1) % length == head) {
            return false;
        }
        content[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (tail == head) {
            return false;
        }
        head = (head + 1) % length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return content[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return content[(tail - 1 + length) % length];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % length == head;
    }
}

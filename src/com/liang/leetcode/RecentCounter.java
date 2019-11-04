package com.liang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */

public class RecentCounter {
    // 定义一个队列
    private Queue<Integer> q;

    public static void main(String[] args) {

    }

    public RecentCounter() {
        // 构造器,使用 链表做队列
        q = new LinkedList<>();
    }

    public int ping(int t) {
        // 入队列
        q.add(t);
        // 比较最后一个数，如果满足，就出队列
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}

package com.liang.collection;


public class LLinkedList<E> {
    private Node first;
    private Node last;

    private int size;

    public void add(E obj) {
        Node node = new Node(obj);
        size++;
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;

            last = node;
        }
    }

    public void show() {
        Node head = first;
        System.out.print("[");
        while (head != null) {
            System.out.print(head.element);
            System.out.print(",");
            head = head.next;
        }
        System.out.print("]\n");
    }

    public int size() {
        return size;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index不合法");
        }
    }


    public E get(int index) {
        // 可以倒叙
        checkRange(index);
        Node head = first;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }

        return (E) head.element;

    }

    private Node getNode(int index) {
        // 可以倒叙
        checkRange(index);
        Node head = first;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }

        return head;

    }

    public void remove(int index) {
        Node node = getNode(index);

        if (node != null) {
            Node up = node.previous;
            Node down = node.next;

            if (up != null) {
                up.next = down;
            }

            if (down != null) {
                down.previous = up;
            }


            if (index == 0) {
                first = down;
            }

            if (index == size - 1) {
                last = up;
            }

            size--;
        }


    }


    public void insert(int index, E element) {
        Node newNode = new Node(element);
        Node temp = getNode(index);

        if (temp!= null) {
            Node up = temp.previous;

            up.next = newNode;
            newNode.previous = up;


            temp.previous = newNode;
            newNode.next = temp;
        }


    }


    public static void main(String[] args) {
        LLinkedList<String> lll = new LLinkedList<>();
        lll.add("hello");
        lll.add("test");
        lll.add("h");
        lll.add("o");
        lll.add("e");
        lll.show();

        System.out.println(lll.size());
        System.out.println(lll.get(4));
        lll.insert(1, "xixi");
        lll.show();
    }
}


package com.jalopymusic.mosh;

public class MoshLinkedList<E> {
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value) {
            this.value = value;
        }
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;
    private Node last;

    public void addLast(E value) {
        if (last == null) {
            first = new Node((value));
            last = first;
        } else {
            last.next = new Node(value);
            last = last.next;
        }
    }

    public void addFirst(E value) {
        first = new Node(value, first);
        if (last == null) {
            last = first;
        }
    }

    public void deleteLast() {
        if (first == last) {
            first = null;
            last = null;
            return;
        }
        Node<E> node = first;
        while (node.next != last) {
            node = node.next;
        }
        node.next = null;
        last = node;
    }

    public void deleteFirst() {
        if (first == last) {
            first = null;
            last = null;
            return;
        }
        first = first.next;
    }

    public int indexOf(E value) {
        if (first == null) {
            return -1;
        }
        Node<E> node = first;
        int i = 0;
        while (node != last) {
            if (node.value.equals(value)) {
                return i;
            }
            node = node.next;
            i++;
        }
        return last.value.equals(value) ? i : -1;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "";
        }
        Node<E> node = first;
        StringBuilder result = new StringBuilder();
        while (node != last) {
            result.append(node.value);
            result.append(',');
            node = node.next;
        }
        result.append(last.value);
        return result.toString();
    }
}

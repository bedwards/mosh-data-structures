package com.jalopymusic.mosh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoshArray<E extends Comparable<E>> {

    private static final int MAX_GROWTH = 1000;

    private final Class<E> elementClass;
    private E[] elements;
    private int insertionIndex = 0;

    public MoshArray(Class<E> elementClass, int size) {
        this.elementClass = elementClass;
        elements = (E[]) Array.newInstance(elementClass, size);
    }

    public boolean add(E element) {
        if (insertionIndex == elements.length) {
            elements = Arrays.copyOf(elements, Math.min(MAX_GROWTH, elements.length * 2));
        }
        elements[insertionIndex] = element;
        insertionIndex++;
        return true;
    }

    public E remove(int index) {
        if (index >= insertionIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E result = elements[index];
        for (int i = index; i < insertionIndex; i++) {
            elements[i] = elements[i + 1];
        }
        insertionIndex--;
        return result;
    }

    public void print() {
        for (int i = 0; i < insertionIndex; i++) {
            System.out.print(elements[i]);
            System.out.print(", ");
        }
        System.out.printf("(underlying length: %s)\n", elements.length);
    }

    @Override
    public String toString() {
        if (insertionIndex == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < insertionIndex; i++) {
            result.append(elements[i]);
            result.append(',');
        }
        result.deleteCharAt(result.lastIndexOf(","));
        return result.toString();
    }

    public int indexOf(Object element) {
        for (int i = 0; i < insertionIndex; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public E max() {
        if (insertionIndex == 0) {
            return null;
        }
        E result = elements[0];
        for (int i = 1; i < insertionIndex; i++) {
            if (elements[i].compareTo(result) > 0) {
                result = elements[i];
            }
        }
        return result;
    }

    public MoshArray<E> intersect(MoshArray<E> other) {
        MoshArray<E> result = new MoshArray<>(elementClass, insertionIndex);
        for (int i = 0; i < insertionIndex; i++) {
            if (other.indexOf(elements[i]) != -1 && result.indexOf(elements[i]) == -1) {
                result.add(elements[i]);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MoshArray)) {
            return false;
        }
        for (int i = 0; i < insertionIndex; i++) {
            if (!elements[i].equals(((MoshArray) o).elements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < insertionIndex; i++) {
            result += elements[i].hashCode();
        }
        return result;
    }

    public void reverse() {
        E[] result = (E[]) Array.newInstance(elementClass, insertionIndex);
        int j = insertionIndex - 1;
        for (int i = 0; i < insertionIndex; i++) {
            result[j] = elements[i];
            j--;
        }
        elements = result;
    }

    public void add(int index, E element) {
        if (index < 0 || index > insertionIndex) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = insertionIndex; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        insertionIndex++;
    }
}

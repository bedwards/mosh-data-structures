package com.jalopymusic.mosh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoshArrayTest {

    private MoshArray<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new MoshArray<>(Integer.class, 3);
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
    }

    @Test
    public void testMoshArray() {
        assertEquals(numbers.remove(2), 30);
        assertEquals(numbers.indexOf(40), 2);
        assertEquals(numbers.indexOf(5), -1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            numbers.remove(5);
        });
    }

    @Test
    public void testMax() {
        assertEquals(numbers.max(), 40);
    }

    @Test
    public void testIntersect() {
        numbers.add(10);
        MoshArray<Integer> other = new MoshArray<>(Integer.class, 3);
        other.add(10);
        other.add(20);
        other.add(50);
        other.add(40);
        other.add(10);
        assertEquals("10,20,40", numbers.intersect(other).toString());
        assertEquals("10,20,40", other.intersect(numbers).toString());
    }

    @Test
    public void testReverse() {
        numbers.reverse();
        assertEquals("40,30,20,10", numbers.toString());
    }

    @Test
    public void testAddAtIndex() {
        numbers.add(2, 55);
        numbers.add(5, 66);
        assertEquals("10,20,55,30,40,66", numbers.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            numbers.add(77, 77);
        });
    }
}

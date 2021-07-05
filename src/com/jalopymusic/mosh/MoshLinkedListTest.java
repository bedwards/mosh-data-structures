package com.jalopymusic.mosh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoshLinkedListTest {
    private MoshLinkedList<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new MoshLinkedList<>();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
    }

    @Test
    public void testAddLast() {
        numbers.addLast(55);
        assertEquals("10,20,30,40,55", numbers.toString());
    }


    @Test
    public void testAddFirst() {
        numbers.addFirst(55);
        assertEquals("55,10,20,30,40", numbers.toString());
    }

    @Test
    public void testDeleteLast() {
        numbers.deleteLast();
        assertEquals("10,20,30", numbers.toString());
    }

    @Test
    public void testDeleteFirst() {
        numbers.deleteFirst();
        assertEquals("20,30,40", numbers.toString());
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, numbers.indexOf(30));
        assertEquals(-1, numbers.indexOf(77));
    }

    @Test
    public void testContains() {
        assertTrue(numbers.contains(40));
        assertFalse(numbers.contains(77));
    }
}

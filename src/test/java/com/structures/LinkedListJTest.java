package com.structures;

import com.structures.list.LinkedListJ;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListJTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private LinkedListJ<String> testList;

    @Before
    public void setUp() {
        testList = new LinkedListJ<>();
    }

    @After
    public void tearDown() {
        testList = null;
    }

    @Test
    public void testAdd() {
        testList.add("value1");
        assertEquals("value1", testList.get(0));
    }

    @Test
    public void testSize() {
        testList.add("value1");
        assertEquals(1, testList.size());
        testList.add("value2");
        assertEquals(2, testList.size());
        testList.add("value3");
        assertEquals(3, testList.size());
        assertFalse(testList.size() == 4);
    }

    @Test
    public void testClear() {
        testList.add("new string");
        assertFalse(testList.isEmpty());
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    @Test
    public void testGet() {
        testList.add("1");
        testList.add("2");
        assertEquals("1", testList.get(0));
        assertEquals("2", testList.get(1));

        exception.expect(IndexOutOfBoundsException.class);
        assertEquals("3", testList.get(2));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testList.isEmpty());
        testList.add("1");
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testRemove() {
        testList.add("1");
        assertEquals("1", testList.remove(0));

        exception.expect(IndexOutOfBoundsException.class);
        testList.remove(-1);

        exception.expect(IndexOutOfBoundsException.class);
        testList.remove(0);
        assertTrue(testList.isEmpty());
    }

    @Test
    public void testIndexOf() {
        testList.add("1");
        testList.add("2");
        testList.add("3");
        assertEquals(0, testList.indexOf("1"));
        assertEquals(1, testList.indexOf("2"));
        assertEquals(2, testList.indexOf("3"));
        assertEquals(-1, testList.indexOf("99"));
    }

    @Test
    public void testAddFirst() {
        testList.add("1");
        testList.add("2");
        testList.addFirst("3");
        assertFalse(testList.get(0).equals("1"));
        assertTrue(testList.get(0).equals("3"));
        assertTrue(testList.get(1).equals("1"));
        assertTrue(testList.get(2).equals("2"));
    }

    @Test
    public void testAddLast() {
        testList.add("1");
        testList.add("2");
        testList.addLast("9");
        assertEquals("1", testList.get(0));
        assertFalse(testList.get(0).equals("3"));
        assertEquals("9", testList.get(2));
    }

    @Test
    public void testSet() {
        testList.add("1");
        testList.add("2");
        testList.add("3");
        assertEquals("2", testList.get(1));
        assertEquals("3", testList.set(1, "3"));
        assertEquals("1", testList.get(0));
        assertEquals("3", testList.get(1));
        assertEquals("3", testList.get(2));
        assertEquals(3, testList.size());

    }

    @Test
    public void testIterator() {
        testList.add("1");
        testList.add("2");
        testList.add("3");
        Iterator<String> iterator = testList.iterator();
        assert (iterator != null);
        assertEquals("1", iterator.next());
        assertEquals("2", iterator.next());
        assertEquals("3", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testContains() {
        testList.add("1");
        testList.add("2");
        testList.add("3");
        assertTrue(testList.contains("1"));
        assertTrue(testList.contains("2"));
        assertTrue(testList.contains("3"));
        assertFalse(testList.contains("4"));
    }
}

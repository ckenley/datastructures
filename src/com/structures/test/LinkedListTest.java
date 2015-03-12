package com.structures.test;

import com.structures.list.LinkedList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListTest extends TestCase {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private LinkedList<String> testList;

    @Before
    protected void setUp() {
        testList = new LinkedList<String>();
    }

    @After
    protected void tearDown() {
        testList = null;
    }

    @Test
    public void testAdd() {
        testList.add("value1");
        assertEquals(testList.get(0), "value1");
    }

    @Test
    public void testSize() {
        testList.add("value1");
        assertEquals(testList.size(), 1);
        testList.add("value2");
        assertEquals(testList.size(), 2);
        testList.add("value3");
        assertEquals(testList.size(), 3);
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
        testList.add("3");
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
        assertFalse(testList.remove(1));
        assertFalse(testList.remove(-1));
        assertTrue(testList.remove(0));
    }

    @Test
    public void testIndexOf() {
        testList.add("1");
        testList.add("2");
        testList.add("3");
        assertEquals(testList.indexOf("1"), 1);
        assertEquals(testList.indexOf("2"), 2);
        assertEquals(testList.indexOf("3"), 3);
        assertEquals(testList.indexOf("99"), -1);
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
        assertTrue(testList.get(0).equals("1"));
        assertFalse(testList.get(0).equals("3"));
        assertTrue(testList.get(2).equals("9"));
    }

}

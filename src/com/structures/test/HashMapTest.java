package com.structures.test;

import com.structures.map.HashMap;
import com.structures.map.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    private static final int SIZE = 128;
    private Map<String, String> testMap;

    @Before
    public void setUp() {
        testMap = new HashMap<>(SIZE);
    }

    @After
    public void tearDown() {
        testMap = null;
    }

    @Test
    public void testConstructor() {
        assertTrue(testMap.size() == 128);
    }

    @Test
    public void testClear() throws Exception {
        assertEquals("Z", testMap.put("A", "Z"));
        assertTrue(!testMap.isEmpty());
        testMap.clear();
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void testContainsKey() throws Exception {
        testMap.put("A", "Z");
        testMap.put("Z", "A");
        assertTrue(testMap.containsKey("A"));
        assertFalse(testMap.containsKey("C"));
        assertTrue(testMap.containsKey("Z"));
    }

    @Test
    public void testContainsValue() throws Exception {
        testMap.put("A", "Z");
        testMap.put("Z", "A");
        assertTrue(testMap.containsValue("A"));
        assertTrue(testMap.containsValue("Z"));
        assertFalse(testMap.containsValue("C"));
    }

    @Test
    public void testPutandGet() throws Exception {
        assertEquals("Z", testMap.put("A", "Z"));
        assertEquals("Y", testMap.put("B", "Y"));
        assertEquals("X", testMap.put("C", "X"));
        assertEquals("Z", testMap.get("A"));
        assertEquals("Y", testMap.get("B"));
        assertEquals("X", testMap.get("C"));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(testMap.isEmpty());
        testMap.put("A", "Z");
        assertFalse(testMap.isEmpty());
    }

    @Test
    public void testRemove() throws Exception {
        assertEquals("Z", testMap.put("A", "Z"));
        assertEquals("Y", testMap.put("B", "Y"));
        assertEquals("X", testMap.put("C", "X"));
        assertTrue(testMap.containsKey("C"));
        assertTrue(testMap.containsValue("X"));
        assertEquals("X", testMap.remove("C"));
        assertFalse(testMap.containsKey("C"));
        assertFalse(testMap.containsValue("X"));
    }

    @Test
    public void testSize() throws Exception {
        testMap = new HashMap<>(6);
        assertEquals(6, testMap.size());
    }
}
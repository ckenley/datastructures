package com.structures.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.structures.map.HashMap;
import com.structures.map.Map;

public class HashMapTest {

    private final int SIZE = 128;
    private Map<String, String> testMap;

    @Before
    public void setUp() {
        testMap = new HashMap<String, String>(SIZE);
    }

    @After
    public void tearDown() {
        testMap = null;
    }
    
    @Test
    public void testContructor(){
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
    public void testEntrySet() throws Exception {
    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {
    	assertTrue(testMap.isEmpty());
    	testMap.put("A", "Z");
    	assertFalse(testMap.isEmpty());
    }

    @Test
    public void testKeySet() throws Exception {

    }

    @Test
    public void testPut() throws Exception {
    	assertEquals("Z", testMap.put("A", "Z"));
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testValues() throws Exception {

    }
}
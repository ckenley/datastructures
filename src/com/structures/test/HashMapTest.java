package com.structures.test;

import com.structures.map.HashMap;
import com.structures.map.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HashMapTest {

    private final int SIZE = 128;
    private Map<Integer, String> testMap;

    @Before
    public void setUp() {

        testMap = new HashMap<Integer, String>(SIZE);
    }

    @After
    public void tearDown() {
        testMap = null;
    }

    @Test
    public void testClear() throws Exception {
        testMap.put(1, "F");
        assertTrue(testMap.isEmpty());
        testMap.clear();
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void testContainsKey() throws Exception {

    }

    @Test
    public void testContainsValue() throws Exception {

    }

    @Test
    public void testEntrySet() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testKeySet() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

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
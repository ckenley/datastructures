package com.structures.test;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import com.structures.list.ArrayList;

public class ArrayListTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private ArrayList<String> testList;

	@Before
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		testList = null;
	}

	@Test
	public void testAddGet() {
		assertTrue(testList.add("A"));
		assertEquals("A", testList.get(0));
		assertEquals(1, testList.size());

		exception.expect(IndexOutOfBoundsException.class);
		testList.get(1);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(testList.isEmpty());
		assertTrue(testList.add("A"));
		assertFalse(testList.isEmpty());
	}

	@Test
	public void testClear() {
		assertTrue(testList.add("A"));
		assertTrue(testList.add("B"));
		assertFalse(testList.isEmpty());
		assertEquals(2, testList.size());
		testList.clear();
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testRemove(){
		assertTrue(testList.add("A"));
		assertTrue(testList.add("B"));
		assertTrue(testList.add("C"));
		assertEquals("B", testList.remove(1));
		assertEquals(2, testList.size());
		assertEquals("A", testList.get(0));
		assertEquals("C", testList.get(1));
		assertTrue(testList.add("A"));
		assertEquals("A", testList.get(0));
		assertEquals("C", testList.get(1));
		assertEquals("A", testList.get(2));
		assertTrue(testList.remove("A"));
		assertEquals("C", testList.get(0));
		assertEquals("A", testList.get(1));
	}
	
	@Test
	public void testIndexOf(){
		assertTrue(testList.add("A"));
		assertTrue(testList.add("B"));
		assertTrue(testList.add("C"));
		assertEquals(0, testList.indexOf("A"));
		assertEquals(1, testList.indexOf("B"));
		assertEquals(2, testList.indexOf("C"));
		assertEquals(-1, testList.indexOf("Z"));
	}
	
	@Test
	public void testSet(){
		assertTrue(testList.add("A"));
		assertTrue(testList.add("B"));
		assertTrue(testList.add("C"));
		assertEquals("Z", testList.set(1, "Z"));
		assertEquals(0, testList.indexOf("A"));
		assertEquals(1, testList.indexOf("Z"));
		assertEquals(2, testList.indexOf("C"));
		assertFalse(testList.contains("B"));
	}
	
	@Test
	public void testContains(){
		assertFalse(testList.contains("A"));
		assertTrue(testList.add("A"));
		assertTrue(testList.contains("A"));
	}
	
	@Test
	public void testIterator(){
		assertTrue(testList.add("A"));
		assertTrue(testList.add("B"));
		assertTrue(testList.add("C"));
		Iterator<String> iterator = testList.iterator();
		assert (iterator != null);
		assert (iterator instanceof Iterator);
		assertEquals("A", iterator.next());
		assertEquals("B", iterator.next());
		assertEquals("C", iterator.next());
		assertFalse(iterator.hasNext());
		
	}

}

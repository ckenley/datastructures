import com.structures.list.LinkedListK
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LinkedListKTest {

    private var testList: LinkedListK<String>? = null

    @Before
    fun setUp() {
        testList = LinkedListK()
    }

    @After
    fun tearDown() {
        testList = null
    }

    @Test
    fun testAdd() {
        assertTrue(testList!!.add("A"))
        assertEquals(1, testList!!.size())
        assertTrue(testList!!.add("B"))
        assertEquals(2, testList!!.size())
        assertTrue(testList!!.add("C"))
        assertEquals(3, testList!!.size())
    }

    @Test
    fun testClear() {
        assertTrue(testList!!.add("A"))
        assertFalse(testList!!.isEmpty)
        testList!!.clear()
    }

    @Test
    fun testGet() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        assertEquals("A", testList!!.get(0))
        assertEquals("B", testList!!.get(1))
        assertEquals("C", testList!!.get(2))
    }

    @Test
    fun testRemoveFirst() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        testList!!.remove(0)
        assertEquals(2, testList!!.size())
        assertEquals("B", testList!!.get(0))
        assertEquals("C", testList!!.get(1))
    }

    @Test
    fun testRemoveMiddle() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        testList!!.remove(1)
        assertEquals(2, testList!!.size())
        assertEquals("A", testList!!.get(0))
        assertEquals("C", testList!!.get(1))
    }

    @Test
    fun testRemoveLast() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        testList!!.remove(2)
        assertEquals(2, testList!!.size())
        assertEquals("A", testList!!.get(0))
        assertEquals("B", testList!!.get(1))
    }

    @Test
    fun testIndexOf() {
        assertEquals(-1, testList!!.indexOf("Z"))
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        assertEquals(0, testList!!.indexOf("A"))
        assertEquals(1, testList!!.indexOf("B"))
        assertEquals(2, testList!!.indexOf("C"))
        assertEquals(-1, testList!!.indexOf("Z"))
    }

    @Test
    fun testSet() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        assertEquals("A", testList!!.set(0, "X"))
        assertEquals("B", testList!!.set(1, "Y"))
        assertEquals("C", testList!!.set(2, "Z"))
        assertEquals("X", testList!!.get(0))
        assertEquals("Y", testList!!.get(1))
        assertEquals("Z", testList!!.get(2))
        assertEquals(3, testList!!.size())
        assertFailsWith<IndexOutOfBoundsException> {
            testList!!.set(99, "Z")
        }
    }

    @Test
    fun testContains() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        assertTrue(testList!!.contains("A"))
        assertTrue(testList!!.contains("B"))
        assertTrue(testList!!.contains("C"))
        assertFalse(testList!!.contains("Z"))
    }

    @Test
    fun testIterator() {
        testList!!.add("A")
        testList!!.add("B")
        testList!!.add("C")
        val iterator = testList!!.iterator()
        assertEquals("A", iterator.next())
        assertEquals("B", iterator.next())
        assertEquals("C", iterator.next())
        assertFalse(iterator.hasNext())
    }

}
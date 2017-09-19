import com.structures.list.ArrayListK
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class ArrayListKTest {

    private var testList: ArrayListK<String>? = null

    @Before
    fun setUp() {
        testList = ArrayListK()
    }

    @After
    fun tearDown() {
        testList = null
    }

    @Test
    fun testAddGet() {
        assertTrue(testList!!.add("A"))
        assertEquals("A", testList!!.get(0))
        assertEquals(1, testList!!.size().toLong())
        assertTrue(testList!!.add("B"))
        assertEquals("B", testList!!.get(1))
        assertEquals(2, testList!!.size().toLong())
        assertFailsWith<IndexOutOfBoundsException> {
            testList!!.get(2)
        }
    }

    @Test
    fun testIsEmpty() {
        assertTrue(testList!!.isEmpty)
        assertTrue(testList!!.add("A"))
        assertFalse(testList!!.isEmpty)
    }

    @Test
    fun testClear() {
        assertTrue(testList!!.add("A"))
        assertTrue(testList!!.add("B"))
        assertFalse(testList!!.isEmpty)
        assertEquals(2, testList!!.size().toLong())
        testList!!.clear()
        assertTrue(testList!!.isEmpty)
    }

    @Test
    fun testRemove() {
        assertTrue(testList!!.add("A"))
        assertTrue(testList!!.add("B"))
        assertTrue(testList!!.add("C"))

        assertEquals("A", testList!!.remove(0))
        assertEquals("B", testList!!.remove(0))
        assertEquals("C", testList!!.remove(0))
        assertEquals(0, testList!!.size().toLong())

        assertTrue(testList!!.add("A"))
        assertFalse(testList!!.add("A"))

        assertTrue(testList!!.add("B"))
        assertTrue(testList!!.add("C"))

        assertEquals("A", testList!!.get(0))
        assertEquals("B", testList!!.get(1))
        assertEquals("C", testList!!.get(2))
    }

    @Test
    fun testIndexOf() {
        assertTrue(testList!!.add("A"))
        assertTrue(testList!!.add("B"))
        assertTrue(testList!!.add("C"))
        assertEquals(0, testList!!.indexOf("A").toLong())
        assertEquals(1, testList!!.indexOf("B").toLong())
        assertEquals(2, testList!!.indexOf("C").toLong())
        assertEquals(-1, testList!!.indexOf("Z").toLong())
    }

    @Test
    fun testSet() {
        assertTrue(testList!!.add("A"))
        assertTrue(testList!!.add("B"))
        assertTrue(testList!!.add("C"))
        assertEquals("B", testList!!.set(1, "Z"))
        assertEquals(0, testList!!.indexOf("A").toLong())
        assertEquals(1, testList!!.indexOf("Z").toLong())
        assertEquals(2, testList!!.indexOf("C").toLong())
        assertFalse(testList!!.contains("B"))
    }

    @Test
    fun testContains() {
        assertFalse(testList!!.contains("A"))
        assertTrue(testList!!.add("A"))
        assertTrue(testList!!.contains("A"))
    }

}
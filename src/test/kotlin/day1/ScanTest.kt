package day1

import kotlin.test.Test
import kotlin.test.assertEquals

class ScanTest {

    @Test
    fun `returns 0 for input that has less than 4 numbers`() {
        assertEquals(0, scan(listOf(1)))
        assertEquals(0, scan(listOf(1, 2)))
        assertEquals(0, scan(listOf(1, 2, 3)))
    }

    @Test
    fun `for 1, 2, 3, 4 returns 1`() {
        val result = scan(listOf(1, 2, 3, 4))
        assertEquals(1, result)
    }

    @Test
    fun `for 1, 2, 2, 1 returns 0`() {
        val result = scan(listOf(1, 2, 2, 1))
        assertEquals(0, result)
    }

    @Test
    fun `for 4, 3, 2, 1 returns 0`() {
        val result = scan(listOf(4, 3, 2, 1))
        assertEquals(0, result)
    }

    @Test
    fun `for 1, 2, 3, 4, 5 returns 3`() {
        val result = scan(listOf(1, 2, 3, 4, 5))
        assertEquals(2, result)
    }
}
package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class CoordinatesTest {

    @Test
    fun `moving forward increases horizontal position but NOT depth`() {
        val coordinates =
            Coordinates.Zero +
                    Movement("forward", 10) +
                    Movement("forward", 10)

        assertEquals(20, coordinates.horizontal)
        assertEquals(0, coordinates.depth)
    }

    @Test
    fun `moving down than increases horizontal position AND depth`() {
        val coordinates = Coordinates.Zero +
                Movement("down", 10) +
                Movement("forward", 10)

        assertEquals(100, coordinates.depth)
        assertEquals(10, coordinates.horizontal)
    }

    @Test
    fun `moving down multiple times adds on depth`() {
        val coordinates =
            Coordinates.Zero +
                    Movement("down", 5) +
                    Movement("down", 5) +
                    Movement("forward", 10)

        assertEquals(100, coordinates.depth)
    }

    @Test
    fun `moving up decreases depth`() {
        val coordinates =
            Coordinates.Zero +
                    Movement("down", 10) +
                    Movement("up", 5) +
                    Movement("forward", 10)

        assertEquals(50, coordinates.depth)
    }
}
package day3

import java.io.File
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class DiagnosticsTest {

    private val diagnostics = Diagnostics()

    @Test
    fun `can calculate gama and epsilon`() {
        val binaries = listOf(
            "11011",
            "10100",
            "00101",
            "10101",
        )

//        gama = 10101
//        epsilon = 01010
        diagnostics.process(binaries)

        assertEquals(210, diagnostics.powerConsumption)
    }

    @Test
    fun `can calculate power consumption from first example`() {
        val binaries = readBinaries("input1.txt")

        diagnostics.process(binaries)

        assertEquals(198, diagnostics.powerConsumption)
    }

    @Test
    fun `can calculate power consumption from second example`() {
        val binaries = readBinaries("input2.txt")

        diagnostics.process(binaries)

        assertEquals(3985686, diagnostics.powerConsumption)
    }


    @Test
    fun `can calculate life support rating from first example`() {
        val binaries = readBinaries("input1.txt")

        diagnostics.process(binaries)

        assertEquals(230, diagnostics.lifeSpan)
    }

    @Test
    fun `can calculate life support rating from second example`() {
        val binaries = readBinaries("input2.txt")

        diagnostics.process(binaries)

        assertEquals(2555739, diagnostics.lifeSpan)
    }

    private fun readBinaries(file: String): List<String> =
        File("src/test/kotlin/day3/$file").readLines()
}
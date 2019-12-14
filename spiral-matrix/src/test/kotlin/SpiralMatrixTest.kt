import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class SpiralMatrixTest {

/*    @Test
    fun testEmptySpiralEdges(){
        val expected = emptyList<Int>()
        assertEquals(expected, SpiralMatrix.edges(0))
    }

    @Test
    fun testTrivialSpiralEdges(){
        val expected = listOf<Int>(1)
        assertEquals(expected, SpiralMatrix.edges(1))
    }

    @Test
    fun testSpiralOfSize2Edges(){
        val expected = listOf<Int>(1,2,3,4)
        assertEquals(expected, SpiralMatrix.edges(2))
    }

    @Test
    fun testSpiralOfSize3Edges(){
        val expected = listOf<Int>(1,3,5,7)
        assertEquals(expected, SpiralMatrix.edges(3))
    }

    @Test
    fun testSpiralOfSize4Edges(){
        val expected = listOf<Int>(1,4,7,10)
        assertEquals(expected, SpiralMatrix.edges(4))
    }

    @Test
    fun testSpiralOfSize5Edges(){
        val expected = listOf<Int>(1,5,9,13)
        assertEquals(expected, SpiralMatrix.edges(5))
    }*/

    //@Ignore
    @Test
    fun testEmptySpiral() {
        val expected = emptyArray<IntArray>()

        assertArrayEquals(expected, SpiralMatrix.ofSize(0))
    }

    //@Ignore
    @Test
    fun testTrivialSpiral() {
        val expected = arrayOf(
            intArrayOf(1)
        )

        assertArrayEquals(expected, SpiralMatrix.ofSize(1))
    }

    //@Ignore
    @Test
    fun testSpiralOfSize2() {
        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 3)
        )

        assertArrayEquals(expected, SpiralMatrix.ofSize(2))
    }

    //@Ignore
    @Test
    fun testSpiralOfSize3() {
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(8, 9, 4),
            intArrayOf(7, 6, 5)
        )

        assertArrayEquals(expected, SpiralMatrix.ofSize(3))
    }

    //@Ignore
    @Test
    fun testSpiralOfSize4() {
        val expected = arrayOf(
            intArrayOf( 1,  2,  3,  4),
            intArrayOf(12, 13, 14,  5),
            intArrayOf(11, 16, 15,  6),
            intArrayOf(10,  9,  8,  7)
        )

        assertArrayEquals(expected, SpiralMatrix.ofSize(4))
    }

    @Ignore
    @Test
    fun testSpiralOfSize5() {
        val expected = arrayOf(
            intArrayOf( 1,  2,  3,  4,  5),
            intArrayOf(16, 17, 18, 19,  6),
            intArrayOf(15, 24, 25, 20,  7),
            intArrayOf(14, 23, 22, 21,  8),
            intArrayOf(13, 12, 11, 10,  9)
        )

        assertArrayEquals(expected, SpiralMatrix.ofSize(5))
    }

}

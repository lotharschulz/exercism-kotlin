
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class RaindropsTest(val input: Int, val expectedOutput: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: raindrops({0})={1}")
        fun data() = listOf(
                arrayOf(   1, "1"),
                arrayOf(   3, "Pling"),
                arrayOf(   5, "Plang"),
                arrayOf(   7, "Plong"),
                arrayOf(   6, "Pling"),
                arrayOf(   8, "8"),
                arrayOf(   9, "Pling"),
                arrayOf(  10, "Plang"),
                arrayOf(  14, "Plong"),
                arrayOf(  15, "PlingPlang"),
                arrayOf(  21, "PlingPlong"),
                arrayOf(  25, "Plang"),
                arrayOf(  27, "Pling"),
                arrayOf(  35, "PlangPlong"),
                arrayOf(  49, "Plong"),
                arrayOf(  52, "52"),
                arrayOf( 105, "PlingPlangPlong"),
                arrayOf(3125, "Plang")
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, Raindrops.convert(input))
    }

}

@RunWith(Parameterized::class)
class FactorsTest2(private val input: Int, private val expectedOutput: List<Int>) {


    companion object {
        val e: List<Int> = emptyList()
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: factors({0})={1}")
        fun data() = listOf(
                arrayOf(-1,e),
                arrayOf(34,listOf(1,2,17,34)),
                arrayOf(3125,listOf(1, 5, 25, 125, 625, 3125))
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, Raindrops.getFactors(input))
    }

}

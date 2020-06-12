import kotlin.test.assertEquals
import kotlin.test.Test

class ResistorColorTest {

    @Test
    fun testBlackColorCode() = assertEquals(0, ResistorColor.colorCode("black"))

    @Test
    fun testWhiteColorCode() = assertEquals(9, ResistorColor.colorCode("white"))

    @Test
    fun testOrangeColorCode() = assertEquals(3, ResistorColor.colorCode("orange"))

    @Test
    fun testBrownColorCode() = assertEquals(7, ResistorColor.colorCode("brown"))

    @Test
    fun testRedColorCode() = assertEquals(6, ResistorColor.colorCode("red"))

    @Test
    fun testYellowColorCode() = assertEquals(5, ResistorColor.colorCode("yellow"))

    @Test
    fun testGreenColorCode() = assertEquals(4, ResistorColor.colorCode("green"))

    @Test
    fun testBlueColorCode() = assertEquals(2, ResistorColor.colorCode("blue"))

    @Test
    fun testVioletColorCode() = assertEquals(1, ResistorColor.colorCode("violet"))

    @Test
    fun testGreyColorCode() = assertEquals(0, ResistorColor.colorCode("grey"))

    @Test
    fun testColors() {
        val expected = listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
        assertEquals(expected, ResistorColor.colors())
    }
}

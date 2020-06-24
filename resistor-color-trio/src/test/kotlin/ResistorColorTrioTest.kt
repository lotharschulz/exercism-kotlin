import kotlin.test.Test
import kotlin.test.assertEquals
import Color.*

class ResistorColorTrioTest {

    @Test
    fun `orange orange black`(){
        assertEquals("33 ohms", ResistorColorTrio.text(ORANGE, ORANGE, BLACK))
        assertEquals("33 ohms", ResistorColorTrio.text2(ORANGE, ORANGE, BLACK))
        assertEquals("33 ohms", ResistorColorTrio.text3(ORANGE, ORANGE, BLACK))
    }

    @Test
    fun `blue grey brown`() {
        assertEquals("680 ohms", ResistorColorTrio.text(BLUE, GREY, BROWN))
        assertEquals("680 ohms", ResistorColorTrio.text2(BLUE, GREY, BROWN))
        assertEquals("680 ohms", ResistorColorTrio.text3(BLUE, GREY, BROWN))
    }

    @Test
    fun `red black red`() {
        assertEquals("2 kiloohms", ResistorColorTrio.text(RED, BLACK, RED))
        assertEquals("2 kiloohms", ResistorColorTrio.text2(RED, BLACK, RED))
        assertEquals("2 kiloohms", ResistorColorTrio.text3(RED, BLACK, RED))
    }

    @Test
    fun `green brown orange`() {
        assertEquals("51 kiloohms", ResistorColorTrio.text(GREEN, BROWN, ORANGE))
        assertEquals("51 kiloohms", ResistorColorTrio.text2(GREEN, BROWN, ORANGE))
        assertEquals("51 kiloohms", ResistorColorTrio.text3(GREEN, BROWN, ORANGE))
    }

    @Test
    fun `yellow violet yellow`() {
        assertEquals("470 kiloohms", ResistorColorTrio.text(YELLOW, VIOLET, YELLOW))
        assertEquals("470 kiloohms", ResistorColorTrio.text2(YELLOW, VIOLET, YELLOW))
        assertEquals("470 kiloohms", ResistorColorTrio.text3(YELLOW, VIOLET, YELLOW))
    }

    @Test
    fun `yellow violet violet`() {
        assertEquals("470 megaohms", ResistorColorTrio.text(YELLOW, VIOLET, VIOLET))
        assertEquals("470 megaohms", ResistorColorTrio.text2(YELLOW, VIOLET, VIOLET))
        assertEquals("470 megaohms", ResistorColorTrio.text3(YELLOW, VIOLET, VIOLET))
    }

}

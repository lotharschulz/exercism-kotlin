import kotlin.test.Test
import kotlin.test.assertEquals

class ResistorColorDuoTest {

    @Test
    fun `brown and black`() = assertEquals(10, ResistorColorDuo.value(Color.BROWN, Color.BLACK))
    @Test
    fun `brown and black2`() = assertEquals(10, ResistorColorDuo.value2(Color.BROWN, Color.BLACK))

    @Test
    fun `blue and grey`() = assertEquals(68, ResistorColorDuo.value(Color.BLUE, Color.GREY))
    @Test
    fun `blue and grey2`() = assertEquals(68, ResistorColorDuo.value2(Color.BLUE, Color.GREY))

    @Test
    fun `yellow and violet`() = assertEquals(47, ResistorColorDuo.value(Color.YELLOW, Color.VIOLET))
    @Test
    fun `yellow and violet2`() = assertEquals(47, ResistorColorDuo.value2(Color.YELLOW, Color.VIOLET))

    @Test
    fun `orange and orange`() = assertEquals(33, ResistorColorDuo.value(Color.ORANGE, Color.ORANGE))
    @Test
    fun `orange and orange2`() = assertEquals(33, ResistorColorDuo.value2(Color.ORANGE, Color.ORANGE))

    @Test
    fun `ignore additional colors`() = assertEquals(51, ResistorColorDuo.value(Color.GREEN, Color.BROWN, Color.ORANGE))
    @Test
    fun `ignore additional colors2`() = assertEquals(51, ResistorColorDuo.value2(Color.GREEN, Color.BROWN, Color.ORANGE))

}

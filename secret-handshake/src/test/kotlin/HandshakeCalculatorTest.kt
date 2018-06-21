
import org.junit.Test
import kotlin.test.assertEquals

class HandshakeCalculatorTest {

    @Test
    fun testThatInput1YieldsAWink() {
        assertEquals(
            listOf(Signal.WINK),
            HandshakeCalculator.calculateHandshake(1))
    }

    @Test
    fun testThatInput2YieldsADoubleBlink() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(2))
    }

    @Test
    fun testThatInput4YieldsACloseYourEyes() {
        assertEquals(
            listOf(Signal.CLOSE_YOUR_EYES),
            HandshakeCalculator.calculateHandshake(4))
    }

    @Test
    fun testThatInput8YieldsAJump() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(8))
    }

    @Test
    fun testAnInputThatYieldsTwoActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(3))
    }

    @Test
    fun testAnInputThatYieldsTwoReversedActions() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(19))
    }

    @Test
    fun testReversingASingleActionYieldsTheSameAction() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(24))
    }

    @Test
    fun testReversingNoActionsYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(16))
    }

    @Test
    fun testInputThatYieldsAllActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),
            HandshakeCalculator.calculateHandshake(15))
    }

    @Test
    fun testInputThatYieldsAllActionsReversed() {
        assertEquals(
            listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(31))
    }

    @Test
    fun testThatInput0YieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(0))
    }

    @Test
    fun testThatInputWithLower5BitsNotSetYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(32))
    }

    @Test
    fun testHasBitFlagSet(){
        assertEquals(true,  16.hasBitFlagSet(0b0001_0000), "16 has bit flag set" )
        assertEquals(true,  16.hasBitFlagSet2(0b0001_0000), "16 has bit flag set2" )
        assertEquals(true,  16.hasBitFlagSet(0b0001_0001), "16 has bit flag set" )
        // its false because (0b0001_0000 and 0b0001_0001) != 0b11
        assertEquals(false,  16.hasBitFlagSet2(0b0001_0001), "16 has _NOT_ bit flag set2" )

        /* ------------ */                                                                                   2
        assertEquals(true,  24.hasBitFlagSet(0b0001_0000), "24 has bit flag set" )
        assertEquals(true,  25.hasBitFlagSet(0b0001_0000), "25 has bit flag set" )
        assertEquals(true,  16.hasBitFlagSet(0b0001_0000), "16 has bit flag set" )
        assertEquals(false,  1.hasBitFlagSet(0b0001_0000), "1 has NO bit flag set" )

        assertEquals(true,  95.hasBitFlagSet(0b0001_0000), "1 has NO bit flag set" )
        assertEquals(false,  79.hasBitFlagSet(0b0001_0000), "1 has NO bit flag set" )
        assertEquals(false,  0.hasBitFlagSet(0b0001_0000), "1 has NO bit flag set" )
        assertEquals(true,  (-1).hasBitFlagSet(0b0001_0000), "-1 has NO bit flag set" )
        assertEquals(true,  (-15).hasBitFlagSet(0b0001_0000), "-15 has NO bit flag set" )
        assertEquals(true,  (-16).hasBitFlagSet(0b0001_0000), "-16 has NO bit flag set" )
        assertEquals(false,  (-17).hasBitFlagSet(0b0001_0000), "-17 has NO bit flag set" )

        assertEquals(true,  95.hasBitFlagSet2(0b0001_0000), "95 has bit flag set2" )
        assertEquals(false,  79.hasBitFlagSet2(0b0001_0000), "95 has bit flag set2" )
        assertEquals(false,  0.hasBitFlagSet2(0b0001_0000), "95 has bit flag set2" )
        assertEquals(true,  (-1).hasBitFlagSet2(0b0001_0000), "-1 has bit flag set2" )
        assertEquals(true,  (-15).hasBitFlagSet2(0b0001_0000), "-15 has bit flag set2" )
        assertEquals(true,  (-16).hasBitFlagSet2(0b0001_0000), "-16 has bit flag set2" )
        assertEquals(false,  (-17).hasBitFlagSet2(0b0001_0000), "-17 has bit flag set2" )
    }

}

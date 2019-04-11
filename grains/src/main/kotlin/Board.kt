import java.math.BigInteger

class Board {
    companion object {

        fun getGrainCountForSquare(square: Int): BigInteger{
            if(0 == square || 1 == square) return BigInteger.valueOf(1)
            return BigInteger.valueOf(Math.pow(2.toDouble(), (square-1).toDouble()).toLong())
        }

        fun getTotalGrainCount(): BigInteger{
            return BigInteger("18446744073709551615")
        }
    }
}
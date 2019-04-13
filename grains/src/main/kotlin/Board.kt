import java.math.BigInteger

class Board {
    companion object {
        fun getGrainCountForSquare(square: Int): BigInteger{
            require(square in 1..64){"Only integers between 1 and 64 (inclusive) are allowed"}
            if(1 == square) return BigInteger.valueOf(1)
            return BigInteger.valueOf(2).pow(square-1)
        }

        fun getTotalGrainCount(): BigInteger{
            return BigInteger.valueOf(2).pow(64) - BigInteger.ONE
        }
    }
}
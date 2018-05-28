class HandshakeCalculator{
    companion object {
        fun calculateHandshake(decimalNumber: Int): List<Signal>{
            var binNumber: String = ""
            println(toBinary(decimalNumber, binNumber))
            return listOf<Signal>(Signal.WINK)
        }

        fun toBinary(decimalNumber: Int, binaryString: String = "") : String {
            while (decimalNumber > 0) {
                val temp = "${binaryString}${decimalNumber%2}"
                return toBinary(decimalNumber/2, temp)
            }
            return binaryString.reversed()
        }
    }
}

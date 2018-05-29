class HandshakeCalculator{
    companion object {
        fun calculateHandshake(decimalNumber: Int): List<Signal>{
            println(toBinary(decimalNumber))
            return listOf<Signal>(Signal.WINK)
        }

        fun toBinary(decimalNumber: Int) : String {
            val result = StringBuilder()
            var decNmbr = decimalNumber
            while (decNmbr>0){
                result.append(decimalNumber%2)
                decNmbr /= 2
            }
            return result.reversed().toString()
        }
    }
}

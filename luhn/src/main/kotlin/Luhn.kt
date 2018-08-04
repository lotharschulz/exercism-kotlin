object Luhn{

    private val DIGITS = """\d""".toRegex()

    fun isValid(number: String): Boolean {
        val purenumber =  number.replace(" ", "")
        if (DIGITS.containsMatchIn(input = purenumber)){
            if (purenumber.length <= 1){
                return purenumber != "0" && purenumber.toInt().rem(10) == 0
            }
            var checksum = 0
            for (i in purenumber.length - 1 downTo 0 step 2){
                checksum += purenumber[i] - '0'
            }
            for (i in purenumber.length - 2 downTo 0 step 2){
                val t = (purenumber[i] - '0') * 2
                checksum += if (t > 9) t - 9 else t
            }
            return checksum.rem(10) == 0
        }
        return false
    }
}
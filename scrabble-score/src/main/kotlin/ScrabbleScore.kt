

class ScrabbleScore{
    companion object {
        private fun valueOf(letter: Char): Int {
            return when (letter.toUpperCase()) {
                'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' ->  1
                'D', 'G'                                         ->  2
                'B', 'C', 'M', 'P'                               ->  3
                'F', 'H', 'V', 'W', 'Y'                          ->  4
                'K'                                              ->  5
                'J', 'X'                                         ->  8
                'Q', 'Z'                                         -> 10
                else                                             ->  0
            }
        }

        fun scoreWord(word: String): Int = word.sumBy { it -> valueOf(it) }
    }
}

/*

http://exercism.io/submissions/bc1183e12ac2447cb1a95b95dee87772

object ScrabbleScore {
    private val points = hashMapOf(
            'A' to 1, 'E' to 1, 'I' to 1, 'O' to 1,
            'U' to 1, 'L' to 1, 'N' to 1, 'R' to 1, 'S' to 1, 'T' to 1,
            'D' to 2, 'G' to 2,
            'B' to 3, 'C' to 3, 'M' to 3, 'P' to 3,
            'F' to 4, 'H' to 4, 'V' to 4, 'W' to 4, 'Y' to 4,
            'K' to 5,
            'J' to 8, 'X' to 8,
            'Q' to 10, 'Z' to 10

    )
    fun scoreWord(str : String) : Int {
        return str.map { points.getOrDefault(it.toUpperCase(), 0) }.sum()
    }
}

 */
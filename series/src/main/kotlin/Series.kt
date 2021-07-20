object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(s.isNotEmpty() && n <= s.length)
        val r = mutableListOf<List<Int>>()
        s.windowed(n).map { substr -> r.add(substr.toCharArray().toList().map { numberChar -> numberChar.code - 48 }) }
        return r.toList()
    }
}

class RailFenceCipher(private val rails: Int) {


    fun getEncryptedData(data: String):String = data.mapIndexedNotNull { index, char -> Pair(indentifyRail(index), char) }
                .sortedBy{ it.first }
                .mapNotNull { it.second }
                .joinToString("")

    fun getDecryptedData(encrypted: String) = placeDataOnRails(encrypted).let { rails ->
        encrypted.indices.joinToString("") { index ->
            indentifyRail(index).let { r ->
                rails[r].take(1).also { rails[r] = rails[r].drop(1) }
            }
        }
    }

    private fun placeDataOnRails(encrypted: String):MutableList<String> = mutableListOf<String>().apply {
        var offset = 0
        getRailCounts(encrypted).onEach {
            this.add(encrypted.substring(offset, offset + it))
            offset += it
        }
    }

    private fun indentifyRail(index: Int): Int {
        /*return (index % ((rails*2) - 2)).let {
            if (it >= rails) ((rails*2) - 2) - it else it
        }
        val r = (index % ((rails*2) - 2))
        if (r >= rails) return ((rails*2) - 2) - r
        return (index % ((rails*2) - 2))*/
        val lowerMidRail = (rails*2) - 2
        val remainder = (index % lowerMidRail)
        if (remainder >= rails) return lowerMidRail - remainder
        return (index % lowerMidRail)
    }


    private fun getRailCounts(data: String):List<Int> = data.mapIndexedNotNull { i, char -> Pair(indentifyRail(i), char) }
        .groupingBy { it.first }.eachCount().mapNotNull { it.value }
}

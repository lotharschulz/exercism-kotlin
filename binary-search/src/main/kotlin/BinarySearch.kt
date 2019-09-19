object BinarySearch {
    const val INVALID = -1

    fun search(list: List<Int>, search: Int):Int{
        require(list.isSorted())
        if (list.size == 1) return 0
        if (list.isEmpty() || list.elementAt(0) > search || !list.contains(search)) return INVALID
        return binSearchRecursive(list,search,0, list.size)
        //return binSearchIterative(list, search)
    }

    private tailrec fun binSearchRecursive(list: List<Int>, search: Int, startIndex: Int, endIndex: Int): Int{
        val m = (startIndex+endIndex)/2
        return when {
            search > list.elementAt(m) -> binSearchRecursive(list, search,m+1, endIndex)
            search < list.elementAt(m) -> binSearchRecursive(list, search, startIndex, m-1)
            else -> return m // search == list[m]
        }
    }

    private fun binSearchIterative(list: List<Int>, search: Int): Int{
        require(list.isSorted())

        var r = 0.rangeTo(list.lastIndex)
        var m: Int

        while (!r.isEmpty()){
            m = ( r.start + r.endInclusive ) / 2
            when {
                search > list[m] -> { r = m + 1..list.lastIndex }
                search < list[m] -> { r = 0 until m }
                list[m] == search -> return m
            }
        }
        return INVALID
    }


    private fun <T: Comparable<T>> List<T>.isSorted(): Boolean = (0 until lastIndex).none() { e -> this[e+1] <= this[e] }
}
object Flattener {
    fun flatten (l: List<Any?>):List<Any?>{
        val flatList = mutableListOf<Any?>()
        flattenList(l, flatList)
        return flatList
    }

    private fun flattenList(nestedList: List<Any?>, flatList: MutableList<Any?>) {
        nestedList.forEach{
            e -> when(e){
                !is List<Any?> -> if(null != e) flatList.add(e)
                else -> flattenList(e, flatList)
            }
        }
    }
}